package org.consultadd.lambdarestapi.utils;

import java.util.HashMap;
import java.util.Map;

public class RequestContext {

    private Map<String, Object> context;

    public RequestContext() {
        this.context = new HashMap<>();
    }

    public Object get(String key) {
        return context.get(key);
    }

    public void put(String key, Object val) {
        this.context.put(key, val);
    }

    public void refresh() {
        this.context.clear();
    }
}
