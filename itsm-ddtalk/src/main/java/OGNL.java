import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 用于OGNL表达式判断时提供一些方便的工具方法，Struts标签、Mybatis动态SQL都使用了OGNL表达式
 * <p>
 * <strong>例如：</strong>
 * </p>
 * <p>
 * 
 * <pre>
 * $lt;if test="@OGNL@isNotEmpty(任何java对象)" >
 * $lt;/if>
 * </pre>
 * 
 * </p>
 * 
 * @author Wesley
 * 
 */
public class OGNL {

	/**
	 * @see #com.venus.common.lang.StringUtils.isEmpty()
	 * @see #java.util.Collection.isEmpty()
	 * @see #java.util.Map.isEmpty()
	 * @see #java.lang.reflect.Array.getLength()
	 */
	public static boolean isEmpty(Object o) {
		if (o == null)
			return true;
		if (o instanceof String)
			return StringUtils.isEmpty((String) o);
		else if (o instanceof Collection<?>)
			return (((Collection<?>) o).isEmpty());
		else if (o instanceof Map<?, ?>)
			return ((Map<?, ?>) o).isEmpty();
		else {
			if(o.getClass().isArray()) {
				return Array.getLength(o) <= 0;
			} else {
				return false;
			}
		}
	}

	/**
	 * @see #isEmpty(Object)
	 */
	public static boolean isNotEmpty(Object o) {

		return !isEmpty(o);
	}

	/**
	 * 判断是否为列表、数组、Map等对象
	 * 
	 * @param o
	 *          对象
	 * @return
	 */
	public static boolean isList(Object o) {
		if (o == null)
			return false;
		if (o instanceof Collection<?>)
			return true;
		else if (o instanceof Map<?, ?>)
			return true;
		else {
			if(o.getClass().isArray()) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * 判断两个字符串是否相等
	 * 
	 * @param str1
	 *          字符串1
	 * @param str2
	 *          字符串2
	 * @return
	 */
	public static boolean equals(	String str1,
																String str2) {
		return StringUtils.equals(str1,
															str2);
	}

}
