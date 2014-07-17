/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.raghu.utils.application;

import java.util.HashMap;

public class AppObjects {
    
    private static final HashMap<String, Object> objectMap = new HashMap();
    
    public static void registerAppObject(String name, Object obj) {
        objectMap.put(name, obj);
    }
    
    public static Object getAppObject(String name) {
        return objectMap.get(name);
    }
    
}
