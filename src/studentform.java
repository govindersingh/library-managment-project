import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class studentform extends JFrame implements ActionListener 
{
   
    JLabel aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton bt1,bt2;
    JComboBox cb;
    Connection c1;
    PreparedStatement psx;
  
    studentform()
    {
       setLayout(null);
       
       jj= new JLabel(" STUDENT FORM");
       jj.setBounds(180,20,200,50);
       add(jj);
       
         
        ii =new JLabel("Gender");
        ii.setBounds(100,100,100,20);
        add(ii);
        
        
        cb= new JComboBox();
        cb.setBounds(210,100,100,20);
        add(cb);
        
        cb.addItem("Select");
        cb.addItem("Male.");
        cb.addItem("Female");
        
        bb = new JLabel("Name");
        bb.setBounds(100,150,150,20);
        add(bb);
        
        t2 = new JTextField();
        t2.setBounds(210,150,100,20);
        add(t2);
        
        cc = new JLabel("ROLL NO.");
        cc.setBounds(100,200,100,20);
        add(cc);
        
        t3 = new JTextField();
        t3.setBounds(210,200,100,20);
        add(t3);
        
        dd = new JLabel("BRANCH");
        dd.setBounds(100,250,100,20);
        add(dd);
        
        
        t4 = new JTextField();
        t4.setBounds(210,250,100,20);
        add(t4);
        
        ee = new JLabel("Email Id");
        ee.setBounds(100,300,100,20);
        add(ee);
        
        t5 = new JTextField();
        t5.setBounds(210,300,100,20);
        add(t5);
        
        ff = new JLabel("Contact No");
        ff.setBounds(100,350,150,20);
        add(ff);
        
        t6 = new JTextField();
        t6.setBounds(210,350,100,20);
        add(t6);
        
       
        bt1= new JButton("SAVE");
        bt1.setBounds(100,400,100,20);
        add(bt1);
        
        bt2= new JButton("CANCEL");
        bt2.setBounds(210,400,100,20);
        add(bt2);
        
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
       
      
        setTitle("STUDENT REGISTRATION FORM");
        setVisible(true);
        setSize(500,700);
        setLocation(400,60);
     
    }
    
    
    
    
    public void actionPerformed (ActionEvent ae)
    {
        if(ae.getSource()==bt1) // SAVE
        {
     try
   {         
            String x=cb.getSelectedItem().toString();
            String y=t2.getText();
            String z=t3.getText();
            String p=t4.getText();
            String q=t5.getText();
            String r=t6.getText();
            String s="0";
                        
            int hasAt= q.indexOf('@');
            int hasDot= q.indexOf('.');
            
            if(hasAt ==-1 || hasDot==-1 )
            {
               t5.setText("");
               JOptionPane.showMessageDialog(this,"Invalid Email Id");
            }
            
            
            else
            {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");    
   c1=DriverManager.getConnection("jdbc:odbc:vivek");
   psx=c1.prepareStatement("insert into libdb (Gender,Name1,RollNo,Branch,Email,Contact,Count) values ('"+x+"','"+y+"','"+z+"','"+p+"','"+q+"','"+r+"','"+s+"')");
  
   
   int k=psx.executeUpdate();
 
   if(k>0)
   {
       JOptionPane.showMessageDialog(this,"Record Inserted Successfully");
        
        t2.setText("");    
        t3.setText("");
        t4.setText("");    
        t5.setText("");    
        t6.setText("");
        cb.setSelectedIndex(0);
        t1.requestFocus();
   }
            
   else
   {
       JOptionPane.showMessageDialog(this,"Record Not Inserted");
   }
   
 }
 }           

catch(Exception e)
 {
 System.out.println("errror is" +e);
 }    
 }
        
        if(ae.getSource()==bt2) // CANCEL
        {
            setVisible(false);
        }
      
    }
    
    
    public static void main(String[] args) 
    {
     studentform ff = new studentform();
     
    }
}
