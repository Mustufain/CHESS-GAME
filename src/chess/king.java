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
public class king extends pieces{
    
    ArrayList<Integer> relativeWhiteMoves = new ArrayList<Integer>();
    ArrayList<Integer> relativeBlackMoves = new ArrayList<Integer>();
    int kingCalls = 0;
    void addRelativePositions(pieces chesspiece){
   
    //relativeIntPositions.clear();
    //relativeWhiteMoves.clear();
    //relativeBlackMoves.clear();
    //int kingpin;
   // kingpin = this.position;
    //this.position = 0;
    if(chesspiece.color == 1 && this.color == 0){ System.out.println("SO");chesspiece.movnum.clear(); chesspiece.mov.clear(); chesspiece.move(moves.createMoves(chesspiece.position));
    if (chesspiece.movnum.isEmpty() == true) System.out.println("Its Empty to begin with");
    for(int p : chesspiece.movnum){System.out.println("Move Pos:"+p);if(this.relativeBlackMoves.isEmpty() != true) System.out.println(p-position-1);
        relativeBlackMoves.add(p-position-1);}}
    
    else if(chesspiece.color == 0 && this.color == 1){chesspiece.movnum.clear(); chesspiece.mov.clear(); chesspiece.move(moves.createMoves(chesspiece.position));
    for(int p : chesspiece.movnum)
        relativeWhiteMoves.add(p-position-1);}
    
    //this.position = kingpin;
        //for( int p :)
       /* for(int p : Checkerboard.allWhitePositions){
            relativeIntPositions.add( p-position);
            relativeWhitePositions.add(p-position);}
           
        for(int p : Checkerboard.allBlackPositions){
            relativeIntPositions.add( p-position);
            relativeBlackPositions.add(p-position);}*/
    }
    
    void move(moves positionz){          // needs the coordinates in object moves... e.g : h.move(new moves(1,3));
            //this.addRelativePositions();
            if(kingCalls == 0){
            if(this.color == 1){if(this.relativeWhiteMoves.isEmpty() == true) System.out.println("DUM DUM");
            for(int p : this.relativeWhiteMoves) System.out.println("WhiteMoves:" + p);
            
            if (this.relativeWhiteMoves.contains(8) == false)
            mov.add(new moves(0,1));
            if (this.relativeWhiteMoves.contains(-8) == false)
            mov.add(new moves(0,-1));
            if (this.relativeWhiteMoves.contains(1) == false)
            mov.add(new moves(1,0));
            if (this.relativeWhiteMoves.contains(-1) == false)
            mov.add(new moves(-1,0));
            if (this.relativeWhiteMoves.contains(9) == false)
            mov.add(new moves(1,1));
            if (this.relativeWhiteMoves.contains(-9) == false)
            mov.add(new moves(-1,-1));
            if (this.relativeWhiteMoves.contains(-7) == false)
            mov.add(new moves(1,-1));
            if (this.relativeWhiteMoves.contains(7) == false)
            mov.add(new moves(-1,1));
            }
        
            if(this.color == 0){ if(this.relativeBlackMoves.isEmpty() == true) System.out.println("DUM DUM");
            for(int p : this.relativeBlackMoves) System.out.println("BlackMoves:" + p);
            if (this.relativeBlackMoves.contains(8) == false)
            mov.add(new moves(0,1));
            if (this.relativeBlackMoves.contains(-8) == false)
            mov.add(new moves(0,-1));
            if ( this.relativeBlackMoves.contains(1) == false)
            mov.add(new moves(1,0));
            if (this.relativeBlackMoves.contains(-1) == false)
            mov.add(new moves(-1,0));
            if (this.relativeBlackMoves.contains(9) == false)
            mov.add(new moves(1,1));
            if ( this.relativeBlackMoves.contains(-9) == false)
            mov.add(new moves(-1,-1));
            if ( this.relativeBlackMoves.contains(-7) == false)
            mov.add(new moves(1,-1));
            if (this.relativeBlackMoves.contains(7) == false)
            mov.add(new moves(-1,1));
            }
            }
            else if (kingCalls == 1) kingCalls = 0;
            
            
            
        super.move(positionz);
    }
    
}
