/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author stanislav.kostomarov
 */
public class NextFigure extends Figure{
    // Описание следующей фигуры
    private final int INITIAL_X_NEXT_FIGURE = 500;  // Начальный X следующей фигуры на экране
    private final int INITIAL_Y_NEXT_FIGURE = 500;  // Начальный Y следующей фигуры на экране

    NextFigure(){
        super();
        SetXY(INITIAL_X_NEXT_FIGURE, INITIAL_Y_NEXT_FIGURE);
    }
}
