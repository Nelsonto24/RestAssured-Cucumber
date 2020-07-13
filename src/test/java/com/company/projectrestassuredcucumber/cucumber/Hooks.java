package com.company.projectrestassuredcucumber.cucumber;

import io.cucumber.java.After;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.cucumber.java.Before;
import static org.hamcrest.Matchers.lessThan;

public class Hooks {  //clase hooks - contiene las acciones que se van a realizar antes que se ejecute el escenario de prueba

    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    @Before("@ApiRest") //se configura para que se ejecute ésta configuración antes de la ejecución de los @test (para este caso solo aplica para los tags APIRest
    public static void setup(){
        requestSpecification =new RequestSpecBuilder() //crear objeto requestSpecification
                .setBaseUri("http://172.20.10.3")
                .setBasePath("/")
                .setPort(8081)
                .addHeader("Content-Type", "application/json")
                .addFilter(new RequestLoggingFilter())  //muestra el log del request .log().all()
                .addFilter(new ResponseLoggingFilter()) //muestra el log del response .log().all()
                .addHeader("Accept", "application/json")
                .addHeader("X-Redmine-API-Key", "475338c5e8fe95ef9f9c1cae8cb69610e2d413ac")
                .build();

        responseSpecification=new ResponseSpecBuilder() //crear objeto responseSpecification
                //.expectStatusCode(200)
                .expectResponseTime(lessThan(3000L))
                .build();

        RestAssured.requestSpecification=requestSpecification; //asignar a las variables de restAssured
        RestAssured.responseSpecification=responseSpecification;
    }

    @Before("@UITest")  //etiquetar tag UITest
    public static void uiTest(){
        System.out.println("Este es un IU Test...");
    }

    @After("@ApiRest")
    public static void cleanUp(){  //setea en blanco al final de una llamada
        RestAssured.reset();
    }

}
