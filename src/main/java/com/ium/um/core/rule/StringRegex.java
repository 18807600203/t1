package com.ium.um.core.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegex {

	/**
	 * 提取节点名称
	 * example : 1_11_1
	 * @param chassisLabel
	 * @return
	 */
	public static String channelLabelRegex(String chassisLabel){
		
		String name = null;
		Pattern p = Pattern.compile("\\d{1,2}\\_\\d{1,4}\\_\\d{1,2}");
		Matcher m = p.matcher(chassisLabel);
		while( m.find()){
			name = m.group();
		}
		return name;
	}
}
