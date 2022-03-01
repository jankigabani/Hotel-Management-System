
package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1 , b2;
    
    Room(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eigth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(555 , -27 , 575 , 570);
        add(icon);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(30 , 30 , 100 , 20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(145 , 30 , 100 , 20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(260 , 30 , 100 , 20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(360 , 30 , 100 , 20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(460 , 30 , 100 , 20);
        add(l5);
        
        t1 = new JTable();
        t1.setBounds(20 , 60 , 520 , 400);
        add(t1);
        
        b1 = new JButton("Load Data");
        b1.setBounds(100 , 480 , 120 , 30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(270 , 480 , 120 , 30);
        b2.addActionListener(this); 
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(450 , 200 , 1160 , 580);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
        try{    
            conn c = new conn();
            String str = "select * from room";
            
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            
        }     
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String [] args){
        new Room().setVisible(true);
    }
}
