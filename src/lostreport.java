import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class lostreport extends JFrame implements ActionListener 
{
   JTable tb;
   String colheads[]={"Roll NO" , "Book ID" ,"Book Name"};
   Object data[][]=new Object[300][3];
   JLabel a;
   JButton bt1;
   Connection c1;
   ResultSet rs;
   PreparedStatement pst;
   
   
   lostreport()
   {
   
       Container c=getContentPane();
       setLayout(null);
       c.setBackground(Color.orange);
       
        tb=new JTable(data,colheads);
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp=new JScrollPane(tb,v,h);
        jsp.setBounds(185,30,300,400);
        add(jsp);
       
        bt1=new JButton("CANCEL");
        bt1.setBounds(280,470,100,20);
        add(bt1);
        
        bt1.addActionListener(this);
        try
        {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           c1=DriverManager.getConnection("jdbc:odbc:vivek");
           pst=c1.prepareStatement("select * from lostdb");
           rs=pst.executeQuery();
           int r=0;
          while(rs.next())
          {
              data[r][0]=rs.getString("RollNo");
              data[r][1]=rs.getString("BName");
              data[r][2]=rs.getString("Bid");
              r++;
           }
           
                   
        
        }
       catch(Exception e)
       {
           
       }
       
       setVisible(true);
       setSize(700,550);
       setLocation(370,140);
       setTitle("Issue Report");
       
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
    public static void main(String[] args) 
    {
new lostreport();
    }
}
