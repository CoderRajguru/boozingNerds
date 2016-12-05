package com.edu.resources;

import com.edu.model.Login;
import com.edu.model.LoginData;
import com.edu.model.Registration;
import com.edu.model.RegistrationData;
import com.edu.service.LoginService;
import com.edu.service.RegistrationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * Created by bikash.rajguru on 2/20/16.
 */

@Path("/login")
public class LoginResource {

    private static final Logger logger = Logger.getLogger(LoginResource.class.getSimpleName());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginvalidation(Login login)
    {
        logger.info("Hit resource");
        LoginService loginObject=new LoginService();
        LoginData loginResponse = loginObject.validateLogin(login);
        if(loginResponse.getLoginId()>0) return Response.status(Response.Status.ACCEPTED).entity(loginResponse).build();
        else
            return Response.status(Response.Status.FORBIDDEN).build();
        //return Response.status(Response.Status.ACCEPTED ).build();
    }


}
