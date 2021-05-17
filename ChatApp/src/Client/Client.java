/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

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
public class Client {

    public Socket socket;
    public ObjectInputStream sInput;
    public ObjectOutputStream sOutput;
    public Listen listen;
    public MainFrame mf = new MainFrame();
    
    public void Start(String ip, int port, Entry e) {
        e.setVisible(false);
        mf.setVisible(true);
        try {
            socket = new Socket(ip, port);
            System.out.println("Servera Bağlandım!");
            sInput = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
            listen = new Listen(this);
            listen.start();
            
            String myName = "Mesut";
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Stop(){
        if (socket != null) {
            try {
                sOutput.flush();
                sOutput.close();
                sInput.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void Send(String msg) {
        try {
            sOutput.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
class Listen extends Thread{
    Client client;
    Listen(Client _client){
        client = _client;
    }
    
    @Override
    public void run(){
        while(client.socket.isConnected()){
            try {
                String received = client.sInput.readUTF();
                System.out.println(received);
            } catch (IOException ex) {
                Logger.getLogger(Listen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
