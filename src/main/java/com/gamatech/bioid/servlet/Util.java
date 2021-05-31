package com.gamatech.bioid.servlet;

import java.util.ArrayList;
import java.util.List;
 
import org.bson.Document;
 
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;
 
public class Util {
	
	private static String DB_PASSWORD = "Sely210897";
	private static String DB_USER = "selyana821";
 
    // Method to make a connection to the mongodb server listening on a default port
    private static MongoClient getConnection() {
        MongoClient mongoClient = MongoClients.create(
        		"mongodb+srv://" + DB_USER + ":" + DB_PASSWORD + 
        		"@selymongocluster.zudvv.mongodb.net/bioid?retryWrites=true&w=majority"
        		);
        return mongoClient;
    }
 
    // Method to search a user in the mongodb
    public static boolean searchUserInDb(String loginId, String loginPwd){
        boolean user_found = false;
        String db_name = "bioid";
        String db_collection_name = "users";
 
        // Get the mongodb connection
        MongoDatabase db = getConnection().getDatabase(db_name);
 
        // Get the mongodb collection.
        MongoCollection col = db.getCollection(db_collection_name);
 
        // Get the particular record from the mongodb collection        
        List obj = new ArrayList();
        obj.add(new BasicDBObject("id", loginId));
        obj.add(new BasicDBObject("pwd", loginPwd));
 
        // Form a where query
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("$and", obj);
        System.out.println("Sql query is?= " + whereQuery.toString());
 
        FindIterable cursor = col.find(whereQuery);
        for(Document doc : cursor) {
            System.out.println("Found?= " + doc);
            user_found = true;
        }
        return user_found;
    }
}