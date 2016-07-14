package com.jikexueyuan.dao;

import org.springframework.stereotype.Repository;

import net.sf.json.JSONObject;
@Repository("jsonFormate")
public class JsonOutputHelpe implements IOutputHelper {
	/**
	 * 格式化为json格式。
	 */

	@Override
	public String formate(Object object) {
	JSONObject object2=JSONObject.fromObject(object);
		return object2.toString();
	}
	
}
