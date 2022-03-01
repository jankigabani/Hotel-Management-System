
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField t1 , t2 , t3 , t4 , t5;
    JButton b1 , b2;
    JComboBox c1 ;
    JRadioButton r1 , r2;
    Choice c2;
    
    AddCustomer(){
        
        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(100 , 20 , 300 , 30);
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Tahoma",Font.BOLD , 20));
        add(l1);
        
        JLabel l2 = new JLabel("ID");
        l2.setBounds(35 , 80 , 100 , 20);
        l2.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l2);
        
        c1 = new JComboBox(new String[] {"Passport" , "Voter-id Card" , "Driving License" , "Aadhar Card"});
        c1.setBounds(250 , 80 , 150 , 25);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        JLabel l3 = new JLabel("NUMBER");
        l3.setBounds(35 , 120 , 100 , 20);
        l3.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(250 ,120 , 150 , 25 );
        add(t1);
        
        JLabel l4 = new JLabel("NAME");
        l4.setBounds(35 , 160 , 100 , 20);
        l4.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(250 ,160 , 150 , 25 );
        add(t2);
        
        JLabel l5 = new JLabel("GENDER");
        l5.setBounds(35 , 200 , 100 , 20);
        l5.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l5);
        
        r1 = new JRadioButton("Male");
        r1.setBounds(250 , 200 , 60 , 25);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setBounds(325 , 200 , 70 , 25);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        JLabel l6 = new JLabel("COUNTRY");
        l6.setBounds(35 , 240 , 100 , 20);
        l6.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l6);
        
        t3 = new JTextField();
        t3.setBounds(250 ,240 , 150 , 25 );
        add(t3);
        
        JLabel l7 = new JLabel("ALLOCATED ROOM NUMBER");
        l7.setBounds(35 , 280 , 200 , 20);
        l7.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l7);
        
        c2 = new Choice();
        try{
            conn c = new conn();
            String str = "select * from room";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c2.add(rs.getString("room_number"));
            }
            
        }catch(Exception e){}
        c2.setBounds(250 , 280 , 150 , 25);
        add(c2);
      
        
        JLabel l8 = new JLabel("CHECKED IN");
        l8.setBounds(35 , 320 , 100 , 20);
        l8.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l8);
        
        t4 = new JTextField();
        t4.setBounds(250 ,320 , 150 , 25 );
        add(t4);
        
        JLabel l9 = new JLabel("DEPOSIT");
        l9.setBounds(35 , 360 , 100 , 20);
        l9.setFont(new Font("Tahoma",Font.PLAIN , 15));
        add(l9);
        
        t5 = new JTextField();
        t5.setBounds(250 ,360 , 150 , 25 );
        add(t5);
        
        b1 = new JButton("Add Customer");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(55 , 410 , 120 , 25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(230 , 410 , 120 , 25);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/customers.jpg"));
        Image i2 = i1.getImage().getScaledInstance(530, 380, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(400 , -60 , 575 , 570);
        add(icon);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500 , 200 , 1000 , 500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1){
        String id = (String) c1.getSelectedItem();
        String number = t1.getText();
        String name = t2.getText();
        String gender = null ;
        if(r1.isSelected()){
            gender = "Male";
        }else if (r2.isSelected()){
            gender = "Female";
        }
        String country = t3.getText();
        String room_number = c2.getSelectedItem();
        String status = t4.getText();
        String deposit = t5.getText();
       
        String str = "insert into customer values('"+id+"', '"+number+"' , '"+name+"' , '"+gender+"' , '"+country+"', '"+room_number+"', '"+status+"' , '"+deposit+"')";
        String str2 = "Update room set available = 'Occupied' where room_number = '"+room_number+"'";
        try{
            conn c = new conn();
            c.s.executeUpdate(str);
            c.s.executeUpdate(str2);
            JOptionPane.showMessageDialog(null , "New Customer Added");
            new Reception().setVisible(true);
            this.setVisible(false);
        }catch(Exception  e){
            
        }
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String [] args){
        new AddCustomer().setVisible(true);
    }
    
    
}
