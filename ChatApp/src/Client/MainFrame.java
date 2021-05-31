/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import GroupChat.ChatFrame;
import GroupChat.ChatRoom;
import Message.Message;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author mesut
 */
public class MainFrame extends javax.swing.JFrame {

    public Client c; //client için değişken oluşturulur

    /**
     * Creates new form MainFrame
     */
    public MainFrame(Client _c) {
        initComponents();
        c = _c; //gelen client değişkene atlır

    }

    private MainFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        chat = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        Send = new javax.swing.JButton();
        connectRoomBtn = new javax.swing.JButton();
        privateChat1 = new javax.swing.JButton();
        createRoom1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        privateRoomName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        roomList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chat.setColumns(20);
        chat.setRows(5);
        jScrollPane1.setViewportView(chat);

        message.setColumns(20);
        message.setRows(5);
        jScrollPane3.setViewportView(message);

        Send.setText("Gönder");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        connectRoomBtn.setText("Özel Odaya Bağlan");
        connectRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectRoomBtnActionPerformed(evt);
            }
        });

        privateChat1.setText("Seçili Kişiyle Özel Mesajlaş");
        privateChat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                privateChat1ActionPerformed(evt);
            }
        });

        createRoom1.setText("Özel Oda Oluştur");
        createRoom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRoom1ActionPerformed(evt);
            }
        });

        userList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(userList);

        jLabel1.setText("Kullanıcı");

        jLabel2.setText("Özel oda adını giriniz.");

        jLabel3.setText("Özel Odalar Listesi");

        roomList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(roomList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(user)
                        .addGap(173, 173, 173)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Send, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(connectRoomBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createRoom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(privateChat1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(privateRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane4)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(privateChat1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(privateRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createRoom1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(connectRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Send, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed
        // TODO add your handling code here:
        Message msg = new Message(Message.messageType.Text); //gönderilecek mesaj için obje oluşturulur
        msg.content = message.getText();    //bilgi mesaja eklenir
        c.Send(msg);//gönderilir
        message.setText("");    //textfield boşaltılır
    }//GEN-LAST:event_SendActionPerformed

    private void privateChat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_privateChat1ActionPerformed
        //eğer seçilen değer null ise veya kendisine eşitse birşey yapma
        if (userList.getSelectedValue().toString().equals(null) || userList.getSelectedValue().toString().equals(c.userName)) {

        } else {    //yap
            ArrayList<String> participiant = new ArrayList<String>();   //chat için gerekli kullanıcıları tutacak arraylist oluşturulur
            participiant.add(c.userName);   //gönderen kişi bu listeye eklenir
            participiant.add(userList.getSelectedValue().toString());   //alacak kişi listeye eklenir
            ChatRoom cr = new ChatRoom(participiant, userList.getSelectedValue().toString(), c); //chatroom objesi oluşturulur

        }
    }//GEN-LAST:event_privateChat1ActionPerformed

    private void createRoom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRoom1ActionPerformed
        if (privateRoomName.getText().equals("")) { //chatroom ado boşsa bişey yapma 
            
        }else{
        boolean flag = false;
        for (int i = 0; i < roomList.getModel().getSize(); i++) {   //chatroom daha önce mevcutsa bayrağı kaldır
            if (roomList.getModel().getElementAt(i).equals(privateRoomName.getText())) {
                flag = true;
            }
        }
        if (flag == false) {    //değilse odayı ekle
            Message createdRoom = new Message(Message.messageType.PrivateRoomCreated);  //oda oluşturulması için mesaj oluşturulur
            createdRoom.roomName = privateRoomName.getText();   // oda adı mesaja girilir
            ArrayList<String> participiant = new ArrayList<String>();   //odanın katılımcı listesi oluşturulur
            participiant.add(c.userName);   //katılımcılara gönderen kişi eklenir
            createdRoom.userList = participiant;    //liste mesaja eklenir
            c.Send(createdRoom);    //gönderlir   
        }
        }
    }//GEN-LAST:event_createRoom1ActionPerformed

    private void connectRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectRoomBtnActionPerformed

        String roomName = roomList.getSelectedValue();  //bağlanılacak odanın adı alınır
        ChatRoom cr = new ChatRoom(null, roomName, c);  //chatroom objesi oluşturulur ve frami oluşturur
        cr.frame.isPrivateRoom = true;  //özel oda flağı kaldırılır
        c.chatFrameList.add(cr.frame);  //frame listesine bu oluşan frame objesi eklenir

        Message msg = new Message(Message.messageType.PrivateRoomJoin);// bu alanla ilgili mesaj tipi oluşturulur
        msg.roomName = roomName;    //oda adı mesaja eklenir
        msg.owner = c.userName; //oda sahibi mesaja eklenir

        c.Send(msg);    //mesaj gönderilir
        cr.frame.setVisible(true);  //frame açılır
    }//GEN-LAST:event_connectRoomBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Send;
    public javax.swing.JTextArea chat;
    public javax.swing.JButton connectRoomBtn;
    public javax.swing.JButton createRoom1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTextArea message;
    public javax.swing.JButton privateChat1;
    public javax.swing.JTextField privateRoomName;
    public javax.swing.JList<String> roomList;
    public javax.swing.JLabel user;
    public javax.swing.JList<String> userList;
    // End of variables declaration//GEN-END:variables
}
