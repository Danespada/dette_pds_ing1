package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import database.Database;
import ihm.IHM;

public class Client{ 

 public static void main (String[]args) throws Exception, JSONException{
   
   IHM fenetre = new IHM();
   
   Socket socket= new Socket ("localhost", 5555);
   OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
   BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
   Scanner sc1 = new Scanner(System.in);
   boolean condition = true;
   
   
   while(condition) {
     System.out.println("Saisir nom magasin");
     String entrée1 = sc1.nextLine();
     if(entrée1.equals("\\q")) {
       condition = false;
       System.out.println("Déconnexion"); 
     }else {
     
     JSONObject job1 = new JSONObject("{Magasin :" + entrée1 + "}");
     writer.write("insert\n");
     writer.flush();
     writer.write(job1.toString()+"\n");
     writer.flush();
     }
   }
   writer.close();
  // writer.flush();
  }
} 
