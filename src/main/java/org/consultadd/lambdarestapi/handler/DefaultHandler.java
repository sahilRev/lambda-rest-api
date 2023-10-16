package org.consultadd.lambdarestapi.handler;

import org.consultadd.lambdarestapi.funtionalInterfaces.AbstractRestApiController;
import org.consultadd.lambdarestapi.funtionalInterfaces.RestApiHandler;
import org.consultadd.lambdarestapi.mapping.RestApiControllerMapping;
import org.consultadd.lambdarestapi.model.Request;
import org.consultadd.lambdarestapi.model.Response;
import org.consultadd.lambdarestapi.utils.RequestContext;
import org.consultadd.lambdarestapi.utils.StringUtils;

public class DefaultHandler implements RestApiHandler {

    private RestApiControllerMapping controllerMapping;

    public DefaultHandler() {
        this.controllerMapping = RestApiControllerMapping.getInstance();
    }

    @Override
    public Response handle(Request request, RequestContext context) {
        if (request == null) {
            throw new IllegalArgumentException("Null request specified.");
        }
        String path = StringUtils.strip(request.getPath());
        if (!path.equals("") && request.getMethod() != null) {
            AbstractRestApiController controller = controllerMapping.getController(path);
            Response response;
            switch (request.getMethod()) {
                case GET:
                    response = controller.doGet(request, context);
                    break;
                case PUT:
                    response = controller.doPut(request, context);
                    break;
                case POST:
                    response = controller.doPost(request, context);
                    break;
                case DELETE:
                    response = controller.doDelete(request, context);
                    break;
                default:
                    response = null;
            }
            return response;
        }
        throw new IllegalArgumentException("Invalid request specified.");
    }
}
