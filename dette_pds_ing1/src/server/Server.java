package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

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
      
  } else {
      System.out.println("Connexion échouée");
      socket.close();
  }
      } 
    }finally {
        serverSocket.close();
      }
    }

  private static void startHandler(final Socket socket, Database bd) throws IOException{
    Thread thread = new Thread(){
      @Override
      public void run() {
        boolean b = true;
        try {
          Connection connexionBD = Database.getConnection();
          OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
          BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream(),"UTF-8"));
          while(b){
            MagasinDAO magasin = new MagasinDAO(connexionBD);
            System.out.println("Nouveau client");
            String nomMag = reader.readLine();
            if (nomMag.equals("insert")) {
              JSONObject jsonObject = new JSONObject(magasin);
              String nomM = jsonObject.getString("Magasin");
              Magasin mag = new Magasin(nomMag);
              magasin.create(mag);
              System.out.println("Ajout de magasin :  " + nomMag);
            } else {
              JSONObject jsonObject = new JSONObject(nomMag);
              writer.write(jsonObject.toString() + "\n");
              writer.flush();
              
            System.out.println("Réception du serveur");
           // Magasin mag = new Magasin(nomMag, montantMag);
           // JSONObject jsonObject = new JSONObject(line);
           // writer.write(jsonObject.toString()+"\n");
           // writer.flush();
           // magasin.create(mag);
          }
          }
        } catch (IOException | SQLException | ClassNotFoundException | JSONException e) {
          e.printStackTrace();
        } finally {
          closeSocket();
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

     
    
