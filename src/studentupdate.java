import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class studentupdate extends JFrame implements ActionListener
{
    
    JLabel aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk,ll,mm;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    JButton bt1,bt2,bt3,bt4;
    JComboBox cb;
    Connection c1;
    PreparedStatement psx;
    ResultSet rx;
  
    studentupdate()
    {
        setLayout(null);
        
        jj= new JLabel("STUDENT INFORMATION");
        jj.setBounds(470,20,200,50);
        add(jj);
       
        kk =new JLabel("SELECT ROLL NO.");
        kk.setBounds(20,100,200,20);
        add(kk);
        
        cb = new JComboBox();
        cb.setBounds(140,100,100,20);
        add(cb);
        
        cb.addItem("Select");
        
        ii =new JLabel("Gender");
        ii.setBounds(420,100,100,20);
        add(ii);
        
        t1 = new JTextField();
        t1.setBounds(530,100,100,20);
        add(t1);
        
        
        bb = new JLabel("Name");
        bb.setBounds(420,150,150,20);
        add(bb);
        
        t2 = new JTextField();
        t2.setBounds(530,150,100,20);
        add(t2);
        
        cc = new JLabel("ROLL NO.");
        cc.setBounds(420,200,100,20);
        add(cc);
        
        t3 = new JTextField();
        t3.setBounds(530,200,100,20);
        add(t3);
        
        dd = new JLabel("BRANCH");
        dd.setBounds(420,250,100,20);
        add(dd);
        
        
        t4 = new JTextField();
        t4.setBounds(530,250,100,20);
        add(t4);
        
        
        ee = new JLabel("Email Id");
        ee.setBounds(420,300,100,20);
        add(ee);
        
        t5 = new JTextField();
        t5.setBounds(530,300,100,20);
        add(t5);
        
        ff = new JLabel("Contact No");
        ff.setBounds(420,350,150,20);
        add(ff);
        
        t6 = new JTextField();
        t6.setBounds(530,350,100,20);
        add(t6);
        
        mm = new JLabel("No of Books Issued");
        mm.setBounds(400,400,150,20);
        add(mm);
        
        t9 = new JTextField();
        t9.setBounds(530,400,100,20);
        add(t9);
        
        
        bt1= new JButton("UPDATE");
        bt1.setBounds(420,450,100,20);
        add(bt1);
        
        bt2= new JButton("CANCEL");
        bt2.setBounds(530,450,100,20);
        add(bt2);
       
        bt3= new JButton("DISPLAY");
        bt3.setBounds(20,150,100,20);
        add(bt3);
       
        bt4= new JButton("DELETE");
        bt4.setBounds(640,450,100,20);
        add(bt4);
       
        try
               {
                   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                   c1=DriverManager.getConnection("jdbc:odbc:vivek");
                   psx=c1.prepareStatement("Select * from libdb");
                   rx = psx.executeQuery();
                  
                   while(rx.next())
                   {
                       cb.addItem(rx.getString("RollNo"));
                   }
                 
               }                        
              
              catch(Exception e)
              {
              
              }
             
        

        bt2.addActionListener(this); 
        bt3.addActionListener(this); 
        bt1.addActionListener(this);
        bt4.addActionListener(this);
        setSize(900,600);
        setVisible(true);
        setTitle("Update and View Student Information");
        setLocation(140,80);
    }
            
        

    
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==bt1) // UPDATE
   {
   try
   {
       
//       String s=cb.getSelectedItem().toString();
       
       String x=t1.getText();
       String y=t2.getText();
       String z=t3.getText();
       String p=t4.getText();
       String q=t5.getText();
       String r=t6.getText();
       String s=t9.getText();
          
       psx=c1.prepareStatement("update libdb set Gender='"+x+"',Name1='"+y+"',RollNo='"+z+"',Branch='"+p+"',Email='"+q+"',Contact='"+r+"',Count='"+s+"' where RollNo='"+z+"'");
       
 int k=psx.executeUpdate();
       
       if(k>0)
       {
        JOptionPane.showMessageDialog(this,"Record Updated Successfully");                   
 t1.setText("");
 t2.setText("");
 t3.setText("");
 t4.setText("");
 t5.setText("");
 t6.setText("");
 t9.setText("");
 t1.requestFocus();
       }    
       else
       {
   JOptionPane.showMessageDialog(this,"Record Not Updated");                   
   }   
   }
   catch(Exception e)
   {
       System.out.println(e);
   }
   }

    // Display    
  
    if(ae.getSource()==bt3)
    {
        try
        {
            
            String w=cb.getSelectedItem().toString();
            psx=c1.prepareStatement("select * from libdb where RollNo=('"+w+"')");
            rx=psx.executeQuery();
            
            rx.next();
            t1.setText(rx.getString("Gender"));
            t2.setText(rx.getString("Name1"));
            t3.setText(rx.getString("RollNo"));
            t4.setText(rx.getString("Branch"));
            t5.setText(rx.getString("Email"));
            t6.setText(rx.getString("Contact"));
            t9.setText(rx.getString("Count"));
            cb.setSelectedIndex(0);
        
        }
     catch(Exception e)
     {
     System.out.println("Error is" +e);
     }
    }
      
   
    if(ae.getSource()==bt4)
    {
        try
        {
             String p=t3.getText();
             psx=c1.prepareStatement("delete from libdb where RollNo='"+p+"'");
             
             int j=psx.executeUpdate();
             if(j>0)
              {
 JOptionPane.showMessageDialog(this,"Record Deleted Successfully");
 t1.setText("");
 t2.setText("");
 t3.setText("");
 t4.setText("");
 t5.setText("");
 t6.setText("");
 t9.setText("");
 t1.requestFocus();
 
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
      studentupdate s = new studentupdate();
    }
}
