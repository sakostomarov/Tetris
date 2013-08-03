/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author stanislav.kostomarov
 */
public class TetrisGame {
    AppletGame appletGame = new AppletGame();
    Glass g;

    TetrisGame() {
        new JFrame();

        this.g = new Glass();
    }
    
    public void PlayGame(){
        g.StartGame();
        for(;;){
            if(!g.NextStep()) return;
            //Sleep(1000);
        }
    }

    private static class JFrame {

        public JFrame() {
        }
    }
}
