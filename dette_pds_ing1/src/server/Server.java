package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.*;

import dao.MagasinDAO;
import database.Database;
import magasin.Magasin;



public class Server
{
  public static void main (String[]args)throws Exception {
    
    ServerSocket serverSocket = new ServerSocket(5555);
    System.out.println("Le serveur écoute sur le port 5555 :");
   //Database.mydb();
    //Connexion à la DB + Requête 
    Database bd = new Database(3);
    System.out.println("Nombre de connexions disponibles : "+bd.getNbConnection());

    
    try {
      while(true) {
        Socket socket = serverSocket.accept();
        if(bd.getPool1().size()!=0) {
          startHandler(socket, bd);
          System.out.println("Nombre de connexions disponibles : "+bd.getNbConnection());
      
  } else {
      System.out.println("Connexion échouée");
      socket.close();
  }
      } 
    }finally {
        serverSocket.close();
      }
    }

  private static void startHandler(final Socket socket, final Database bd) throws IOException{
    Thread thread = new Thread(){
      @Override
      public void run() {
        boolean b = true;
        Connection connexionBD = bd.addConnection();
        try {
          OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
          BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream(),"UTF-8"));
          while(b){
            MagasinDAO magasin = new MagasinDAO(connexionBD);
            //System.out.println("Nouveau magasin");
            String ligne = reader.readLine();
            if(ligne!=null) {
            if (ligne.equals("insert")) {
            }else if(ligne.equals("getMagasins")) {
              System.out.println("getMagasins");
              ArrayList<Magasin> list = magasin.findList();
              final GsonBuilder builder = new GsonBuilder();
              final Gson gson = builder.create();
              System.out.println(list);
              writer.write(gson.toJson(list)+"\n");
              writer.flush();
              System.out.println("sendmag");
            }else if(ligne.equals("redevance")) {
              System.out.println("calcul redevance avec :");
             String mag1 = reader.readLine();
             int mag = Integer.parseInt(mag1);
             String date = reader.readLine();
             System.out.println("magasin :"+mag);
              System.out.println("date :"+date);
              System.out.println("recuperation de la superficie");
              double red = 160*magasin.getSurfaceFromidMagasin(mag);
              System.out.println("magasin privilegie ?");
              if(magasin.getPrivilegeFromidMagasin(mag)){
                red = red*1.2;
              }
              System.out.println(red);
            }
            }else {
              b=false;
            }
            
          }
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          closeSocket();
          bd.close(connexionBD);
        }
      }
      
      
      private void closeSocket() {
        try {
          socket.close();
        }catch (IOException e) {
        }
      }
      
      
    };
    thread.start();
  }
} 

     
    
