package com.manage.base;

/**
 * @(#) ReflectUtils.java 2016年02月24日
 */

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 反射方法
 * <pre>
 */
public class ReflectUtils {
	 
	/**
	 * 实现两个实例对象之间的对拷 obj1 数据源 obj2 目标数据
	 */
	public static void copy(Object obj1, Object obj2) {
		// 对obj1反射
		Class<?> obj1Class = obj1.getClass();
		Method[] obj1Methods = obj1Class.getMethods();
		// 对obj2反射
		Class<?> obj2Class = obj2.getClass();
		Method[] obj2Methods = obj2Class.getMethods();

		// 把obj2的方法影射到MAP中，方便调用
		Map<String, Method> obj2MeMap = new HashMap<>();
		for (Method obj2Method : obj2Methods) {
			obj2MeMap.put(obj2Method.getName(), obj2Method);
		}

		for (Method obj1Method : obj1Methods) {
			String methodName = obj1Method.getName();
			int paramNums = obj1Method.getParameterTypes().length;
			if (methodName != null && methodName.startsWith("get")
					&& paramNums == 0) {
				try {
					Method obj2Method = obj2MeMap.get(methodName);
					if (obj2Method == null
							|| obj2Method.getReturnType() != obj1Method
									.getReturnType()) {
						continue;
					}

					// 调用obj1实例中的getXXXX方法
					Object obj1Return = obj1Method.invoke(obj1);
					String setMethodName = "set" + methodName.substring(3);

					Method obj2Setmethod = obj2MeMap.get(setMethodName);
					if(obj2Setmethod==null) {
						continue;
					}
					// // 调用obj2实例中的setXXX方法
					obj2Setmethod.invoke(obj2, obj1Return);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * 实现两个实例对象之间的对拷 obj1 数据源 obj2 目标数据
	 */
	public static void copyNotNull(Object obj1, Object obj2) {
		// 对obj1反射
		Class<?> obj1Class = obj1.getClass();
		Method[] obj1Methods = obj1Class.getMethods();
		// 对obj2反射
		Class<?> obj2Class = obj2.getClass();
		Method[] obj2Methods = obj2Class.getMethods();

		// 把obj2的方法影射到MAP中，方便调用
		Map<String, Method> obj2MeMap = new HashMap<>();
		for (Method obj2Method : obj2Methods) {
			obj2MeMap.put(obj2Method.getName(), obj2Method);
		}

		for (Method obj1Method : obj1Methods) {
			String methodName = obj1Method.getName();
			int paramNums = obj1Method.getParameterTypes().length;
			if (methodName != null && methodName.startsWith("get")
					&& paramNums == 0) {
				try {
					Method obj2Method = obj2MeMap.get(methodName);
					if (obj2Method == null
							|| obj2Method.getReturnType() != obj1Method
									.getReturnType()) {
						continue;
					}

					// 调用obj1实例中的getXXXX方法
					Object obj1Return = obj1Method.invoke(obj1);
					String setMethodName = "set" + methodName.substring(3);

					Method obj2Setmethod = obj2MeMap.get(setMethodName);
					if(obj2Setmethod==null || obj1Return==null) {
						continue;
					}
					// // 调用obj2实例中的setXXX方法
					obj2Setmethod.invoke(obj2, obj1Return);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 根据对象的属性名，获取属性值
	 * <pre>
	 * @功能说明:
	 * ...................
	 * @版本更新列表
	 * 修改版本: 1.0.0
	 * 修改日期: 2014-10-20
	 * 修  改  人: Administrator
	 * 修改说明: 形成初始版本
	 * 复  审  人:
	 * </pre>
	 * @date 2014-10-20
	 * @param property
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Object getObjectPropertyValue(String property, Object obj) throws Exception {
		String getMethod = "get"+property.replaceFirst(property.substring(0, 1), property.substring(0, 1).toUpperCase());
		Method method = obj.getClass().getMethod(getMethod);
		return method.invoke(obj);
	}
	
	//判断2个同对象属性值是否一致
	public static boolean contrastObj(Object obj1, Object obj2){
	    boolean valuesame = false;
	    try{
	    	Class<?> clazz = obj1.getClass();
	    	Field[] fields = clazz.getDeclaredFields();
	    	for(Field field : fields){
	    		if(field.getName().indexOf("time")>-1 || field.getName().indexOf("date")>-1){
	    			continue;
	    		}
	    		PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
	    		Method getMethod = pd.getReadMethod();
	    		Object o1 = getMethod.invoke(obj1);
	    		Object o2 = getMethod.invoke(obj2);
	    		if(o1.toString().equals(o2.toString())){
	    			//list.add(getMethod.getName()+":" + "false");
	    		}else{
	    			//list.add(getMethod.getName()+":" + "true");
	    			valuesame = true;
	    			break;
	    		}
	    	}
	    }catch(Exception e){
	    	
	    }
//	    for(Object obj : list){
//	    	System.err.println(obj);
//	    }
	 return valuesame;
	}
	
	/**
	 * 简要描述：将List<Map>拷贝到List<Object>
	 * 创建人：Risun
	 * 修改人：
	 * @param c
	 * @param maplist
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static <T> List<T> listMapToJavaBean(Class<T> c, List<Map<String, Object>> maplist) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		List<T> listObject = null;
		if(maplist != null && !maplist.isEmpty()) {
			listObject = new ArrayList<>();
			T object = null;
			for(Map<String, Object> map : maplist) {
				object = c.newInstance();
				org.apache.commons.beanutils.BeanUtils.populate(object, map);
				listObject.add(object);
			}
		}
		return listObject;
	}
	
	/**
	 * 简要描述：将List<Object>拷贝到List<Map>
	 * 创建人：Risun
	 * 修改人：
	 * @param listT
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	public static <T> List<Map<String, Object>> listJavaBean2Map(List<T> listT) throws InstantiationException, IllegalAccessException, InvocationTargetException, IntrospectionException {
		List<Map<String, Object>> listMap = null;
		if(listT != null && !listT.isEmpty()) {
			listMap = new ArrayList<>();
			Map<String, Object> map = null;
			for(T object : listT) {
				map = convertBean(object);
				listMap.add(map);
			}
		}
		return listMap;
	}
	
	 /**
     * 将一个 JavaBean 对象转化为一个  Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Map<String,Object> convertBean(Object bean)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Class<?> type = bean.getClass();
        Map<String, Object> returnMap = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
//                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }
	/**
	 * 利用反射获取指定对象的指定属性
	 * @param obj 目标对象
	 * @param fieldName 目标属性
	 * @return 目标属性的值
	 */
	public static Object getFieldValue(Object obj, String fieldName) {
		Object result = null;
		Field field = ReflectUtils.getField(obj, fieldName);
		if (field != null) {
			field.setAccessible(true);
			try {
				result = field.get(obj);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 利用反射获取指定对象里面的指定属性
	 * @param obj 目标对象
	 * @param fieldName 目标属性
	 * @return 目标字段
	 */
	public static Field getField(Object obj, String fieldName) {
		Field field = null;
		for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz=clazz.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(fieldName);
				break;
			} catch (NoSuchFieldException e) {
				//这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
			}
		}
		return field;
	}

	/**
	 * 利用反射设置指定对象的指定属性为指定的值
	 * @param obj 目标对象
	 * @param fieldName 目标属性
	 * @param fieldValue 目标值
	 */
	public static void setFieldValue(Object obj, String fieldName,
									 Object fieldValue) {
		Field field = ReflectUtils.getField(obj, fieldName);
		if (field != null) {
			try {
				field.setAccessible(true);
				field.set(obj, fieldValue);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
