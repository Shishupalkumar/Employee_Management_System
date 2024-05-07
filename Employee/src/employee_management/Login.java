
package employee_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;

public class Login extends JFrame implements ActionListener{
     
      JTextField tfusername,tfpassword;
    Login(){
        
        getContentPane().setBackground(new Color(163,255,188)); // for custom color
        setLayout(null);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);
        
        tfusername=new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);
        
        tfpassword=new JTextField();
        tfpassword.setBounds(150,70,150,30);
        add(tfpassword);
        
        JButton login =new JButton("Login");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
         //for image ImageIcon class is use
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT); // for scaling the image on frame without using crop
        ImageIcon i3=new ImageIcon(i2); // return into imageicon class
        JLabel image=new JLabel(i3); // we can add image using JLabel class 
        image.setBounds(350,0,200,200);
        add(image);
        
        
        setSize(600, 300);
        setLocation(450,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String username= tfusername.getText();  // fpr getting the value from textfield 
            String password= tfpassword.getText();
            
            // creating conn class object
            Conn c =new Conn();
            
            // to check the databse values 
            String query ="select * from login where username= '"+username+"' and password = '"+password+"' ";
            
            
           java.sql. ResultSet rs=c.s.executeQuery(query); // ResultSet which is in sql package
            
            // to checking rs values 
            if(rs.next()){
                setVisible(false);
                // create next class object which we want 
                new Home();
            }
            else{
                
               JOptionPane.showMessageDialog(null, " Invalid Username or password "); // for showing pop up 
               setVisible(false);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String a[]){
        new Login();
    }
}
