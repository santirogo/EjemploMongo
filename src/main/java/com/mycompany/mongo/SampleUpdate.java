/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.Arrays;

/**
 *
 * @author brown
 */
public class SampleUpdate {
    public static void main(String[] args) {
         try {
            
            MongoCredential credential =
            MongoCredential.createCredential("administrator",
            "admin", "mypassword".toCharArray());

            MongoClient mongoClient = new MongoClient(new
            ServerAddress("localhost"), Arrays.asList(credential));
            
//            MongoClient mongoClient = new MongoClient(HOST, PORT);

            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("javastuff");
            BasicDBObject newDocument = new BasicDBObject();
            newDocument.append("$set", new BasicDBObject().append("age",21));
            BasicDBObject searchQuery = new BasicDBObject().append("name","Santiago");
            coll.update(searchQuery, newDocument);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
    }
}
