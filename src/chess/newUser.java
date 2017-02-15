
package chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class newUser extends JFrame implements ActionListener
{
    JTextField UserName=new JTextField(10);
    JLabel UserLabel=new JLabel("Enter A Unique User Name");
    JButton Register=new JButton("Register User");
    JButton Cancel=new JButton("Cancel");
    
    JFrame f=new JFrame("Register A User");
    
    static boolean isRegistered=false;
    
    JPanel p=new JPanel();
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    
    public newUser()
    {       
        p.setLayout(new  BoxLayout(p,BoxLayout.Y_AXIS));
        p1.setLayout(new  BoxLayout(p1,BoxLayout.Y_AXIS));
        p2.setLayout(new  BoxLayout(p2,BoxLayout.X_AXIS));        
        
        p1.add(UserLabel);
        p1.add(UserName);
        
        p2.add(Register);
        p2.add(Cancel);
        
        p.add(p1);
        p.add(p2);
        
        f.add(p);
        f.setSize(250, 100);
        f.setLocation(550, 250);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Register.addActionListener(this);
        Cancel.addActionListener(this);
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {          
        if(ae.getSource()==Register)
        {
            try 
            {
                //set kr bhai sb kch
                //Connections.InsertUsers(con,name1, i, i, i, i);
                String n=UserName.getText();
                boolean bct=Connections.InsertUsers(CHESS.con, n);
                System.out.println("User Saved: "+bct);
                if(bct)
                {
                    f.dispose();
                    isRegistered=true;
                    JOptionPane.showMessageDialog(null, "User Saved");
                }
                //else
                  //  JOptionPane.showMessageDialog(null, "User Not Saved...!");
            System.out.println(n);
            } 
            catch (SQLException ex)
            {
                Logger.getLogger(CHESS.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "User Not Saved. \nMaybe An Invalid Name....!");
            }
        }    
        
        if(ae.getSource()==Cancel)
        {
            f.dispose();
        }
        
        
    }
}
