import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class issue extends JFrame implements ActionListener
{
   JLabel a,b,c,d,e,f,g,h,i,j,k,l,m;
   JTextField t1,t2,t3,t4,t5,t6,t7,t8;
   JButton bt1,bt2,bt3,bt4,bt5;
   Connection c1;
   PreparedStatement psx;
   JComboBox cb1,cb2;
   ResultSet rs;
   issue()
   {
       setLayout(null);
        
        a= new  JLabel("Student Info");
        a.setBounds(70,20,100,20);
        add(a);
         
        b= new  JLabel("Select Roll NO.");
        b.setBounds(20,70,100,20);
        add(b);
          
        cb1= new JComboBox();
        cb1.setBounds(120,70,100,20);
        add(cb1);
        
        cb1.addItem("Select");
        
        e=new JLabel("Roll NO.");
        e.setBounds(20,120,100,20);
        add(e);
 
        t1=new JTextField();
        t1.setBounds(120,120,100,20);
        add(t1);
        
        f= new  JLabel("NAME");
        f.setBounds(20,170,100,20);
        add(f);
 
        t2=new JTextField();
        t2.setBounds(120,170,100,20);
        add(t2);
        
        j= new  JLabel("No of Books Issued");
        j.setBounds(10,220,150,20);
        add(j);
 
        t6=new JTextField();
        t6.setBounds(120,220,100,20);
        add(t6);
        
        
        c= new  JLabel("Book Info");
        c.setBounds(570,20,100,20);
        add(c);
         
        d= new  JLabel("Select Book ID.");
        d.setBounds(520,70,100,20);
        add(d);
          
        cb2= new JComboBox();
        cb2.setBounds(620,70,100,20);
        add(cb2);
        cb2.addItem("Select");
        
        g=new JLabel("Book ID.");
        g.setBounds(520,120,100,20);
        add(g);
 
        t3=new JTextField();
        t3.setBounds(620,120,100,20);
        add(t3);
        
        h= new  JLabel("Book Name");
        h.setBounds(520,170,100,20);
        add(h);
 
        t4=new JTextField();
        t4.setBounds(620,170,100,20);
        add(t4);
        
        i= new  JLabel("Status");
        i.setBounds(520,220,100,20);
        add(i);
 
        t5=new JTextField();
        t5.setBounds(620,220,100,20);
        add(t5);
        
        
        try
               {
                   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                   c1=DriverManager.getConnection("jdbc:odbc:vivek");
                   psx=c1.prepareStatement("Select * from libdb");
                   rs = psx.executeQuery();
                  
                   while(rs.next())
                   {
                       cb1.addItem(rs.getString("RollNo"));
                   }
                 
               }                        
              
              catch(Exception e)
              {
              
              }
             
       try
      {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       c1=DriverManager.getConnection("jdbc:odbc:vivek");
       psx=c1.prepareStatement("select * from bk1db");
       rs=psx.executeQuery();
       
       while(rs.next())
                   
       {
                       cb2.addItem(rs.getString("Bid"));
                   }
       
  
       
       
      }
        catch(Exception e)
       {
            
       }
   
       bt1=new JButton("DISPLAY BOOK");
       bt1.setBounds(360,70,130,20);
       add(bt1);
       
       bt2=new JButton("DISPLAY");
       bt2.setBounds(230,70,100,20);
       add(bt2);
       
       bt3=new JButton("ISSUE");
       bt3.setBounds(220,270,100,20);
       add(bt3);
    
       bt4=new JButton("CLEAR");
       bt4.setBounds(330,270,100,20);
       add(bt4);
        
       bt5=new JButton("CANCEL");
       bt5.setBounds(440,270,100,20);
       add(bt5);
       
       setTitle("Books Issue");
        setVisible(true);
        setLocation(150,80);
        setSize(800,600);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
   
   }
   public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand()=="DISPLAY BOOK")
        {
            try 
            {
        String p=cb2.getSelectedItem().toString();
        psx=c1.prepareStatement("Select Bid,Name1,Status from bk1db where Bid=?");
        psx.setString(1,p);
        rs=psx.executeQuery();
        rs.next();
        {
        t3.setText(rs.getString("Bid"));    
        t4.setText(rs.getString("Name1"));
        t5.setText(rs.getString("Status"));
        }
  }
   catch(Exception e)
   {
       
   }
 }
            
        
  if(ae.getActionCommand()=="DISPLAY")  // Display Student Detail
    {
        try
        {
            
            String w=cb1.getSelectedItem().toString();
            psx=c1.prepareStatement("select RollNo,Name1,Count from libdb where RollNo=('"+w+"')");
            rs=psx.executeQuery();
            rs.next();
            t1.setText(rs.getString("RollNo"));
            t2.setText(rs.getString("Name1"));
            t6.setText(rs.getString("Count"));
            }
catch(Exception e)
{
    
}
}    
 if(ae.getActionCommand()=="ISSUE")
 {
   
   try
   
   {
       String xx=t1.getText();
       psx=c1.prepareStatement("Select Count from libdb where RollNo=('"+xx+"')");
       rs=psx.executeQuery();
      rs.next();
      
       int g=Integer.parseInt(rs.getString("Count"));  // CONVERTED INTO INTEGER TYPE CZ COUNT IS OF INT TYPE
       if(g >= 3)
       {
          JOptionPane.showMessageDialog(this,"Kitni Buks lega be");
       }
       
       else
       
       {  
   
        try
        
           {
           
            String x=t1.getText();    
            String y=t2.getText();
            String z=t6.getText();
            String p=t3.getText();
            String q=t4.getText();
            String t="Issued";              
            
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");    
   c1=DriverManager.getConnection("jdbc:odbc:vivek");
   psx=c1.prepareStatement("insert into bkissue1 (RollNo,Name1,Bid,BName) values ('"+x+"','"+y+"','"+p+"','"+q+"')");
   int d=psx.executeUpdate();
   if(d>0)
   {
       JOptionPane.showMessageDialog(this,"BOOK ISSUED SUCCCESSFULLY");
       
   
       
   try
   {
    psx=c1.prepareStatement("update bk1db set Status=? where Bid=('"+p+"')");
    psx.setString(1,t);
    int j=psx.executeUpdate();
    if(j>0)
    {
      JOptionPane.showMessageDialog(this,"Status updated"); 
    }
   }
   catch(Exception e)
   {
       System.out.println(e);
   }
   
   try
   {
    psx=c1.prepareStatement("update libdb set Count=Count+1 where RollNo=('"+x+"')");
    int j=psx.executeUpdate();
    if(j>0)
    {
      JOptionPane.showMessageDialog(this,"Status updated"); 
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
       t6.setText("");
       t1.requestFocus();
       cb1.setSelectedIndex(0);
       cb2.setSelectedIndex(0);
  
   }  // if closed
           }    
catch(Exception e)
     {
        System.out.println(e);
     }
    
    }  
   
 }       
  
catch(Exception e)
   {
       
   }
 
 
    
    
   
 if(ae.getActionCommand()=="CLEAR")
   
 {
  t1.setText("");       
  t2.setText("");          
  t3.setText("");       
  t4.setText("");       
  t5.setText("");       
  t6.setText("");       
  cb1.setSelectedIndex(0);
  cb2.setSelectedIndex(0);
  
 }
    
 if(ae.getActionCommand()=="CANCEL")
 {
     setVisible(false);
 }
    
    }        
          
    }
public static void main(String[] args) 
    {
   issue is=new issue();
    }
}