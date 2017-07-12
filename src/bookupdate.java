import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class bookupdate extends JFrame implements ActionListener 
{

     JLabel aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk,ll;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton bt1,bt2,bt3;
    JComboBox cb;
    Connection c1;
    PreparedStatement psx;
     ResultSet rs;
    bookupdate()
    {
       setLayout(null);
        kk =new JLabel("SELECT BOOK ID.");
        kk.setBounds(20,100,200,20);
        add(kk);
        
        cb = new JComboBox();
        cb.setBounds(140,100,100,20);
        add(cb);
        
        cb.addItem("Select");

       
       jj= new JLabel("Book Details");
       jj.setBounds(470,20,200,50);
       add(jj);
       
         
        ii =new JLabel("Book ID");
        ii.setBounds(420,100,100,20);
        add(ii);
        
        t1 = new JTextField();
        t1.setBounds(530,100,100,20);
        add(t1);
        
        
        bb = new JLabel("Book Name");
        bb.setBounds(420,150,150,20);
        add(bb);
        
        t2 = new JTextField();
        t2.setBounds(530,150,100,20);
        add(t2);
        
        cc = new JLabel("Author");
        cc.setBounds(420,200,100,20);
        add(cc);
        
        t3 = new JTextField();
        t3.setBounds(530,200,100,20);
        add(t3);
        
        dd = new JLabel("Publisher");
        dd.setBounds(420,250,100,20);
        add(dd);
        
        
        t4 = new JTextField();
        t4.setBounds(530,250,100,20);
        add(t4);
        
        ee = new JLabel("Price");
        ee.setBounds(420,300,100,20);
        add(ee);
        
        t5 = new JTextField();
        t5.setBounds(530,300,100,20);
        add(t5);
        
        ff = new JLabel("Edition");
        ff.setBounds(420,350,150,20);
        add(ff);
        
        t6 = new JTextField();
        t6.setBounds(530,350,100,20);
        add(t6);
        
       
        gg = new JLabel("Pages");
        gg.setBounds(420,400,150,20);
        add(gg);
        
        t7 = new JTextField();
        t7.setBounds(530,400,100,20);
        add(t7);
        
        ll = new JLabel("Status");
        ll.setBounds(420,450,150,20);
        add(ll);
        
        t8 = new JTextField();
        t8.setBounds(530,450,100,20);
        add(t8);
        
        
        bt1= new JButton("UPDATE");
        bt1.setBounds(420,500,100,20);
        add(bt1);
        
        bt2= new JButton("CANCEL");
        bt2.setBounds(530,500,100,20);
        add(bt2);
        
        bt3= new JButton("DISPLAY");
        bt3.setBounds(20,170,100,20);
        add(bt3);
        
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
      try
      {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       c1=DriverManager.getConnection("jdbc:odbc:vivek");
       psx=c1.prepareStatement("select * from bk1db");
       rs=psx.executeQuery();
       
       while(rs.next())
                   
       {
                       cb.addItem(rs.getString("Bid"));
                   }
       
  
       
       
      }
        catch(Exception e)
       {
            
       }
        setTitle("View & Update Book Details");
        setVisible(true);
        setSize(800,600);
        setLocation(180,80);
     
    }
    
    //Display
    
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource()==bt3)
    {
      try
        {
        String p=cb.getSelectedItem().toString();
        psx=c1.prepareStatement("Select * from bk1db where Bid=?");
        psx.setString(1,p);
        rs=psx.executeQuery();
        rs.next();
        {
        t1.setText(rs.getString("Bid"));    
        t2.setText(rs.getString("Name1"));
        t3.setText(rs.getString("Author"));
        t4.setText(rs.getString("Publisher"));
        t5.setText(rs.getString("Price"));
        t6.setText(rs.getString("Edition"));
        t7.setText(rs.getString("Pages"));
        t8.setText(rs.getString("Status"));
        }
        }
    catch (Exception e)
    {
        System.out.println(e);
    }
    }
    
    // Update
     
    if(ae.getSource()==bt1)
     {
          try
   {
//String xx=cb.getSelectedItem().toString();       
String x=t1.getText();
String y=t2.getText();
String z=t3.getText();
String p=t4.getText();
String q=t5.getText();
String r=t6.getText();
String s=t7.getText();
String t=t8.getText();

       
psx=c1.prepareStatement("update bk1db set Bid=?,Name1=?,Author=?,Publisher=?,Price=?,Edition=?,Pages=?,Status=? where Bid=?");
psx.setString(1,x);
psx.setString(2,y);
psx.setString(3,z);
psx.setString(4,p);
psx.setString(5,q);
psx.setString(6,r);
psx.setString(7,s);
psx.setString(8,t);
psx.setString(9,x);
int j=psx.executeUpdate();
if(j>0)
{
 JOptionPane.showMessageDialog(this,"Record Update Successfully");   
 t1.setText("");
 t2.setText("");
 t3.setText("");
 t4.setText("");
 t5.setText("");
 t6.setText("");
 t7.setText("");
 t8.setText("");
 t1.requestFocus();
 cb.setSelectedIndex(0);
 
}
   
   
   }
   
     catch(Exception e)
     {
         System.out.println(e);
     }
   
     }
    if(ae.getSource()==bt2)
          
      {
       setVisible(false);   
      }
    }
    
    
    public static void main(String[] args) 
    {
   bookupdate bu= new bookupdate();
    }
}
