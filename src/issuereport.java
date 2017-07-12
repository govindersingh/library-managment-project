import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class issuereport extends JFrame implements ActionListener
{
    JTable tb;
    String colheads[]={"Roll No","Name","BookName"};
    Object data[][]=new Object[500][3];
    Connection c1;
    ResultSet rs;
    PreparedStatement pst;
    JLabel a;
    JButton bt1;
    
   public issuereport()
    {
      Container c;
      c=getContentPane(); 
      setLayout(null);
      c.setBackground(Color.orange);
      
       bt1=new JButton("Cancel");
       bt1.setBounds(270,435,100,20);
       add(bt1);
       bt1.addActionListener(this);
       
       tb= new JTable(data,colheads);
       int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
       int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
       JScrollPane jsp=new JScrollPane(tb,v,h);
       add(jsp);
       jsp.setBounds(185,10,300,400);
      
       try
       {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          c1=DriverManager.getConnection("jdbc:odbc:vivek");
          pst=c1.prepareStatement("select * from bkissue1");
          rs=pst.executeQuery();
          int r=0;
          while(rs.next())
          {
          data[r][0]=rs.getString("RollNo");    
          data[r][1]=rs.getString("Name1");
          data[r][2]=rs.getString("BName");    
          r++;
          }
       }
       catch(Exception e)
       {
           
       }
   
       setVisible(true);
       setSize(700,500);
       setLocation(370,140);
       setTitle("Issue Report");
       setResizable(false);
    }
   
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bt1)
        {
            int response=JOptionPane.showConfirmDialog(this,"Are You Sure You Want To Exit?","exit mess",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(response==JOptionPane.YES_OPTION)
            {
                setVisible(false);
            }
        }
    }
 
    public static void main(String ar[])
    {
issuereport br=new issuereport();    
    }
}