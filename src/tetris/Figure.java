/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author stanislav.kostomarov
 */
public class Figure {
    final int HEIGHT_IN_SQUARES = 4;// Высота фигуры в квадратах
    final int WIDTH_IN_SQUARES = 4; // Ширина фигуры в квадратах
    
    private int x = 0, y = 0;       // Абсолютные координаты фигуры
    private int color = 0;          // Цвет фигуры

    protected boolean f[][];        // Основное описание фигуры
    
    Figure(){
        this.f = new boolean[HEIGHT_IN_SQUARES][WIDTH_IN_SQUARES];
    }
    
    Figure(int x, int y, int color){
        this();
        this.x          = x;
        this.y          = y;
        this.color      = color;
    }
    
    protected void SetXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    protected void SetColor(int color){
        this.color = color;
    }
    
    public void Copy(Figure f){
        this.x          = f.x;
        this.y          = f.y;
        this.color      = f.color;
        
        for(int i = 0; i < HEIGHT_IN_SQUARES; ++i)
            for(int j = 0; j < WIDTH_IN_SQUARES; ++j)
                this.f[i][j] = f.f[i][j];
    }
}
