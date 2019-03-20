package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import database.Database;
import ihm.IHM;
import magasin.Magasin;

public class Client{ 

 public static void main (String[]args) throws Exception, JSONException{
   
   
   Socket socket= new Socket ("localhost", 5555);
   OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
   BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
   Scanner sc1 = new Scanner(System.in);
   IHM fenetre = new IHM(writer);
   boolean condition = true;
   //recuperation des magasins
  // writer.write("getMagasins\n");
   writer.flush();
  // System.out.println("coucou");
   String magasins = reader.readLine();
   System.out.println(magasins);
   final Gson gson = new GsonBuilder().setPrettyPrinting().create();
   //recuperation de la liste
   ArrayList<Magasin> listeMag = new ArrayList<Magasin>(); 
   listeMag = gson.fromJson(magasins, listeMag.getClass());
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
