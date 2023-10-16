package org.consultadd.lambdarestapi.funtionalInterfaces;

import org.consultadd.lambdarestapi.model.Request;
import org.consultadd.lambdarestapi.model.Response;
import org.consultadd.lambdarestapi.utils.RequestContext;

public interface RestApiHandler {

    Response handle(Request request, RequestContext context);
}
