/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

public class FigureInGlass extends Figure {
    // Описание фигуры в стакане
    private final int INITIAL_X_FIGURE_IN_GLASS   = 10; // Начальный X фигуры в стакане
    private final int INITIAL_Y_FIGURE_IN_GLASS   = 0;  // Начальный Y фигуры в стакане
    
    private int xInGlass, yInGlass;                     // Координаты X и Y фигуры в стакане
    private Glass g;                                    // Ссылка на стакан
    
    FigureInGlass(Glass g) {
        super();
        this.g = g;
        SetInitialXY();
    }
    
    private void SetInitialXY(){
        xInGlass = INITIAL_X_FIGURE_IN_GLASS;
        yInGlass = INITIAL_Y_FIGURE_IN_GLASS;
        
        SetXY();
    }

    private void SetXY(){
        int x = X_GLASS + (SQARE_SIZE + PIXELS_BETWEEN_SQARES) * xInGlass;
        int y = Y_GLASS + (SQARE_SIZE + PIXELS_BETWEEN_SQARES) * yInGlass;
        super.SetXY(x, y);
    }

    public void NextFigure(Figure f){
        super.Copy(f);
        SetInitialXY();
    }
    
    private boolean CanBe(int x, int y, int r){
        for(int i = 0; i < HEIGHT_IN_SQUARES; ++i)
            for(int j = 0; j < WIDTH_IN_SQUARES; ++j)
                if(prototype[figureId][r][i][j] && g.IsSquareSet(i + yInGlass, j + xInGlass))
                    return false;
        return true;
    }
    
    public boolean MoveRight(){
        if(CanBe(xInGlass + 1, yInGlass, rotate)){
            xInGlass++;
            SetXY();
            return true;
        }
        else return false;
    }
    
    public boolean MoveLeft(){
        if(CanBe(xInGlass - 1, yInGlass, rotate)){
            xInGlass--;
            SetXY();
            return true;
        }
        else return false;
    }
    
    public boolean MoveDown(){
        if(CanBe(xInGlass, yInGlass + 1, rotate)){
            yInGlass++;
            SetXY();
            return true;
        }
        else return false;
    }
    
    public boolean RotateFigure(){
        int r = (rotate + 1) % 4;
        if(CanBe(xInGlass, yInGlass, r)){
            rotate = r;
            SetXY();
            return true;
        }
        else return false;
    }
    
    public void WriteFigureInGlass(){
        for(int i = 0; i < HEIGHT_IN_SQUARES; ++i)
            for(int j = 0; j < WIDTH_IN_SQUARES; ++j)
                if(prototype[figureId][rotate][i][j])
                    g.SetSqare(i + yInGlass, j + xInGlass, color);
    }
}
