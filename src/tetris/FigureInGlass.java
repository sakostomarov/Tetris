/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

public class FigureInGlass extends Figure {
    private final int initialXInGlass = 10;
    private final int initialYInGlass = 0;
    
    private int xInGlass, yInGlass; // Координаты X и Y фигуры в стакане
    private Glass g;

    FigureInGlass(Glass g, Figure f) {
        super(f);
        this.g = g;

        xInGlass = initialXInGlass;
        yInGlass = initialYInGlass;
        
        SetXY();
    }
    
    public void NextFigure(Figure f){
        super.Copy(f);
        this.xInGlass       = initialXInGlass;
        this.yInGlass       = initialYInGlass;
        SetXY();
    }
    
    public void FigureCopy(FigureInGlass f){
        super.Copy(f);
        this.xInGlass       = f.xInGlass;
        this.yInGlass       = f.yInGlass;
        SetXY();
    }
    
    private void SetXY(){
        int x = g.xGlass + (g.squareSize + g.pixelsBetweenSqares) * xInGlass;
        int y = g.yGlass + (g.squareSize + g.pixelsBetweenSqares) * yInGlass;
        super.SetXY(x, y);
    }
    
    public int GetXInGlass(){
        return xInGlass;
    }

    public int GetYInGlass(){
        return yInGlass;
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
    
    public void RotateFigure(){
        SetRotate((GetRotate() + 1)%4);
    }
    
    public void Erase(){
        // todo
        super.Erase();
    }
    
    public void Draw(){
        // todo
        super.Draw();
    }
}
