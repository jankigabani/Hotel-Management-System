
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener{
    
    
    JTextField t1 , t2 , t3 , t4 , t5;
    JComboBox c1 , c2;
    JButton b1 , b2;
    AddDriver(){
        
        JLabel title = new JLabel("Add Drivers");
        title.setBounds(150 , 10 , 150 , 30);
        title.setFont(new Font("Tahoma",Font.BOLD , 18));
        add(title);
        
        JLabel name = new JLabel("Name");
        name.setBounds(60 , 70 , 100 , 30);
        name.setFont(new Font("Tahoma",Font.PLAIN , 16));
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200 , 70 , 150 , 30);
        add(t1);
        
        JLabel age = new JLabel("Age");
        age.setBounds(60 , 110 , 100 , 30);
        age.setFont(new Font("Tahoma",Font.PLAIN , 16));
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(200 , 110 , 150 , 30);
        add(t2);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(60 , 150 , 100 , 30);
        gender.setFont(new Font("Tahoma",Font.PLAIN , 16));
        add(gender);
        
        c1 = new JComboBox(new String[] {"Male" , "Female"});
        c1.setBounds(200 , 150 , 150 , 30);
        c1.setBackground(Color.WHITE);
        add(c1);
       
        JLabel car = new JLabel("Car Company");
        car.setBounds(60 , 190 , 100 , 30);
        car.setFont(new Font("Tahoma",Font.PLAIN , 16));
        add(car);
        
        t3 = new JTextField();
        t3.setBounds(200 , 190 , 150 , 30);
        add(t3);
        
        JLabel model = new JLabel("Car Model");
        model.setBounds(60 , 230 , 100 , 30);
        model.setFont(new Font("Tahoma",Font.PLAIN , 16));
        add(model);
        
        t4 = new JTextField();
        t4.setBounds(200 , 230 , 150 , 30);
        add(t4);
        
        JLabel available = new JLabel("Available");
        available.setBounds(60 , 270 , 100 , 30);
        available.setFont(new Font("Tahoma",Font.PLAIN , 16));
        add(available);
       
        c2 = new JComboBox(new String[] {"Available" , "Unavailable"});
        c2.setBounds(200 , 270 , 150 , 30);
        c2.setBackground(Color.WHITE);
        add(c2);
       
        JLabel location = new JLabel("Location");
        location.setBounds(60 , 310 , 100 , 30);
        location.setFont(new Font("Tahoma",Font.PLAIN , 16));
        add(location);
        
        t5 = new JTextField();
        t5.setBounds(200 , 310 , 150 , 30);
        add(t5);
        
        b1 = new JButton("Add Driver");
        b1.setBounds(50 , 370 , 130 , 30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(220 , 370 , 130 , 30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/sixth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400 , 20 , 550 , 400);
        add(l1);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(465 , 200 , 1000 , 500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() ==  b1){
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String)c1.getSelectedItem();
            String company = t3.getText();
            String brand = t4.getText();
            String available = (String)c2.getSelectedItem();
            String location = t5.getText();
            
            
            conn c = new conn();
            try{
                String str = "insert into driver values ('"+name+"', '"+age+"' , '"+gender+"' , '"+company+"' , '"+brand+"' , '"+available+"', '"+location+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null , "Driver Added");
                this.setVisible(false);
            
            }catch(Exception e){
                
            }
            
        }else if(ae.getSource() == b2){
            setVisible(false);
        }
    }
    public static void main(String [] args){
        new AddDriver().setVisible(true);
    }
}
