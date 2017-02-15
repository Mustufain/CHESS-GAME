/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author Haider
 */
public class moves {
    int posx;
    int posy;
    
    moves(int x , int y){
        posx = x; posy= y;
    }
    
   static moves addmoves( moves a , moves b){
       int x , y ;
       x = a.posx + b.posx;
       y = a.posy + b.posy;
       return new moves(x, y);
    };
   
   static moves subtractmoves( moves a , moves b){
       int x , y ;
       x = a.posx - b.posx;
       y = a.posy - b.posy;
       return new moves(x, y);
    };
   
    
   static void printmoves(moves a){
       System.out.println(a.posx + " , " + a.posy);
       
   }
   static int sumMoves(moves a)
   {
       int x,y;
       x=a.posx;
       y=a.posy;
       return x+8*y;
   }
   
   static moves createMoves( int position){
       
       int x;int y;
        if((position+1)%8 == 0 && position > 0) {x = 8; y = (position+8)/8;}
        else if((position+1)%8 == 0 && position < 0) {x = -8; y = (position+8)/8;}
        else{ x = (position+1)%8;
        y = (position+9)/8;}
        return new moves(x,y);
        
        }
}
