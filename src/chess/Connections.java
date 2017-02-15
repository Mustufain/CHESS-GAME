/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Usama Mukhtar
 */

public class Connections 
{
    public static Connection Connect() throws ClassNotFoundException
    {
       Connection conn=null;
       try
       {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//loading the driver
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\localhost(sa):1433;databaseName=CHESS","sa","123");
        System.out.println("Connected database successfully...");        
       }catch(SQLException s)
       {System.out.println(s);}
       finally
       {
           return conn;
       }
    }

    
    public static int InsertPieces(Connection c,int ID,boolean Life,int pos,int Times, String GameName) throws SQLException//for one piece
    {
        Statement s1=c.createStatement();
        int x=s1.executeUpdate("Insert into Pieces(PieceID,isAlive,Position,TimesMoved,GameName)" +"Values("+ID+",'"+Life+"','"+pos+"','"+Times+"','"+GameName+"')");
        return x;
    }
    
    public static ResultSet AccessPieces(Connection c, String GameName) throws SQLException
    {
        Statement s=c.createStatement();
        ResultSet r=s.executeQuery("Select * from Pieces"+" where GameName='"+GameName+"'");
        return r;
    }
    //not used
    public static void DeletePieces(Connection c, int GameName) throws SQLException
    {
        Statement s=c.createStatement();
        s.executeQuery("Select * from Pieces"+" where GameName='"+GameName+"'");
        //return r;
    }
    public static void SavePieces(Connection con, int[] PieceIDs,String GameName)//used for one game,32 pieces
    {
        int i=0;int r;
        while(i<32)
        {
           try
           {
               r=Connections.InsertPieces(con,PieceIDs[i]+1 , CHESS.life[i], CHESS.positions[i], CHESS.TimesMoved[i] ,GameName);
               System.out.println(r+" line entered");

              // r1=r+1;
           }
           catch (SQLException ex) 
           {
               Logger.getLogger(CHESS.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("phns gye boss:"+ex);
           }
           i++;
       }
       System.out.println("LinesEntered:"+i );     
    }
    
    
    
    
    //Game Functions
    public static boolean InsertUsers(Connection c,String Name) throws SQLException
    {
        int x;boolean b=true;int i=0;
        Statement s=c.createStatement();
        x=s.executeUpdate("Insert into Users(UserID, Name)"+"Values("+i+",'"+Name+"')");
        if(x==1)
        return b;
        else
        return !b;
    }
    public static ResultSet AccessUsers(Connection c,String UserName) throws SQLException
    {
        Statement s=c.createStatement();
        ResultSet r=s.executeQuery("Select * from Pieces"+" where Name='"+UserName+"'");
        return r;
    }
    public static boolean SearchUsers(Connection con,String UserName)
    {
        boolean b=true;Statement s1;String temp;
        try {
                s1 = con.createStatement();
                ResultSet rs1=s1.executeQuery("select Name from Users");
            while(rs1.next())
            {
                
                temp=rs1.getString("Name");
                System.out.println("comparing "+temp+" with "+UserName);
                if(temp.equals(UserName))
                {
                    System.out.println("User Mil Gya: "+temp);
                    b=false;break;
                }
                //if((!(rs1.next()))&&(b))
                //{
                  //  System.out.println("o pehle save to kr is user ko mamu..!");
                //}
            }
                        
            } catch (SQLException ex) {
                Logger.getLogger(CHESS.class.getName()).log(Level.SEVERE, null, ex);
       }    
    
    return !b;
    
    }

    
    
    
    public static int InsertGames(Connection c,String GameName,boolean WhiteToPlay,String Player1,String Player2) throws SQLException
    {
        int x;int i=0;
        Statement s=c.createStatement();
        x=s.executeUpdate("Insert into Games(GameID, GameName,WhiteToPlay,Player1Name,Player2Name)"+"Values("+i+",'"+GameName+"','"+WhiteToPlay+"','"+Player1+"','"+Player2+"')");
        return x;
    }
    public static ResultSet AccessGame(Connection c,String GameName) throws SQLException
    {
        Statement s=c.createStatement();
        ResultSet r=s.executeQuery("Select * from Games"+" where GameName='"+GameName+"'");
        return r;
    }
 /*   public static void UpdateGame(Connection c,boolean whiteToPlay,int GameID) throws SQLException
    {
        //boolean b=false;
        Statement s=c.createStatement();
        s.execute("update Games SET WhiteToPlay= "+whiteToPlay+"where GameID="+GameID);
        //ResultSet r=s.executeQuery("Select * from Games"+" where GameID='"+GameID+"'");
        //return b;
    }    */
    
    
    public static boolean searchGame(Connection con,String GameName)
    {
        boolean b=true;Statement s1;String temp;
        try {
                s1 = con.createStatement();
                ResultSet rs1=s1.executeQuery("select GameName from Games");
            while((rs1.next())&&(b))
            {
                temp=rs1.getString("GameName");
                System.out.println("comparing "+temp+" with "+GameName);
                if(temp.equals(GameName))
                {
                    System.out.println("game mil gae records me..");
                    b=false;//break;
                }
            }
                        
            } catch (SQLException ex) 
            {
                Logger.getLogger(CHESS.class.getName()).log(Level.SEVERE, null, ex);
            }    
    
    return !b;
    }
    
    /*public static boolean LoadGame(Connection con,int ID)
    {
        Statement s1=con.createStatement("select * from Games");
    }*/
    
    
    public static boolean saveGame(Connection con)
    {
        boolean b,tempToPlay,b1,b2;
        String s,tempName="noValue";
        int temp,temp1,temp2;
        temp1=-1;temp2=-1;
        int num;
        
        int i=0;
        CHESS.positions=Checkerboard.getPositions();
        CHESS.life=Checkerboard.getLife();
        CHESS.TimesMoved=Checkerboard.getTimes();//method to be defined
                //Giving Names and ID's
        //String[] PieceNames=new String[32];
        int[] PieceIDs=new int[32];
        //int[] colors=new int[32];        
        
        
        
            temp=-1;b=false;boolean x1=false;
            while(!b)//b=>true only when a new game has been saved
            {
                //while(!x1)
                //{
                    tempName=JOptionPane.showInputDialog("Enter a Game Name:");
                    //temp=Integer.parseInt(s);
                    x1=Connections.searchGame(con, tempName);//returns boolean
                    if(x1)//if found then ask again
                    {   
                        x1=false;
                        JOptionPane.showMessageDialog(new JLabel("not saved"),"Pehle Wali Game apke abba g k liye bnai hai kya jo overwrite kr dun?");
                    }
                    else
                        x1=true;
                //}
                //tempName=JOptionPane.showInputDialog("Enter GameName:");
                tempToPlay=Checkerboard.whiteToPlay;
                //x1=false;
               // while(!x1)
                //{
                    //s=JOptionPane.showInputDialog("Enter Player1ID:");
                    //temp1=Integer.parseInt(s);
                    //temp1=Integer.parseInt(CHESS.name1);
                    //b1=Connections.SearchUsers(con, CHESS.name1);//true when found
                    //if(!x1)//opens dialog box when not found
                    //{
                    //    JOptionPane.showMessageDialog(new JLabel("kk"),"User1 Does Not Exist,Mje ilhaam nae hota wrna bna dyta");  
                  //  }
                //    else x1=true;
               // }
                //x1=false;
                //while(!x1)
                //{                
                    //s=JOptionPane.showInputDialog("Enter Player2ID:");
                    //temp2=Integer.parseInt(s);
                    //b2=Connections.SearchUsers(con, CHESS.name2);//.true when found
                  //  if(x1==false)
                    //    JOptionPane.showMessageDialog(new JLabel("kk"),"User2 Does Not Exist,Mje ilhaam nae hota wrna bna dyta");
                    //else x1=true;
                //}
                while( i<CHESS.positions.length)
                {
                    System.out.println(CHESS.positions[i]);
                    i++;
                }
                CHESS.life=Checkerboard.getLife();
                
                i=0;
                while( i<CHESS.life.length)
                {
                    System.out.println(CHESS.life[i]);
                    i++;
                }i=0;
                while( i<CHESS.TimesMoved.length)
                {
                    System.out.println(CHESS.TimesMoved[i]);
                    i++;
                }                
                
                try 
                {
                     Connections.InsertGames(con ,tempName,tempToPlay ,  CHESS.name1,  CHESS.name2);
                     for(int ct=0;ct<32;ct++)
                        {
                           // if(ct<16)
                            //   colors[ct]=0;
                            //else
                              //  colors[ct]=1;
                            PieceIDs[ct]=ct;
                            //PieceNames[ct]="Piece"+ct;
                            System.out.println(PieceIDs[ct]);
                        } 
                       
                    }
                catch (SQLException ex)
                {
                        Logger.getLogger(CHESS.class.getName()).log(Level.SEVERE, null, ex);
                }
                   // Connections.InsertPieces(con, temp, s, temp, b, temp, saveGameID);
                    b=true;
                    if(x1)
                    JOptionPane.showMessageDialog(new JLabel("saved"),"Saved Game Successfully BOSS...!");//pieces abhi krne hen is game k
                
                    else
                        JOptionPane.showMessageDialog(new JLabel("saved"),"Game Not Saved BOSS...!");
            }
                                // int r1=0;i=0;int r;
                    System.out.println("before saving pieces");             
                    Connections.SavePieces(con, PieceIDs, tempName);             
                    System.out.println("after saving pieces");
                    return b;
    }
    
    //NOT USED
    
    public static boolean LoadGame()
    {
           boolean b=true;ResultSet rs1;String s;int i;
           String tempName;
           boolean tempToPlay;
           // while(!b)
            //{
            s=JOptionPane.showInputDialog(null, "Select Your Game Name:");
            //temp=Integer.parseInt(s);
            b=Connections.searchGame(CHESS.con, s);
            if(!b)
            {
                JOptionPane.showMessageDialog(null,"Enter a Valid Game Name To Load it");
            }
            else
            {
                    try
                    {
                        rs1=Connections.AccessGame(CHESS.con, s);i=0;Statement s2;ResultSet rs2;
                        while(i<1)        
                        {
                            while(rs1.next())
                            {
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
                                CHESS.positions[j]=rs2.getInt("Position");
                                CHESS.life[j]=rs2.getBoolean("isAlive");
                                CHESS.TimesMoved[j]=rs2.getInt("timesMoved");
                                    //if(j<16)
                                      //  colors[j]=0;
                                    //else
                                      //  colors[j]=1;
                                    j++;

                                }

                            Checkerboard.setPositions(CHESS.positions);
                            Checkerboard.setLife(CHESS.life);
                            Checkerboard.setTimes(CHESS.TimesMoved);//to be defined
                            Checkerboard.Loadsetup(CHESS.positions, CHESS.life, CHESS.TimesMoved, tempToPlay);
                            i++;
                            }
                        }//1st while end
                        b=true;
                                    //P.remove(B1);
            CHESS.MainWindow.getContentPane().remove(CHESS.Panel2);    
            CHESS.MainWindow.add(CHESS.Panel3);
            //MainWindow.repaint();
            CHESS.MainWindow.invalidate();
            CHESS.MainWindow.validate();
            CHESS.Panel3.setVisible(true);
            
                    } 
                    catch (SQLException ex)
                    {
                        b=false;
                        Logger.getLogger(CHESS.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
            return b;
            }   
    }
    


