
package employee_management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class View_Employee extends JFrame implements ActionListener {
    Choice choiceEmp;
    JTable table;
    JButton search , print,update,back;
    
    View_Employee(){
        
        getContentPane().setBackground(new Color(255,131,122));
        
        JLabel lblsearch=new JLabel("Search by Employee_Id");
        lblsearch.setBounds(20,20,150,20);
        //search.setFont(new Font("serif",Font.BOLD,15));
        add(lblsearch);
        
        choiceEmp=new Choice();
        choiceEmp.setBounds(180,20,150,20);
        add(choiceEmp);
        
        try{
            Conn conn=new Conn();
            java.sql.ResultSet resultSet=conn.s.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEmp.add(resultSet.getString("empId"));   // for add values in dropdown from database
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        table =new JTable();
        try{
            Conn conn =new Conn();
            java.sql.ResultSet resultSet =conn.s.executeQuery("Select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jp=new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);
        
        search =new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print =new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        update =new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
        back =new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
        
        
        
        setSize(900,650);
        setLayout(null);
        setLocation(100,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==search){
            String query ="select * from employee where empId = '"+choiceEmp.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                java.sql.ResultSet resultSet =c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==print){
            try{
                table.print();   // for printing the table 
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()== update){
            setVisible(false);
            new Update_Employee(choiceEmp.getSelectedItem());
            
        }
        else if (ae.getSource()==back){
            setVisible(false);
            new Home();
        }
        
    }
    public static void main(String a[])
    {
        new View_Employee();
    }
    
}
