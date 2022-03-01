
package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CheckOut extends JFrame implements ActionListener{
    
    Choice c1;
    JTextField t1;
    JButton b1 , b2 , b3;
    
    
    CheckOut()
    {
        JLabel l1 = new JLabel("Check Out");
        l1.setBounds(120 , 20 , 100 , 35);
        l1.setForeground(Color.GRAY);
        l1.setFont(new Font("Tahoma",Font.PLAIN , 20));
        add(l1);
        
        
        
        JLabel l2 = new JLabel("Customer Id");
        l2.setBounds(30 , 80 , 100 , 30);
        add(l2);
        
        c1 = new Choice();
        try{
           conn c = new conn();
           ResultSet rs = c.s.executeQuery("select * from customer");
           while(rs.next()){
              c1.add(rs.getString("number"));
           }
           
        }catch(Exception e){
            
        }
        c1.setBounds(150 , 80 , 150 , 30);
        add(c1);
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30 , 130 , 100 , 30);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds( 150, 130 , 150 , 25);
        add(t1);
        
        b1 = new JButton("Checkout");
        b1.setBounds(30 , 200 , 120 , 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this); 
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(170 , 200 , 100 , 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this); 
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(310 , 80 , 20 , 20);
        b3.addActionListener(this); 
        add(b3);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(350 , 0 , 400 , 250);
        add(l4);
        
        setLayout(null);
        setBounds(500 , 200 , 800 , 330);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == b1){
             String id = c1.getSelectedItem();
             String room_number = t1.getText();
             String str = "delete from customer where number = '"+id+"'";
             String str2 = "Update room set available = 'Available' where room_number = '"+room_number+"'";
               conn c = new conn();
               try{
                   c.s.executeUpdate(str);
                   c.s.executeUpdate(str2);
                   JOptionPane.showMessageDialog(null , "Checkout Done");
                   new Reception().setVisible(true);
                   this.setVisible(false);
               }catch(Exception e){
                   
               }
         
         }else if(ae.getSource() == b2){
             new Reception().setVisible(true);
             this.setVisible(false);
         }else if(ae.getSource() == b3){
             conn c = new conn();
             try{
             String id = c1.getSelectedItem();
             ResultSet rs = c.s.executeQuery("select * from customer where number = '"+id+"'");
             while(rs.next()){
                 t1.setText(rs.getString("room_number"));
             }
             }catch(Exception e){
                 
             }
         }
    }
    
     public static void main(String [] args){
        new CheckOut().setVisible(true);
    }
    
}