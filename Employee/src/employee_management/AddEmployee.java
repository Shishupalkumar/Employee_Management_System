
package employee_management;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
//import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran =new Random(); // random class for random num in util package 
    int number =ran.nextInt(999999); // for generatin random numbers 
    
    JButton add,back;
    JTextField tfname, tffname,tfsalary ,tfaddress,tfphone,tfemail,tfdesignation,tfadhar;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempId;
    
    AddEmployee(){
        
         getContentPane().setBackground(new Color(163,255,188)); // for custom color
        
        JLabel heading =new JLabel("Add  Employee Details");
        heading.setBounds(300,20,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname =new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        labelname.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(labelname);
        
        tfname =new JTextField();
        tfname.setBounds(160,100,150,30);
        add(tfname);
        
        JLabel labelfname =new JLabel("Father's Name");
        labelfname.setBounds(400,100,150,30);
        labelfname.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(labelfname);
        
        tffname =new JTextField();
        tffname.setBounds(570,100,150,30);
        add(tffname);
        
        JLabel labeldob =new JLabel("D.O.B");
        labeldob.setBounds(50,150,100,30);
        labeldob.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(labeldob);
        
        dcdob =new JDateChooser();  // for calender which is in com.toedter.calendar.JDateChooser; 
        dcdob.setBounds(160,150,150,30);
        add(dcdob);
        
        JLabel labelsalary =new JLabel("Salary");
        labelsalary.setBounds(400,150,150,30);
        labelsalary.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary =new JTextField();
        tfsalary.setBounds(570,150,150,30);
        add(tfsalary);
        
        JLabel labeladdress =new JLabel("Address");
        labeladdress.setBounds(50,200,100,30);
        labeladdress.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress =new JTextField();
        tfaddress.setBounds(160,200,150,30);
        add(tfaddress);
        
        JLabel labelphone =new JLabel("Phone");
        labelphone.setBounds(400,200,150,30);
        labelphone.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(labelphone);
        
        tfphone =new JTextField();
        tfphone.setBounds(570,200,150,30);
        add(tfphone);
        
        JLabel labelemail =new JLabel("Email");
        labelemail.setBounds(50,250,100,30);
        labelemail.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(labelemail);
        
        tfemail =new JTextField();
        tfemail.setBounds(160,250,150,30);
        add(tfemail);
        
        JLabel labeleducation =new JLabel("Qualifiaction");
        labeleducation.setBounds(400,250,150,30);
        labeleducation.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(labeleducation);
        
        String courses[]={"BA","BSC","BBA","BCA","B.COM","BTech","MBA","MCA","MA","MTech","MSC","Phd"};
        cbeducation =new JComboBox(courses);
        cbeducation.setBounds(570,250,150,30);
        cbeducation.setBackground(Color.white);
        add(cbeducation);
        
         JLabel labeldesignation =new JLabel("Designation");
        labeldesignation.setBounds(50,300,120,30);
        labeldesignation.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation =new JTextField();
        tfdesignation.setBounds(160,300,150,30);
        add(tfdesignation);
        
        JLabel labeladhar =new JLabel("Adhar Number");
        labeladhar.setBounds(400,300,150,30);
        labeladhar.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(labeladhar);
        
        tfadhar =new JTextField();
        tfadhar.setBounds(570,300,150,30);
        add(tfadhar);
        
         JLabel labelempId =new JLabel("Emp. Id");
        labelempId.setBounds(50,350,150,30);
        labelempId.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(labelempId);
        
        lblempId =new JLabel(""+number);
        lblempId.setBounds(160,350,150,30);
        lblempId.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lblempId);
        
        add =new JButton("Add Details");
        add.setBounds(150,450,150,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        back =new JButton("Back");
        back.setBounds(350,450,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        
        setSize(900,600);
        setLocation(100,50);
        setLayout(null);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==add){
            
            String name=tfname.getText();
            String fname=tffname.getText();
            String dob =((JTextField)dcdob.getDateEditor().getUiComponent()).getText(); // for dob 
            String salary =tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=(String)cbeducation.getSelectedItem();
             String designation=tfdesignation.getText();
            String adhar= tfadhar.getText();
            String empId=lblempId.getText();
            
            try{
                Conn conn =new Conn();
                String query ="insert into employee values ('"+name+"','"+fname+"', '"+dob+"', '"+salary+"','"+address+"','"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+adhar+"', '"+empId+"')";
                
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully ");
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
        new AddEmployee();
    }
    
}
