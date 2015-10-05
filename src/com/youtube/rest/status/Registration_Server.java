package com.youtube.rest.status;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/registration")
public class Registration_Server {
	
    private static MongoDB registerMongo = new MongoDB("registerMongo");
	
	
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(String track) throws JSONException {
		System.out.println("IN REGISTER FUNCTION");
        JSONObject obj = new JSONObject(track);
		registerMongo.insertObject(obj);
	
		String result = "Registration saved: "+ track;
		return Response.status(201).entity(result).build();	
	}
    

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(String track) throws JSONException {
		
			
			registerMongo.updateObject(track);
			
			String result = "Registration updated: "+ track;
			return Response.status(201).entity(result).build();	
	}		

	@POST
	@Path("/deregister")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deregister(String track) throws JSONException {
		System.out.println("IN DEREGISTER FUNCTION");
      
		registerMongo.deleteObject("ID",track);
	
		String result = "Registration deleted: "+ track;
		return Response.status(201).entity(result).build();	
	}
}
	
