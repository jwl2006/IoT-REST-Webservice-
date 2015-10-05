package com.youtube.rest.status;


import java.net.UnknownHostException;




import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;



public class MongoDB {

	private static DBCollection table;
	private static MongoClient mongo;
	private static DB db;
    public MongoDB(String dbName) 
    {
    	System.out.println("in Mongo Constructor");
    	try{
    	mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB(dbName);
		table = db.getCollection("user");
		}
    	catch(UnknownHostException e1){
    		System.err.println("Failure during host name resolution: " + e1);
    	}
    }

    
    public void insertObject(JSONObject obj)
    {
    	
    	String ret =obj.toString();
    	DBObject dbobject = (DBObject) JSON.parse(ret);
		table.insert(dbobject);
    }

    public String findObject (String param,String name)
    {
    	
    	BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put(param, name);

        StringBuilder result=new StringBuilder();
    
    	DBCursor cursor = table.find(searchQuery);

    	while (cursor.hasNext()) {
    		result.append(cursor.next());
    	}

    	String ret = result.toString();
    	System.out.println(ret);
    	return ret;
    	}
  
    public void updateObject(String newValue) throws JSONException
    {
    	 
        
    	 String oldobj = findObject("ID",newValue);
    	
         this.deleteObject("ID",newValue);
         JSONObject jobj = new JSONObject(oldobj);
         jobj.put("Lifetime", 86400);
       
         this.insertObject(jobj);
        
    }
    
    public void deleteObject(String param, String value)
    {
    	BasicDBObject document = new BasicDBObject();
    	document.put(param, value);
    	table.remove(document); 	
    }
    
    
    
    
    

}



