package com.webencyclop.app.restcontrollers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Controller("/")
@Secured(SecurityRule.IS_ANONYMOUS)
public class HomeRestController {

    @Get
    public String home() {
        return "Server is  up and running! Use these rest end points: \n[POST]: /login  \n[GET]: /demo/one";
    }

}
