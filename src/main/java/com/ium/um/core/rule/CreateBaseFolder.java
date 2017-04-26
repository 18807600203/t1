package com.ium.um.core.rule;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 创建项目基本文件及文件夹
 */
public class CreateBaseFolder {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public CreateBaseFolder() {

		createStepFolder();
		createProjFileFolder();
	}

	/**
	 * 创建StepFile文件夹
	 */
	private void createStepFolder() {

		String url = "StepFile";
		File f = new File(url);
		if (!f.exists() && !f.isDirectory()) {
			f.mkdir();
			logger.info("创建StepFile文件夹成功 (Create StepFile folder successfully)");
		}
	}
	
	/**
	 * 创建ProjFile文件夹
	 */
	private void createProjFileFolder(){
		
		String url = "ProjFile";
		File f = new File(url);
		if( !f.exists() && !f.isDirectory()){
			f.mkdir();
			logger.info("创建ProjFile文件夹成功  (Create ProjFile folder successfully)");
		}
	}
}
