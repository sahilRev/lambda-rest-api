package org.consultadd.lambdarestapi.model;

import lombok.Data;
import org.consultadd.lambdarestapi.enums.HttpMethod;

import java.util.Map;

@Data
public class Request {

    private HttpMethod method;

    private String path;

    private Map<String, Object> apiData;
}
