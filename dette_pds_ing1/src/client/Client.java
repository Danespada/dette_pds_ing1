package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import database.Database;
import ihm.IHM;
import magasin.Magasin;

public class Client{ 

 public static void main (String[]args) throws Exception{
   
   
   Socket socket= new Socket ("localhost", 5555);
   OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
   BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
   Scanner sc1 = new Scanner(System.in);
   IHM fenetre = new IHM(writer,reader);
   boolean condition = true;
   //recuperation des magasins
  // writer.write("getMagasins\n");
  // System.out.println("coucou");

  // writer.flush();
  }
} 
