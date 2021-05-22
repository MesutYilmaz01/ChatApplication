/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import GroupChat.ChatFrame;
import Message.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

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
    public ArrayList<ChatFrame> chatFrameList ;
    public String userName;
    public void Start(String ip, int port, Entry e, String _userName) {
        e.setVisible(false);
        mf = new MainFrame(this);
        mf.setVisible(true);
        chatFrameList = new ArrayList<ChatFrame>();
        try {
            socket = new Socket(ip, port);
            System.out.println("Servera Bağlandım!");
            sInput = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
            listen = new Listen(this);
            listen.start();
            userName = _userName;
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
            sOutput.writeObject(msg);
            sOutput.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

class Listen extends Thread {

    Client client;
    

    Listen(Client _client) {
        client = _client;
    }

    @Override
    public void run() {
        while (client.socket.isConnected()) {
            System.out.println("Soket Mesaj Aldı..");
            try {
                Message received = (Message) (client.sInput.readObject());
                switch (received.type) {
                    case ConnectedClients:
                        ArrayList<String> users = (ArrayList<String>) (received.content);
                        DefaultListModel<String> model = new DefaultListModel<String>();
                        for (int i = 0; i < users.size(); i++) {
                            model.add(i, users.get(i));
                            System.out.println(users.get(i)+"\n");
                        }
                        client.mf.userList.setModel(model);
                        client.mf.user.setText(client.userName);
                        break;
                    case ChatGroupConnection:
                        boolean append = true;
                        for(int i = 0; i< client.chatFrameList.size(); i++){ 
                           System.out.println();
                            ChatFrame cf = client.chatFrameList.get(i);
                            if(received.userList.contains(cf.roomName))
                            {
                                String text = "";
                                text = cf.chatField.getText();
                                String newMsg = received.owner + " : " + received.content.toString() + "\n";
                                cf.chatField.setText(text + newMsg);
                                append = false;
                                System.out.println("1");
                            }
                        }
                        if(append){
                            ArrayList<String> tmpChatUserList = new ArrayList<String>();
                            tmpChatUserList.add(client.userName);
                            tmpChatUserList.add(received.owner);
                            client.chatFrameList.add(new ChatFrame(client, tmpChatUserList, received.owner));
                            int newCFrameIndex = client.chatFrameList.size() - 1; 
                            String newMsg = received.owner + " : " + received.content.toString() + "\n";
                            client.chatFrameList.get(newCFrameIndex).chatField.setText(newMsg);
                            
                            client.chatFrameList.get(newCFrameIndex).setVisible(true);
                            System.out.println("2");
                        }
                        append=true;
                        System.out.println("ChatFram tetiklendi." + client.userName);
                        break;
                    case Text:
                        String temp = client.mf.chat.getText();
                        temp += received.content.toString() + "\n";
                        System.out.println("Text tetiklendi." + client.userName);
                        client.mf.chat.setText(temp);
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(Listen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Listen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
