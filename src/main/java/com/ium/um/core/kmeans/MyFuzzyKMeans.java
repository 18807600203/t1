package com.ium.um.core.kmeans;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.mahout.clustering.Cluster;
import org.apache.mahout.clustering.canopy.CanopyDriver;
import org.apache.mahout.clustering.classify.WeightedPropertyVectorWritable;
import org.apache.mahout.clustering.fuzzykmeans.FuzzyKMeansDriver;
import org.apache.mahout.common.HadoopUtil;
import org.apache.mahout.common.distance.ManhattanDistanceMeasure;
import org.apache.mahout.math.DenseVector;
import org.apache.mahout.math.NamedVector;
import org.apache.mahout.math.Vector;
import org.apache.mahout.math.VectorWritable;

import com.ium.um.core.rule.StringRegex;
import com.ium.um.domain.match.MatchData;

public class MyFuzzyKMeans {

	private List<MatchData> beanList = new ArrayList<>();
	/*
     * 数据类别 
     */ 
	private Class<MatchData> classT;  
	/*
	 * 参与配对的Bean属性
	 */
	private List<String> fieldNames = new ArrayList<String>();

	private int maxIterations;
	
	public List<MatchData> getBeanList() {
		return beanList;
	}
	
	
	/**
	 * 方法入口
	 * @param beanList 准备配对的的List
	 * @param maxIterations 迭代次数
	 */
	@SuppressWarnings("unchecked")
	public MyFuzzyKMeans( List<MatchData> beanList, int maxIterations){

		this.beanList = beanList;
		this.maxIterations = maxIterations;
		MatchData t = beanList.get(0);  
		this.classT = (Class<MatchData>) t.getClass();  
		Field[] fields = this.classT.getDeclaredFields();  
		for (int i = 0; i < fields.length; i++) {  
			Annotation kmeansAnnotation = fields[i].getAnnotation(KmeanField.class);  
			if (kmeansAnnotation != null) {  
				fieldNames.add(fields[i].getName());  
			}  
		}

		mainFunction();
	}

	/**
	 * 每个Bean根据 参与的配对的属性，转换成 Double数组类型
	 * @param bean 待配对的Bean
	 * @return
	 */
	private double[] getValues2Double(MatchData bean){

		int size = fieldNames.size();
		double[] d = new double[size];

		for (int i = 0; i < fieldNames.size(); i++) {  
			
			String fieldName = fieldNames.get(i);  
			String getName = "get"  + fieldName.substring(0, 1).toUpperCase()  + fieldName.substring(1);  
			Double vaule = Double.parseDouble(  invokeMethod(bean, getName,null ) + "");

			d[i] = vaule;
		}  
		return d;
	}

	/**
	 * 每个转换Double数组类型  再转换为 math.Vector的向量集合
	 * @return
	 */
	private List<Vector> getValues2Vector(){

		List<Vector> v = new ArrayList<Vector>();
		for(int i = 0; i < beanList.size(); i++){

			MatchData mvBean = beanList.get(i);
			String p = mvBean.getP();
			NamedVector namedV = new NamedVector(new DenseVector( getValues2Double(mvBean)), p);	
			v.add(namedV);
		}

		return v;
	}

	/*
	 * 算法
	 */
	private void mainFunction(){

		List<Vector> vectors = getValues2Vector();

		File testData = new File("clustering/data");
		if (!testData.exists()) {
			testData.mkdir();
		}

		testData = new File("clustering/data/points");
		if (!testData.exists()) {
			testData.mkdir();
		}

		Configuration conf = new Configuration();
		try{
			HadoopUtil.delete(conf, new Path("clustering"));//清空文件夹

			FileSystem fs = FileSystem.get(conf);
			writePointsToFile(vectors, "clustering/data/points/file1", fs, conf);//将getValues2Vector的集合写入 hadoop 识别的二进制文件
			
			CanopyDriver.run(conf, new Path("clustering/data/points"), new Path("clustering/data/clusters"), 
					new ManhattanDistanceMeasure(), 1.0, 2.0, false, 0.0, true); //利用Canopy算法给出最优的簇数量
			
			FuzzyKMeansDriver.run(new Path("clustering/data/points"), new Path("clustering/data/clusters/clusters-0-final"), 
					new Path("clustering/output"), 0.0001, maxIterations, 2, true, true, 0, true); //算法及输出文件
		
			SequenceFile.Reader reader = new SequenceFile.Reader(fs,
					new Path("clustering/output/" + Cluster.CLUSTERED_POINTS_DIR + "/part-m-0"), conf);//读取文件

			IntWritable key = new IntWritable();
			WeightedPropertyVectorWritable value = new WeightedPropertyVectorWritable();
			while (reader.next(key, value)) {
				//System.out.println(value.getVector() + " belongs to cluster " + key.toString());
				//循环赋值，耗时长
				String s = StringRegex.channelLabelRegex(value.toString());
				for( MatchData bean : beanList){
					if(bean.getP().equals(s)){
						bean.setMatchGroup( "class_" + key.toString());
					}
				}		
			}
			reader.close();
		}catch( IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	}


	/*------公共方法-----*/  
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object invokeMethod(Object owner, String methodName,Class[] argsClass,  
			Object... args) {  
		Class ownerClass = owner.getClass();  
		try {  
			Method method=ownerClass.getDeclaredMethod(methodName,argsClass);  
			return method.invoke(owner, args);  
		} catch (SecurityException e) {  
			e.printStackTrace();  
		} catch (NoSuchMethodException e) {  
			e.printStackTrace();  
		} catch (Exception ex) {  
			ex.printStackTrace();  
		}  

		return null;  
	}


	/*
	 * 将 Vecto的点集写入文件
	 */
	private void writePointsToFile(List<Vector> points, String fileName, FileSystem fs, Configuration conf)
			throws IOException {
		Path path = new Path(fileName);
		SequenceFile.Writer writer = new SequenceFile.Writer(fs, conf, path, LongWritable.class, VectorWritable.class);
		long recNum = 0;
		VectorWritable vec = new VectorWritable();
		for (Vector point : points) {
			vec.set(point);
			writer.append(new LongWritable(recNum++), vec);
		}
		writer.close();
	}



}
