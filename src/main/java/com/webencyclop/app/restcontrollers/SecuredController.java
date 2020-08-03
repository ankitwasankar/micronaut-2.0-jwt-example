package com.webencyclop.app.restcontrollers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.security.Principal;

@Controller("/demo")
@Secured(SecurityRule.IS_AUTHENTICATED)
public class SecuredController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/one")
    public String index(Principal principal) {
        return principal.getName();
    }
}
