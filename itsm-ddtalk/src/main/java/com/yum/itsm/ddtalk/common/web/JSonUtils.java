package com.yum.itsm.ddtalk.common.web;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yum.itsm.ddtalk.common.page.Page;

/**
 * 
 * JSON工具类
 * 
 * @author
 */
public class JSonUtils {
	private static final Logger logger = LoggerFactory.getLogger(JSonUtils.class);

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	
	public static JSONArray readJsonArrayFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	/**
	 * 基本数据类型字符串数据常量定义.
	 */
	private static final String[] BASE_DATA_TYPE = new String[] {
		"Character",
		"char",
		"String",
		"Number",
		"BigDecimal",
		"BigInteger",
		"Long",
		"long",
		"Integer",
		"int",
		"Short",
		"short",
		"Byte",
		"byte",
		"Double",
		"double",
		"Float",
		"float",
		"Boolean",
		"bool",
		"Date",
		"Time",
		"Timestamp" };

	/**
	 * 组装jqGrid分页信息参数
	 * 
	 * @param Page
	 *          <T>
	 * 
	 * @throws JSONException
	 * */
	public static JSONObject getJQGridPageJSONObject(Page<?> page)
			throws JSONException {
		JSONObject jsonPage = new JSONObject();
		jsonPage.put(	"page",
									page.getPage());
		jsonPage.put(	"total",
									page.getPages());
		jsonPage.put(	"records",
									page.getRecords());
		return jsonPage;
	}

	/**
	 * 
	 * toJSONObject:<br>
	 * 利用反射机制转换bean为json对象，此对象包含所有可以访问的属性和属性值<br>
	 * 生成的json数据只包含BASE_DATA_TYPE中配置的简单对象类型<br>
	 * 
	 * @param bean
	 * @return
	 * 
	 */
	public static JSONObject toJSONObject(Object bean) {
		JSONObject json = toJSONObject(	bean,
																		null,
																		1);
		return json;
	}

	/**
	 * 
	 * toJSONObject:<br>
	 * 利用反射机制转换bean为json对象，此对象包含所有可以访问的属性和属性值<br>
	 * 生成的json数据只包含BASE_DATA_TYPE中配置的简单对象类型<br>
	 * 
	 * @param bean
	 * @return
	 * 
	 */
	public static JSONObject toJSONObject(Object bean,
																				List<String> properties) {
		JSONObject json = toJSONObject(	bean,
																		properties,
																		1);
		return json;
	}

	/**
	 * 
	 * */
	/**
	 * 
	 * toJSONObject: <br/>
	 * 利用反射机制转换entity为json格式<br>
	 * 生成的json数据只包含简单对象类型<br>
	 * 
	 * @param bean
	 * @param prefix
	 * @param deep
	 *          转换深度，为了避免循环引用造成死循环
	 * @return
	 * 
	 */
	public static JSONObject toJSONObject(Object bean,
																				int deep) {
		return toJSONObject(bean,
												null,
												deep);
	}

	/**
	 * 
	 * toJSONObject:利用反射机制转换entity为json格式，生成的json数据只包含BASE_DATA_TYPE中配置的简单对象类型 <br/>
	 * 
	 * @param bean
	 * @param properties
	 * @param deep
	 * @return
	 * 
	 */
	public static JSONObject toJSONObject(Object bean, List<String> properties, int deep) {
		int maxDeep = 3;
		if (deep > 0)
			maxDeep = deep;
		
		if(bean instanceof Map) {
			return toJSONObject((Map)bean, properties, deep);
		} else {
			JSONObject json = new JSONObject();
			toJSONObject( json, bean, properties, null, 0, maxDeep);
			return json;
		}
	}

	/**
	 * 
	 * toJSONObject: 深层次转换 <br/>
	 * 递归方法，将Java对象逐层转换为JSON对象.<br/>
	 * 
	 * @param json
	 * @param object
	 * @param properties
	 *          Java对象属性列表，如果不为空，则只转换列表所包含的属性；否则全部转换
	 * @param prefix
	 * @param deep
	 *          当前层次
	 * @param maxDeep
	 *          最深层次，防止循环引用
	 * 
	 */
	private static void toJSONObject(	JSONObject json,
																		Object object,
																		List<String> properties,
																		String prefix,
																		int deep,
																		int maxDeep) {
		if (deep == maxDeep)
			return;

		// Field[] fields = object.getClass().getFields();
		List<Field> fields = getAllFields(object.getClass());
		for (Field field : fields) {
			try {
				boolean isStatic = Modifier.isStatic(field.getModifiers());
				if(isStatic)
					continue;
				
				String fieldName = field.getName();
				if (fieldName.equalsIgnoreCase("serialVersionUID"))
					continue;
				
				if (properties != null && !properties.contains(fieldName))
					continue;

				Method method = getGetter(object.getClass(),
																	fieldName);
				
				if(method == null)
					continue;
				
				Class returnTypeClass = method.getReturnType();
				Object fieldValue = method.invoke(object,
																					new Object[] {});
				String propertyName = StringUtils.isEmpty(prefix) ? field.getName() : prefix.trim() + "." + field.getName();

//				if (fieldValue == null) {
//					json.put(	propertyName,
//										JSONObject.NULL);
//					continue;
//				}
//
//				if (fieldValue.getClass().isArray()) {
//					JSONArray jsonArray = toJSONArray(fieldValue);
//					json.put(	propertyName,
//										jsonArray);
//				}
//
//				if (fieldValue instanceof Map) {
//					JSONArray jsonArray = toJSONArray((Map) fieldValue);
//					json.put(	propertyName,
//										jsonArray);
//				}
//
//				if (fieldValue instanceof Collection) {
//					JSONArray jsonArray = toJSONArray((Collection) fieldValue);
//					json.put(	propertyName,
//										jsonArray);
//				}
//
//				if (fieldValue instanceof Date) {
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//					json.put(	propertyName,
//										sdf.format((Date) fieldValue));
//					continue;
//				}
//				
//				if (isPrimary(returnTypeClass)) {
//					json.put(	propertyName,
//										fieldValue);
//					continue;
//				}
//				
//				if (fieldValue instanceof JSONObject || fieldValue instanceof JSONArray || JSONObject.NULL.equals(fieldValue)
//						|| fieldValue instanceof JSONString || fieldValue instanceof CharSequence) {
//					json.put(	propertyName,
//										fieldValue);
//					continue;
//				}
//
//				Package objectPackage = returnTypeClass.getPackage();
//				String objectPackageName = objectPackage != null ? objectPackage.getName() : "";
//				if (objectPackageName.startsWith("java.") || objectPackageName.startsWith("javax.")
//						|| returnTypeClass.getClassLoader() == null) {
//					json.put(	propertyName,
//										fieldValue.toString());
//				}
				json.put(	propertyName,
				         	toJSONObjectValue(fieldValue));
			} catch (Exception ex) {
				logger.error("", ex);
			}
		}
	}
	
	private static Object toJSONObjectValue(Object value) {
		if (value == null) {
			return JSONObject.NULL;
		}
		
		Class returnTypeClass = value.getClass();

		if (value.getClass().isArray()) {
			JSONArray jsonArray = toJSONArray(value);
			return jsonArray;
		}

		if (value instanceof Map) {
			JSONArray jsonArray = toJSONArray((Map) value);
			return jsonArray;
		}

		if (value instanceof Collection) {
			JSONArray jsonArray = toJSONArray((Collection) value);
			return jsonArray;
		}

		if (value instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format((Date) value);
		}
		
		if (isPrimary(returnTypeClass)) {
			return value;
		}
		
		if (value instanceof JSONObject || value instanceof JSONArray || JSONObject.NULL.equals(value)
				|| value instanceof JSONString || value instanceof CharSequence) {
			return value;
		}

		Package objectPackage = returnTypeClass.getPackage();
		String objectPackageName = objectPackage != null ? objectPackage.getName() : "";
		if (objectPackageName.startsWith("java.") || objectPackageName.startsWith("javax.")
				|| returnTypeClass.getClassLoader() == null) {
			return value;
		}
		
		return value;
	}

	public static JSONArray toJSONArray(Object array) {
		return toJSONArray(	array,
												null,
												1);
	}

	public static JSONArray toJSONArray(Object array,
																			int deep) {
		return toJSONArray(	array,
												null,
												deep);
	}

	public static JSONArray toJSONArray(Object array,
																			List<String> properties,
																			int deep) {
		if (array == null)
			return new JSONArray();

		if (array instanceof Collection)
			return toJSONArray((Collection) array);

		JSONArray jsonArray = new JSONArray();
		if (array.getClass().isArray()) {
			int length = Array.getLength(array);
			for (int i = 0; i < length; i += 1) {
				Object value = Array.get(	array,
																	i);
				JSONObject json = toJSONObject(	value,
																				properties,
																				deep);
				jsonArray.put(json);
			}
		} else if (array instanceof Map) {
			jsonArray.put(toJSONObject(	(Map) array,
																	properties));
		} else {
			jsonArray.put(toJSONObject(	array,
																	properties));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(Collection collection) {
		return toJSONArray(	collection,
												null,
												1);
	}

	public static JSONArray toJSONArray(Collection collection,
																			int deep) {
		return toJSONArray(	collection,
												null,
												deep);
	}

	public static JSONArray toJSONArray(Collection collection, List<String> properties) {
		return toJSONArray(	collection, null, 1);
	}

	public static JSONArray toJSONArray(Collection collection, List<String> properties, int deep) {
		JSONArray jsonArray = new JSONArray();
		Iterator iter = collection.iterator();
		while (iter.hasNext()) {
			JSONObject json = toJSONObject(	iter.next(), properties, deep);
			jsonArray.put(json);
		}

		return jsonArray;
	}

	public static JSONObject toJSONObject(Map map) {
		return toJSONObject(map,
												null,
												1);
	}

	public static JSONObject toJSONObject(Map map,
																				int deep) {
		return toJSONObject(map,
												null,
												deep);
	}

	public static JSONObject toJSONObject(Map map,
																				List<String> properties,
																				int deep) {
		JSONObject json = new JSONObject();
		Iterator i = map.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry e = (Map.Entry) i.next();
			String key = e.getKey().toString();
			Object value = e.getValue();
//			JSONObject jsonObject = toJSONObject(	value,
//																						properties,
//																						deep);
//
//			json.put(	key,
//								jsonObject.toString());
			
			Object jsonValue = toJSONObjectValue(value);
			json.put(key, jsonValue);
		}

		return json;
	}

	/**
	 * 以UTF-8编码方式，把数据发送到客户端
	 * 
	 * @param text
	 */
	public static void putJson(	JSONObject json, String name, Object value) {
		try {
			if (value == null) {
				json.put(	name, JSONObject.NULL);
			} else {
				json.put(	name, value);
			}
		} catch (JSONException e) {
			logger.error(	"putJson", e);
		}
	}

	/**
	 * 检查返回类型是否为基本数据类型.
	 * 
	 * @param returnType
	 * @return
	 */
	private static boolean isPrimary(Class<?> typeClass) {
		String returnType = typeClass.getSimpleName();

		for (int i = 0; i < BASE_DATA_TYPE.length; i++) {
			if (BASE_DATA_TYPE[i].equals(returnType))
				return true;
		}
		return false;
	}

	/**
	 * 
	 * 获得类的所有字段<br/>
	 * 
	 * @param clazz
	 * @return
	 * 
	 */
	private static List<Field> getAllFields(Class clazz) {
		List<Field> fields = new ArrayList<Field>();
		List<Class> clist = new ArrayList<Class>();
		clist.addAll(ClassUtils.getAllSuperclasses(clazz));
		clist.add(clazz);
		for (Class class1 : clist) {
			if(class1 == Object.class)
				continue;
			
			Field[] fs = class1.getDeclaredFields();
			for (Field field : fs) {
				if (!fields.contains(field))
					fields.add(field);
			}
		}

		return fields;
	}

	/**
	 * 根据名称获取一个 Getter。
	 * <p>
	 * 比如，你想获取 abc 的 getter ，那么优先查找 getAbc()，如果 没有，则查找 abc()。
	 * 
	 * @param fieldName
	 * @return 方法
	 * @throws NoSuchMethodException
	 *           没有找到 Getter
	 * @throws IntrospectionException 
	 */
	public static Method getGetter(	Class clazz,
																	String fieldName) {
		String fn = StringUtils.capitalize(fieldName);
		Method method = getMethod(clazz,
															"get" + fn);
		if (method == null)
			method = getMethod(	clazz,
													"is" + fn);
		
		return method;
		
		//		PropertyDescriptor pd = new PropertyDescriptor(	fieldName,
//																										clazz);
//		Method readMethod = pd.getReadMethod();
//
//		return readMethod;
	}

	/**
	 * getMethod: 获得类方法.<br/> 
	 *
	 * @param clazz
	 * @param fn
	 * @return
	 * @throws NoSuchMethodException
	 * 
	 */
	private static Method getMethod(Class clazz,
																	String fn) {
		try {
			return clazz.getMethod(fn);
		} catch (Exception e) {
			// logger.debug("Method " + fn + " of Class " + clazz + " is null.");
			return null;
		}
	}

	/**
	 * 根据一个字段获取 Setter
	 * <p>
	 * 比如，你想获取 abc 的 setter ，那么优先查找 setAbc(T abc)，如果 没有，则查找 abc(T abc)。
	 * 
	 * @param field
	 *          字段
	 * @return 方法
	 * @throws NoSuchMethodException
	 *           没找到 Setter
	 */
	private static Method getSetter(Class clazz,
																	Field field)
			throws NoSuchMethodException {
		Class type = field.getType();
		String fieldName = field.getName();
		try {
			return clazz.getMethod(	"set" + StringUtils.capitalize(fieldName),
															type);
		} catch (Exception e) {
			try {
				if (fieldName.startsWith("is") && (type == Boolean.class || type == Boolean.TYPE))
					return clazz.getMethod(	"set" + StringUtils.capitalize(fieldName.substring(2)),
																	type);
				return clazz.getMethod(	field.getName(),
																type);
			} catch (Exception e1) {
				return clazz.getMethod(	fieldName,
																type);
			}
		}
	}

}
