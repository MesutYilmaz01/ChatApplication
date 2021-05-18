/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mesut
 */
public class Server {

    public ServerSocket ss;
    public int port = 0;
    public ServerListen listenThread;
    public int clientCount = 0;
    public ArrayList<ServerClient> Clients = new ArrayList<>();

    public Server(int _port) {
        try {
            port = _port;
            ss = new ServerSocket(port);
            listenThread = new ServerListen(this);
            listenThread.start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void Send(String msg) {

        for (ServerClient c : Clients) {
            try {
                c.sOutput.writeUTF(msg);
                
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}

class ServerListen extends Thread {

    Server server;

    public ServerListen(Server _s) {
        server = _s;
    }

    @Override
    public void run() {
        while (!server.ss.isClosed()) {
            try {
                System.out.println("Client Bekleniyor.");
                Socket clientSocket = server.ss.accept();
                System.out.println("Client Bağlandı");
                ServerClient client = new ServerClient(clientSocket, server.clientCount, server);
                server.clientCount++;
                server.Clients.add(client);
                client.listen.start();

            } catch (IOException ex) {
                Logger.getLogger(ServerListen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
