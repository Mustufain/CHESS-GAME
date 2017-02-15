/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Checkerboard extends JFrame implements MouseListener 
{
    
    int whiteOnTop = 0;     //0 for true else 1
    int topToStart = 0;     //0 for true else 1
    public static ArrayList<Integer> allWhitePositions = new ArrayList<Integer>();
    public static ArrayList<Integer> allBlackPositions = new ArrayList<Integer>();

    private final int ROWS = 8;
    private final int COLS = 8;
    private final int GAP = 2;
    private final int NUM = ROWS * COLS;
    public int y;
    public int x;
    public  int alpha;
    public JPanel pane = new JPanel
    (new GridLayout(8, 8, 2, 2));
    public static JPanel[] panel = new JPanel[64];
    private Color color1 = Color.WHITE;
    private Color color2 = new Color(25,150,150);
    private Color tempColor;
    public boolean check;
    public static boolean whiteToPlay ;


    // DECLARING ALL THE CHESS PIECES :
    // WHITE CHESS PIECES
    static horse whiteHorse1 = new horse();
    static horse whiteHorse2 = new horse();
    static queen whiteQueen = new queen();
    static king whiteKing = new king();
    static castle whiteCastle1 = new castle();
    static castle whiteCastle2 = new castle();
    static bishop whiteBishop1 = new bishop();
    static bishop whiteBishop2 = new bishop();
    static pawn[] whitePawn = new pawn[8];
    
    // BLACK CHESS PIECES
    static horse blackHorse1 = new horse();
    static horse blackHorse2 = new horse();
    static queen blackQueen = new queen();
    static king blackKing = new king();
    static castle blackCastle1 = new castle();
    static castle blackCastle2 = new castle();
    static bishop blackBishop1 = new bishop();
    static bishop blackBishop2 = new bishop();
    static pawn[] blackPawn = new pawn[8];
    
    static boolean LoadedOrNot=false;


    // IMAGE INSERTION CODE: ***********************************************************

    URL B_Bishop = getClass().getResource("B_Bishop.png");ImageIcon B_Bishop_Icon = new ImageIcon(B_Bishop);
    URL B_Castle = getClass().getResource("B_Castle.png");ImageIcon B_Castle_Icon = new ImageIcon(B_Castle);
    URL B_King = getClass().getResource("B_King.png");    ImageIcon B_King_Icon = new ImageIcon(B_King);
    URL B_Knight = getClass().getResource("B_Knight.png");ImageIcon B_Knight_Icon = new ImageIcon(B_Knight);
    URL B_Queen = getClass().getResource("B_Queen.png");  ImageIcon B_Queen_Icon = new ImageIcon(B_Queen);
    URL B_Pawn = getClass().getResource("B_Pawn.png");    ImageIcon B_Pawn_Icon = new ImageIcon(B_Pawn);

    URL W_Bishop = getClass().getResource("W_Bishop.png");ImageIcon W_Bishop_Icon = new ImageIcon(W_Bishop);
    URL W_Castle = getClass().getResource("W_Castle.png");ImageIcon W_Castle_Icon = new ImageIcon(W_Castle);
    URL W_King = getClass().getResource("W_King.png");    ImageIcon W_King_Icon = new ImageIcon(W_King);
    URL W_Knight = getClass().getResource("W_Knight.png");ImageIcon W_Knight_Icon = new ImageIcon(W_Knight);
    URL W_Queen = getClass().getResource("W_Queen.png");  ImageIcon W_Queen_Icon = new ImageIcon(W_Queen);
    URL W_Pawn = getClass().getResource("W_Pawn.png"); ImageIcon W_Pawn_Icon = new ImageIcon(W_Pawn);
       
    static JLabel B_Castle1_Label=new JLabel();//static JLabel B_Castle1_Killed_Label=new JLabel();
    static JLabel B_Knight1_Label=new JLabel();
    static JLabel B_Bishop1_Label=new JLabel();
    static JLabel B_Queen_Label=new JLabel();
    static JLabel B_King_Label=new JLabel();
    static JLabel B_Bishop2=new JLabel();
    static JLabel B_Knight2=new JLabel();
    static JLabel B_Castle2_Label=new JLabel();

    static JLabel W_Castle1_Label=new JLabel();
    static JLabel W_Knight1_Label=new JLabel();
    static JLabel W_Bishop1_Label=new JLabel();
    static JLabel W_Queen_Label=new JLabel();
    static JLabel W_King_Label=new JLabel();
    static JLabel W_Bishop2=new JLabel();
    static JLabel W_Knight2=new JLabel();
    static JLabel W_Castle2_Label=new JLabel();

    public JLabel[] W_Pawn_Label=new JLabel[8];

    public JLabel[] B_Pawn_Label=new JLabel[8];

    
    static JLabel B_Castle1_Killed_Label;
    static JLabel B_Knight1_Killed_Label;//=new JLabel();
    static JLabel B_Bishop1_Killed_Label;//=new JLabel();
    static JLabel B_Queen_Killed_Label;//=new JLabel();
    static JLabel B_King_Killed_Label;//=new JLabel();
    static JLabel B_Bishop2_Killed_Label;//=new JLabel();
    static JLabel B_Knight2_Killed_Label;//=new JLabel();
    static JLabel B_Castle2_Killed_Label;//=new JLabel();

    static JLabel W_Castle1_Killed_Label;//=new JLabel();
    static JLabel W_Knight1_Killed_Label;//=new JLabel();
    static JLabel W_Bishop1_Killed_Label;//=new JLabel();
    static JLabel W_Queen_Killed_Label;//=new JLabel();
    static JLabel W_King_Killed_Label;//=new JLabel();
    static JLabel W_Bishop2_Killed_Label;//=new JLabel();
    static JLabel W_Knight2_Killed_Label;//=new JLabel();
    static JLabel W_Castle2_Killed_Label;//=new JLabel();

    public static JLabel[] W_Killed_Pawn_Label=new JLabel[8];
    
    public static JLabel[] B_Killed_Pawn_Label=new JLabel[8];  
    

    
    
    
    //ENDS : ***********************************************************************
    
    pieces thePiece;


        
    public Checkerboard() throws InterruptedException
    {
    super("Checkerboard");

    if(LoadedOrNot)
        System.out.println("A Saved Game Is Loaded..!");
    else
    {this.defaultsetup(topToStart);
    
    }


            for(int x = 0; x < 8; x++)    B_Pawn_Label[x]=new JLabel();

            for(int x = 0 ; x < 8 ; x++)  W_Pawn_Label[x]=new JLabel();
            
            

            
    //***************************************************************************************
    //this.refresh();

        B_Castle1_Killed_Label.setIcon(B_Castle_Icon);        
        B_Knight1_Killed_Label.setIcon(B_Knight_Icon);        
        B_Bishop1_Killed_Label.setIcon(B_Bishop_Icon);
        B_Queen_Killed_Label.setIcon(B_Queen_Icon); 
        B_King_Killed_Label.setIcon(B_King_Icon);   
        B_Bishop2_Killed_Label.setIcon(B_Bishop_Icon); 
        B_Knight2_Killed_Label.setIcon(B_Knight_Icon); 
        B_Castle2_Killed_Label.setIcon(B_Castle_Icon);
           
        W_Castle1_Killed_Label.setIcon(W_Castle_Icon);
        W_Knight1_Killed_Label.setIcon(W_Knight_Icon);
        W_Bishop1_Killed_Label.setIcon(W_Bishop_Icon); 
        W_Queen_Killed_Label.setIcon(W_Queen_Icon);
        W_King_Killed_Label.setIcon(W_King_Icon);
        W_Bishop2_Killed_Label.setIcon(W_Bishop_Icon); 
        W_Knight2_Killed_Label.setIcon(W_Knight_Icon);
        W_Castle2_Killed_Label.setIcon(W_Castle_Icon);             
            
        for(JLabel B_Killed_L:B_Killed_Pawn_Label)
        {
            B_Killed_L.setIcon(B_Pawn_Icon);
        }
        for(JLabel W_Killed_L:W_Killed_Pawn_Label)
        {
            W_Killed_L.setIcon(W_Pawn_Icon);
        }            

            
            
            
            
            
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(pane);
    for(x = 0; x < NUM; ++x)
    {
    panel[x] = new JPanel();
    pane.add(panel[x]);
    if(x % COLS == 0)
        {
        tempColor = color1;
        color1 = color2;
        color2 = tempColor;
        }

    if(x % 2 == 0) 
        {
            panel[x].setBackground(color1);
        }
    else 
        {
            panel[x].setBackground(color2);
        }

    }//for x<64 ends
    for(int c=0;c<64;c++)
    {
    panel[c].addMouseListener(this);
    }
     
    this.refresh(whiteOnTop); // If top player is White insert 0 else insert 1      
    }//constructor ends

    

    @Override
    public void mouseClicked(MouseEvent e) 
    {
       JPanel P = new JPanel();
       P=(JPanel) e.getSource();
       P.setBackground(Color.YELLOW);
     
      if(alpha==1)  
      {
         for(int b=0;b<64;b++)
         {
         if(b % COLS == 0)
            {
            tempColor = color1;
            color1 = color2;
            color2 = tempColor;
            }


        if(b % 2 == 0)
            panel[b].setBackground(color1);
        else
            panel[b].setBackground(color2);
        if (check == true)
            panel[blackKing.position].setBackground(Color.ORANGE);
        }//FOR b<64 end
        alpha = 0;
           
        
        // ADD AN UNSELECT METHOD HERE:
        this.unselectall();
      }//if(alpha==1) end
        
    else if (alpha==0)    
    {
        alpha=1;
    }
    try
    {         
        this.refresh(whiteOnTop); 
    }
    catch (InterruptedException ex) 
    {
        Logger.getLogger(Checkerboard.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("ERROR ERROR ERROR");
    }
        
  }//Mouseclicked end

    
    @Override
    public void mousePressed(MouseEvent e) 
    {
        // White Horse 1
        if(whiteToPlay == true )
        {
            if(e.getSource()==panel[whiteHorse1.position]&& alpha == 0)
                {
                showpos(whiteHorse1);
                }
            changepos( e , whiteHorse1);
       
        // White Horse 2
            if(e.getSource()==panel[whiteHorse2.position] && alpha == 0)
                {
                showpos(whiteHorse2);
                }
            changepos(e, whiteHorse2);
        
      
        // White Castle 1 
            if(e.getSource()==panel[whiteCastle1.position]&& alpha == 0)
                {
                showpos(whiteCastle1);
                }
            changepos(e, whiteCastle1);
 
        
        // White Castle 2 
            if(e.getSource()==panel[whiteCastle2.position]&& alpha == 0)
                {
                showpos(whiteCastle2);
                }
            changepos(e, whiteCastle2);

        
        // White Queen
            if(e.getSource() == panel[whiteQueen.position]&& alpha == 0)
                {
                this.showpos(whiteQueen);
                }
        changepos(e, whiteQueen);
      
         // White King *******************************************************
                
           if(e.getSource() == panel[whiteKing.position]&& alpha == 0)
                {
                whiteKing.movnum.clear();
                whiteKing.mov.clear();
                whiteKing.relativeWhiteMoves.clear();
                whiteKing.relativeBlackMoves.clear();
                whiteKing.addRelativePositions(blackHorse1);
                whiteKing.addRelativePositions(blackCastle1);
                whiteKing.addRelativePositions(blackCastle2);
                whiteKing.addRelativePositions(blackHorse2);
                whiteKing.addRelativePositions(blackQueen);
                whiteKing.addRelativePositions(blackBishop1);
                whiteKing.addRelativePositions(blackBishop2);
                blackKing.mov.clear();blackKing.movnum.clear();blackKing.kingCalls = 1;blackKing.move(moves.createMoves(blackKing.position));
                whiteKing.addRelativePositions(blackKing);
                for(pawn x : blackPawn)
                    {
                    x.kingMove = 1; 
                    whiteKing.addRelativePositions(x); x.mov.clear();x.movnum.clear();
                    }
                    
                this.showpos(whiteKing);
                }//e.getsource==w_king ends, 1st IF(whiteToPlay=true) still continues
           
           for(int alpha : whiteKing.movnum) 
           {
                if (e.getSource()== panel[alpha-1] && whiteKing.select == true && Checkerboard.allWhitePositions.contains(alpha-1) == false)
                    {
                    whiteKing.position = alpha-1;
                    whiteKing.select = false;
                    whiteToPlay = false;
                    }
            }

                
                
         // White Bishop 1
            
           if(e.getSource() == panel[whiteBishop1.position]&& alpha == 0)
           {
           this.showpos(whiteBishop1);
           }
           changepos(e, whiteBishop1);
   
           if(e.getSource() == panel[whiteBishop2.position]&& alpha == 0)
           {
           this.showpos(whiteBishop2);
           }
           changepos(e, whiteBishop2);
          
           // White Pawns
           for ( int x = 0 ; x < 8 ; x++)
           {
                if(e.getSource() == panel[whitePawn[x].position]&& alpha == 0)
                {
                this.showpos(whitePawn[x]);
                }
                for(int no = 0; no < 8 ; no++)
                    changepos(e, whitePawn[no]);
         
           }
           
        
        }
        //END *********************************************************
        //whiteToPlay = false;
        if(whiteToPlay == false)
        {
            // Black Horse 1
            if(e.getSource()==panel[blackHorse1.position]&& alpha == 0)
                {
                showpos(blackHorse1);
                }
            changepos(e, blackHorse1);
    
            // Black Horse 2
            if(e.getSource()==panel[blackHorse2.position]&& alpha == 0)
                {
                showpos(blackHorse2);
                }
            changepos(e, blackHorse2);
        
        
            // Black Castle 1 ***
            if(e.getSource()==panel[blackCastle1.position]&& alpha == 0)
                {
                showpos(blackCastle1);
                }
            changepos(e, blackCastle1);
      
            // Black Castle 2 
            if(e.getSource()==panel[blackCastle2.position]&& alpha == 0)
            {
            showpos(blackCastle2);
            }
            changepos(e, blackCastle2);
    
            // Black Queen
            if(e.getSource() == panel[blackQueen.position]&& alpha == 0 && blackQueen.alive == true)
            {
            this.showpos(blackQueen);
            }
            changepos(e, blackQueen);
       
            // Black King *******************************************************
                
            if(e.getSource() == panel[blackKing.position]&& alpha == 0)
            {
                blackKing.movnum.clear();
                blackKing.mov.clear();
                blackKing.relativeWhiteMoves.clear();
                blackKing.relativeBlackMoves.clear();
                blackKing.addRelativePositions(whiteHorse1);
                blackKing.addRelativePositions(whiteCastle1);
                blackKing.addRelativePositions(whiteCastle2);
                blackKing.addRelativePositions(whiteHorse2);
                blackKing.addRelativePositions(whiteQueen);
                blackKing.addRelativePositions(whiteBishop1);
                blackKing.addRelativePositions(whiteBishop2);
                whiteKing.mov.clear();whiteKing.movnum.clear();whiteKing.move(moves.createMoves(whiteKing.position));
                blackKing.addRelativePositions(whiteKing);
                for(pawn x : whitePawn)
                {
                    x.kingMove = 1;
                    blackKing.addRelativePositions(x);
                    x.mov.clear();x.movnum.clear();
                }
                this.showpos(blackKing);

            }//e.getsource=b_king ends
            
            for(int alpha : blackKing.movnum)
                if (e.getSource()== panel[alpha-1] && blackKing.select == true && Checkerboard.allBlackPositions.contains(alpha-1) == false)
                    {
                    blackKing.position = alpha-1;
                    blackKing.select = false;
                    whiteToPlay = true;
                    }
                //END *********************************************************
                
            // Black Bishop 1
            if(e.getSource() == panel[blackBishop1.position]&& alpha == 0)
            {
            this.showpos(blackBishop1);
            }
            changepos(e, blackBishop1);
      
            // Black Bishop 2
            if(e.getSource() == panel[blackBishop2.position]&& alpha == 0)
            {
            this.showpos(blackBishop2);
            }
            changepos(e, blackBishop2);
             
            // Black Pawns
            for ( int x = 0 ; x < 8 ; x++)
            {
                if(e.getSource() == panel[blackPawn[x].position]&& alpha == 0)
                {
                this.showpos(blackPawn[x]);
                }
                for(int no = 0; no < 8 ; no++)
                    changepos(e, blackPawn[no]);
            }//BLACKPAWNS END
       // whiteToPlay = true;
        }
        
        //END  of White pieces click*********************************************************
    }//MousePressed ends

    @Override
    public void mouseReleased(MouseEvent e) 
    {
    }
   


    @Override
    public void mouseEntered(MouseEvent e)
    {
    }
    
    @Override
    public void mouseExited(MouseEvent e) 
    {
    }
    
    
    
    void showpos(pieces chesspiece)
    {
     
     /*
     A METHOD USING WHICH YOU CAN SEE ALL THE VALID POSITIONS OF ALL THE PIECES ON THE BOARD
     IT TAKES IN one VARIABLE: THE OBJECT OF THE CHESSPIECE E.G the 'h' of horse h = new horse();
     
     */if(chesspiece.alive == true)
       {
        int position = chesspiece.position;
        chesspiece.select = true;
        
        int x;int y;
        if((position+1)%8 == 0) {x = 8; y = (position+8)/8;}
        else{ x = (position+1)%8;
        y = (position+9)/8;}
        chesspiece.move(new moves(x,y));
        for( int a : chesspiece.movnum )
        {
            if ( chesspiece.color == 0)
            {
                if (Checkerboard.allWhitePositions.contains(a-1)== true)
                panel[a-1].setBackground(Color.GRAY);
                else if (Checkerboard.allBlackPositions.contains(a-1)== true)
                panel[a-1].setBackground(Color.RED);
                else
                panel[a-1].setBackground(Color.GREEN);
            }
            else
            {
                if (Checkerboard.allWhitePositions.contains(a-1)== true)
                panel[a-1].setBackground(Color.RED);
                else if (Checkerboard.allBlackPositions.contains(a-1)== true)
                panel[a-1].setBackground(Color.GRAY);
                else
                panel[a-1].setBackground(Color.GREEN);
            }
           
        }
       }//if(chesspiece.alive==true) ends
    }//show pos method ends
    
    
    void selectpos()
    {
        
    }
    
    /*
     This method takes in three variables... 
     * 1)The object of that extends pieces
     * 2)The position of the panel 
     * 3)The new Position of the panel
     */
    void changepos(MouseEvent e, pieces chessPiece) 
    {    
        for(int beta : chessPiece.movnum)
        {            
            if (chessPiece.color == 0 && e.getSource()== panel[beta-1 ]&& chessPiece.select == true && Checkerboard.allWhitePositions.contains(beta-1) == false)
            {
                if(this.getPiece(beta-1) != null)
                { 
                getPiece(beta-1).alive = false;
                
                
                
                panel[beta-1].removeAll();/*getPiece(beta-1).position = 64;*/
                }
                chessPiece.position = beta-1;
                chessPiece.movnum.clear();
                chessPiece.mov.clear();
                chessPiece.select = false;
                chessPiece.timesMoved++;
                whiteToPlay = false;
           }
           else  if (chessPiece.color == 1 && e.getSource()== panel[beta-1 ]&& chessPiece.select == true && Checkerboard.allBlackPositions.contains(beta-1) == false)
           {
                if(this.getPiece(beta-1) != null)
                { 
                getPiece(beta-1).alive = false; 
                panel[beta-1].removeAll();/*getPiece(beta-1).position = 64;*/}
                chessPiece.position = beta-1;
                chessPiece.movnum.clear();
                chessPiece.mov.clear();
                chessPiece.select = false;
                chessPiece.timesMoved++;
                whiteToPlay = true;
                }
          }//for ends
    
    }//changepos method ends
    
  
    
    void unselectall()
    {
        // White Chess Pieces
        whiteHorse1.select = false;
        whiteHorse2.select = false;
        whiteQueen.select = false;
        whiteKing.select = false;
        whiteCastle1.select = false;
        whiteCastle2.select = false;
        whiteBishop1.select = false;
        whiteBishop2.select = false;
        for(int x = 0 ; x < 8 ; x++)
            whitePawn[x].select = false;
        // Black Chess Pieces
        blackHorse1.select = false;
        blackHorse2.select = false;
        blackQueen.select = false;
        blackKing.select = false;
        blackCastle1.select = false;
        blackCastle2.select = false;
        blackBishop1.select = false;
        blackBishop2.select = false;
        for(int x = 0 ; x < 8 ; x++)
            blackPawn[x].select = false;
       // Checkerboard.allWhitePositions.clear();

        this.updatePositions();
    }//unselect all method ends
    
    void defaultsetup(int phi) 
    {// The Images should be loded here... Also add labels here
        System.out.println("IN DEFAULT SETUP..");
        if( phi == 0) 
            whiteToPlay = true;
        else if (phi == 1) 
            whiteToPlay = false;
     // White Chess Pieces
     whiteHorse1.position = 1; whiteHorse1.color = 0;
     whiteHorse2.position = 6; whiteHorse2.color = 0;
     whiteQueen.position = 3; whiteQueen.color = 0;
     whiteKing.position =4 ; whiteKing.color = 0;
     whiteCastle1.position = 0; whiteCastle1.color = 0;
     whiteCastle2.position = 7; whiteCastle2.color = 0;
     whiteBishop1.position = 2; whiteBishop1.color = 0;
     whiteBishop2.position = 5; whiteBishop2.color = 0;
     int y = 8;
     for(int x = 0 ; x < 8; x++)
     {
     whitePawn[x] = new pawn();
     whitePawn[x].position = 8+x;
     whitePawn[x].color = 0;
     }
     //Black Chess Pieces
     blackHorse1.position = 57; blackHorse1.color = 1;
     blackHorse2.position = 62; blackHorse2.color = 1;
     blackQueen.position = 59;  blackQueen.color = 1;
     blackKing.position = 60; blackKing.color = 1;
     blackCastle1.position = 56;blackCastle1.color = 1;
     blackCastle2.position = 63;blackCastle2.color = 1;
     blackBishop1.position = 58;blackBishop1.color = 1;
     blackBishop2.position = 61;blackBishop2.color = 1;
     y = 8;
     for(int x = 0 ; x < 8; x++)
     {
     blackPawn[x] = new pawn();
     blackPawn[x].position = 48+x;
     blackPawn[x].color = 1;
     }
   
     this.updatePositions();
    }//defaultsetup method
    
    static void Loadsetup(int[] pos,boolean[] isAlive,int[] Times,boolean phi )
    {// The Images should be loded here... Also add labels here
        LoadedOrNot=true;
        whiteToPlay = phi;
     // White Chess Pieces
        whiteHorse1.position = pos[1]; whiteHorse1.color = 0;whiteHorse1.alive=isAlive[1];whiteHorse1.timesMoved=Times[1];
        whiteHorse2.position = pos[6]; whiteHorse2.color = 0;whiteHorse2.alive=isAlive[6];whiteHorse2.timesMoved=Times[6];
        whiteQueen.position = pos[3]; whiteQueen.color = 0;whiteQueen.alive=isAlive[3];whiteQueen.timesMoved=Times[3];
        whiteKing.position =pos[4] ; whiteKing.color = 0;whiteKing.alive=isAlive[4];whiteKing.timesMoved=Times[4];
        whiteCastle1.position = pos[0]; whiteCastle1.color = 0;whiteCastle1.alive=isAlive[0];whiteCastle1.timesMoved=Times[0];
        whiteCastle2.position = pos[7]; whiteCastle2.color = 0;whiteCastle2.alive=isAlive[7];whiteCastle2.timesMoved=Times[7];
        whiteBishop1.position = pos[2]; whiteBishop1.color = 0;whiteBishop1.alive=isAlive[2];whiteBishop1.timesMoved=Times[2];
        whiteBishop2.position = pos[5]; whiteBishop2.color = 0;whiteBishop2.alive=isAlive[5];whiteBishop2.timesMoved=Times[5];
        int y = 8;
        for(int x = 0 ; x < 8; x++)
        {
            whitePawn[x] = new pawn();
            whitePawn[x].position = pos[x+8];
            whitePawn[x].alive=isAlive[x+8];
            whitePawn[x].color = 0;
            whitePawn[x].timesMoved=Times[x+8];
        }     //Black Chess Pieces
        blackHorse1.position =pos[17]; blackHorse1.color =1;blackHorse1.alive=isAlive[17];blackHorse1.timesMoved=Times[17];
        blackHorse2.position = pos[22]; blackHorse2.color = 1;blackHorse2.alive=isAlive[22];blackHorse2.timesMoved=Times[22];
        blackQueen.position = pos[19];  blackQueen.color = 1;blackQueen.alive=isAlive[19];blackQueen.timesMoved=Times[19];
        blackKing.position = pos[20]; blackKing.color = 1;blackKing.alive=isAlive[20];blackKing.timesMoved=Times[20];
        blackCastle1.position = pos[16];blackCastle1.color = 1;blackCastle1.alive=isAlive[16];blackCastle1.timesMoved=Times[16];
        blackCastle2.position = pos[23];blackCastle2.color = 1;blackCastle2.alive=isAlive[23];blackCastle2.timesMoved=Times[23];
        blackBishop1.position = pos[18];blackBishop1.color = 1;blackBishop1.alive=isAlive[18];blackBishop1.timesMoved=Times[18];
        blackBishop2.position = pos[21];blackBishop2.color = 1;blackBishop2.alive=isAlive[21];blackBishop2.timesMoved=Times[22];
        y = 8;
        for(int x = 0 ; x < 8; x++)
        { //48-55
            blackPawn[x] = new pawn();
            blackPawn[x].position = pos[x+24];
            blackPawn[x].alive=isAlive[x+24];
            blackPawn[x].color = 1;
            blackPawn[x].timesMoved=Times[x+24];
        }
        
        //refresh();
        for(int h=0;h<64;h++)
        {
         panel[h]=new JPanel();
        }
        //panel[blackCastle1.position]=new JPanel();
        if (blackCastle1.alive == false) 
        {
            panel[blackCastle1.position].repaint();
            CHESS.Player1Kills[8].add(B_Castle1_Killed_Label);
        } 
        if (blackHorse1.alive == false)
        {
            panel[blackCastle1.position].repaint();
            CHESS.Player1Kills[9].add(B_Knight1_Killed_Label);
        }        
        if (blackBishop1.alive == false) 
        {
            panel[blackCastle1.position].repaint();
            CHESS.Player1Kills[10].add(B_Bishop1_Killed_Label);
        }         
        if (blackQueen.alive == false) 
        {
            panel[blackCastle1.position].repaint();
            CHESS.Player1Kills[11].add(B_Queen_Killed_Label);
        }        
        if (blackKing.alive == false)
        {
            panel[blackCastle1.position].repaint();
            CHESS.Player1Kills[12].add(B_King_Killed_Label);
        }        
        if (blackBishop2.alive == false)
        {
            panel[blackCastle1.position].repaint();
            CHESS.Player1Kills[13].add(B_Bishop2_Killed_Label);
        }        
        if (blackHorse2.alive == false)
        {
            panel[blackCastle1.position].repaint();
            CHESS.Player1Kills[14].add(B_Knight2_Killed_Label);
        }         
        if (blackCastle2.alive == false) 
        {
            panel[blackCastle1.position].repaint();
            CHESS.Player1Kills[15].add(B_Castle2_Killed_Label);
        } 
        
        
        
        
        
        if (whiteCastle1.alive == false)
        {
            panel[whiteCastle1.position].repaint();
            CHESS.Player2Kills[8].add(W_Castle1_Killed_Label);
        } 
        if (whiteHorse1.alive == false)
        {
            panel[whiteCastle1.position].repaint();
            CHESS.Player2Kills[9].add(W_Knight1_Killed_Label);
        } 
        if (whiteBishop1.alive == false)
        {
            panel[whiteCastle1.position].repaint();
            CHESS.Player2Kills[10].add(W_Bishop1_Killed_Label);
        } 
        if (whiteQueen.alive == false)
        {
            panel[whiteCastle1.position].repaint();
            CHESS.Player2Kills[11].add(W_Queen_Killed_Label);
        } 
        if (whiteKing.alive == false)
        {
            panel[whiteCastle1.position].repaint();
            CHESS.Player2Kills[12].add(W_King_Killed_Label);
        } 
        if (whiteBishop2.alive == false)
        {
            panel[whiteCastle1.position].repaint();
            CHESS.Player2Kills[13].add(W_Bishop2_Killed_Label);
        } 
        if (whiteHorse2.alive == false)
        {
            panel[whiteCastle1.position].repaint();
            CHESS.Player2Kills[14].add(W_Knight2_Killed_Label);
        } 
        if (whiteCastle2.alive == false)
        {
            panel[whiteCastle1.position].repaint();
            CHESS.Player2Kills[15].add(W_Castle2_Killed_Label);
        } 
        
        int j=0;

        if(blackPawn[0].alive == false)
        {
            panel[blackPawn[0].position].repaint();
            CHESS.Player1Kills[0].add(B_Killed_Pawn_Label[0]);
        }
        else j++;

        if(blackPawn[1].alive == false)
        {
            panel[blackPawn[1].position].repaint();
            CHESS.Player1Kills[1].add(B_Killed_Pawn_Label[1]);
        //CHESS.Player1KillPieces.add(CHESS.Player1Kills[1]);
        }
        else j++;  
        //JLabel B_Pawnn=new JLabel();
       // B_Pawnn=B_Pawn_Label[2];
        if(blackPawn[2].alive == false)
        {
            panel[blackPawn[2].position].repaint();
            CHESS.Player1Kills[2].add(B_Killed_Pawn_Label[2]);
        //CHESS.Player1KillPieces.add(CHESS.Player1Kills[2]);
        }
        else j++; 
        if(blackPawn[3].alive == false)
        {
            panel[blackPawn[3].position].repaint();
            CHESS.Player1Kills[3].add(B_Killed_Pawn_Label[3]);                
        }
        else j++;                
        if(blackPawn[4].alive == false)
        {
            panel[blackPawn[4].position].repaint();
            CHESS.Player1Kills[4].add(B_Killed_Pawn_Label[4]);
        }
        else j++;
        if(blackPawn[5].alive == false)
        {
            panel[blackPawn[5].position].repaint();
            CHESS.Player1Kills[5].add(B_Killed_Pawn_Label[5]);
        }
        else j++;                
        if(blackPawn[6].alive == false)
        {
            panel[blackPawn[6].position].repaint();
            CHESS.Player1Kills[6].add(B_Killed_Pawn_Label[6]);
        }
        else j++;
        if(blackPawn[7].alive == false)
        {
            panel[blackPawn[7].position].repaint();
            CHESS.Player1Kills[7].add(B_Killed_Pawn_Label[7]);
        }
        else j++;      

        //W_L=W_Pawn_Label[0];
        //B_L.setIcon(B_Pawn_Icon);
        if(whitePawn[0].alive == false)
        {
            panel[whitePawn[0].position].repaint();
            CHESS.Player2Kills[0].add(W_Killed_Pawn_Label[0]);
        }
        else j++;
        if(whitePawn[1].alive == false)
        {
            panel[whitePawn[1].position].repaint();
            CHESS.Player2Kills[1].add(W_Killed_Pawn_Label[1]);
        }
        else j++;  
        if(whitePawn[2].alive == false)
        {
            panel[whitePawn[2].position].repaint();
            CHESS.Player2Kills[2].add(W_Killed_Pawn_Label[2]);
        }
        else j++; 
        if(whitePawn[3].alive == false)
        {
            panel[whitePawn[3].position].repaint();
            CHESS.Player2Kills[3].add(W_Killed_Pawn_Label[3]);
        }
        else j++;                
        if(whitePawn[4].alive == false)
        {
            panel[whitePawn[4].position].repaint();
            CHESS.Player2Kills[4].add(W_Killed_Pawn_Label[4]);
        }
        else j++;
        if(whitePawn[5].alive == false)
        {
            panel[whitePawn[5].position].repaint();
            CHESS.Player2Kills[5].add(W_Killed_Pawn_Label[5]);
        }
        else j++;                
        if(whitePawn[6].alive == false)
        {
            panel[whitePawn[6].position].repaint();
            CHESS.Player2Kills[6].add(W_Killed_Pawn_Label[6]);
        }
        else j++;
        if(whitePawn[7].alive == false)
        {
            panel[whitePawn[7].position].repaint();
            CHESS.Player2Kills[7].add(W_Killed_Pawn_Label[7]);
        }
        else j++;                   
        //}  
        int i=0;
      /*  for(W_L: W_Pawn_Label)
        {
            W_L.setIcon(W_Pawn_Icon);
            if(whitePawn[i].alive == true)
            panel[whitePawn[i++].position].add(W_L);
            else i++;
        }   */  
     
          
    }//Loadsetup method ends
    
    void refresh(int phi)throws InterruptedException
    {
        if(phi == 0)
        {
            B_Castle1_Label.setIcon(B_Castle_Icon);        
            B_Knight1_Label.setIcon(B_Knight_Icon);        
            B_Bishop1_Label.setIcon(B_Bishop_Icon);
            B_Queen_Label.setIcon(B_Queen_Icon); 
            B_King_Label.setIcon(B_King_Icon);   
            B_Bishop2.setIcon(B_Bishop_Icon); 
            B_Knight2.setIcon(B_Knight_Icon); 
            B_Castle2_Label.setIcon(B_Castle_Icon);

            W_Castle1_Label.setIcon(W_Castle_Icon);
            W_Knight1_Label.setIcon(W_Knight_Icon);
            W_Bishop1_Label.setIcon(W_Bishop_Icon); 
            W_Queen_Label.setIcon(W_Queen_Icon);
            W_King_Label.setIcon(W_King_Icon);
            W_Bishop2.setIcon(W_Bishop_Icon); 
            W_Knight2.setIcon(W_Knight_Icon);
            W_Castle2_Label.setIcon(W_Castle_Icon);        
        
            if (blackCastle1.alive == true) panel[blackCastle1.position].add(B_Castle1_Label);         
            if (blackHorse1.alive == true)panel[blackHorse1.position].add(B_Knight1_Label);       
            if (blackBishop1.alive == true) panel[blackBishop1.position].add(B_Bishop1_Label);        
            if (blackQueen.alive == true) panel[blackQueen.position].add(B_Queen_Label);        
            if (blackKing.alive == true)panel[blackKing.position].add(B_King_Label);        
            if (blackBishop2.alive == true)panel[blackBishop2.position].add(B_Bishop2);        
            if (blackHorse2.alive == true)panel[blackHorse2.position].add(B_Knight2);        
            if (blackCastle2.alive == true) panel[blackCastle2.position].add(B_Castle2_Label);

            if (whiteCastle1.alive == true)panel[whiteCastle1.position].add(W_Castle1_Label);
            if (whiteHorse1.alive == true)panel[whiteHorse1.position].add(W_Knight1_Label);
            if (whiteBishop1.alive == true)panel[whiteBishop1.position].add(W_Bishop1_Label);
            if (whiteQueen.alive == true)panel[whiteQueen.position].add(W_Queen_Label);
            if (whiteKing.alive == true)panel[whiteKing.position].add(W_King_Label);
            if (whiteBishop2.alive == true)panel[whiteBishop2.position].add(W_Bishop2);
            if (whiteHorse2.alive == true)panel[whiteHorse2.position].add(W_Knight2);
            if (whiteCastle2.alive == true)panel[whiteCastle2.position].add(W_Castle2_Label);
            
            //CHESS.Player2Kills[7].add(CHESS.W_Killed_Pawn_Label[7]);
            
            if (blackCastle1.alive == false) CHESS.Player1Kills[0].add(B_Castle1_Killed_Label);       
            if (blackHorse1.alive == false)CHESS.Player1Kills[1].add(B_Knight1_Killed_Label);       
            if (blackBishop1.alive == false) CHESS.Player1Kills[2].add(B_Bishop1_Killed_Label);        
            if (blackQueen.alive == false) CHESS.Player1Kills[3].add(B_Queen_Killed_Label);        
            if (blackKing.alive == false)CHESS.Player1Kills[4].add(B_King_Killed_Label);        
            if (blackBishop2.alive == false)CHESS.Player1Kills[5].add(B_Bishop2_Killed_Label);        
            if (blackHorse2.alive == false)CHESS.Player1Kills[6].add(B_Knight2_Killed_Label);        
            if (blackCastle2.alive == false) CHESS.Player1Kills[7].add(B_Castle2_Killed_Label);

            if (whiteCastle1.alive == false)CHESS.Player2Kills[0].add(W_Castle1_Killed_Label);
            if (whiteHorse1.alive == false)CHESS.Player2Kills[1].add(W_Knight1_Killed_Label);
            if (whiteBishop1.alive == false)CHESS.Player2Kills[2].add(W_Bishop1_Killed_Label);
            if (whiteQueen.alive == false)CHESS.Player2Kills[3].add(W_Queen_Killed_Label);
            if (whiteKing.alive == false)CHESS.Player2Kills[4].add(W_King_Killed_Label);
            if (whiteBishop2.alive == false)CHESS.Player2Kills[5].add(W_Bishop2_Killed_Label);
            if (whiteHorse2.alive == false)CHESS.Player2Kills[6].add(W_Knight2_Killed_Label);
            if (whiteCastle2.alive == false)CHESS.Player2Kills[7].add(W_Castle2_Killed_Label);            
            
            
            if(blackPawn[0].alive==false)CHESS.Player1Kills[8].add(B_Killed_Pawn_Label[0]);
            if(blackPawn[1].alive==false)CHESS.Player1Kills[9].add(B_Killed_Pawn_Label[1]);
            if(blackPawn[2].alive==false)CHESS.Player1Kills[10].add(B_Killed_Pawn_Label[2]);
            if(blackPawn[3].alive==false)CHESS.Player1Kills[11].add(B_Killed_Pawn_Label[3]);
            if(blackPawn[4].alive==false)CHESS.Player1Kills[12].add(B_Killed_Pawn_Label[4]);
            if(blackPawn[5].alive==false)CHESS.Player1Kills[13].add(B_Killed_Pawn_Label[5]);
            if(blackPawn[6].alive==false)CHESS.Player1Kills[14].add(B_Killed_Pawn_Label[6]);
            if(blackPawn[7].alive==false)CHESS.Player1Kills[15].add(B_Killed_Pawn_Label[7]);
            //if(blackPawn[0].alive==false)          
            
            if(whitePawn[0].alive==false)CHESS.Player2Kills[8].add(W_Killed_Pawn_Label[0]);
            if(whitePawn[1].alive==false)CHESS.Player2Kills[9].add(W_Killed_Pawn_Label[1]);
            if(whitePawn[2].alive==false)CHESS.Player2Kills[10].add(W_Killed_Pawn_Label[2]);
            if(whitePawn[3].alive==false)CHESS.Player2Kills[11].add(W_Killed_Pawn_Label[3]);
            if(whitePawn[4].alive==false)CHESS.Player2Kills[12].add(W_Killed_Pawn_Label[4]);
            if(whitePawn[5].alive==false)CHESS.Player2Kills[13].add(W_Killed_Pawn_Label[5]);
            if(whitePawn[6].alive==false)CHESS.Player2Kills[14].add(W_Killed_Pawn_Label[6]);
            if(whitePawn[7].alive==false)CHESS.Player2Kills[15].add(W_Killed_Pawn_Label[7]);            
            
            
            int j=0;
            for(JLabel B_L: B_Pawn_Label)
            {
                //B_L=new JLabel();
                B_L.setIcon(B_Pawn_Icon);
                if(blackPawn[j].alive == true)
                panel[blackPawn[j++].position].add(B_L);
                else j++;            
            }  
 
        int i=0;
        for(JLabel W_L: W_Pawn_Label)
        {
            W_L.setIcon(W_Pawn_Icon);
            if(whitePawn[i].alive == true)
            panel[whitePawn[i++].position].add(W_L);
            else i++;
        }
        
        }//if(phi==0) ends
          
        if(phi == 1)
        {
            B_Castle1_Label.setIcon(B_Castle_Icon);        
            B_Knight1_Label.setIcon(B_Knight_Icon);        
            B_Bishop1_Label.setIcon(B_Bishop_Icon);
            B_Queen_Label.setIcon(B_Queen_Icon); 
            B_King_Label.setIcon(B_King_Icon);   
            B_Bishop2.setIcon(B_Bishop_Icon); 
            B_Knight2.setIcon(B_Knight_Icon); 
            B_Castle2_Label.setIcon(B_Castle_Icon);

            W_Castle1_Label.setIcon(W_Castle_Icon);
            W_Knight1_Label.setIcon(W_Knight_Icon);
            W_Bishop1_Label.setIcon(W_Bishop_Icon); 
            W_Queen_Label.setIcon(W_Queen_Icon);
            W_King_Label.setIcon(W_King_Icon);
            W_Bishop2.setIcon(W_Bishop_Icon); 
            W_Knight2.setIcon(W_Knight_Icon);
            W_Castle2_Label.setIcon(W_Castle_Icon);

            panel[blackCastle1.position].add(W_Castle1_Label);         
            panel[blackHorse1.position].add(W_Knight1_Label);       
            panel[blackBishop1.position].add(W_Bishop1_Label);        
            panel[blackQueen.position].add(W_Queen_Label);        
            panel[blackKing.position].add(W_King_Label);        
            panel[blackBishop2.position].add(W_Bishop2);        
            panel[blackHorse2.position].add(W_Knight2);        
            panel[blackCastle2.position].add(W_Castle2_Label);

            panel[whiteCastle1.position].add(B_Castle1_Label);
            panel[whiteHorse1.position].add(B_Knight1_Label);
            panel[whiteBishop1.position].add(B_Bishop1_Label);
            panel[whiteQueen.position].add(B_Queen_Label);
            panel[whiteKing.position].add(B_King_Label);
            panel[whiteBishop2.position].add(B_Bishop2);
            panel[whiteHorse2.position].add(B_Knight2);
            panel[whiteCastle2.position].add(B_Castle2_Label);

            int j=0;
            for(JLabel B_L: W_Pawn_Label)
                {

                    B_L.setIcon(W_Pawn_Icon);
                    panel[blackPawn[j++].position].add(B_L);
                }  
            int i=0;
            for(JLabel W_L: B_Pawn_Label)
            {

                W_L.setIcon(B_Pawn_Icon);
                panel[whitePawn[i++].position].add(W_L);
            }
        }//if(phi==1) ends
          
    }//refresh mrthod ends
    
    
    void updatePositions()
    {
        allWhitePositions.clear();
        allBlackPositions.clear();
        System.out.println("UPDATING POSITIONS");
        if(whiteCastle1.alive == true) allWhitePositions.add(whiteCastle1.position);
        if(whiteHorse1.alive == true)allWhitePositions.add(whiteHorse1.position);
        if(whiteBishop1.alive == true)allWhitePositions.add(whiteBishop1.position);
        if(whiteQueen.alive == true)allWhitePositions.add(whiteQueen.position);
        if(whiteKing.alive == true)allWhitePositions.add(whiteKing.position);
        if(whiteBishop2.alive == true)allWhitePositions.add(whiteBishop2.position);
        if(whiteHorse2.alive == true)allWhitePositions.add(whiteHorse2.position); 
        if(whiteCastle2.alive == true)allWhitePositions.add(whiteCastle2.position);
        for(int x = 0 ; x < 8 ; x++)
        {
          if(whitePawn[x].alive == true)  allWhitePositions.add(whitePawn[x].position);
        }
       
        if(blackCastle1.alive == true) allBlackPositions.add(blackCastle1.position);
        if(blackHorse1.alive == true)allBlackPositions.add(blackHorse1.position);
        if(blackBishop1.alive == true)allBlackPositions.add(blackBishop1.position);
        if(blackQueen.alive == true)allBlackPositions.add(blackQueen.position);
        if(blackKing.alive == true)allBlackPositions.add(blackKing.position);
        if(blackBishop2.alive == true)allBlackPositions.add(blackBishop2.position);
        if(blackHorse2.alive == true)allBlackPositions.add(blackHorse2.position);
        if(blackCastle2.alive == true)allBlackPositions.add(blackCastle2.position);
        
        for(int x = 0 ; x < 8 ; x++)
        {
            if(blackPawn[x].alive == true) allBlackPositions.add(blackPawn[x].position);
        }
//        
        
    }//update positions method ends
    
    
    pieces getPiece(int position)
    {
        int j ;
        if(position == whiteHorse1.position && whiteHorse1.alive == true ) return whiteHorse1;
        if(position == whiteHorse2.position && whiteHorse2.alive == true) return whiteHorse2;
        if(position == whiteQueen.position && whiteQueen.alive == true ) return whiteQueen;
        if(position == whiteKing.position && whiteKing.alive == true) return whiteKing;
        if(position == whiteCastle1.position && whiteCastle1.alive == true ) return whiteCastle1;
        if(position == whiteCastle2.position && whiteCastle2.alive == true) return whiteCastle2;
        if(position == whiteBishop1.position && whiteBishop1.alive == true) return whiteBishop1;
        if(position == whiteBishop2.position && whiteBishop2.alive == true) return whiteBishop2;
        j=0;
        if(position == whitePawn[j].position && whitePawn[j].alive == true) return whitePawn[j];j++;
        if(position == whitePawn[j].position && whitePawn[j].alive == true) return whitePawn[j];j++;
        if(position == whitePawn[j].position && whitePawn[j].alive == true) return whitePawn[j];j++;
        if(position == whitePawn[j].position && whitePawn[j].alive == true) return whitePawn[j];j++;
        if(position == whitePawn[j].position && whitePawn[j].alive == true) return whitePawn[j];j++;
        if(position == whitePawn[j].position && whitePawn[j].alive == true) return whitePawn[j];j++;
        if(position == whitePawn[j].position && whitePawn[j].alive == true) return whitePawn[j];j++;
        if(position == whitePawn[j].position && whitePawn[j].alive == true) return whitePawn[j];
        
       
        
        if(position == blackHorse1.position && blackHorse1.alive == true ) return blackHorse1;
        if(position == blackHorse2.position && blackHorse2.alive == true) return blackHorse2;
        if(position == blackQueen.position && blackQueen.alive == true ) return blackQueen;
        if(position == blackKing.position && blackKing.alive == true) return blackKing;
        if(position == blackCastle1.position && blackCastle1.alive == true ) return blackCastle1;
        if(position == blackCastle2.position && blackCastle2.alive == true) return blackCastle2;
        if(position == blackBishop1.position && blackBishop1.alive == true) return blackBishop1;
        if(position == blackBishop2.position && blackBishop2.alive == true) return blackBishop2;
        j=0;
        if(position == blackPawn[j].position && blackPawn[j].alive == true) return blackPawn[j];j++;
        if(position == blackPawn[j].position && blackPawn[j].alive == true) return blackPawn[j];j++;
        if(position == blackPawn[j].position && blackPawn[j].alive == true) return blackPawn[j];j++;
        if(position == blackPawn[j].position && blackPawn[j].alive == true) return blackPawn[j];j++;
        if(position == blackPawn[j].position && blackPawn[j].alive == true) return blackPawn[j];j++;
        if(position == blackPawn[j].position && blackPawn[j].alive == true) return blackPawn[j];j++;
        if(position == blackPawn[j].position && blackPawn[j].alive == true) return blackPawn[j];j++;
        if(position == blackPawn[j].position && blackPawn[j].alive == true) return blackPawn[j];

        else return null;
    } //getPiece ends

    
    public static int[] getPositions()
    {
        int[] x=new int[32];
        int i=8,j=0;
        x[0]=whiteCastle1.position;
        x[1]=whiteHorse1.position;
        x[2]=whiteBishop1.position;
        x[3]=whiteQueen.position;
        x[4]=whiteKing.position;
        x[5]=whiteBishop2.position;
        x[6]=whiteHorse2.position;
        x[7]=whiteCastle2.position;
        while((i<16)&&(j<8))
        {
            x[i]=whitePawn[j].position;
            i++;j++;
        }
        i=24;j=0;
        x[16]=blackCastle1.position;
        x[17]=blackHorse1.position;
        x[18]=blackBishop1.position;
        x[19]=blackQueen.position;
        x[20]=blackKing.position;
        x[21]=blackBishop2.position;
        x[22]=blackHorse2.position;
        x[23]=blackCastle2.position;
        while((i<32)&&(j<8))
        {
            //whitePawn[j] = new pawn();
            x[i]=blackPawn[j].position;
            i++;j++;
        }        
        return x;
    }//getPositions ends

    public static void setPositions(int[] x)
    {
        //System.out.println(x[0]);
        whiteCastle1.position=x[0];
        whiteHorse1.position=x[1];
        whiteBishop1.position=x[2];
        whiteQueen.position=x[3];
        whiteKing.position=x[4];
        whiteBishop2.position=x[5];
        whiteHorse2.position=x[6];
        whiteCastle2.position=x[7];
        int i=8,j=0;
        while((i<16)&&(j<8))
        {
            whitePawn[j] = new pawn();
            whitePawn[j].position=x[i];
            i++;j++;
        }
        
        blackCastle1.position=x[16];
        blackHorse1.position=x[17];
        blackBishop1.position=x[18];
        blackQueen.position=x[19];
        blackKing.position=x[20];
        blackBishop2.position=x[21];
        blackHorse2.position=x[22];
        blackCastle2.position=x[23];
        i=24;j=0;
        while((i<32)&&(j<8))
        {
            blackPawn[j] = new pawn();
            blackPawn[j].position=x[i];
            i++;j++;
        }        
    }
    
    
    
    
    public static boolean[] getLife()
    {
        boolean[] x=new boolean[32];
        int i=8,j=0;
        x[0]=whiteCastle1.alive;
        x[1]=whiteHorse1.alive;
        x[2]=whiteBishop1.alive;
        x[3]=whiteQueen.alive;
        x[4]=whiteKing.alive;
        x[5]=whiteBishop2.alive;
        x[6]=whiteHorse2.alive;
        x[7]=whiteCastle2.alive;
        while((i<16)&&(j<8))
        {
            x[i]=whitePawn[j].alive;
            i++;j++;
        }
        i=24;j=0;
        x[16]=blackCastle1.alive;
        x[17]=blackHorse1.alive;
        x[18]=blackBishop1.alive;
        x[19]=blackQueen.alive;
        x[20]=blackKing.alive;
        x[21]=blackBishop2.alive;
        x[22]=blackHorse2.alive;
        x[23]=blackCastle2.alive;
        while((i<32)&&(j<8))
        {
            x[i]=blackPawn[j].alive;
            i++;j++;
        }        
        return x;
    }    

    
    public static void setLife(boolean[] x)
    {
        int i=8,j=0;
        whiteCastle1.alive=x[0];
        whiteHorse1.alive=x[1];
        whiteBishop1.alive=x[2];
        whiteQueen.alive=x[3];
        whiteKing.alive=x[4];
        whiteBishop2.alive=x[5];
        whiteHorse2.alive=x[6];
        whiteCastle2.alive=x[7];
        while((i<16)&&(j<8))
        {
            
            whitePawn[j].alive=x[i];
            i++;j++;
        }
        
        blackCastle1.alive=x[16];
        blackHorse1.alive=x[17];
        blackBishop1.alive=x[18];
        blackQueen.alive=x[19];
        blackKing.alive=x[20];
        blackBishop2.alive=x[21];
        blackHorse2.alive=x[22];
        blackCastle2.alive=x[23];
        i=24;j=0;
        while((i<32)&&(j<8))
        {
            blackPawn[j].alive=x[i];
            i++;j++;
        }        
    }//setLife profile ends    
    
    

    public static void setTimes(int[] x)
    {
        int i=8,j=0;
        whiteCastle1.timesMoved=x[0];
        whiteHorse1.timesMoved=x[1];
        whiteBishop1.timesMoved=x[2];
        whiteQueen.timesMoved=x[3];
        whiteKing.timesMoved=x[4];
        whiteBishop2.timesMoved=x[5];
        whiteHorse2.timesMoved=x[6];
        whiteCastle2.timesMoved=x[7];
        while((i<16)&&(j<8))
        {
            
            whitePawn[j].timesMoved=x[i];
            i++;j++;
        }
        
        blackCastle1.timesMoved=x[16];
        blackHorse1.timesMoved=x[17];
        blackBishop1.timesMoved=x[18];
        blackQueen.timesMoved=x[19];
        blackKing.timesMoved=x[20];
        blackBishop2.timesMoved=x[21];
        blackHorse2.timesMoved=x[22];
        blackCastle2.timesMoved=x[23];
        i=24;j=0;
        while((i<32)&&(j<8))
        {
            blackPawn[j].timesMoved=x[i];
            i++;j++;
        }        
    }//setLife profile ends    


    public static int[] getTimes()
    {
        int[] x=new int[32];
        int i=8,j=0;
        x[0]=whiteCastle1.timesMoved;
        x[1]=whiteHorse1.timesMoved;
        x[2]=whiteBishop1.timesMoved;
        x[3]=whiteQueen.timesMoved;
        x[4]=whiteKing.timesMoved;
        x[5]=whiteBishop2.timesMoved;
        x[6]=whiteHorse2.timesMoved;
        x[7]=whiteCastle2.timesMoved;
        while((i<16)&&(j<8))
        {
            x[i]=whitePawn[j].timesMoved;
            i++;j++;System.out.println("white"+x[i]);
        }
        
        x[16]=blackCastle1.timesMoved;
        x[17]=blackHorse1.timesMoved;
        x[18]=blackBishop1.timesMoved;
        x[19]=blackQueen.timesMoved;
        x[20]=blackKing.timesMoved;
        x[21]=blackBishop2.timesMoved;
        x[22]=blackHorse2.timesMoved;
        x[23]=blackCastle2.timesMoved;
        i=24;j=0;
        while((i<32)&&(j<8))
        {
            x[i]=blackPawn[j].timesMoved;
            System.out.println("black"+i+":"+x[i]);
            i++;j++;
        }        
        return x;
    }    






}//endsclass 


