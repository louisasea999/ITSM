package com.yum.itsm.ddtalk.common.service;

import java.util.Map;

public interface HttpClientService {

    String getRemoteResponse(String url,
                             String user,
                             String pass,
                             Map<String, String> params);
}
