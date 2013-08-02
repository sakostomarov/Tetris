/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author stanislav.kostomarov
 */
class Square {
    private int squareSize, x, y;
    
    private boolean isSet = false;
    private int color = 0;

    Square(int squareSize, int x, int y){
        this.squareSize = squareSize;
        this.x = x;
        this.y = y;
    }
    
    Square(int squareSize, int x, int y, int color, boolean isSet){
        this(squareSize, x, y);
        this.color = color;
        this.isSet = isSet;
    }
    
    public void Erase(){
        ;
    }
    public void Draw(){
        ;
    }
}
