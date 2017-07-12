import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class menu extends JFrame implements ActionListener
{
 JMenuBar jmb;
 JMenu jm1,jm2,jm3,jm4,jm5;
 JMenuItem m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14;
 ImageIcon img1;
 menu()
 {
     Container c = getContentPane();
     //c.setBackground(Color.cyan);
     setLayout(null);
    
     
     jmb = new JMenuBar();
     
     jm1 = new JMenu("INFORMATION");
     jm2 = new JMenu("UPDATE");
     jm3 = new JMenu("TRANSACTIONS");
     jm4 = new JMenu("REPORT");
     jm5 = new JMenu("HELP");
     
     m1 = new JMenuItem("Students");
     m2 = new JMenuItem("Books");
     m3 = new JMenuItem("Student");
     m4 = new JMenuItem("Books");
     m5 = new JMenuItem("Issue");
     m6 = new JMenuItem("Return");
     m7 = new JMenuItem("Lost");
     m8 = new JMenuItem("About Studets");
     m9 = new JMenuItem("About Books");
     m10 = new JMenuItem("About Issue ");
     m11=  new JMenuItem("About Lost");
     m12 = new JMenuItem("About Me");
     m13= new JMenuItem("Exit");
   
    jm1.add(m1);
    jm1.add(m2);
    jm2.add(m3);
    jm2.add(m4);
    jm3.add(m5);
    jm3.add(m6);
    jm3.add(m7);
    jm4.add(m8);
    jm4.add(m9);
    jm4.add(m10);
    jm4.add(m11);
    jm5.add(m12);
    jm5.add(m13);
    
    
    jmb.add(jm1);
    jmb.add(jm2);
    jmb.add(jm3);
    jmb.add(jm4);
    jmb.add(jm5);
    
    setJMenuBar(jmb);
    
    m1.addActionListener(this);
    m2.addActionListener(this);
    m3.addActionListener(this);
    m4.addActionListener(this);    
    m5.addActionListener(this);    
    m6.addActionListener(this);    
    m7.addActionListener(this);    
    m8.addActionListener(this);
    m9.addActionListener(this);
    m10.addActionListener(this);
    m11.addActionListener(this);
    m12.addActionListener(this);
    m13.addActionListener(this);
    
    
    
    
    setTitle("MENU BAR");
    setVisible(true);
    setSize(1280,775);
    
    
  }
 
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==m1)
    {
        //setVisible(false);
        new studentform().setVisible(true);
    }
 
    if(ae.getSource()==m2)
    {
        //setVisible(false);
        new bookform().setVisible(true);
    }

  if(ae.getSource()==m3)
    {
        //setVisible(false);
        new studentupdate().setVisible(true);
    }
   
   if(ae.getSource()==m4)
    {
        //setVisible(false);
        new bookupdate().setVisible(true);
    }

 if(ae.getSource()==m5)
    {
        //setVisible(false);
        new issue().setVisible(true);
    }
if(ae.getSource()==m6)
    {
        //setVisible(false);
        new bookreturn().setVisible(true);
    }

if(ae.getSource()==m7)
    {
        //setVisible(false);
        new booklost().setVisible(true);
    }

if(ae.getSource()==m8)
    {
        //setVisible(false);
        new studentreport().setVisible(true);
    }

if(ae.getSource()==m9)
    {
        //setVisible(false);
        new bookreport().setVisible(true);
    }
 
if(ae.getSource()==m10)
    {
        //setVisible(false);
        new issuereport().setVisible(true);
    }
 
if(ae.getSource()==m11)
    {
        //setVisible(false);
        new lostreport().setVisible(true);
    }

if(ae.getSource()==m13)
    {
        //setVisible(false);
        int response=JOptionPane.showConfirmDialog(this,"Are You Sure You Want to exit?","exit mess",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION)
        {
            setVisible(false);
        }
    }

}
    
public static void main(String[] args)
{
 menu mm = new menu();

    }
}
