
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1 , m2 , m3;
    JMenuItem i1,i2,i3,i4,i5,i6;
    
    Dashboard(){
        
        mb = new JMenuBar();
        add(mb);
        
        m1 = new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.DARK_GRAY);
        mb.add(m1);
        
        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.DARK_GRAY);
        mb.add(m2);
        
        m3 = new JMenu("MEAL ORDER MANAGEMENT");
        m3.setForeground(Color.DARK_GRAY);
        mb.add(m3);
        
        i1 = new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);
        
        i2 = new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);
        
        i3 = new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);
        
        i4 = new JMenuItem("ADD DRIVERS");
        i4 .addActionListener(this);
        m2.add(i4);
        
        i5 = new JMenuItem("ADD DISH");
        i5 .addActionListener(this);
        m2.add(i5);
       
        i6 = new JMenuItem("ORDER");
        i6.addActionListener(this);
        m3.add(i6);
        
        mb.setBounds(0 , 0 ,1920 , 35); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0 , 0 , 1920 , 1000);
        add(l1);
        
        JLabel l2 = new JLabel("THE OBEROIS WELCOMES YOU");
        l2.setBounds(580 , 80 , 1000 , 50);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif", Font.PLAIN , 50));
        l1.add(l2);
        
        
        setLayout(null);
        setBounds(0 ,0 , 1920 , 1040);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getActionCommand().equals("RECEPTION")){
            new Reception().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD DISH")){
            new AddDishes().setVisible(true);
        }else if(ae.getActionCommand().equals("ORDER")){
            new OrderManagement().setVisible(true);
        }
        
    }
    
    public static void main(String [] args){
        new Dashboard().setVisible(true);
        
        
    } 
   
}
