import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class bookreturn extends JFrame implements ActionListener
{
   JLabel a,b,c,d,e,f,g,h,i,j,k,l,m;
   JTextField t1,t2,t3,t4,t5,t6,t7,t8;
   JButton bt1,bt2,bt3,bt4;
   Connection c1;
   PreparedStatement psx;
   JComboBox cb1,cb2;
   ResultSet rs;
   bookreturn()
   {
       setLayout(null);
        
        a= new  JLabel("BOOK RETURN");
        a.setBounds(150,30,100,20);
        add(a);
         
        b= new  JLabel("Select BOOK ID");
        b.setBounds(20,80,100,20);
        add(b);
          
        cb1= new JComboBox();
        cb1.setBounds(130,80,100,20);
        add(cb1);
        
        cb1.addItem("Select");
        
        e=new JLabel("Roll NO.");
        e.setBounds(70,150,100,20);
        add(e);
 
        t1=new JTextField();
        t1.setBounds(180,150,100,20);
        add(t1);
        
        f= new  JLabel("NAME");
        f.setBounds(70,200,100,20);
        add(f);
 
        t2=new JTextField();
        t2.setBounds(180,200,100,20);
        add(t2);
        
        j= new  JLabel("Book Id");
        j.setBounds(70,250,100,20);
        add(j);
 
        t6=new JTextField();
        t6.setBounds(180,250,100,20);
        add(t6);
        
        g=new JLabel("Book Name:");
        g.setBounds(70,300,100,20);
        add(g);
 
        t3=new JTextField();
        t3.setBounds(180,300,100,20);
        add(t3);
        
        
        
        
             
      try
      {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       c1=DriverManager.getConnection("jdbc:odbc:vivek");
       psx=c1.prepareStatement("select * from bkissue1");
       rs=psx.executeQuery();
       
       while(rs.next())
                   
       {
           cb1.addItem(rs.getString("Bid"));
        }
      }
        catch(Exception e)
       {
            
       }
   
        
      
       bt2=new JButton("DISPLAY");
       bt2.setBounds(240,80,100,20);
       add(bt2);
       
       bt1=new JButton("CANCEL");
       bt1.setBounds(240,370,100,20);
       add(bt1);
        
       
       bt3=new JButton("RETURN");
       bt3.setBounds(20,370,100,20);
       add(bt3);
    
       bt4=new JButton("CLEAR");
       bt4.setBounds(130,370,100,20);
       add(bt4);
        
        setTitle("Books Return");
        setVisible(true);
        setLocation(360,120);
        setSize(400,550);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
   }
   public void actionPerformed(ActionEvent ae)
    {
   if(ae.getActionCommand()=="DISPLAY")
    {
   try
   {
     String w=cb1.getSelectedItem().toString();
     psx=c1.prepareStatement("select RollNo,Name1,Bid,BName from bkissue1 where Bid=('"+w+"')");
     rs=psx.executeQuery();
     rs.next();
     t1.setText(rs.getString("RollNo"));
     t2.setText(rs.getString("Name1"));
     t6.setText(rs.getString("Bid"));
     t3.setText(rs.getString("BName"));
     
                  
   }
catch(Exception e)
{
    
}
}    
 
 if(ae.getSource()==bt3) //Return
 {
    try
    {
            String x=t1.getText();     // Roll No
            String y=t2.getText();      //Name
            String z=t6.getText();      //Book id
            String p=t3.getText();      // Book Name
            String t="Available";
            
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");    
   c1=DriverManager.getConnection("jdbc:odbc:vivek");
   psx=c1.prepareStatement("insert into bkreturn (RollNo,Name1,Bid,BName) values ('"+x+"','"+y+"','"+z+"','"+p+"')");
   int g=psx.executeUpdate();
   if(g>0)
   {
       JOptionPane.showMessageDialog(this,"BOOK RETURN SUCCCESSFULLY");
       
   try
   {
    psx=c1.prepareStatement("update bk1db set Status=('"+t+"') where Bid=('"+z+"')");
    int k=psx.executeUpdate();
    if(k>0)
    {
       JOptionPane.showMessageDialog(this,"Status updated In Book Table"); 
    }
   }
   catch(Exception e)
   {
       System.out.println(e);
   }
       
   try
   {
    psx=c1.prepareStatement("update libdb set Count=Count-1 where RollNo=('"+x+"')");
    int k=psx.executeUpdate();
    if(k>0)
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
   psx=c1.prepareStatement("delete from bkissue1 where Bid=('"+z+"')");
   int v=psx.executeUpdate();
   if(v>0)
   {
       JOptionPane.showMessageDialog(this,"Issue Table Updated");
       t1.setText("");
       t2.setText("");
       t3.setText("");
       t6.setText("");
       t1.requestFocus();
       cb1.setSelectedIndex(0);
       cb2.setSelectedIndex(0);
   
   }
   }
   
   catch(Exception e)
   {
       
   }
       
   }
    
     else
     {
         JOptionPane.showMessageDialog(this,"Not Issued");
     }
            }
        
            
            
            
    
    catch(Exception e)
            
            {
        System.out.println(e);
    }
 }
   

 
 if(ae.getActionCommand()=="CLEAR")
   
 {
  t1.setText("");       
  t2.setText("");          
  t3.setText("");       
  t6.setText("");       
  
  cb1.setSelectedIndex(0);

  
 }
    
    
   if(ae.getActionCommand()=="CANCEL")
   {
       setVisible(false);
   }
    }        
          
 
public static void main(String[] args) 
    {
   bookreturn br=new bookreturn();
    }
}
