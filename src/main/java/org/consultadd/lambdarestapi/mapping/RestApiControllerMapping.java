package org.consultadd.lambdarestapi.mapping;


import org.consultadd.lambdarestapi.exceptions.NoMappingFoundException;
import org.consultadd.lambdarestapi.funtionalInterfaces.AbstractRestApiController;
import org.consultadd.lambdarestapi.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class RestApiControllerMapping {

    private static RestApiControllerMapping restApiControllerMapping;

    private Map<String, AbstractRestApiController> controllerMap = new HashMap<>();

    private RestApiControllerMapping() {
    }

    public static RestApiControllerMapping getInstance() {
        if (null == restApiControllerMapping) {
            restApiControllerMapping = new RestApiControllerMapping();
        }
        return restApiControllerMapping;
    }

    public void addMapping(String path, AbstractRestApiController controller) {
        this.controllerMap.put(path, controller);
    }

    public AbstractRestApiController getController(String path) {
        if (null == path) {
            throw new IllegalArgumentException("Invalid path specified.");
        }
        path = StringUtils.strip(path);
        if (controllerMap.containsKey(path)) {
            return controllerMap.get(path);
        } else {
            throw new NoMappingFoundException("No mapping found for specified path : " + path);
        }
    }
}
