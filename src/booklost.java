import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class booklost extends JFrame implements  ActionListener 
{
JLabel a,b,c,d,e,f,g,h;
JTextField t1,t2,t3,t4,t5,t6,t7;
JButton bt1,bt2,bt3;
JComboBox cb1;
Connection c1;
ResultSet rs;
PreparedStatement pst;

booklost()
{
    setLayout(null);
    
    a=new JLabel("Select Book ID.");
    a.setBounds(100,20,100,20);        
    add(a);
    
    cb1= new JComboBox();
    cb1.setBounds(210,20,100,20);
    add(cb1);
    cb1.addItem("Select");
    
    try
    {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    c1=DriverManager.getConnection("jdbc:odbc:vivek");
    pst=c1.prepareStatement("select * from bk1db");
    rs=pst.executeQuery();
    while(rs.next())
    {
        cb1.addItem(rs.getString("Bid"));
    }
    }
    
    catch(Exception e)
    {
        
    }

    b=new JLabel("Book Name");
    b.setBounds(100,70,100,20);
    add(b);
    
    t1=new JTextField();
    t1.setBounds(210,70,100,20);
    add(t1);
    
    c=new JLabel("Author");
    c.setBounds(100,120,100,20);
    add(c);
    
    t2=new JTextField();
    t2.setBounds(210,120,100,20);
    add(t2);
    
    d=new JLabel("Edition");
    d.setBounds(100,170,100,20);
    add(d);
    
    t3=new JTextField();
    t3.setBounds(210,170,100,20);
    add(t3);
    
    e=new JLabel("Price");
    e.setBounds(100,220,100,20);
    add(e);
    
    t4=new JTextField();
    t4.setBounds(210,220,100,20);
    add(t4);
    
    f=new JLabel("Fine");
    f.setBounds(100,270,100,20);
    add(f);
    
    t5=new JTextField();
    t5.setBounds(210,270,100,20);
    add(t5);
    
    
    bt1= new JButton("DISPLAY");
    bt1.setBounds(350,20,100,20);
    add(bt1);
    
    bt2= new JButton("LOST");
    bt2.setBounds(100,320,100,20);
    add(bt2);
    
    bt3= new JButton("CANCEL");
    bt3.setBounds(210,320,100,20);
    add(bt3);
    
    bt1.addActionListener(this);
    bt2.addActionListener(this);
    bt3.addActionListener(this);
    
    setSize(500,400);
    setVisible(true);
    setTitle("BookLost");
    setLocation(380,200);
}


public void actionPerformed(ActionEvent ae)
{
    if(ae.getActionCommand()=="DISPLAY")
    {
        try
        {
            String a=cb1.getSelectedItem().toString();
            pst=c1.prepareStatement("select * from bk1db where Bid=('"+a+"')");
            rs=pst.executeQuery();
            rs.next();
            t1.setText(rs.getString("Name1"));
            t2.setText(rs.getString("Author"));
            t3.setText(rs.getString("Edition"));
            t4.setText(rs.getString("Price"));
        
            
        }
    
     catch(Exception e)
    {
        System.out.println(e);
    }
   }

if(ae.getActionCommand()=="LOST")
{
    try
    
    {
  
    String a=cb1.getSelectedItem().toString();
    String z="BOOKLOST";
    pst=c1.prepareStatement("update bk1db set Status=('"+z+"') where Bid=('"+a+"')");    
    int j=pst.executeUpdate();
    if(j>0)
    {
        JOptionPane.showMessageDialog(this,"Status Updated");
    }
    }     
catch(Exception e)
{
System.out.println(e);    
}
 
    try
            {
                String az=cb1.getSelectedItem().toString();
                pst=c1.prepareStatement("select * from bkissue1 where Bid=('"+az+"')");
                rs=pst.executeQuery();
                rs.next();
                String rn=rs.getString("RollNo");
                
                String aa=t1.getText();
                String ee=t5.getText();
                pst=c1.prepareStatement("insert into lostdb (RollNo,Bid,BName,Fine) values (('"+rn+"'),('"+az+"'),('"+aa+"'),('"+ee+"'))");
                int j1=pst.executeUpdate();
                if(j1>0)
                {
                    JOptionPane.showMessageDialog(this,"Record Inserted");
                }
            }
            catch(Exception e)
            {
               System.out.println(e); 
            }
            
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t1.requestFocus();
        cb1.setSelectedIndex(0);        
}
    

 if(ae.getActionCommand()=="CANCEL")
{
    setVisible(false);
}
}

        
    
public static void main(String[] args) 
   {
    booklost bl= new booklost();
    }
}
