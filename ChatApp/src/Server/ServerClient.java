/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mesut
 */
public class ServerClient {
    Server server;
    int id = 0;
    Socket socket;
    ObjectOutputStream sOutput;
    ObjectInputStream sInput;
    Listen listen;
    public String name = "User" + id;

    public ServerClient(Socket _socket, int _id, Server _server) {
        server = _server;
        socket = _socket;
        id = _id;
        try {
            sOutput = new ObjectOutputStream(socket.getOutputStream());
            sInput = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServerClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        listen = new Listen(this,server);
    }

    public void Send(String message) {
        try {
            sOutput.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ServerClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

class Listen extends Thread {

    ServerClient Client;
    Server server;

    //thread nesne alması için yapıcı metod
    Listen(ServerClient Client, Server _server) {
        this.Client = Client;
        server = _server;
    }

    @Override
    public void run() {
        while (Client.socket.isConnected()) {
            try {
                String recieved = Client.sInput.readUTF();
                server.Send(recieved);
            } catch (IOException ex) {
                Logger.getLogger(Listen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
