package com.yum.itsm.ddtalk.common;

import org.apache.commons.lang3.StringUtils;

public class Parameter {
	private String name;
	
	private String value;

	private String label;

	private String type;

	private String length;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
	
	public String asXml() {
		StringBuilder xml = new StringBuilder();
		xml.append("<parameter");
		if( !StringUtils.isEmpty(name) ) {
			xml.append(" name=\"").append(name).append("\"");
		}
		if( !StringUtils.isEmpty(label) ) {
			xml.append(" label=\"").append(label).append("\"");
		}
		if( !StringUtils.isEmpty(type) ) {
			xml.append(" type=\"").append(type).append("\"");
		}
		if( !StringUtils.isEmpty(length) ) {
			xml.append(" length=\"").append(length).append("\"");
		}
			
		xml.append("><![CDATA[")
			.append(value == null ? "" : value.trim())
			.append("]]></parameter>\n");
		return xml.toString();
	}

	@Override
	public String toString() {
		return "Parameter [name=" + name + ", value=" + value + ", label=" + label + ", type=" + type + ", length="
				+ length + "]";
	}
}
