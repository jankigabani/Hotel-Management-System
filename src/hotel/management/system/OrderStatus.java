
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class OrderStatus extends JFrame implements ActionListener{
    
    Choice z1 , z2;
    JButton b1 , b2 , b3 , b4;
    JTextField t1;
    
    OrderStatus(){
        
        JLabel l1 = new JLabel("ORDER STATUS");
        l1.setBounds(120 , 30 , 190 , 35);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma",Font.PLAIN , 20));
        add(l1);
        
        JLabel rn = new JLabel("Room Number");
        rn.setBounds(30 , 110 , 150 , 30);
        rn.setFont(new Font("Tahoma",Font.PLAIN , 17));
        add(rn);
        
        z1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                z1.add(rs.getString("room_number"));
            }
        }catch(Exception e){
            
        }
        z1.setBounds(190 , 115 , 150 , 25);
        add(z1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(350 , 115 , 20 , 20);
        b3.addActionListener(this); 
        add(b3);
        
        JLabel j1 = new JLabel("Order Status");
        j1.setBounds(30 , 160 , 150 , 30);
        j1.setFont(new Font("Tahoma",Font.PLAIN , 17));
        add(j1);
       
        t1 = new JTextField();
        t1.setBounds( 190, 160 , 150 , 25);
        add(t1);
        
        b1 = new JButton("Order Completed");
        b1.setBounds(30 , 300 , 140 , 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this); 
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(210 , 300 , 140 , 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this); 
        add(b2);
        
        b4 = new JButton("Update Order Status");
        b4.setBounds(100 , 250 , 190 , 30);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this); 
        add(b4);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twenty.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(380, 420, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(385 , 15 , 380 , 420);
        add(l4);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500 , 200 , 800 , 500);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
            String room_number = z1.getSelectedItem();
             String  order_status = t1.getText();
             String str = "delete from OrderStatus where room_number = '"+room_number+"'";
               conn c = new conn();
               try{
                   c.s.executeUpdate(str);
                   JOptionPane.showMessageDialog(null , "Order Completed");
                   new OrderManagement().setVisible(true);
                   this.setVisible(false);
               }catch(Exception e){
                   
               }
        }else if(ae.getSource() == b2){
            new OrderManagement().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            conn c = new conn();
             try{
             String room_number = z1.getSelectedItem();
             ResultSet rs = c.s.executeQuery("select * from OrderStatus where room_number = '"+room_number+"'");
             while(rs.next()){
                 t1.setText(rs.getString("order_status"));
             }
             }catch(Exception e){
                 
             }
        }else if(ae.getSource() == b4){
            try{
                
                 conn c = new conn();
                 String order_status = t1.getText();
                 String room_number = z1.getSelectedItem();
                 String str = "Update OrderStatus set order_status = '"+order_status+"' where room_number ='"+room_number+"'";
                 c.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null , "Order Updated Successfully");
                 
             }catch(Exception e){
                 
             }
        }
        
    }
    
    public static void main(String [] args){
        new OrderStatus().setVisible(true);
    }
    
}
