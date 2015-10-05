package com.youtube.rest.status;
//import java.net.UnknownHostException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


@Path("/bootstrap")
public class BootStrap_Server {
	   

	
    private static MongoDB strapMongo = new MongoDB("strapMongo");

    

   
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public JSONObject bootstrapInfo(@PathParam("id") String client_id)
             {
           try{ 
            String id = client_id;
            System.out.println("HERE IN THE BOOTINFO");
            if (id.equals("client1")){  
            	System.out.println(id);
            	String result =strapMongo.findObject("ID","client1");
            	System.out.println(result);
                JSONObject jobj = new JSONObject(result);
                return jobj;
            }
            else if (id.equals("client2")){ 
            	String result =strapMongo.findObject("ID","client2");
                JSONObject jobj = new JSONObject(result);
                return jobj;
            }
           
           } catch(JSONException e1) {
        	   
        	   
           }
            // pass the information to registration server.
           return null;  
    }       
        
 }
    
        
	
    	
    
    


