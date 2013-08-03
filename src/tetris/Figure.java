/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.Random;
import java.awt.Color;

/**
 *
 * @author stanislav.kostomarov
 */
public class Figure {
    public final int HEIGHT_IN_SQUARES = 4;// Высота фигуры в квадратах
    public final int WIDTH_IN_SQUARES = 4; // Ширина фигуры в квадратах
    
    private final int initialX = 500;
    private final int initialY = 400;
    
    Random r;
    
    private int x, y;               // Абсолютные координаты фигуры

    private int figureId;           // Идентификатор фигуры
    private int rotate;             // Ориентация фигуры
    private int color;
    
    final protected Color colors[] = {
        Color.BLUE,
        Color.CYAN,
        Color.GRAY,
        Color.GREEN,
        Color.PINK,
        Color.RED,
        Color.WHITE,
        Color.YELLOW
    };
    
    final public boolean prototype[][][][] = {
        
        // Прямая
        {{{false},{false},{true},{false}},
         {{false},{false},{true},{false}},
         {{false},{false},{true},{false}},
         {{false},{false},{true},{false}}},
        {{{false},{false},{false},{false}},
         {{true },{true },{true },{true }},
         {{false},{false},{false},{false}},
         {{false},{false},{false},{false}}},
        {{{false},{false},{true },{false}},
         {{false},{false},{true },{false}},
         {{false},{false},{true },{false}},
         {{false},{false},{true },{false}}},
        {{{false},{false},{false},{false}},
         {{true },{true },{true },{true }},
         {{false},{false},{false},{false}},
         {{false},{false},{false},{false}}},

        // Обратная буква Г
        {{{false},{true },{false},{false}},
         {{false},{true },{false},{false}},
         {{false},{true },{true },{false}},
         {{false},{false},{false},{false}}},
        {{{false},{true },{true },{true }},
         {{false},{true },{false},{false}},
         {{false},{false},{false},{false}},
         {{false},{false},{false},{false}}},
        {{{false},{false},{true },{true }},
         {{false},{false},{false},{true }},
         {{false},{false},{false},{true }},
         {{false},{false},{false},{false}}},
        {{{false},{false},{false},{false}},
         {{false},{false},{false},{true }},
         {{false},{true },{true },{true }},
         {{false},{false},{false},{false}}},
        
        // Буква Г
        {{{false},{true },{true },{false}},
         {{false},{true },{false},{false}},
         {{false},{true },{false},{false}},
         {{false},{false},{false},{false}}},
        {{{false},{true },{true },{true }},
         {{false},{false},{false},{true }},
         {{false},{false},{false},{false}},
         {{false},{false},{false},{false}}},
        {{{false},{false},{false},{true }},
         {{false},{false},{false},{true }},
         {{false},{false},{true },{true }},
         {{false},{false},{false},{false}}},
        {{{false},{false},{false},{false}},
         {{false},{true },{false},{false}},
         {{false},{true },{true },{true }},
         {{false},{false},{false},{false}}},
        
        // Квадрат
        {{{false},{false},{false},{false}},
         {{false},{true },{true },{false}},
         {{false},{true },{true },{false}},
         {{false},{false},{false},{false}}},
        {{{false},{false},{false},{false}},
         {{false},{true },{true },{false}},
         {{false},{true },{true },{false}},
         {{false},{false},{false},{false}}},
        {{{false},{false},{false},{false}},
         {{false},{true },{true },{false}},
         {{false},{true },{true },{false}},
         {{false},{false},{false},{false}}},
        {{{false},{false},{false},{false}},
         {{false},{false},{false},{false}},
         {{false},{false},{false},{false}},
         {{false},{false},{false},{false}}},

        // Треножка
        {{{false},{false},{true },{false}},
         {{false},{true },{true },{true }},
         {{false},{false},{false},{false}},
         {{false},{false},{false},{false}}},
        {{{false},{false},{true },{false}},
         {{false},{false},{true },{true }},
         {{false},{false},{true },{false}},
         {{false},{false},{false},{false}}},
        {{{false},{false},{false},{false}},
         {{false},{true },{true },{true }},
         {{false},{false},{true },{false}},
         {{false},{false},{false},{false}}},
        {{{false},{false},{true },{false}},
         {{false},{true },{true },{false}},
         {{false},{false},{true },{false}},
         {{false},{false},{false},{false}}},

        // Загагулина как s
        {{{false},{false},{true },{false}},
         {{false},{false},{true },{true }},
         {{false},{false},{false},{true }},
         {{false},{false},{false},{false}}},
        {{{false},{false},{true },{true }},
         {{false},{true },{true },{false}},
         {{false},{false},{false},{false}},
         {{false},{false},{false},{false}}},
        {{{false},{false},{true },{false}},
         {{false},{false},{true },{true }},
         {{false},{false},{false},{true }},
         {{false},{false},{false},{false}}},
        {{{false},{false},{true },{true }},
         {{false},{true },{true },{false}},
         {{false},{false},{false},{false}},
         {{false},{false},{false},{false}}},

        // Загагулина как обратная s
        {{{false},{false},{false},{true }},
         {{false},{false},{true },{true }},
         {{false},{false},{true },{false}},
         {{false},{false},{false},{false}}},
        {{{false},{true },{true },{false}},
         {{false},{false},{true },{true }},
         {{false},{false},{false},{false}},
         {{false},{false},{false},{false}}},
        {{{false},{false},{false},{true }},
         {{false},{false},{true },{true }},
         {{false},{false},{true },{false}},
         {{false},{false},{false},{false}}},
        {{{false},{true },{true },{false}},
         {{false},{false},{true },{true }},
         {{false},{false},{false},{false}},
         {{false},{false},{false},{false}}}
        };

    Figure(){
        r           = new Random();
        SetRandomFigure();
        x           = initialX;
        y           = initialY;
    }
    
    Figure(Figure f){
        r = new Random();
        this.Copy(f);
    }
    
    public void SetRandomFigure(){
        figureId    = r.nextInt(prototype.length);
        rotate      = r.nextInt(prototype[0].length);
        color       = r.nextInt(colors.length);        
    }
    
    protected void SetXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public boolean[][] GetCurentPrototype(){
        return prototype[figureId][rotate];
    }
    
    public void Copy(Figure f){
        this.figureId   = f.figureId;
        this.rotate     = f.rotate;
        this.color      = f.color;
        
        //this.x          = f.x;
        //this.y          = f.y;
    }
    
    public int GetFigureId(){
        return figureId;
    }
    
    public int GetRotate(){
        return rotate;
    }
    
    public Color GetColor(){
        return colors[color];
    }
    
    public void SetRotate(int rotate){
        this.rotate = rotate;
    }
    
    public void Erase(){
        
    }
    
    public void Draw(){
        
    }
}
