package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

    HotelManagementSystem()    {
        setBounds(450 , 250 , 1024 , 576);
//        setSize(400 , 400);
//        setLocation(300 , 300);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0 ,0 , 1024 , 576);
        add(l1);
        
        JLabel l = new JLabel("OBEROI AMARVILAS");
        l.setBounds(360 , 22 , 1500 , 32);
        l.setForeground(Color.BLACK);
        l.setFont(new Font("Californian FB",Font.BOLD ,32));
        l1.add(l);
        
        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(20 , 490 , 1500 , 25);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.PLAIN ,25));
        l1.add(l2);
        
        JButton b1 = new JButton("NEXT");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("serif",Font.PLAIN,20));
        b1.setBounds(850 , 470 , 120 , 40);
        b1.addActionListener(this);
        l1.add(b1);
        
        setLayout(null);
        setVisible(true);
        
        while(true)
        {
            l2.setVisible(false);
            try{
                Thread.sleep(800);
            }catch(Exception e){
               
            }
             l2.setVisible(true);
             try{
                Thread.sleep(800);
             }catch(Exception e){
                 
             }
        }
       

    }
    
    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);
        this.setVisible(false);

    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
