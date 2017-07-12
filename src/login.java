import java.awt.*;

import javax.swing.*;

import java.awt.event.*;




public class login extends JFrame implements ActionListener

{
    JLabel a,b,c,d;

    JTextField t1,t2;

    JButton bt1;

    
    login()
    
{
        Container c=getContentPane();

       
        setLayout(null);

        
        c=new JLabel("LOGIN WINDOW");

        c.setBounds(200,20,100,50);

        add(c);

        
        a=new JLabel("USER ID");

        a.setBounds(150,100,100,20);

        add(a);

        
        t1=new JTextField();

        t1.setBounds(260,100,100,20);

        add(t1);

        
        b=new JLabel("PASSWORD");

        b.setBounds(150,150,100,20);

        add(b);

        
        t2=new JPasswordField();

        t2.setBounds(260,150,100,20);

        add(t2);


        
        bt1= new JButton("Login");

        bt1.setBounds(200,200,100,20);

        add(bt1);

        
        bt1.addActionListener(this);

        
       
    }

    
    public void actionPerformed(ActionEvent ae)

    {

        if(ae.getActionCommand()=="Login")

        {

             String x =t1.getText();

             String y =t2.getText();

            
             if(x.equals("admin") && y.equals("admin123"))

                 {

                     
            
                    setVisible(false);

                    new menu().setVisible(true);

                 }
                else

                 {
                     JOptionPane.showMessageDialog(this,"Login Denied");

                     t1.setText("");

                     t2.setText("");

                     t1.requestFocus();

                
                     
                 }

             }

        }

      
        
    
    public static void main(String[] args)
 
    {
       login log= new login();

       log.setTitle("Login Window");

       log.setVisible(true);

       log.setSize(550,350);

       log.setLocation(300,200);

    }

}
