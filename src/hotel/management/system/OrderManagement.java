
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OrderManagement extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4;
    
    OrderManagement(){
        
        JLabel title = new JLabel("MEAL ORDER MANAGEMENT");
        title.setBounds(165 , 50 , 500 , 30);
        title.setFont(new Font("Tahoma",Font.BOLD , 25));
        add(title);
        
        b1 = new JButton("Menu");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50 , 150 , 200 , 50);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Order");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(50 , 220 , 200 , 50);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Order Status");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(50 , 290 , 200 , 50);
        b3.addActionListener(this); 
        add(b3);
        
        b4 = new JButton("Close");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(50 , 360 , 200 , 50);
        b4.addActionListener(this);
        add(b4);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/fourteen.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(360, 320, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(200 , 40 , 550 , 470);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(585 , 200 , 700 , 510);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            new Menu().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b2){
            new Orders().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            new OrderStatus().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b4){
            setVisible(false);
        }
    }
    public static void main(String [] args){
        new OrderManagement().setVisible(true);
        
    }
}
