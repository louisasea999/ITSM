package com.yum.itsm.ddtalk.common.utils;

import java.io.StringReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParameterUtil {
	public static String separator = "---";

	public static Map<String, Object> parseParameter(String parameter) {
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		if(parameter == null || parameter.trim().length() == 0)
			return params;
		
		if(parameter.trim().startsWith("<"))
			return parseParameterXml(parameter);
		
		String[] parameters = parameter.trim().split("\n");
		for (String p : parameters) {
			String param = p.trim();
			if(param.length() == 0)
				continue;
			
			String[] data = param.split(separator);
			if(data.length == 0)
				throw new RuntimeException("Invalid parameter string[" + parameter + "]. Valid parameter format is key---value");

			if(data.length == 1)
				params.put("parameter", data[0]);
			else
				params.put(data[0], data[1]);
		}
		
		return params;
	}

	public static Map<String, Object> parseParameterXml(String parameter) {
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		if(parameter == null || parameter.trim().length() == 0)
			return params;
		
		parameter = parameter.trim();
		if(parameter.startsWith("<parameter")) {
			parameter = "<parameters>" + parameter + "</parameters>";
		}
		
		StringReader reader = new StringReader(parameter.trim());
		SAXReader saxReader = new SAXReader();
		Document dom;
		try {
			dom = saxReader.read(reader);
			List parameters = dom.selectNodes("//parameter");
			for (int i = 0; i < parameters.size(); i++) {
				Element p = (Element)parameters.get(i);
				String name = p.attributeValue("name");
				String value = p.getText();
				if(name == null || name.trim().length() == 0)
					throw new RuntimeException("Invalid parameter string[" + parameter + "]. Valid format is <root><parameter name='name'>value</parameter></root>");
				
				params.put(name.trim(), value.trim());
			}
			
			return params;
		} catch (DocumentException e) {
			e.printStackTrace();
			return params;
		}
	}

	public static Map<String, Object> parseParameters(String... parameters) {
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		if(parameters == null || parameters.length == 0)
			return params;
		
		for (String parameter : parameters) {
			if(parameter == null || parameter.trim().length() == 0)
				continue;
			Map<String, Object> tempParams = parseParameter(parameter);
			params.putAll(tempParams);
		}
		
		return params;
	}
	
	public static String mergeParameters(String... parameters) {
		if(parameters == null || parameters.length == 0)
			return "";
		
		Map<String, Object> params = parseParameters(parameters);
		
		String parameter = toString(params);
		return parameter;
	}
	
	public static String toString(Map<String, Object> params) {
		if (params == null || params.size() == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder(1024);
		Set<String> keySet = params.keySet();
		for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object value = params.get(key);
			String v = value == null ? "" : value.toString();
			sb.append(key).append(separator).append(v).append("\n");
		}
		
		return sb.toString();
	}
	
	public static String toXml(Map<String, Object> params) {
		if (params == null || params.size() == 0) {
			return "";
		}
		
		Document document = DocumentHelper.createDocument();// 建立document对象，用来操作xml文件   
		Element root = document.addElement("root");// 建立根节点  
		//root.addComment("This is a test for dom4j ");// 加入一行注释  
		
		Set<String> keySet = params.keySet();
		for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object value = params.get(key);
			String v = value == null ? "" : value.toString();
			
			Element parameterElement = root.addElement("parameter");// 添加一个parameter节点
			parameterElement.addAttribute("name", key);// 添加属性内容
			parameterElement.setText(v); // 添加文本内容
//			CDATA cdata = DocumentHelper.createCDATA(v);
//			parameterElement.add(cdata); // 添加文本内容
//			Element titleElement = parameterElement.addElement("title");// 添加文本节点
//			titleElement.setText("ajax in action");// 添加文本内容
		}
		
		return document.asXML();
	}
}
