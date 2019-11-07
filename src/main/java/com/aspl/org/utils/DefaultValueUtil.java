package com.aspl.org.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DefaultValueUtil {
	
	public static boolean isNull(Field field, Object instance) {
		field.setAccessible(true);
		
		if(getFieldValue(field,instance)==null){
			
			return true;
		}
		return false;
		
		
	}
	
	
	public static <T> void doWith(Field field,Object instance) {
		//System.out.print("in doWith");
		String type = getFieldType(field).toString();
		try {
		switch(type) {
		case "class java.lang.String":
			
				field.set(instance,"");
			
			break;
		case "class java.lang.Integer":
			
				field.set(instance,0);
			
			break;
		case "class java.lang.Double":
			
				field.set(instance,0.0);
			
			break;
		}
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Class<?> getFieldType(Field field) {
		
		return field.getType();
	}
	
	public static <T> Object getFieldValue(Field field,Object instance) {
					try {
						if(getFieldType(field).toString()=="interface java.util.List") 					
						field.setAccessible(true);
						
						return field.get(instance);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
					return null;
	}
	
	public static Object setListFieldsDefault(Object myObject) {
		
		for(Field listField : myObject.getClass().getDeclaredFields()) {
			if(DefaultValueUtil.isNull(listField,(Object)myObject)) {
				//System.out.println("innnn");
				DefaultValueUtil.doWith(listField,(Object)myObject);
			}
		}
		return myObject;
		
	}
		public static Object setDefault(Object myObject) {
			Object object=myObject;
			for(Field field:myObject.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				try {
					
					if(getFieldType(field).toString().equals("interface java.util.List")) {
					
						List<Object> list = (ArrayList)field.get(myObject);
						List<Object> Resultlist = new ArrayList();
						
						for(Object ListField:list) {
							
							 object = setListFieldsDefault(ListField);
							 //return object;
							 Resultlist.add(object);
						}
						field.set(myObject, Resultlist);
					}else {
						if(DefaultValueUtil.isNull(field,(Object)object)) {
							
							DefaultValueUtil.doWith(field,(Object)object);
						}
					}
					
				}
			 catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
			return myObject;
	}
}
