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
public class Glass {
    final int xGlass                = 200;
    final int yGlass                = 200;
    final int squareSize            = 20;
    final int pixelsBetweenSqares   = 1;
    final int initialXInGlass       = 10;
    final int initialYInGlass       = 0;
    final int initialFigureColor    = 100;
    final int GLASS_HEIGHT          = 30;
    final int GLASS_WIDTH           = 20;
    final Color DEFAULT_COLOR       = Color.GRAY;
    
    private FigureInGlass mainFigure, additionalFigure, tempFigure;
    private Figure nextFigure;
    private Square squares[][];
    
    private boolean isGameActive    = false;
    
    Glass(){
        nextFigure = new Figure();
        mainFigure = new FigureInGlass(this, nextFigure);
        additionalFigure = new FigureInGlass(this, nextFigure);
        
        nextFigure.SetRandomFigure();
        
        squares = new Square[GLASS_HEIGHT][GLASS_WIDTH];
        for(int i = 0; i < GLASS_HEIGHT; ++i)
            for(int j = 0; j < GLASS_WIDTH; ++j){
                boolean isSet;
                if(j == 0 || j == GLASS_WIDTH - 1 || i == GLASS_HEIGHT - 1) isSet = true;
                else isSet = false;
                squares[i][j] = new Square(squareSize, CalculateSquareX(j), CalculateSquareY(i), DEFAULT_COLOR, isSet);
            }
    }

    public void StartGame(){
        
        this.isGameActive = true;
    }
    
    public boolean NextStep(){
        if(!this.isGameActive) return false;
        
        MoveFigureDown();
        
        return this.isGameActive;
    }
    
    private int CalculateSquareX(int xInGlass){
        return xInGlass * (squareSize + pixelsBetweenSqares);
    }
    
    private int CalculateSquareY(int yInGlass){
        return yInGlass * (squareSize + pixelsBetweenSqares);
    }

    public boolean MoveFigureRight(){
        additionalFigure.Copy(mainFigure);
        mainFigure.MoveRight();
        return TestFigure();
    }

    public boolean MoveFigureLeft(){
        additionalFigure.Copy(mainFigure);
        mainFigure.MoveLeft();
        return TestFigure();
    }

    public boolean MoveFigureDown(){
        additionalFigure.Copy(mainFigure);
        mainFigure.MoveDown();
        if(!TestFigure()) { FigureIsDropped(); return false;}
        
        return true;
    }

    public boolean RotateFigure(){
        additionalFigure.Copy(mainFigure);
        mainFigure.RotateFigure();
        return TestFigure();
    }

    private boolean TestFigure(){
        if(TestCanFigureBe(mainFigure)){
            additionalFigure.Erase();
            mainFigure.Draw();
            return true;
        }
        else {
            tempFigure = additionalFigure;
            additionalFigure = mainFigure;
            mainFigure = tempFigure;
            return false;
        }
    }

    private boolean TestCanFigureBe(FigureInGlass f) {
        boolean p[][] = f.GetCurentPrototype();
        for(int i = 0; i < f.HEIGHT_IN_SQUARES; ++i)
            for(int j = 0; j < f.WIDTH_IN_SQUARES; ++j)
                if(p[i][j] && squares[i + f.GetYInGlass()][j + f.GetXInGlass()].GetIsSet())
                    return false;
        return true;
    }
    
    private void FigureIsDropped(){
        WriteFigureInGlass(mainFigure);
        DeleteFullRows();
        mainFigure.NextFigure(nextFigure);
        mainFigure.Draw();
        
        nextFigure.Erase();
        nextFigure.SetRandomFigure();
        nextFigure.Draw();
        
        isGameActive = TestCanFigureBe(mainFigure);
    }
    
    private boolean IsRowFull(int row){
        for(int j = 1; j < this.GLASS_WIDTH - 1; ++j)
            if(!squares[row][j].GetIsSet()) return false;
        return true;
    }
    
    private void DeleteFullRows(){
        for(int i = 0; i < this.GLASS_HEIGHT - 1; ++i){
            if(IsRowFull(i)) DeleteFullRow(i);
        }
    }
    
    private void DeleteFullRow(int i){
        for(; i > 0; --i){
            for(int j = 1; j < this.GLASS_WIDTH - 1; ++j)
                this.squares[i][j].ChangeSquare(this.squares[i - 1][j].GetIsSet(), this.squares[i - 1][j].GetColor());
        }
        
        for(int j = 1; j < this.GLASS_WIDTH - 1; ++j)
            this.squares[0][j].ChangeSquare(false, DEFAULT_COLOR);
    }
    
    private void WriteFigureInGlass(FigureInGlass f){
       for(int i = 0; i < f.HEIGHT_IN_SQUARES; ++i)
           for(int j = 0; j < f.WIDTH_IN_SQUARES; ++j)
               if(f.GetCurentPrototype()[i][j]){
                   int x, y;
                   x = j + f.GetXInGlass();
                   y = i + f.GetYInGlass();
                   squares[y][x].ChangeSquare(true, f.GetColor());
               }
   }
}
