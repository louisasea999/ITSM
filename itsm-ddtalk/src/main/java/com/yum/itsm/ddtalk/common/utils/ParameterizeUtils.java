package com.yum.itsm.ddtalk.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Project Name: cmsz-msp-sfp-portlet <br/>
 * Package Name: com.cmsz.msp.sfp.util <br/>
 * ClassName: ParameterUtils <br/>
 * Function: 动态参数解析，解析参数化的字符串<br>
 * 参数格式“{name=ParaName,label=ParamLabel,type=number/string,length=3}”. <br/>
 * Date: 2014-3-5 下午3:21:15 <br/>
 * 
 * @version
 * @author 苏祖伟(Walker) mailto: zuwei.su@qq.com
 * @date 2014-3-5 下午3:21:15
 */
public class ParameterizeUtils {
	
	/**
	 * Slf4j Logger 
	 **/
	private static Logger logger = LoggerFactory.getLogger(ParameterizeUtils.class);

	private static String leftSeparator = "{";

	private static String rightSeparator = "}";

	/**
	 * 
	 * parse:解析包含参数的字符串，返回字符串中包含的复杂参数列表. <br/>
	 * 
	 * @param str
	 *          包含参数的字符串，参数格式：{name=ParaName,label=ParamLabel,type=number/string, length=3}
	 * @return
	 * 
	 */
	public static List<ParameterizeUtils.Param> parse(String str) {
		List<ParameterizeUtils.Param> list = new ArrayList<ParameterizeUtils.Param>();

		if (str != null) {
			List<Object> params = parseParameterizeString(str);
			for (Object object : params) {
				if (object instanceof Param) {
					list.add((Param) object);
				}
			}
		}

		return list;
	}

	/**
	 * 
	 * applyParameter:用提供的数据（data）值替换字符串中的参数. <br/>
	 * 
	 * @param str 包含参数的字符串，参数分为两种，复杂参数和简单参数，简单参数主要是用于替换，复杂参数包含了参数类型等信息，可以提供动态的参数信息<br/>
	 * 							简单参数格式：{ParaName}<br/>
	 * 							复杂参数格式：{name=ParaName,label=ParamLabel,type=number/string, length=3}<br/>
	 * @param data 参数值，以name匹配
	 * @return
	 * 
	 */
	public static String apply(	String str,
															Map<String, Object> data) {
		StringBuilder sb = new StringBuilder(128);

		if (str != null) {
			List<Object> params = parseParameterizeString(str);
			for (Object object : params) {
				if (object instanceof Param) {
					ParameterizeUtils.Param param = (ParameterizeUtils.Param) object;

					String paramName = param.getName();
					String paramValue = "";
					Object v = data.get(paramName);
					if (v != null)
						paramValue = v.toString();

					// 添加参数值
					sb.append(paramValue);
				} else {
					// 拷贝非参数字符串
					sb.append(object.toString());
				}
			}
		}

		return sb.toString();
	}

	/**
	 * 
	 * parseParameterizeString:解析包含参数的字符串，将字符串分解为列表，以参数串为分割，列表中依次保存的分割后的各部分（非参数字符串和解析后参数对象）. <br/>
	 * 
	 * @param str
	 * @return
	 * 
	 */
	private static List<Object> parseParameterizeString(String str) {
		List<Object> list = new ArrayList<Object>();
		if (str == null || str.length() == 0)
			return list;

		String ts = str;
		int l = ts.indexOf(leftSeparator);
		int r = ts.indexOf(	rightSeparator,
												l + leftSeparator.length());
		while (l >= 0 && r >= 0) {
			list.add(ts.substring(0,
														l));

			String paramStr = ts.substring(	l + leftSeparator.length(),
																			r);

			Object param = parseParameterize(paramStr);
			list.add(param);

			ts = ts.substring(r + rightSeparator.length());
			l = ts.indexOf(leftSeparator);
			r = ts.indexOf(	rightSeparator,
											l + leftSeparator.length());
		}

		if (ts.length() > 0)
			list.add(ts);

		return list;
	}

	/**
	 * 
	 * parseParameterize:将参数字符串解析为参数对象，无法解析就直接返回原是字符串. <br/>
	 * 
	 * @param paramStr
	 * @return
	 * 
	 */
	private static Object parseParameterize(String paramStr) {
		String original = leftSeparator + paramStr + rightSeparator;;
		String paraName = null;
		String paraLabel = null;
		String paraType = null;
		String paraLength = null;

		try {
			// none parameterize str
			if (paramStr.trim().length() == 0)
				return original;

			// For Simple parameterize {paraName}
			if (paramStr.indexOf("=") < 0) {
				Param param = new Param();
				param.setName(paramStr.trim());
				return param;
			}

			String[] properties = paramStr.split(",");
			for (String prop : properties) {
				String[] kv = prop.split("=");
				String key = kv[0].trim();
				String value = kv[1].trim();
				if (key.equalsIgnoreCase("name")) {
					paraName = value;
				}
				if (key.equalsIgnoreCase("label")) {
					paraLabel = value;
				}
				if (key.equalsIgnoreCase("type")) {
					paraType = value;
				}
				if (key.equalsIgnoreCase("length")) {
					paraLength = value;
				}
			}

			if (paraName == null) {
				throw new NullPointerException("Invalid parameterize string. name of parameter is needed.");
			}

			if (paraLabel == null)
				paraLabel = paraName;

			if (paraType == null)
				paraType = "string";

			ParameterizeUtils.ComplexParam param = new ParameterizeUtils.ComplexParam();
			param.setName(paraName);
			param.setLabel(paraLabel);
			param.setType(paraType);
			param.setLength(paraLength);
			return param;
		} catch (Exception e) {
			logger.error("parseParameterize(" + paramStr + ")", e);
			return original;
		}
	}

	// Simple parameterize {paraName}
	public static class Param {
		private String name;

		public Param() {
		}

		public Param(String name) {
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	// Complex parameterize {name=ParaName,label=ParamLabel,type=number/string,length=3}
	public static class ComplexParam extends Param {
		private String label;

		private String type;

		private String length;

		public ComplexParam() {
		}

		public ComplexParam(	String name,
									String label,
									String type,
									String length) {
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getLength() {
			return length;
		}

		public void setLength(String length) {
			this.length = length;
		}

	}

	public static void main(String[] args) {
		String str = "ServerRuntimes[Name={name=serverName,label=服务器名称, type=String,length=2}]/JMSRuntime/JMSServers[Name={name=jmsServerName,label=JMS服务器名称,type=String}]/Destinations[Name={name=queueName, label=队列名称, type=String}]/MessagesPendingCount";
		List<ParameterizeUtils.Param> list = ParameterizeUtils.parse(str);
		System.out.println(list);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put(	"serverName",
							"AdminServer");
		data.put(	"jmsServerName",
							"sdpJMSServer");
		data.put(	"queueName",
							"module1!testQueue");

		String str2 = ParameterizeUtils.apply(str,
																					data);
		System.out.println(str2);

		str = "ServerRuntimes[{serverName}]/JMSRuntime/JMSServers[{jmsServerName}]/Destinations[{queueName}]/MessagesPendingCount";
		list = ParameterizeUtils.parse(str);
		System.out.println(list);

		str2 = ParameterizeUtils.apply(	str,
																		data);
		System.out.println(str2);

		str = "abcdefghijklmn{{jsdlfksdjflkdjfsdlfsd";
		list = ParameterizeUtils.parse(str);
		System.out.println(list);

		str2 = ParameterizeUtils.apply(	str,
																		data);
		System.out.println(str2);
	}
}
