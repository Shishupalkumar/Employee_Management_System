
package employee_management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
     JButton update,add,view,remove ;
    
    Home(){
        
        setLayout(null);
        
        //for image ImageIcon class is use
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120, 630,Image.SCALE_DEFAULT); // for scaling the image on frame without using crop
        ImageIcon i3=new ImageIcon(i2); // return into imageicon class
        JLabel image=new JLabel(i3); // we can add image using JLabel class 
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading =new JLabel("Employee Management System");
        heading.setBounds(620,20,400,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setForeground(Color.red);
        image.add(heading);
        
        add = new JButton("Add Employee");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        image.add(add);
        
        view  = new JButton("View Employee");
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        image.add(view);
        
        update  = new JButton("Update Employee");
        update.setBounds(650,140,150,40);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(820,140,150,40);
        remove.addActionListener(this);
        image.add(remove);
        
        
        
        setSize(1120, 630);
        setLocation(100,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        // differencitiate the button that which button is call
        
        if(ae.getSource()==add){
            setVisible(false);
            new AddEmployee();
            
        }
        else if(ae.getSource()== view){
            new View_Employee();
            setVisible(false);
            
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new View_Employee();
            

        }
        else if(ae.getSource()== remove){
            setVisible(false);
            new Remove_Employee();
            
        }
        
    }
    public static void main(String a[]){
        new Home();
    }
    
}
