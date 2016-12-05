package com.edu.resources;

import com.edu.model.Registration;
import com.edu.model.RegistrationData;
import com.edu.service.RegistrationService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * Created by bikash.rajguru on 2/27/16.
 */
@Path("/registration")
public class ResgistrationResource {

    private static final Logger logger = Logger.getLogger(ResgistrationResource.class.getSimpleName());


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newRegistration(Registration registration) throws Exception
    {
        logger.info("Hit Registraion resource");
        System.out.println("Hit Registraion resource");
        RegistrationService registrationobject=new RegistrationService();
        RegistrationData RegistrationResponse=registrationobject.newRegistration(registration);
       // return Response.status(Response.Status.ACCEPTED).entity(RegistrationResponse).build();

        if(RegistrationResponse.getId()>0) return Response.status(Response.Status.ACCEPTED).entity(RegistrationResponse).build();
        else
            return Response.status(Response.Status.FORBIDDEN).build();

    }

}
