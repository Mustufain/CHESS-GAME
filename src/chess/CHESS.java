
package chess;
/**
 *
 * @author Haider
 */
import java.awt.*;
//import javax.swing.*;
//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CHESS  implements ActionListener
{
    static JMenuBar Bar = new JMenuBar();
    JMenu menu = new JMenu("FILE");
    JMenuItem save = new JMenuItem("Save Game");
    JMenuItem Exit = new JMenuItem("Exit");
    
    final static JFrame MainWindow=new JFrame("CHESS");
    public static JPanel Panel3=new JPanel();
    final static JPanel Panel2 = new JPanel();
    final static  JPanel Panel1 = new JPanel();
    
    //in panel 2
    JButton New = new JButton("New Game");
    JButton Load = new JButton("Load Game");
    JButton signUP = new JButton("Register A User");
    
    JLabel firstPicture= new JLabel();
    JLabel secondPicture= new JLabel();

    static String name1;
    static String name2;
    
    public static JPanel Player2Side=new JPanel();
    public static JPanel Player1Side=new JPanel();
    
    public static JPanel Profile1=new JPanel();
    public static JPanel Profile2=new JPanel();
    
    static JPanel Player1KillPieces=new JPanel(new GridLayout(8,2,1,1));
    static JPanel[] Player1Kills=new JPanel[16];

    static JPanel Player2KillPieces=new JPanel(new GridLayout(8,2,1,1));
    static JPanel[] Player2Kills=new JPanel[16];
    
    static Connection  con; 
    
    final static int LENGTH=1366;
    final static int HEIGHT=700;
    
    static boolean life[]=new boolean[32];
    static int positions[]=new int[32];
    static int TimesMoved[]=new int[32];
   
    
    URL imgURL = getClass().getResource("Pic1.png");
    ImageIcon firstPicture_Icon=new ImageIcon(imgURL);
    
    URL imgURL1 = getClass().getResource("Pic2.png");
    ImageIcon secondPicture_Icon=new ImageIcon(imgURL1);
           
    
    public static void main(String[] args)   throws InterruptedException, ClassNotFoundException, SQLException
    {
        
        try
        {  
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");       
        }
        catch(ClassNotFoundException e)
        {  e.printStackTrace();
        
        }
        catch(InstantiationException e){
            e.printStackTrace();}
        catch(IllegalAccessException e)
        {  e.printStackTrace();
        }
        
        catch(UnsupportedLookAndFeelException e)
        {  e.printStackTrace();
        }
       
            
            
        CHESS c=new CHESS();
        con = Connections.Connect();
        //Board=new Checkerboard(); 
        
    }
       
    public CHESS() throws InterruptedException
    {
        //MainWindow.setJMenuBar(Bar);//bcz we want it to be set when we get to thirdpanel
        Bar.add(menu);
        menu.add(save);
        //menu.add(saveExisting);
        menu.add(Exit);

        Panel1.setBackground(Color.WHITE);
        Panel1.setSize(LENGTH, HEIGHT);
        Panel1.add(firstPicture);
        Panel1.setLayout(null);
        firstPicture.setBounds(0,10, 1366, 700);

        
        //WHEN GAME LOADED,KILLED LABELS INITIALIZED HERE
    Checkerboard.B_Castle1_Killed_Label=new JLabel();
    Checkerboard.B_Knight1_Killed_Label=new JLabel();
    Checkerboard.B_Bishop1_Killed_Label=new JLabel();
    Checkerboard.B_Queen_Killed_Label=new JLabel();
    Checkerboard.B_King_Killed_Label=new JLabel();
    Checkerboard.B_Bishop2_Killed_Label=new JLabel();
    Checkerboard.B_Knight2_Killed_Label=new JLabel();
    Checkerboard.B_Castle2_Killed_Label=new JLabel();

    Checkerboard.W_Castle1_Killed_Label=new JLabel();
    Checkerboard.W_Knight1_Killed_Label=new JLabel();
    Checkerboard.W_Bishop1_Killed_Label=new JLabel();
    Checkerboard.W_Queen_Killed_Label=new JLabel();
    Checkerboard.W_King_Killed_Label=new JLabel();
    Checkerboard.W_Bishop2_Killed_Label=new JLabel();
    Checkerboard.W_Knight2_Killed_Label=new JLabel();
    Checkerboard.W_Castle2_Killed_Label=new JLabel();        
        
        
        
        
        for(int x = 0; x < 8; x++)    Checkerboard.B_Killed_Pawn_Label[x]=new JLabel();

        for(int x = 0 ; x < 8 ; x++)  Checkerboard.W_Killed_Pawn_Label[x]=new JLabel();
        //JButton n1=new JButton("Haider Mushtaq");        
        //JButton n2=new JButton("Usama Mukhtar");
        //JButton n3=new JButton("Mstufain Abbas");
        //JButton n4=new JButton("Nazish Kazmi");
            //for(int x = 0; x < 8; x++)    Kala_Pawn_Label[x]=new JLabel();

           // for(int x = 0 ; x < 8 ; x++)  W_Pawn_Label[x]=new JLabel();

        
                
        Panel2.setSize(1366, 700);   
        Panel2.add(signUP);
        Panel2.add(New);
        Panel2.add(Load);
        Panel2.setBackground(Color.WHITE);
        Panel2.setLayout(null);
        
        Panel2.add(secondPicture);
//B1.setBounds(385, 350,200 , 25);
        signUP.setBounds(585,400,200, 26);
        Load.setBounds(585,350,200, 26);
        New.setBounds(585,300,200, 26);
        

        //Player2Side=new JPanel();
        //Player1Side=new JPanel();
        Player2Side.setLayout(null);
        Player1Side.setLayout(null);
        int i;
        for(i=0;i<16;i++)
        {
            Player1Kills[i]=new JPanel();
            Player2Kills[i]=new JPanel();
            Player1KillPieces.add(Player1Kills[i]);
            Player2KillPieces.add(Player2Kills[i]);
            Player1Kills[i].setBackground(new Color(205,235,235));
            Player2Kills[i].setBackground(new Color(150,150,100));
        }
        JLabel l1=new JLabel("PLAYER1");
        //l1.setBackground(Color.yellow);
        Profile1.add(new JLabel("PLAYER1"));
        Profile1.setBackground(new Color(125,145,125));

        //Player1Side.add(Profile1);
        Player1Side.add(Player1KillPieces);
        Player2Side.add(Player2KillPieces); 
        //Player1Side.add(Profile2);
        Player1KillPieces.setBounds(0, 0, 130, 640);
        Player2KillPieces.setBounds(0, 0, 130, 640);
        Player1Side.setBounds(0,0,140,640);
        Player2Side.setBounds(0,0,140,640);
        
        Profile2.add(new JLabel("PLAYER2"));
        Profile2.setBackground(new Color(25,150,150));
        
        secondPicture.setBounds(0, -70, 1366, 700);
        
        
        firstPicture.setIcon(firstPicture_Icon);
        secondPicture.setIcon(secondPicture_Icon);
        
        MainWindow.setSize(1366, 700);
        MainWindow.setVisible(true);
        Panel3.setLayout(new BoxLayout(Panel3, BoxLayout.X_AXIS));  
        MainWindow.add(Panel1);
        
        Timer timer = new Timer(5000,new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            MainWindow.getContentPane().remove(Panel1);
              
            MainWindow.invalidate();
            MainWindow.validate();
            MainWindow.repaint();            
        }
        }
        );
        timer.start();
    
        Timer timer1 = new Timer(5000,new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            MainWindow.add(Panel2);
            MainWindow.repaint();                                         
        }
        } 
        );
        timer1.start();    
    

        MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainWindow.setVisible(true);

        //B1.addActionListener(this);
        save.addActionListener(this);
        //saveExisting.addActionListener(this);
        Exit.addActionListener(this);
        Load.addActionListener(this);
        signUP.addActionListener(this);
        //reg.addActionListener(this);
        //name.addActionListener(this);
        New.addActionListener(this);
        //Player1.addActionListener(this);
        //Player2.addActionListener(this);
}

    @Override
    public void actionPerformed(ActionEvent ae) 
    {  
        //save Menu
        boolean isSaved=true;;
        if(ae.getSource()==save)
        {   
            isSaved=Connections.saveGame(con);
            System.out.println("saved is: "+isSaved);
        }

        //in menu
        if(ae.getSource()==Exit)
        { 
          System.exit(0);        
        }
        
        boolean isLoaded=true;
        if(ae.getSource()==Load)
        {
            
            loadGame l=new loadGame();
        }
        
        if(ae.getSource()==New)
        {
            try 
            {
                StartNewGame p=new StartNewGame();
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(CHESS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(ae.getSource()==signUP)
        {
           newUser n=new newUser();      
        }
        
   
     }//actionperformed end
}//class end
