/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupChat;

import Client.Client;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author mesut
 */
public class ChatRoom {

    public String roomName;
    public ArrayList<String> userList;
    public ChatFrame frame;
    public Client client;
    public ChatRoom( ArrayList<String> _userList, String _roomName, Client _client)
    {
        roomName = _roomName;
        userList = _userList;
        client = _client;
        frame = new ChatFrame(client, userList, roomName);
        frame.setVisible(true);        
        frame.users.setVisible(false);
    }
}
