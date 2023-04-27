package pt.isec.pa.tinypac;

import pt.isec.pa.tinypac.gameengine.*;
import pt.isec.pa.tinypac.model.data.*;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TerminalSize;

import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;

class TestClient implements IGameEngineEvolve {
    int count = 0;
    @Override
    public void evolve(IGameEngine gameEngine, long currentTime) {
        System.out.printf("[%d] %d\n",currentTime,++count);
        if (count >= 20) gameEngine.stop();
    }
}

public class TinyPAcMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        InputStream input = TinyPAcMain.class.getClassLoader().getResourceAsStream("files/Level01.txt");
        Scanner scanner = new Scanner(input);

        int heigth = 31;
        int width = 29;

        // Criando o labirinto
        Maze maze = new Maze(heigth, width);
        for (int y = 0; y < heigth; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                char c = line.charAt(x);
                if (c == 'x') {
                    maze.set(y, x, new Wall());
                } else if (c == 'o') {
                    maze.set(y, x, new PacDot());
                } else if (c == 'O') {
                    maze.set(y, x, new PacPill());
                } else if (c == 'M') {
                    maze.set(y, x, new Pacman());
                }
            }
        }

        // Configurando a janela
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(88,50));
        Terminal terminal = defaultTerminalFactory.createTerminal();;

        // Exibindo o labirinto na janela
        char[][] mazeChars = maze.getMaze();
        for (int y = 0; y < heigth; y++) {
            for (int x = 0; x < width; x++) {
                terminal.putCharacter(mazeChars[y][x]);
            }
            terminal.putCharacter('\n');
        }

        Thread.sleep(5000);
        terminal.close();
    }
}