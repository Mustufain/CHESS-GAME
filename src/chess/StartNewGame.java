/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author mustu
 */
class StartNewGame extends JFrame implements ActionListener

{
    
    
    
    JFrame f=new JFrame("New Game...");
    JPanel p=new JPanel();
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JLabel l1=new JLabel("Enter User1");
    JLabel l2=new JLabel("Enter User2");
    JTextField t1=new JTextField(10);
    JTextField t2=new JTextField(10);
    JButton b1=new JButton("OK");
    JButton b2=new JButton("CANCEL");
    
    //String name1;
    //String name2;
    
    public boolean isStarted=false;
    
    public StartNewGame() throws InterruptedException
       {
            p.setLayout(new  BoxLayout(p,BoxLayout.Y_AXIS));
            p1.setLayout(new  BoxLayout(p1,BoxLayout.Y_AXIS));
            p2.setLayout(new  BoxLayout(p2,BoxLayout.X_AXIS));
            f.add(p);
            p.add(p1);
            p.add(p2);
            p1.add(l1);
            p1.add(t1);
            p1.add(l2);
            p1.add(t2);
            p2.add(b1);
            p2.add(b2);
            f.setSize(200, 150);
            f.add(p);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            f.setLocation(550, 250);
            
            b1.addActionListener(this);
            b2.addActionListener(this);
       }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
            boolean b=false;
            //while(!b)
            {
            CHESS.name1=t1.getText();
            CHESS.name2=t2.getText();
            System.out.println(CHESS.name1+","+CHESS.name2);                        
            
            
           // CHESS.P.remove(B1);
            boolean b1,b2;
            b1=Connections.SearchUsers(CHESS.con, CHESS.name1);
            b2=Connections.SearchUsers(CHESS.con, CHESS.name2);
            if(b1&&b2)
            {
            CHESS.MainWindow.remove(CHESS.Panel2);    
            CHESS.MainWindow.add(CHESS.Panel3);
            CHESS.MainWindow.invalidate();
            CHESS.MainWindow.validate();
            CHESS.Panel3.setVisible(true);
           // StartNewGame.isStarted=true;
            System.out.println("Game started");
            //b=true;
            isStarted=true;
                //boolean q=StartNewGame.isStarted;
            if(isStarted)
            {
                try {
                    Checkerboard frame = new Checkerboard();
                    //System.out.println("StartNewGame.isStarted is:"+StartNewGame.isStarted);
                    //CHESS.Panel2.remove(CHESS.New);
                    //CHESS.Panel2.remove(CHESS.Load);
                    //CHESS.Panel2.remove(CHESS.signUP);
                    CHESS.MainWindow.getContentPane().remove(CHESS.Panel2);  
                    CHESS.MainWindow.setJMenuBar(CHESS.Bar);
                    CHESS.MainWindow.add(CHESS.Panel3);
                    CHESS.MainWindow.repaint();
                    CHESS.MainWindow.invalidate();
                    CHESS.MainWindow.validate();
                    CHESS.Panel3.setVisible(true);
                    System.out.println("Game Successfully Started..!");
                    
                    CHESS.Panel3.add(CHESS.Profile1);
                    CHESS.Panel3.add(CHESS.Player1Side);
                    //Checkerboard frame = new Checkerboard();
                    CHESS.Panel3.add(frame.pane);
                    //frame.pane.setBounds(260,-350,850,640);
                    CHESS.Panel3.add(CHESS.Player2Side);
                    CHESS.Panel3.add(CHESS.Profile2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StartNewGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            

            
            }
            else
            {
                JOptionPane.showMessageDialog(null, "User Names Have Not Been Registered..");
                
            }
            }
            if(isStarted)
            {
                f.dispose();
            }
        }
 
        if(e.getSource()==b2)
        {
            isStarted=false;
            f.dispose();
        }
        
        
    }
    
}
