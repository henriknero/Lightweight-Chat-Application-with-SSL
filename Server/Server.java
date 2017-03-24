/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author henri
 */
public class Server {
    private ServerSocket listener;
    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;
    
    public void startServer() throws IOException{
        try{
            listener = new ServerSocket(6789,10);
            while(true){
                try{
                    waitForConnection();
                    setupStream();
                }
                catch(EOFException eofException){
                    System.out.println("Server ended connection.");
                }
                finally{
                    try{
                        socket.close();
                        input.close();
                        output.close();
                        System.out.println("Socket successfully closed!");
                    }catch(IOException ioException){
                        System.out.println("Error, socket did not close correctly!");
                    }
                }
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
        finally{
            listener.close();
        }
    
    }

    private void waitForConnection() throws IOException {
        socket = listener.accept();
        System.out.println("Host " + socket.getInetAddress().toString() + " has connected to the sever.");
        
    }

    private void setupStream() throws IOException {
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
        output.flush();
        System.out.println("Streams are setup.");
    }
}
