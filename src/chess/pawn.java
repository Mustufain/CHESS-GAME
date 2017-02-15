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
public class pawn extends pieces {
    
    ArrayList<Integer> relativeWhitePositions = new ArrayList<Integer>();
    ArrayList<Integer> relativeBlackPositions = new ArrayList<Integer>();
    int kingMove = 0 ;
    
    void addRelativePositions(){
   
    relativeIntPositions.clear();
    relativeWhitePositions.clear();
    relativeBlackPositions.clear();
    
        for(int p : Checkerboard.allWhitePositions)if(p < 64){
            relativeIntPositions.add( p-position);
            relativeWhitePositions.add(p-position);}
           
        for(int p : Checkerboard.allBlackPositions)if(p<64){
            relativeIntPositions.add( p-position);
            relativeBlackPositions.add(p-position);}
    }
    
    void move(moves positionz){          // needs the coordinates in object moves... e.g : h.move(new moves(1,3));
            this.addRelativePositions();
            
            
        if(color == 0 /*white*/ && kingMove == 0 ){        
        if(this.relativeIntPositions.contains(8) == false) {mov.add(new moves(0,1));
        if (timesMoved == 0 && this.relativeIntPositions.contains(16) == false)
        mov.add(new moves(0,2));}
        
        if(this.relativeBlackPositions.contains(9) == true) mov.add(new moves(1,1));
        if(this.relativeBlackPositions.contains(7) == true) mov.add(new moves(-1,1));
        
        }
        else if (color == 0 && kingMove == 1){
            mov.add(new moves(1,1));
            mov.add(new moves(-1,1));
            kingMove = 0;
        }
        //}
       
        
        if (color == 1/*Black*/ && kingMove == 0){
        if(this.relativeIntPositions.contains(-8) == false){ mov.add(new moves(0,-1));
        if(timesMoved == 0 && this.relativeIntPositions.contains(-16) == false)
        mov.add(new moves(0,-2));}
        
        if(this.relativeWhitePositions.contains(-9) == true) mov.add(new moves(-1,-1));
        if(this.relativeWhitePositions.contains(-7) == true) mov.add(new moves(1,-1));
        
        
        }
        else if (color == 1 && kingMove == 1){
            mov.add(new moves(-1,-1));
            mov.add(new moves(1,-1));
            kingMove = 0;
        }
        
        super.move(positionz);
    }
       
    
}
