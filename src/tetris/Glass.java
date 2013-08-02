/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author stanislav.kostomarov
 */
public class Glass {
    final int xGlass                = 200;
    final int yGlass                = 200;
    final int sqareSize             = 20;
    final int pixelsBetweenSqares   = 1;
    final int initialXInGlass       = 10;
    final int initialYInGlass       = 0;
    final int initialFigureColor    = 100;
    
    private FigureInGlass mainFigure, testFigure, tempFigure;
    
    Glass(){
        mainFigure = new FigureInGlass(xGlass, yGlass, sqareSize, pixelsBetweenSqares, initialXInGlass, initialYInGlass, initialFigureColor);
        testFigure = new FigureInGlass(xGlass, yGlass, sqareSize, pixelsBetweenSqares);
    }

    public boolean MoveFigureRight(){
        f1.MoveRight();
        return TestFigure();
    }

    public boolean MoveFigureLeft(){
        f1.MoveLeft();
        return TestFigure();
    }

    public boolean MoveFigureDown(){
        f1.MoveDown();
        return TestFigure();
    }

    public boolean RotateFigure(){
        f1.RotateFigure();
        return TestFigure();
    }

    private boolean TestFigure(){
        if(TestCanFigureBe(f1)){
            f1.ReDrawFigure();
            return true;
        }
        else {
            f1.RollBackFigure();
            return false;
        }
    }

    private boolean TestCanFigureBe(FigureInGlass f1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
