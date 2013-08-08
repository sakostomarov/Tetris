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
public interface Tetris {
    // Описание стакана
    int GLASS_HEIGHT                = 30;   // Высота стакана
    int GLASS_WIDTH                 = 20;   // Ширина стакана
    int X_GLASS                     = 200;  // X стакана на экране
    int Y_GLASS                     = 200;  // Y стакана на экране

    // Описание квадратов
    int SQARE_SIZE                  = 20;   // Размер квадрата
    int PIXELS_BETWEEN_SQARES       = 1;    // Кол-во пикселей между квадратами
    
    int SCORE_X                     = 500;  // Координата X счета на экране
    int SCORE_Y                     = 400;  // Координата Y счета на экране
    
    // Описание цветов
    Color COLORS[] = {
        Color.BLACK,
        Color.GRAY,
        Color.BLUE,
        Color.CYAN,
        Color.GREEN,
        Color.PINK,
        Color.RED,
        Color.WHITE,
        Color.YELLOW
    };
    int DEFAULT_COLOR           = 2;    // Индекс цвета по умолчанию
}
