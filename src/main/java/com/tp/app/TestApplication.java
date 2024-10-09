package com.tp.app;


import com.tp.rest.*;
import com.tp.service.UserService;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

public class TestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(OpenApiResource.class);
        clazzes.add(UserController.class);
        clazzes.add(KahootController.class);
        clazzes.add(QuestionController.class);
        clazzes.add(GameSessionController.class);
        clazzes.add(CORSFilter.class);
//      //  clazzes.add(AcceptHeaderOpenApiResource.class);


        return clazzes;
    }
}
