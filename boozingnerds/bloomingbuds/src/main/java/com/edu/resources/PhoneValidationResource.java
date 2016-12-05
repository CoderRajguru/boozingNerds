package com.edu.resources;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.edu.service.LoginService;

@Path("/OTP")
public class PhoneValidationResource {
	
	private static final Logger logger = Logger.getLogger(LoginResource.class.getSimpleName());
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response getOTP(long phone){
        logger.info("Hit resource");
        PhoneValidationResource phoneValidationObject=new PhoneValidationResource();
		return null;
		
	}
}
