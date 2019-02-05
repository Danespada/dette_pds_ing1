package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import database.Database;

public class Client{ 

 public static void main (String[]args) throws Exception{
   Socket socket= new Socket ("localhost", 5555);
   OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
   BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
   
   JSONObject jsonObject = new JSONObject();
   jsonObject.put("message", "The Hate U Give Little Enfants F Everybody");
   
   
   writer.write(jsonObject.toString()+"\n");
   writer.flush();
   
   String line = reader.readLine();
   jsonObject = new JSONObject(line);
   
   System.out.println("Received from Server:\n " + jsonObject.toString(2));
  
   Database.mydb();
   
   
   socket.close();
   
 }
}
