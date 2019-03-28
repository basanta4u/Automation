package com.my.home.test.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class TestUtils {
	
public static ResourceBundle environmentConstants = Utf8ResourceBundle.getBundle("env");
    
    public static final Map<String, String> LOGIN_MAP = convertResourceBundleToMap( environmentConstants);//new HashMap<>();
    
    
    public static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
        Map<String, String> map = new HashMap<String, String>();

        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
          String key = keys.nextElement();
          map.put(key, resource.getString(key));
        }

        return map;
      }

}
