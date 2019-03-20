package com.iroshnk.demo;

import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("demo")
@SwaggerDefinition(info = @Info(title = "Demo Kumuluzee API", version = "v.0.0.1"), host = "localhost:8080")
public class DemoApplication extends Application {
}
