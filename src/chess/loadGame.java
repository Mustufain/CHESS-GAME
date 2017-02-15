
package chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class loadGame extends JFrame implements ActionListener
{
    JLabel Game=new JLabel("Enter Your Game Name:");
    JTextField Name=new JTextField(10);
    JButton Load=new JButton("Load");
    JButton Cancel=new JButton("Cancel");
    
    JFrame f=new JFrame("Load A Game");
    
    boolean Loaded=false;
    
    JPanel p=new JPanel();
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    
    public loadGame()
    {
        p.setLayout(new  BoxLayout(p,BoxLayout.Y_AXIS));
        p1.setLayout(new  BoxLayout(p1,BoxLayout.Y_AXIS));
        p2.setLayout(new  BoxLayout(p2,BoxLayout.X_AXIS));
        
        p1.add(Game);
        p1.add(Name);
        p2.add(Load);
        p2.add(Cancel);
        
        p.add(p1);
        p.add(p2);
        
        f.add(p);
        f.setSize(250,100);
        f.setLocation(550, 250);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Load.addActionListener(this);
        Cancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==Load)
        {
           boolean b=false;ResultSet rs1;String s;int i=0;
           //String tempName;
           boolean tempToPlay;
           // while(!b)
            //{
            s=Name.getText();
            //temp=Integer.parseInt(s);
            b=Connections.searchGame(CHESS.con, s);
            if(!b)
            {
                JOptionPane.showMessageDialog(null,"Enter a Valid Game Name To Load it");
            }
            else
            {
               // System.out.println("in else in loadGame");
                System.out.println(Name.getText()+","+s);
                    try
                    {
                        rs1=Connections.AccessGame(CHESS.con, s);Statement s2;ResultSet rs2;
                       //System.out.println("in try in loadGame");
                        //while(i<1)        
                        //{
                            //System.out.println("in while1 in loadGame");
                            while(rs1.next())
                            {
                                
                            //System.out.println("in while2 in loadGame");
                            //tempName=rs1.getString("GameName");
                            tempToPlay=rs1.getBoolean("WhiteToPlay");
                            CHESS.name1=rs1.getString("Player1Name");
                            CHESS.name2=rs1.getString("Player2Name");
                            //player1,2 k labels py ye id's ya names dalne hen
                            
                            rs2=Connections.AccessPieces(CHESS.con, s);
                            int j=0;                           
                            //CHESS.positions=new int[32];
                            //CHESS.life=new boolean[32];
                            while(rs2.next())
                            {
                                
                            //System.out.println("in while3 in loadGame");
                                CHESS.positions[j]=rs2.getInt("Position");
                                CHESS.life[j]=rs2.getBoolean("isAlive");
                                CHESS.TimesMoved[j]=rs2.getInt("timesMoved");
                                  //  if(j<16)
                                    //    colors[j]=0;
                                    //else
                                      //  colors[j]=1;
                                    j++;

                            }

                            Checkerboard.setPositions(CHESS.positions);//load positions in game
                            Checkerboard.setLife(CHESS.life);
                            Checkerboard.Loadsetup(CHESS.positions, CHESS.life,CHESS.TimesMoved, tempToPlay);
                            i++;
                            
                            
                            //System.out.println("b4 while2 end in loadGame");
                            }//2nd while end
                        //}//1st while end
                        b=true;
                   
                CHESS.MainWindow.getContentPane().remove(CHESS.Panel2);  
                CHESS.MainWindow.setJMenuBar(CHESS.Bar);
                CHESS.MainWindow.add(CHESS.Panel3);
                CHESS.MainWindow.repaint();
                CHESS.MainWindow.invalidate();
                CHESS.MainWindow.validate();
                CHESS.Panel3.setVisible(true);
                System.out.println("Game Successfully Loaded..!");
                f.dispose();                        
                        
                CHESS.Panel3.add(CHESS.Profile1);
                CHESS.Panel3.add(CHESS.Player1Side);             
                Checkerboard frame = new Checkerboard();
                CHESS.Panel3.add(frame.pane);
                CHESS.Panel3.add(CHESS.Player2Side);
                CHESS.Panel3.add(CHESS.Profile2);                        
                        
                                    //P.remove(B1);

                    } //try
                catch (InterruptedException ex) {
                    Logger.getLogger(loadGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex)
                    {
                        b=false;
                        Logger.getLogger(CHESS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Loaded=b;
               }//else ends
        
            
            
        }
        if(ae.getSource()==Cancel)
        {
            System.out.println("Game Not Loaded..!");
            f.dispose();
        }
    }


}
