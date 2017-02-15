/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author Haider
 */
public class bishop extends pieces {
    void move(moves position){          // needs the coordinates in object moves... e.g : h.move(new moves(1,3));
            this.addRelativePositions();
            
            for (int x = 0 ; x < 1; x++){
            mov.add(new moves(1,1));    if(this.relativeIntPositions.contains(8+1) == true) break;
            mov.add(new moves(2,2));    if(this.relativeIntPositions.contains(8*2+2) == true) break;
            mov.add(new moves(3,3));    if(this.relativeIntPositions.contains(8*3+3) == true) break;
            mov.add(new moves(4,4));    if(this.relativeIntPositions.contains(8*4+4) == true) break;
            mov.add(new moves(5,5));    if(this.relativeIntPositions.contains(8*5+5) == true) break;
            mov.add(new moves(6,6));    if(this.relativeIntPositions.contains(8*6+6) == true) break;
            mov.add(new moves(7,7));    if(this.relativeIntPositions.contains(8*7+7) == true) break;
            mov.add(new moves(8,8));    if(this.relativeIntPositions.contains(8*8+8) == true) break;
            }
            
            for (int x = 0 ; x < 1; x++){
            mov.add(new moves(-1,-1));  if(this.relativeIntPositions.contains(8*-1-1) == true) break;
            mov.add(new moves(-2,-2));  if(this.relativeIntPositions.contains(8*-2-2) == true) break;
            mov.add(new moves(-3,-3));  if(this.relativeIntPositions.contains(8*-3-3) == true) break;
            mov.add(new moves(-4,-4));  if(this.relativeIntPositions.contains(8*-4-4) == true) break;
            mov.add(new moves(-5,-5));  if(this.relativeIntPositions.contains(8*-5-5) == true) break;
            mov.add(new moves(-6,-6));  if(this.relativeIntPositions.contains(8*-6-6) == true) break;
            mov.add(new moves(-7,-7));  if(this.relativeIntPositions.contains(8*-7-7) == true) break;
            mov.add(new moves(-8,-8));  if(this.relativeIntPositions.contains(8*-8-8) == true) break;
            }
            
            for (int x = 0 ; x < 1; x++){
            mov.add(new moves(1,-1));   if(this.relativeIntPositions.contains(8*-1+1) == true) break;
            mov.add(new moves(2,-2));   if(this.relativeIntPositions.contains(8*-2+2) == true) break;
            mov.add(new moves(3,-3));   if(this.relativeIntPositions.contains(8*-3+3) == true) break;
            mov.add(new moves(4,-4));   if(this.relativeIntPositions.contains(8*-4+4) == true) break;
            mov.add(new moves(5,-5));   if(this.relativeIntPositions.contains(8*-5+5) == true) break;
            mov.add(new moves(6,-6));   if(this.relativeIntPositions.contains(8*-6+6) == true) break;
            mov.add(new moves(7,-7));   if(this.relativeIntPositions.contains(8*-7+7) == true) break;
            mov.add(new moves(8,-8));   if(this.relativeIntPositions.contains(8*-8+8) == true) break;
            }
            
            for (int x = 0 ; x < 1; x++){
            mov.add(new moves(-1,1));   if(this.relativeIntPositions.contains(8-1) == true) break;
            mov.add(new moves(-2,2));   if(this.relativeIntPositions.contains(8*2-2) == true) break;
            mov.add(new moves(-3,3));   if(this.relativeIntPositions.contains(8*3-3) == true) break;
            mov.add(new moves(-4,4));   if(this.relativeIntPositions.contains(8*4-4) == true) break;
            mov.add(new moves(-5,5));   if(this.relativeIntPositions.contains(8*5-5) == true) break;
            mov.add(new moves(-6,6));   if(this.relativeIntPositions.contains(8*6-6) == true) break;
            mov.add(new moves(-7,7));   if(this.relativeIntPositions.contains(8*7-7) == true) break;
            mov.add(new moves(-8,8));   if(this.relativeIntPositions.contains(8*8-8) == true) break;
            }
            
        super.move(position);
    }
}
