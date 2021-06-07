package com.gamatech.bioid.servlet;

import java.util.ArrayList;
import java.util.List;
 
import org.bson.Document;

import com.mongodb.MongoClientSettings;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;
import org.bson.types.ObjectId;
 
public class Util {
	
	private static String DB_PASSWORD = "Sely210897";
	private static String DB_USER = "selyana821";
	private static String DB_NAME = "bioid";
	private static String DB_COLLECTION_NAME = "users";
 
    // Method to make a connection to the mongodb server listening on a default port
    private static MongoClient getConnection() {
        MongoClient mongoClient = MongoClients.create(
        		"mongodb+srv://" + DB_USER + ":" + DB_PASSWORD + 
        		"@selymongocluster.zudvv.mongodb.net/bioid?retryWrites=true&w=majority"
        		);
        return mongoClient;
    }
 
    // Method to search a user in the mongodb
    public static boolean searchUserInDb(String email, String password){
        boolean user_found = false;
 
        // Get the mongodb connection
        MongoDatabase db = getConnection().getDatabase(DB_NAME);
 
        // Get the mongodb collection.
        MongoCollection col = db.getCollection(DB_COLLECTION_NAME);
 
        // Get the particular record from the mongodb collection   
        List obj = new ArrayList();
        obj.add(new BasicDBObject("email", email));
        obj.add(new BasicDBObject("pass", password));
 
        // Form a where query
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("$and", obj);
        System.out.println("Sql query is?= " + whereQuery.toString());
 
        FindIterable<Document> cursor = col.find(whereQuery);
        for(Document doc : cursor) {
            System.out.println("Found?= " + doc);
            user_found = true;
        }
        
        return user_found;
    }
    
    //Method to register a user in the mongodb
    public static void registerUserInDB(String email, String password) {
    	
    	boolean user_found = false;
 
        // Get the mongodb connection
        MongoDatabase db = getConnection().getDatabase(DB_NAME);
 
        // Get the mongodb collection.
        MongoCollection col = db.getCollection(DB_COLLECTION_NAME);
  

        Document userDocument = new Document("_id", new ObjectId());
        
        userDocument.append("email", email);
        userDocument.append("pass", password);
        
        col.insertOne(userDocument);
       
    	
    }
}