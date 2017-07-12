import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class bookform extends JFrame implements ActionListener 
{
   
    JLabel aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton bt1,bt2,bt3;
    JComboBox cb;
    Connection c2;
    PreparedStatement pst;
    
    bookform()
    {
       setLayout(null);
       
       jj= new JLabel(" Book Form");
       jj.setBounds(180,20,200,50);
       add(jj);
       
        aa = new JLabel("Book Id");
        aa.setBounds(100,100,100,20);
        add(aa);
        
        t1 = new JTextField();
        t1.setBounds(210,100,100,20);
        add(t1);
         
        ii =new JLabel("Name");
        ii.setBounds(100,150,100,20);
        add(ii);
        
        t2 = new JTextField();
        t2.setBounds(210,150,100,20);
        add(t2);
        
        bb = new JLabel("Author");
        bb.setBounds(100,200,150,20);
        add(bb);
        
        t3 = new JTextField();
        t3.setBounds(210,200,100,20);
        add(t3);
        
        
        
        cc = new JLabel("Publisher");
        cc.setBounds(100,250,100,20);
        add(cc);
        
        t4 = new JTextField();
        t4.setBounds(210,250,100,20);
        add(t4);
        
        dd = new JLabel("Price");
        dd.setBounds(100,300,100,20);
        add(dd);
        
        t5 = new JTextField();
        t5.setBounds(210,300,100,20);
        add(t5);
        
        
        ee = new JLabel("Edition");
        ee.setBounds(100,350,100,20);
        add(ee);
        
        t6 = new JTextField();
        t6.setBounds(210,350,100,20);
        add(t6);
        
        
        
        ff = new JLabel("Pages");
        ff.setBounds(100,400,150,20);
        add(ff);
        
        t7 = new JTextField();
        t7.setBounds(210,400,100,20);
        add(t7); 
     
       
        
        bt1= new JButton("SAVE");
        bt1.setBounds(100,500,100,20);
        add(bt1);
        
        bt2= new JButton("CANCEL");
        bt2.setBounds(210,500,100,20);
        add(bt2);
        
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
      
        setTitle(" NEW BOOK FORM");
        setVisible(true);
        setSize(500,700);
        setLocation(400,60);
     
    }
    
    
    
    
    public void actionPerformed (ActionEvent ae)
    {
       // Save
        if(ae.getSource()==bt1)
        {
            try
            {
            String x=t1.getText();    
            String y=t2.getText();
            String z=t3.getText();
            String p=t4.getText();
            String q=t5.getText();
            String r=t6.getText();    
            String s=t7.getText();
            String st="Available";
           
            if(x.equals(""))
                
            {
                JOptionPane.showMessageDialog(this,"Field Cannot Be Empty");
            }    
            else
            {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");    
   c2=DriverManager.getConnection("jdbc:odbc:vivek");
   pst=c2.prepareStatement("insert into bk1db (Bid,Name1,Author,Publisher,Price,Edition,Pages,Status) values (?,?,?,?,?,?,?,?)");
   pst.setString(1,x);                         
   pst.setString(2,y);
   pst.setString(3,z);
   pst.setString(4,p);
   pst.setString(5,q);
   pst.setString(6,r);
   pst.setString(7,s);
   pst.setString(8,st);
   
   int j=pst.executeUpdate();
   if(j>0)
   {
       JOptionPane.showMessageDialog(this,"Record Inserted Successfully");
       t1.setText("");
       t2.setText("");
       t3.setText("");
       t4.setText("");
       t5.setText("");
       t6.setText("");
       t7.setText("");
       
       t1.requestFocus();
   }
            
            }
        }
            catch(Exception e)
        {
        System.out.println(e);
        }
        }
            
            //CANCEL
        
        if(ae.getSource()==bt2)
        {
            setVisible(false);
        }
     
        }
   
    
    public static void main(String[] args) 
    {
     bookform ff = new bookform();
     
    }
}
