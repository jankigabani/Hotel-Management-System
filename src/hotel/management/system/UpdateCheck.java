
package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    JButton b1 , b2 , b3;
    Choice c1;
    JTextField t1 , t2 , t3 , t4 , t5;
    
    UpdateCheck(){
        
        JLabel l1 = new JLabel("Check-in Details");
        l1.setFont(new Font("Tahoma",Font.PLAIN , 25));
        l1.setForeground(Color.GRAY);
        l1.setBounds(100 ,20 ,200 , 30 );
        add(l1);
       
        
        JLabel l2 = new JLabel("Customer-ID");
        l2.setBounds(30 ,80 ,100 , 20 );
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
        c1.setBounds(220 , 80 , 150 , 25);
        add(c1);
         
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30 ,120 ,100 , 20 );
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(220 , 120 , 150 , 25 );
        add(t1);
        
         
        JLabel l4 = new JLabel("Name");
        l4.setBounds(30 ,160 ,100 , 20 );
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(220 , 160 , 150 , 25 );
        add(t2);
        
        JLabel l5 = new JLabel("Checked-In ");
        l5.setBounds(30 ,200 ,100 , 20 );
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(220 , 200 , 150 , 25 );
        add(t3);
         
        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(30 ,240 ,100 , 20 );
        add(l6);
        
        t4 = new JTextField();
        t4.setBounds(220 , 240 , 150 , 25 );
        add(t4);
        
        JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(30 ,280 ,100 , 20 );
        add(l7);
        
        t5 = new JTextField();
        t5.setBounds(220 , 280 , 150 , 25 );
        add(t5);
        
        
        b1 = new JButton("Check");
        b1.setBounds(30 , 340 , 100 , 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this); 
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBounds(150 , 340 , 100 , 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this); 
        add(b2);
       
        b3 = new JButton("Back");
        b3.setBounds(270 , 340 , 100 , 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this); 
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/ten.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 430, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(400 , 0 , 575 , 400);
        add(icon);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500 , 200 , 1000 , 470);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == b1){
             try{
                 String room_number = null;
                 String deposit = null;
                 int PendingAmount ;
                 String price = null ;
                 conn c = new conn();
                 String id = c1.getSelectedItem();
                 String str = "select * from customer where number = '"+id+"'";
                 ResultSet rs = c.s.executeQuery(str);
                 while(rs.next()){
                     t1.setText(rs.getString("room_number"));
                     t2.setText(rs.getString("name"));
                     t3.setText(rs.getString("status"));
                     t4.setText(rs.getString("deposit"));
                     room_number = rs.getString("room_number");
                      deposit = rs.getString("deposit");
                 }
                 ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room_number+"'");
                 while(rs2.next()){
                     price = rs2.getString("price");
                 }
                     PendingAmount = Integer.parseInt(price)- Integer.parseInt(deposit);
                     t5.setText(Integer.toString(PendingAmount));
                 
             }catch(Exception e){
                 
             }
         }else if(ae.getSource() == b2){
              try{
                                conn c = new conn();
                                
                                String s1 = c1.getSelectedItem();
				String room_number = t1.getText(); //room_number;    
                                String name = t2.getText(); //name    
                                String status = t3.getText(); //status;    
                                String deposit = t4.getText(); //deposit    
				
                                c.s.executeUpdate("update customer set room_number = '"+room_number+"', name = '"+name+"', status = '"+status+"', deposit = '"+deposit+"' where number = '"+s1+"'");
                                
                                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                                new Reception().setVisible(true);
                                setVisible(false);
                            }catch(Exception ee){
                                System.out.println(ee);
                            }				
         }else if(ae.getSource() == b3){
             new Reception().setVisible(true);
             this.setVisible(false);
         }
    }
    
    public static void main(String [] args){
        new UpdateCheck().setVisible(true);
    }
    
}
