

package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDishes extends JFrame implements ActionListener{
    JTextField t1;
    JComboBox c1 , c2;
    JButton b1 , b2 , b3;
    JRadioButton r1 , r2 ;
    AddDishes(){
        
        JLabel title = new JLabel("Add Dish");
        title.setBounds(180 , 20 , 150 , 30);
        title.setFont(new Font("Tahoma",Font.BOLD , 23));
        add(title);
        
        JLabel time = new JLabel("Order Time");
        time.setBounds(60 , 100 , 100 , 30);
        time.setFont(new Font("Tahoma",Font.PLAIN , 16));
        add(time);
        
        c1 = new JComboBox(new String[] {"Breakfast" , "Lunch" , "Dinner"});
        c1.setBounds(220 , 100 , 150 , 30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(380 , 100 , 25, 25);
        b3.addActionListener(this); 
        add(b3);
        
        JLabel type = new JLabel("Type");
        type.setBounds(60 , 140 , 100 , 30);
        type.setFont(new Font("Tahoma",Font.PLAIN , 16));
        add(type);
        
        c2 = new JComboBox();
        c2.addActionListener(this);
        c2.setBounds(220 , 140 , 150 , 30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        JLabel name = new JLabel("Name");
        name.setBounds(60 , 180 , 100 , 30);
        name.setFont(new Font("Tahoma",Font.PLAIN , 16));
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(220 , 180 , 150 , 30);
        add(t1);
        
        JLabel vn = new JLabel("Veg./NonVeg.");
        vn.setBounds(60 , 220 , 100 , 30);
        vn.setFont(new Font("Tahoma",Font.PLAIN , 16));
        add(vn);
        
        r1 = new JRadioButton("Veg");
        r1.setFont(new Font("serif",Font.PLAIN , 14));
        r1.setBounds(220 , 220 , 70 , 30);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton("NonVeg");
        r2.setFont(new Font("serif",Font.PLAIN , 14));
        r2.setBounds(290 , 220 , 90 , 30);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        b1 = new JButton("Add Dish");
        b1.setBounds(60 , 330 , 130 , 30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(235 , 330 , 130 , 30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/thirteen.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l1 = new JLabel(i6);
        l1.setBounds(400 , 20 , 530 , 400);
        add(l1);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(465 , 200 , 970 , 500);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() ==  b1){
            String time = (String)c1.getSelectedItem();
            String type = (String)c2.getSelectedItem();
            String name = t1.getText();
            String vn = null;
        
        if(r1.isSelected()){
            vn = "Veg";
        }else if(r2.isSelected()){
            vn = "NonVeg";
        }
        
        conn c = new conn();
            try{
                String str = "insert into dish values ('"+time+"', '"+type+"' , '"+name+"' , '"+vn+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null , "Dish Added");
                this.setVisible(false);
            }
            catch(Exception e){
                
            }
        
        }else if(ae.getSource() == b2){
            setVisible(false);
        }else if(ae.getSource() == b3){
            try{     
        if(c1.getSelectedItem().equals("Breakfast")){
            c2.getSelectedItem();
            c2.addItem("Waffles");
            c2.addItem("Pancakes");
            c2.addItem("Pastries");
            c2.addItem("Fruits/juices");
            c2.addItem("Sandwiches");
            c2.addItem("Hot Items");
            c2.addItem("Beverages");
        }else if(c1.getSelectedItem().equals("Lunch")){
            c2.getSelectedItem();
            c2.addItem("Veg Appetizer/Starters");
            c2.addItem("Soups");
            c2.addItem("Rice and noodles");
            c2.addItem("salad");
            c2.addItem("chinese dishes");
            c2.addItem("Roti");
            c2.addItem("Burgers/Sandwiches/pizzas");
            c2.addItem("Drinks");
        }else if(c1.getSelectedItem().equals("Dinner")){
            c2.getSelectedItem();
            c2.addItem("Italian/Pasta");
            c2.addItem("Soups/Salads");
            c2.addItem("Burgers/Sandwiches/pizzas");
            c2.addItem("Indian Main course");
            c2.addItem("Paratha");
            c2.addItem("Papad");
            c2.addItem("Rice / Noodles");
            c2.addItem("Desserts");
            c2.addItem("Hot Beverages");
            c2.addItem("Ice cream");
        }
        String type = (String)c2.getSelectedItem();
         }
        catch(Exception e){
            System.out.println(e);
        }
        }
    }
  
    public static void main(String [] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new AddDishes().setVisible(true);
            }
        });
        
    }
}
