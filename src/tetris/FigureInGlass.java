/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

public class FigureInGlass extends Figure {
    private int squareSize, pixelsBetweenSqares;

    private int xGlass;
    private int yGlass;
    private int xInGlass = 0, yInGlass = 0; // Координаты X и Y фигуры в стакане

    FigureInGlass(int xGlass, int yGlass, int squareSize, int pixelsBetweenSqares, int xInGlass, int yInGlass, int color){
        this(xGlass, yGlass, squareSize, pixelsBetweenSqares);
        this.xInGlass               = xInGlass;
        this.yInGlass               = yInGlass;
        SetColor(color);
        SetXY();
    }

    FigureInGlass(int xGlass, int yGlass, int squareSize, int pixelsBetweenSqares) {
        super();
        this.xGlass                 = xGlass;
        this.yGlass                 = yGlass;
        this.squareSize             = squareSize;
        this.pixelsBetweenSqares    = pixelsBetweenSqares;
    }
    
    public void FigureCopy(FigureInGlass f){
        this.xGlass         = f.xGlass;
        this.yInGlass       = f.yInGlass;
        super.Copy(f);
    }
    
    private void SetXY(){
        int x = xGlass + (squareSize + pixelsBetweenSqares) * xInGlass;
        int y = yGlass + (squareSize + pixelsBetweenSqares) * yInGlass;
        super.SetXY(x, y);
    }
    
    public void MoveRight(){
        xInGlass++;
        SetXY();
    }
    
    public void MoveLeft(){
        xInGlass--;
        SetXY();
    }
    
    public void MoveDown(){
        yInGlass++;
        SetXY();
    }
}
