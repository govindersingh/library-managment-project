import java.awt.*;
import java.awt.event.* ; 
import javax.swing.*;
import java.sql.*;


public class studentreport extends JFrame implements ActionListener
{
 
 JTable tb1;
 String[] colheads={"Rollno","Name","Branch"};
 Object data[][]=new Object[500][3];
 Connection con = null;
 PreparedStatement pst = null;
 ResultSet rs=null;
JLabel first,second;
ImageIcon img1,img2;
JButton b1;

public studentreport()
 {
Container c;
c = getContentPane();
c.setLayout(null);
c.setBackground(Color.orange);

b1=new JButton("Cancel");
b1.setBounds(270,435,100,20);
c.add(b1);
b1.addActionListener(this);



//Demo For JTable
   tb1=new JTable(data,colheads);
   tb1.setGridColor(Color.GRAY);
   int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
   int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
   JScrollPane jsp=new JScrollPane(tb1,v,h);
   c.add(jsp);
   jsp.setBounds(185,10,300,400);

this.showdata();
setTitle("Student Report");
   setSize(650,500);        
  setLocation(370,140);
  setVisible(true);
  setResizable(false);
}

public void showdata()
 {
  try {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       con = DriverManager.getConnection("jdbc:odbc:vivek");    
   pst = con.prepareStatement("Select * from libdb");
   rs=pst.executeQuery();
   int r=0;
   while(rs.next())
   {
    data[r][0]=rs.getString("RollNo");
    data[r][1]=rs.getString("Name1");
    data[r][2]=rs.getString("Branch");
    r++;
   }
   
   rs.close();
   pst.close();
   con.close();
      
  } 
     catch (Exception ex) 
  {
   
  }
 }

public void actionPerformed(ActionEvent ae)
{
if(ae.getActionCommand()=="Cancel")
{
int response = JOptionPane.showConfirmDialog(null, "Really Do you want to Exit?", "Exit Mess",
         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
 
     if (response == JOptionPane.YES_OPTION) 
     {
      setVisible(false);
      dispose();      
 
     } 

}
}


public static void main(String a[])
{
new studentreport();
}
}




 










