
package hotel.management.system;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    
    
    JComboBox c1;
    JCheckBox c2 ;
    JButton b1 , b2 ;
    JTable t1;
    
    SearchRoom(){
        
        JLabel l1 = new JLabel("Search For Room");
        l1.setBounds(400 , 30 , 200 , 30);
        l1.setForeground(Color.GRAY);
        l1.setFont(new Font("Tahoma",Font.PLAIN , 20));
        add(l1);
        
        JLabel l2 = new JLabel("Room Bed Type");
        l2.setBounds(100 , 100 , 130 , 20);
        l2.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l2);
        
        
        c1 = new JComboBox(new String[] {"Single Bed" , "Double Bed"});
        c1.setBounds(230 , 100 , 150 , 25);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        
        c2 = new JCheckBox("Only display Available");
        c2.setBackground(Color.WHITE);
        c2.setBounds(650 , 100 , 150 , 25);
        add(c2);
        
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
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(50 , 160 , 100 , 20);
        l3.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l3);
        
        JLabel l4 = new JLabel("Availability");
        l4.setBounds(270 , 160 , 100 , 20);
        l4.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l4);
        
        JLabel l5 = new JLabel("Cleaning Status");
        l5.setBounds(450 , 160 , 100 , 20);
        l5.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l5);
        
        JLabel l7 = new JLabel("Price");
        l7.setBounds(680 , 160 , 100 , 20);
        l7.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l7);
        
        JLabel l6 = new JLabel("Bed Type");
        l6.setBounds(860 , 160 , 100 , 20);
        l6.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l6);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500 , 200 , 1000 , 650);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == b1){
             try{
                 String str = "select * from Room where bed_type = '"+c1.getSelectedItem()+"'";
                 String str2 = "select * from room where available = 'Available' AND  bed_type = '"+c1.getSelectedItem()+"'";
                 conn c= new conn();
                 
                 ResultSet rs;
                 if(c2.isSelected()){
                     rs = c.s.executeQuery(str2);
                     t1.setModel(DbUtils.resultSetToTableModel(rs));
                 } else{
                    rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                 }
                
             }catch(Exception e){
                 
             }
         }else if(ae.getSource() == b2){
             new Reception().setVisible(true);
             this.setVisible(false);
         } 
    }
    public static void main(String [] args){
         new SearchRoom().setVisible(true);
    }
    
}
