
package hotel.management.system;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class PickUp extends JFrame implements ActionListener{
    
    
    
    Choice c1;
    JButton b1 , b2 ;
    JTable t1;
    
    PickUp(){
        
        JLabel l1 = new JLabel("PickUp Service");
        l1.setBounds(400 , 30 , 200 , 30);
        l1.setForeground(Color.GRAY);
        l1.setFont(new Font("Tahoma",Font.PLAIN , 20));
        add(l1);
        
        JLabel l2 = new JLabel("Type of Car");
        l2.setBounds(100 , 100 , 100 , 20);
        l2.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l2);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs= c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("brand"));
            }
        }catch(Exception e){
            
        }
        c1.setBounds(200 ,100 , 200 , 25 );
        add(c1);
        
        t1 = new JTable();
        t1.setBounds(0 , 200 , 1000 , 300);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setBounds(330 , 520 , 120 , 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this); 
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(530 , 520 , 120 , 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this); 
        add(b2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(50 , 160 , 100 , 20);
        l3.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l3);
        
        JLabel l4 = new JLabel("Age");
        l4.setBounds(200 , 160 , 100 , 20);
        l4.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l4);
        
        JLabel l5 = new JLabel("Gender");
        l5.setBounds(330 , 160 , 100 , 20);
        l5.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l5);
        
        JLabel l7 = new JLabel("Company");
        l7.setBounds(470 , 160 , 100 , 20);
        l7.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l7);
        
        JLabel l6 = new JLabel("Brand");
        l6.setBounds(620 , 160 , 100 , 20);
        l6.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l6);
        
        JLabel l8 = new JLabel("Availabilty");
        l8.setBounds(755 , 160 , 100 , 20);
        l8.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l8);
        
        JLabel l9 = new JLabel("Location");
        l9.setBounds(890 , 160 , 100 , 20);
        l9.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l9);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500 , 200 , 1000 , 650);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == b1){
             try{
                 String str = "select * from driver where brand = '"+c1.getSelectedItem()+"'";
                 conn c= new conn();
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
         new PickUp().setVisible(true);
    }
    
}
