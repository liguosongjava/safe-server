package com.safe.info.core.util;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
public class DwzJSONUtil {
    private static final Logger log = LoggerFactory.getLogger(DwzJSONUtil.class);
    private static final ObjectMapper DEFAULT_JACKSON_MAPPER = new ObjectMapper();
    
    static {DEFAULT_JACKSON_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));}
   
    
    public static String fromObject(Object obj) {
        try {
            return DEFAULT_JACKSON_MAPPER.writeValueAsString(obj);
        }
        catch (Exception e) {
            log.error("Fail on encode "+obj+" to json", e);
            return "{}";
        }
    }
    
    public static void main(String[] args) {
        HashMap<String,Object> m = new HashMap<String,Object>();
        m.put("date", new java.util.Date());
        m.put("abc", "1234545");
        System.err.println(fromObject(m));
    }
}
