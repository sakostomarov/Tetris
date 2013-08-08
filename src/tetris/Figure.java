/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.Random;

/**
 *
 * @author stanislav.kostomarov
 */
public class Figure implements Tetris{
    public final int HEIGHT_IN_SQUARES  = 4;    // Высота фигуры в квадратах
    public final int WIDTH_IN_SQUARES   = 4;    // Ширина фигуры в квадратах
    
    Random r;
    private int x, y;               // Абсолютные координаты фигуры

    protected int figureId;         // Идентификатор фигуры
    protected int rotate;           // Ориентация фигуры
    protected int color;            // Цвет фигуры
    
    final public boolean prototype[][][][] = {
        
        // Прямая
        {
        {{false, false, true , false},
         {false, false, true , false},
         {false, false, true , false},
         {false, false, true , false}},
        {{false, false, false, false},
         {true , true , true , true },
         {false, false, false, false},
         {false, false, false, false}},
        {{false, false, true , false},
         {false, false, true , false},
         {false, false, true , false},
         {false, false, true , false}},
        {{false, false, false, false},
         {true , true , true , true },
         {false, false, false, false},
         {false, false, false, false}}
        },

        // Обратная буква Г
        {
        {{false, true , false, false},
         {false, true , false, false},
         {false, true , true , false},
         {false, false, false, false}},
        {{false, true , true , true },
         {false, true , false, false},
         {false, false, false, false},
         {false, false, false, false}},
        {{false, false, true , true },
         {false, false, false, true },
         {false, false, false, true },
         {false, false, false, false}},
        {{false, false, false, false},
         {false, false, false, true },
         {false, true , true , true },
         {false, false, false, false}}
        },
        
        // Буква Г
        {
        {{false, true , true , false},
         {false, true , false, false},
         {false, true , false, false},
         {false, false, false, false}},
        {{false, true , true , true },
         {false, false, false, true },
         {false, false, false, false},
         {false, false, false, false}},
        {{false, false, false, true },
         {false, false, false, true },
         {false, false, true , true },
         {false, false, false, false}},
        {{false, false, false, false},
         {false, true , false, false},
         {false, true , true , true },
         {false, false, false, false}}
        },
        
        // Квадрат
        {
        {{false, false, false, false},
         {false, true , true , false},
         {false, true , true , false},
         {false, false, false, false}},
        {{false, false, false, false},
         {false, true , true , false},
         {false, true , true , false},
         {false, false, false, false}},
        {{false, false, false, false},
         {false, true , true , false},
         {false, true , true , false},
         {false, false, false, false}},
        {{false, false, false, false},
         {false, false, false, false},
         {false, false, false, false},
         {false, false, false, false}},
        },

        // Треножка
        {
        {{false, false, true , false},
         {false, true , true , true },
         {false, false, false, false},
         {false, false, false, false}},
        {{false, false, true , false},
         {false, false, true , true },
         {false, false, true , false},
         {false, false, false, false}},
        {{false, false, false, false},
         {false, true , true , true },
         {false, false, true , false},
         {false, false, false, false}},
        {{false, false, true , false},
         {false, true , true , false},
         {false, false, true , false},
         {false, false, false, false}}
        },

        // Загагулина как s
        {
        {{false, false, true , false},
         {false, false, true , true },
         {false, false, false, true },
         {false, false, false, false}},
        {{false, false, true , true },
         {false, true , true , false},
         {false, false, false, false},
         {false, false, false, false}},
        {{false, false, true , false},
         {false, false, true , true },
         {false, false, false, true },
         {false, false, false, false}},
        {{false, false, true , true },
         {false, true , true , false},
         {false, false, false, false},
         {false, false, false, false}}
        },

        // Загагулина как обратная s
        {
        {{false, false, false, true },
         {false, false, true , true },
         {false, false, true , false},
         {false, false, false, false}},
        {{false, true , true , false},
         {false, false, true , true },
         {false, false, false, false},
         {false, false, false, false}},
        {{false, false, false, true },
         {false, false, true , true },
         {false, false, true , false},
         {false, false, false, false}},
        {{false, true , true , false},
         {false, false, true , true },
         {false, false, false, false},
         {false, false, false, false}}
        }
    };

    Figure(){
        r = new Random();
        SetRandomFigure();
    }
    
    Figure(int x, int y){
        this();
        this.x      = x;
        this.y      = y;
    }
    
    protected void SetXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void SetRandomFigure(){
        figureId    = r.nextInt(prototype.length);
        rotate      = r.nextInt(prototype[0].length);
        color       = r.nextInt(COLORS.length-1) + 1;        
    }
    
    public void Copy(Figure f){
        this.figureId   = f.figureId;
        this.rotate     = f.rotate;
        this.color      = f.color;
    }
    
    public void Draw(){
        
    }
}
