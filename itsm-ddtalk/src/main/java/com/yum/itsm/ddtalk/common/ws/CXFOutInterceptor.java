package com.yum.itsm.ddtalk.common.ws;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.cxf.interceptor.AbstractOutDatabindingInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;

public class CXFOutInterceptor extends AbstractOutDatabindingInterceptor {

	public CXFOutInterceptor() {
		super(Phase.MARSHAL);
	}

	public void handleMessage(Message outMessage) {
		Map<String, List<String>> headers = (Map<String, List<String>>) outMessage.get(Message.PROTOCOL_HEADERS);
		if (headers == null) {
			headers = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
			outMessage.put(	Message.PROTOCOL_HEADERS,
											headers);
		}
		// modify headers
		headers.put(	"Access-Control-Allow-Origin",
										Arrays.asList("*"));
		headers.put(	"Access-Control-Allow-Headers",
									Arrays.asList("accept", "content-type"));
		headers.put(	"Access-Control-Allow-Methods",
									Arrays.asList("GET", "POST", "PUT", "DELETE"));
	}
}