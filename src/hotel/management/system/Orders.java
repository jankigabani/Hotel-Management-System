
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Orders extends JFrame implements ActionListener {
    
    JComboBox c1 , c2 , c3 , c4;
    JButton b1 , b2 , b3 , b4 , b5;
    Choice z1 , z2;
    JTable t1;
    
    Orders(){
        
        JLabel title = new JLabel("ORDERS");
        title.setBounds(480 , 20 , 500 , 27);
        title.setFont(new Font("Tahoma",Font.BOLD , 34));
        add(title);
        
        JLabel title1 = new JLabel("Check Order For Once");
        title1.setBounds(900 , 70 , 500 , 27);
        title1.setFont(new Font("Tahoma",Font.PLAIN, 25));
        add(title1);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/fifteen.jpeg"));
        Image i8 = i7.getImage().getScaledInstance(220, 600, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l1 = new JLabel(i9);
        l1.setBounds(30 , 20 , 220 , 600);
        add(l1);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/line.jpg"));
        Image i11 = i10.getImage().getScaledInstance(5, 500, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l2 = new JLabel(i12);
        l2.setBounds(710 , 80 , 5 , 500);
        add(l2);
        
        JLabel rn = new JLabel("Room Number");
        rn.setBounds(300 , 100 , 150 , 30);
        rn.setFont(new Font("Tahoma",Font.PLAIN , 19));
        add(rn);
        
        z2 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                z2.add(rs.getString("room_number"));
            }
        }catch(Exception e){
            
        }
        z2.setBounds(480 , 105 , 150 , 25);
        add(z2);
        
        JLabel time = new JLabel("Order Time");
        time.setBounds(300 , 170 , 100 , 30);
        time.setFont(new Font("Tahoma",Font.PLAIN , 19));
        add(time);
        
        c1 = new JComboBox(new String[] {"Breakfast" , "Lunch" , "Dinner"});
        c1.setBounds(480 , 170 , 150 , 30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(650 , 170 , 25, 25);
        b3.addActionListener(this); 
        add(b3);
        
        JLabel type = new JLabel("Type");
        type.setBounds(300 , 240 , 100 , 30);
        type.setFont(new Font("Tahoma",Font.PLAIN , 19));
        add(type);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b2 = new JButton(i3);
        b2.setBounds(650 , 240 , 25, 25);
        b2.addActionListener(this); 
        add(b2);
        
        c2 = new JComboBox();
        c2.addActionListener(this);
        c2.setBounds(480 , 240 , 150 , 30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        JLabel name = new JLabel("Name");
        name.setBounds(300 , 310 , 100 , 30);
        name.setFont(new Font("Tahoma",Font.PLAIN , 19));
        add(name);
        
        z1 = new Choice();
        z1.setBounds(480 , 310 , 150 , 65);
        add(z1);
        
        JLabel q = new JLabel("Quantity");
        q.setBounds(300 , 380 , 100 , 25);
        q.setFont(new Font("Tahoma",Font.PLAIN , 19));
        add(q);
        
        c3 = new JComboBox(new String[] {"1" , "2" , "3", "4" , "5" , "6", "7" , "8" , "9", "10"});
        c3.setBounds(480 , 380 , 150 , 30);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        JLabel os = new JLabel("Order Status");
        os.setBounds(300 , 445 , 150 , 25);
        os.setFont(new Font("Tahoma",Font.PLAIN , 19));
        add(os);
        
        c4 = new JComboBox(new String[] {"Uncompleted" , "Completed"});
        c4.setBounds(480 , 445 , 150 , 30);
        c4.setBackground(Color.WHITE);
        add(c4);
        
        JLabel j1 = new JLabel("Room Number");
        j1.setBounds(745 , 110 , 150 , 30);
        j1.setFont(new Font("Tahoma",Font.BOLD , 12));
        add(j1);
        
        JLabel j2 = new JLabel("Time");
        j2.setBounds(865 , 110 , 150 , 30);
        j2.setFont(new Font("Tahoma",Font.BOLD , 12));
        add(j2);
        
        JLabel j3 = new JLabel("Type");
        j3.setBounds(950 , 110 , 150 , 30);
        j3.setFont(new Font("Tahoma",Font.BOLD , 12));
        add(j3);
        
        JLabel j4 = new JLabel("Name");
        j4.setBounds(1050 , 110 , 150 , 30);
        j4.setFont(new Font("Tahoma",Font.BOLD , 12));
        add(j4);
        
        JLabel j5 = new JLabel("Quantity");
        j5.setBounds(1140 , 110 , 150 , 30);
        j1.setFont(new Font("Tahoma",Font.BOLD , 12));
        add(j5);
        
        JLabel j6 = new JLabel("Order Status");
        j6.setBounds(1220 , 110 , 150 , 30);
        j6.setFont(new Font("Tahoma",Font.BOLD , 11));
        add(j6);
        
        t1 = new JTable();
        t1.setBounds(740 , 150 , 570 , 300);
        add(t1);
        
        b1 = new JButton("Add Order");
        b1.setBounds(310 , 530 , 130 , 40);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b4 = new JButton("Back");
        b4.setBounds(487 , 530 , 130 , 40);
        b4.addActionListener(this);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        add(b4);
        
        b5 = new JButton("Load Order");
        b5.setBounds(950 , 530 , 130 , 40);
        b5.addActionListener(this);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        add(b5);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(300 , 200 , 1340 , 680);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b3){
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
        }else if(ae.getSource() == b2){
            try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from dish where time = '"+c1.getSelectedItem()+"' AND type = '"+c2.getSelectedItem()+"'");
            while(rs.next()){
                z1.add(rs.getString("name"));
            }
        }catch(Exception e){
            
        }
        }else if(ae.getSource() == b1){
            String room_number = (String)z2.getSelectedItem();
            String time = (String)c1.getSelectedItem();
            String type = (String)c2.getSelectedItem();
            String name = (String)z1.getSelectedItem();
            String quantity = (String)c3.getSelectedItem();
            String order_status = (String)c4.getSelectedItem();
        
        conn c = new conn();
            try{
                String str = "insert into OrderStatus values ('"+room_number+"', '"+time+"' , '"+type+"' , '"+name+"', '"+quantity+"', '"+order_status+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null , "Order Added");
            }
            catch(Exception e){
                
            }
        }else if(ae.getSource() == b4){
            new OrderManagement().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b5){
             try{
                 String str1 = "select * from OrderStatus where room_number = '"+z2.getSelectedItem()+"'";
                               
                 conn c= new conn();
                 
                 ResultSet rs;
                     rs = c.s.executeQuery(str1);
                     t1.setModel(DbUtils.resultSetToTableModel(rs));
                 
            }catch(Exception e){
                 
            }
        }
        
    }
     public static void main(String [] args){
         new Orders().setVisible(true);
    }
}
