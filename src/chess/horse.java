/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author Haider
 */
public class horse extends pieces {
    
    
    
    void move(moves position){          // needs the coordinates in object moves... e.g : h.move(new moves(1,3));
            mov.add(new moves(2,1));
            mov.add(new moves(2,-1));
            mov.add(new moves(-2,1));
            mov.add(new moves(-2,-1));
            mov.add(new moves(1,2));
            mov.add(new moves(1,-2));
            mov.add(new moves(-1,2));
            mov.add(new moves (-1,-2));
        
        super.move(position);
    }
}
