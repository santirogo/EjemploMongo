/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mongo;

import java.util.Arrays;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
public class HelloSecureMongo{
 public static void main( String args[] ){
 try{
     
    MongoCredential credential =
 MongoCredential.createCredential("administrator",
 "admin", "mypassword".toCharArray());

 MongoClient mongoClient = new MongoClient(new
 ServerAddress("localhost"), Arrays.asList(credential));
 DB db = mongoClient.getDB( "test" );
 System.out.println("Successfully connected to securedatabase");
 }catch(Exception e){
 System.err.println( e.getClass().getName() + ": " +
 e.getMessage() );
 }
 }
}
