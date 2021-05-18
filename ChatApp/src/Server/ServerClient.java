/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Message.Message;
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
    String name = "";

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
            sOutput.writeUTF(message);
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
                System.out.println("dinlemedeyim.");
                try {
                    Message received = (Message) (Client.sInput.readObject());
                    
                    switch (received.type) {
                        case Name:
                            Client.name = received.content.toString();
                            break;
                        case Text:
                            received.content = Client.name+" : "+ received.content.toString();
                            server.Send(received);
                            break;
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Listen.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(Listen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
