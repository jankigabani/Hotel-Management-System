
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Menu extends JFrame implements ActionListener{
   
    JCheckBox c1, c2 , c3 ;
    JButton b1 , b2 ;
    JTable t1 ;
    
    Menu(){
        
        JLabel title = new JLabel("MENU");
        title.setBounds(320 , 20 , 500 , 27);
        title.setFont(new Font("Tahoma",Font.BOLD , 34));
        add(title);
        
        c1 = new JCheckBox("Breakfast");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Tahoma",Font.BOLD , 20));
        c1.setBounds(100 , 75 , 200 , 25);
        add(c1);
        
        c2 = new JCheckBox("Lunch");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Tahoma",Font.BOLD , 20));
        c2.setBounds(330 , 75 , 190 , 25);
        add(c2);
        
        c3 = new JCheckBox("Dinner");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Tahoma",Font.BOLD , 20));
        c3.setBounds(530 , 75 , 150 , 25);
        add(c3);
        
        JLabel l3 = new JLabel("Time");
        l3.setBounds(80 , 125 , 100 , 20);
        l3.setFont(new Font("Tahoma",Font.PLAIN , 18));
        add(l3);
        
        JLabel l4 = new JLabel("Type");
        l4.setBounds(260 , 125 , 100 , 20);
        l4.setFont(new Font("Tahoma",Font.PLAIN , 18));
        add(l4);
        
        JLabel l5 = new JLabel("Name");
        l5.setBounds(420 , 125 , 100 , 20);
        l5.setFont(new Font("Tahoma",Font.PLAIN , 18));
        add(l5);
        
        JLabel l7 = new JLabel("Veg/NonVeg");
        l7.setBounds(580 , 125 , 100 , 20);
        l7.setFont(new Font("Tahoma",Font.PLAIN , 18));
        add(l7);
        
        
        t1 = new JTable();
        t1.setBounds(15 , 150 , 700 , 400);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setBounds(170 , 570 , 140 , 40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this); 
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(420 , 570 , 140 , 40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this); 
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/seventeen.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(700 , 20 , 600 , 600);
        add(l1);
        
       getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(300 , 200 , 1340 , 690);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                 String str = "select * from dish";
                 String str1 = "select * from dish where time = 'Breakfast'";
                 String str2 = "select * from dish where time = 'Lunch'";
                 String str3 = "select * from dish where time = 'Dinner'";
                 
                 conn c= new conn();
                 
                 ResultSet rs;
                 
                 if(c1.isSelected()){
                     rs = c.s.executeQuery(str1);
                     t1.setModel(DbUtils.resultSetToTableModel(rs));
                 } else if(c2.isSelected()){
                     rs = c.s.executeQuery(str2);
                     t1.setModel(DbUtils.resultSetToTableModel(rs));
                 } else if(c3.isSelected()){
                     rs = c.s.executeQuery(str3);
                     t1.setModel(DbUtils.resultSetToTableModel(rs));
                 }else{
                    rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                 }
                 
            }catch(Exception e){
                 
            }
        }else if(ae.getSource() == b2){
             new OrderManagement().setVisible(true);
             this.setVisible(false);
         } 
    }
      public static void main(String [] args){
         new Menu().setVisible(true);
    }
}
