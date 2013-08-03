/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
/**
 *
 * @author stanislav.kostomarov
 */
class Square {
    private int squareSize, x, y;
    
    private boolean isSet = false;
    private Color color;

    Square(int squareSize, int x, int y, Color color, boolean isSet){
        this.squareSize = squareSize;
        this.x = x;
        this.y = y;
        this.color = color;
        this.isSet = isSet;
        
        this.Draw();
    }
    
    public void ChangeIsSet(boolean isSet){
        if(this.isSet != isSet){
            this.isSet = isSet;
            Draw();
        }
    }
    
    public void ChangeSquare(boolean isSet, Color color){
        this.ChangeIsSet(isSet);
        this.color = color;
    }
    
    public boolean GetIsSet(){
        return isSet;
    }
    
    public Color GetColor(){
        return color;
    }
    
    public void Draw(){
        ;
    }
}
