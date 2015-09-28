package com.youtube.rest.status;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/status")

public class V1_status {
	private static final String api_version = "0.01.00";
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public String returnTitle(){
		return "<p>Java Web Service </p>"
				+ "<p>what the funk </p>";
	}
	@Path("/version")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public String returnVersion(){
		return "Version: " +api_version;
	}
}
