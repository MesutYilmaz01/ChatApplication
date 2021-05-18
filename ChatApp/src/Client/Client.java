/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

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
public class Client {

    public Socket socket;
    public ObjectInputStream sInput;
    public ObjectOutputStream sOutput;
    public Listen listen;
    public MainFrame mf;

    public void Start(String ip, int port, Entry e, String userName) {
        e.setVisible(false);
        mf = new MainFrame(this);
        mf.setVisible(true);
        try {
            socket = new Socket(ip, port);
            System.out.println("Servera Bağlandım!");
            sInput = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
            listen = new Listen(this);
            listen.start();

            Message name = new Message(Message.messageType.Name);
            name.content = userName;
            Send(name);

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Stop() {
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

    public void Send(Message msg) {
        try {
            String deneme = msg.content.toString();
            sOutput.writeObject(msg);
            sOutput.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

class Listen extends Thread {

    Client client;
    String temp = "";

    Listen(Client _client) {
        client = _client;
    }

    @Override
    public void run() {
        String temp = "";
        while (client.socket.isConnected()) {
            try {
                Message received = (Message) (client.sInput.readObject());
                switch (received.type) {
                    case Name:
                        break;
                    case Text:
                        temp += received.content.toString() + "\n";
                        client.mf.chat.setText(temp);
                }
            } catch (IOException ex) {
                Logger.getLogger(Listen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Listen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
