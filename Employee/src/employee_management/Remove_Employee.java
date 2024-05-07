
package employee_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Remove_Employee extends JFrame implements ActionListener{
    
    Choice cempId;
    JButton delete,back;
    
    Remove_Employee(){
        
        getContentPane().setBackground(new Color(255,127,127));
        setLayout(null);
        
        JLabel labelempId =new JLabel("Employee Id");
        labelempId.setBounds(50,50,200,30);
        labelempId.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelempId);
        
        cempId =new Choice();
        cempId.setBounds(300,50,150,30);
        add(cempId);
        
        try{
            // for taking choice value from db
            Conn c=new Conn();
            String query ="select * from employee";
            java.sql.ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                
                cempId.add(rs.getString("empId")); // for taking choice values from database
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel labelname =new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        labelname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelname);
        
        JLabel lblname =new JLabel();
        lblname.setBounds(300,100,100,30);
        lblname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblname);
        
        JLabel labelphone =new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        labelphone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelphone);
        
        JLabel lblphone =new JLabel();
        lblphone.setBounds(300,150,100,30);
        lblphone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblphone);
        
         JLabel labelemail =new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        labelemail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelemail);
        
        JLabel lblemail =new JLabel();
        lblemail.setBounds(300,200,400,30);
        lblemail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblemail);
        
        try{
            Conn c=new Conn();
            String query ="select * from employee where empId='"+cempId.getSelectedItem()+"' ";
            java.sql.ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
                //lblname.setText(rs.getString("name"));
                
               
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        // for checking the item changing or not 
        cempId.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            
            try{
            Conn c=new Conn();
            String query ="select * from employee where empId='"+cempId.getSelectedItem()+"' ";
            java.sql.ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
                //lblname.setText(rs.getString("name"));
                
               
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            
        }
    });
        
        delete=new JButton("Delete");
        delete.setBounds(100,300,130,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);
        
        back=new JButton("Back");
        back.setBounds(300,300,130,30);
        back.setBackground(Color.black);
        back.addActionListener(this);
        back.setForeground(Color.white);
        add(back);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT); // for scaling the image on frame without using crop
        ImageIcon i3=new ImageIcon(i2); // return into imageicon class
        JLabel image=new JLabel(i3); // we can add image using JLabel class 
        image.setBounds(500,00,600,600);
        add(image);

        
        
        
        
        
        setSize(1000,500);
        setLocation(100,20);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==delete){
            
            // for deleting the data from db
            try{
                Conn c=new Conn();
                String query ="delete from employee where empId='"+cempId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Information Deleted Sucessfully");
                setVisible(false);
                
                new Home();
                
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else{
            setVisible(false);
            new Home();
        }
        
    }
    
        
    public static void main(String a[]){
        new Remove_Employee();
    }
    
}
