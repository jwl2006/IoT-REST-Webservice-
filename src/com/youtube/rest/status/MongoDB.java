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
    	System.out.println("In the Insert Object");
    	String ret =obj.toString();
    	System.out.println("&&&"+ret);
    	DBObject dbobject = (DBObject) JSON.parse(ret);
		table.insert(dbobject);
    }

    public String findObject (String param,String name)
    {
    	
    	BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put(param, name);
    	System.out.println("$"+searchQuery.toString());

        StringBuilder result=new StringBuilder();
    
    	DBCursor cursor = table.find(searchQuery);

    	while (cursor.hasNext()) {
    	//	System.out.println("&"+cursor.next());
    		result.append(cursor.next());
    	}

    	String ret = result.toString();
  //  	System.out.println(ret);
    	return ret;
    	}
  
    public void updateObject(String newValue) throws JSONException
    {
    	 
   //      System.out.println(newValue);
    	 String oldobj = findObject("Object-Instance-1",newValue);
    	System.out.println("***OLD OBJECT"+oldobj);
         this.deleteObject("Object-Instance-1",newValue);
         JSONObject jobj = new JSONObject(oldobj);
         jobj.put("Serial-Num-2", "000-01");
         jobj.put("Update-Time", "000-00000");
  //       jobj.put("$oid", "56306a4a4b284sdsc46508c285");
       
         this.insertObject(jobj);
         
        
    }
    
    public void deleteObject(String param, String value)
    {
    	BasicDBObject document = new BasicDBObject();
    	document.put(param, value);
    	table.remove(document); 	
    }
    
    
    
    
    

}



