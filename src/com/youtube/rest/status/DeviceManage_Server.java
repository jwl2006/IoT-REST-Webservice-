package com.youtube.rest.status;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/manage")
public class DeviceManage_Server {
	
	
	private static MongoDB manageMongo = new MongoDB("manageMongo");
	
	
	
	@POST
	@Path("/read")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response read(String track) throws JSONException {
		
        JSONObject obj = new JSONObject(track);
		manageMongo.insertObject(obj);
	
		String result = "Info Read from Client saved in Server DB: "+ track;
		return Response.status(201).entity(result).build();	
	}
	
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(String track) throws JSONException {
		
		
		System.out.println("¥¥¥¥¥in update in Server");
		manageMongo.updateObject(track);
		String updatedData = manageMongo.findObject("Object-Instance-1",track);
		System.out.println("Management updated: "+ track);
		return Response.status(201).entity(updatedData).build();	
			
	}
	
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(String track) throws JSONException {
	
		
          String info = "{\"Object-ID-3\":\"Device-Watch\",\"Manufacture-17\":\"Apple\","
          		+ "\"Model-Num-1\":\"Luna\",\"Serial-Num-2\""+":\"030-203\",\"Hardware-18\":\"329-42\","
          		+ "\"Produce-Date-13\":\"2015-03-12\",\"Object-Instance-1\":\"watchC\",\"Update_Time\":\"02-31-2014\"}";
					
		if (track.equals("watchC"))
		{
			System.out.println("IN WATCH C");
		JSONObject obj = new JSONObject(info);
		
		manageMongo.insertObject(obj);
		System.out.println(info);
		return Response.status(201).entity(info).build();
		}
		String Error ="error";
		System.out.println("Not a registered user");
		return Response.status(201).entity(Error).build();
		
	}
	
	

	

	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(String track) throws JSONException {
		manageMongo.deleteObject("Object-Instance-1",track);
		System.out.println( "Registration deleted: "+ track);
		return Response.status(201).entity(track).build();	
	}
	
	
	
	
	
	
	
	
	
	
}
