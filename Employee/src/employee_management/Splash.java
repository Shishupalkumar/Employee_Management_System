
package employee_management;

// import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Splash extends JFrame implements ActionListener{
 
    
    Splash(){
        
        getContentPane().setBackground(Color.white); //method in awt and usd for changing form color
        
        JLabel heading =new JLabel("Employee Management System");
        heading.setBounds(80,20,1200,80);
        heading.setFont(new Font("serif",Font.BOLD,60)); // for font 
        heading.setForeground(Color.red);  // for heading forecolor
        add(heading);
        
        //for image ImageIcon class is use
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1170, 650,Image.SCALE_DEFAULT); // for scaling the image on frame without using crop
        ImageIcon i3=new ImageIcon(i2); // return into imageicon class
        JLabel image=new JLabel(i3); // we can add image using JLabel class 
        image.setBounds(50,100,1050,500);
        add(image);
        
         JButton clickhere =new JButton("Click here to Continue");
        clickhere.setBounds(400,400,300,70);
        clickhere.setBackground(Color.black);
        clickhere.setForeground(Color.white);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        
        setLayout(null);
       setSize(1170,650);
       setLocation(100,40);
        setVisible(true);
        
        
        // for dippering the heading 
        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);  // it is the method for sleeping the threadbut hising the heading 
                
            }catch(Exception e){   
            }  //heading.setVisible(true);
        
       heading.setVisible(true);
            try{
                Thread.sleep(500);  // it is the method for sleeping the thread and showing the heading 
                
            }catch(Exception e){
                e.printStackTrace();
                
            }  
    }
    }
    // abstarct method of ActionListener interface
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login(); // for opening login form
        
        
    }
    
    public static void main(String a[]){
        new Splash();
        
    }  
}
