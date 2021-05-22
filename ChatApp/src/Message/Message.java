/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mesut
 */
public class Message implements java.io.Serializable{
    public enum messageType {Name,Text,ConnectedClients, ChatGroupConnection,
        PrivateRoomUpdated, PrivateRoomJoin, PrivateRoomList, PrivateRoomCreated};
    public messageType type;
    public String owner;
    public Object content;
    public ArrayList<String> userList;
    public String roomName;
    public HashMap<String, ArrayList<String>> roomList;
    public Message(messageType _type){
        type = _type;
    }
}
