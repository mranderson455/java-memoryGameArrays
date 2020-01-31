package memory.game;
import java.util.Random;

public class MemoryGame {

    static final int gridSize = 4;
    static final Random myRandom = new Random();
    static char[] deck = {'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H'};
    static boolean[] cardDrawn = new boolean[16];
    static char[][] grid = new char[4][];
    
    public static void main(String[] args) {
        // Initialize vairables
        for (int i = 0; i < cardDrawn.length; i++) {
            cardDrawn[i] = false;
        }
        for (int i = 0; i < grid.length; i++) {
            grid[i] = new char[gridSize];
        }
        
        InitializeGrid();
        PrintGrid();
    }
    
    public static void InitializeGrid() {
        int randIndex;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                do {
                    randIndex = myRandom.nextInt(deck.length);
                } while (cardDrawn[randIndex] == true);
                
                cardDrawn[randIndex] = true;
                grid[i][j] = deck[randIndex];
            }
        }
    }
    
    public static void PrintGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j % 4 == 0) {
                    System.out.println();
                }
                System.out.print(grid[i][j] + ", ");
            }
        }
    }
}
