/**
 * 
 */
package com.edu.resources;

import java.util.logging.Logger;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.edu.model.LoginData;
import com.edu.model.MyDashboardData;
import com.edu.service.DashboardService;

/**
 * @author bikash.rajguru
 *
 */
@Path("/MyDashboard")
public class DashboardResource {
	
	private static final Logger logger = Logger.getLogger(LoginResource.class.getSimpleName());

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response getDashboard(LoginData login){
		System.out.println("login value is " + login.getLoginId());
		DashboardService dashboardDataObj=new DashboardService();
		MyDashboardData myDashBoardData=dashboardDataObj.getdashboardData(login);
		if(myDashBoardData.getClass_ID()>0) return Response.status(Response.Status.ACCEPTED).entity(myDashBoardData).build();
		
		return Response.status(Response.Status.FORBIDDEN).build();
		
	}

	
}
