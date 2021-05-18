/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

/**
 *
 * @author mesut
 */
public class Message implements java.io.Serializable{
    public enum messageType {Name,Text};
    public messageType type;
    public Object content;
    
    public Message(messageType _type){
        type = _type;
    }
}
