/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;

/**
 *
 * @author Haider
 */
public abstract class pieces {
    ArrayList<moves> mov = new ArrayList<moves>();
    ArrayList<Integer> movnum= new ArrayList<Integer>();
   
    ArrayList<Integer> relativeIntPositions = new ArrayList<Integer>();
    int timesMoved;
    int color;
    int position;
    boolean select;
    boolean alive = true;
    
    
   void addRelativePositions(){
  // if(alive == true){
    relativeIntPositions.clear();
        for(int p : Checkerboard.allWhitePositions){
            relativeIntPositions.add( p-position);}
           
        for(int p : Checkerboard.allBlackPositions)
            relativeIntPositions.add( p-position);
           
    }//}
    
   
    void move(moves position){
        
     moves ans ;
    for( moves alpha : mov){
        ans   =  moves.addmoves(position, alpha);
        if(ans.posx>0 && ans.posx <= 8 && ans.posy >0 && ans.posy<=8)
        {
       // moves.printmoves(ans);
        movnum.add(moves.sumMoves(ans)-8);
        }
    }}
    
    };
    

