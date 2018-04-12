package com.safe.info.core.vo;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class ExecuteResult {
	public static String jsonReturn(int statusCode) {
		Map<String, Object> jsonObj = new HashMap<String, Object>();
		if(statusCode == 200) {
			jsonObj.put("statusCode", "200");
			jsonObj.put("message", "操作成功");
		} else if (statusCode == 300) {
			jsonObj.put("statusCode", "300");
			jsonObj.put("message", "操作失败，请重试");
		} else if (statusCode == 301) {
			jsonObj.put("statusCode", "301");
			jsonObj.put("message", "登录已过期，请重新登录");
		}
		jsonObj.put("closeCurrent", true);
		return JSON.toJSONString(jsonObj);
	}
	
	public static String jsonReturn(int statusCode, boolean closeCurrent) {
		Map<String, Object> jsonObj = new HashMap<String, Object>();
		if(statusCode == 200) {
			jsonObj.put("statusCode", "200");
			jsonObj.put("message", "操作成功");
		} else if (statusCode == 300) {
			jsonObj.put("statusCode", "300");
			jsonObj.put("message", "操作失败，请重试");
		} else if (statusCode == 301) {
			jsonObj.put("statusCode", "301");
			jsonObj.put("message", "登录已过期，请重新登录");
		}
		jsonObj.put("closeCurrent", closeCurrent);
		return JSON.toJSONString(jsonObj);
	}
	
	public static String jsonReturn(int statusCode, String msg) {
		Map<String, Object> jsonObj = new HashMap<String, Object>();
		if(statusCode == 200) {
			jsonObj.put("statusCode", "200");
			jsonObj.put("message", "操作成功 " + msg);
		} else if (statusCode == 300) {
			jsonObj.put("statusCode", "300");
			jsonObj.put("message", "操作失败:" + msg);
		} else if (statusCode == 301) {
			jsonObj.put("statusCode", "301");
			jsonObj.put("message", "登录已过期，请重新登录");
		}
		jsonObj.put("closeCurrent", true);
		return JSON.toJSONString(jsonObj);
	}
	
	public static String jsonReturn(int statusCode, String msg, boolean closeCurrent) {
		Map<String, Object> jsonObj = new HashMap<String, Object>();
		if(statusCode == 200) {
			jsonObj.put("statusCode", "200");
			jsonObj.put("message", "操作成功 " + msg);
		} else if (statusCode == 300) {
			jsonObj.put("statusCode", "300");
			jsonObj.put("message", "操作失败:" + msg);
		} else if (statusCode == 301) {
			jsonObj.put("statusCode", "301");
			jsonObj.put("message", "登录已过期，请重新登录");
		}
		jsonObj.put("closeCurrent", closeCurrent);
		return JSON.toJSONString(jsonObj);
	}
}
