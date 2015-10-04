
package com.youtube.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


	@Path("/webservice")
	
	public class JSONService  {
	
	
	private static MongoDB myMongo = new MongoDB("testdb");
	
		
	private	static Resource client1 = new Resource();
	private	static Resource client2 = new Resource();
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getResourceInJSON(
			@PathParam("id") String client_id
			) throws JSONException {
		String id = client_id;
		
		System.out.println("client id from server side:"+id);
		
		if (id.equals("client1")){
			System.out.println("In Client1 Service");
			
	        String result = myMongo.findObject(id);
	        JSONObject jobj = new JSONObject();
	        jobj.put("ID", id);
	        jobj.put("VALUE", result);
	        return jobj;
		}
		
		if (id.equals("client2")){
			JSONObject jobj = new JSONObject();
	        jobj.put("ID", client2.getID());
	        jobj.put("VALUE", client2.getValue());
	        return jobj;
		}
		
		return null;
		  
	}	
	


	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(String track) throws JSONException {
        JSONObject obj = new JSONObject(track);
        
        	System.out.println("ID is : "+obj.optString("ID"));
        	System.out.println("value is : "+obj.optString("VALUE"));
			
        	if (obj.optString("ID").equals("client1")){
				myMongo.insertObject(obj);
			    System.out.println("server track: " + client1.getID()+ client1.getValue());    
			}
		
			if (obj.optString("ID").equals("client2")){ 
				myMongo.insertObject(obj);
			    System.out.println("server track: " + client2.getID());      
			}
			
			
		    String result = "Resource saved: "+ track;
		    return Response.status(201).entity(result).build();	
	}
	

	
	
	
	}

	
	

