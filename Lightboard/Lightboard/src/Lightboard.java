import java.io.IOException;
import java.util.Arrays;

// Board object that has a bunch of lights (signified by booleans) and can modify them at well using JOptionPanes
public class Lightboard {

    private boolean[][] board;
    
    // Generates a random 10x10 lightboard with a 40% chance of each light being done
    public Lightboard() {
        board = generate(10, 10, 40);
    }
    
    public boolean[][] getBoard() { return board; }

    // Changes a light at a certain position to a certain state
    public void setLight(int row, int col, boolean isOn) throws IOException {
        try {
            board[row][col] = isOn;
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    // Toggles a light at a certain position
    public void toggleLight(int row, int col) throws IOException {
        try {
            board[row][col] = !board[row][col];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    // Sets a row of lights to a certain state
    public void setRow(int row, boolean isOn) throws IOException {
        try {
            Arrays.fill(board[row], isOn);
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    // Toggles a certain row
    public void toggleRow(int row) throws IOException {
        try {
            for(int c = 0; c < board[row].length; c++) board[row][c] = !board[row][c];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    // Sets a certain column to a certain state
    public void setCol(int col, boolean isOn) throws IOException {
        try {
            for(int r = 0; r < board.length; r++) board[r][col] = isOn;
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    // Toggles a column
    public void toggleCol(int col) throws IOExeption {
        try {
            for(int r = 0; r < board.length; r++) board[r][col] = !board[r][col];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    // Sets a grid formed from the rectangle between a certain location and another to a certain state
    public void setGrid(int sRow, int sCol, int eRow, int eCol, boolean isOn) throws IOException {
        try {
            for(int r = sRow; r <= eRow; r++) for(int c = sCol; c <= eCol; c++) board[r][c] = isOn;
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    // Toggles a grid formed from the rectangle between a certain location and another
    public void toggleGrid(int sRow, int sCol, int eRow, int eCol) throws IOException {
        try {
            for(int r = sRow; r <= eRow; r++) for(int c = sCol; c <= eCol; c++) board[r][c] = !board[r][c];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    // Sets all lights to a certain state
    public void setAll(boolean isOn) {
        for (boolean[] booleans : board) Arrays.fill(booleans, isOn);
    }

    // Toggles the lightboard
    public void toggleAll() {
        for(int r = 0; r < board.length; r++) for(int c = 0; c < board[r].length; c++) board[r][c] = !board[r][c];
    }

    // Creates the map for a lightboard
    public boolean[][] generate(int numRows, int numCols, double percent) {
        if(percent < 0 || percent > 100) return null;
        boolean[][] retArr = new boolean[numRows][numCols];
        for(int r = 0; r < numRows; r++) for(int c = 0; c < numCols; c++)
            retArr[r][c] = (Math.random() * 100) < percent;
        board = retArr;
        return board;
    }

    // Randomizes the board with a certain chance
    public void randomize(double percent) {
        if(percent < 0 || percent > 100) return;
        for(int r = 0; r < board.length; r++) for(int c = 0; c < board[r].length; c++)
            board[r][c] = (Math.random() * 100) < percent;
    }

    // Randomizes the board
    public void randomize() {
        double percent = (Math.random()*100.0000000001);
        for(int r = 0; r < board.length; r++) for(int c = 0; c < board[r].length; c++)
            board[r][c] = (Math.random() * 100) < percent;
    }

    // Randomizes a grid of lights with a certain chance
    public void randomizeGrid(int sRow, int sCol, int eRow, int eCol, double percent) throws IOException {
        try {
            for (int r = sRow; r <= eRow; r++)
                for (int c = sCol; c <= eCol; c++) board[r][c] = (Math.random() * 100) < percent;
        }
        catch(ArrayIndexOutOfBoundsException e) { throw new IOException(); }
    }

    // Randomizes a grid of lights
    public void randomizeGrid(int sRow, int sCol, int eRow, int eCol) throws IOException {
        double percent = (Math.random()*100.0000000001);
        try {
            for (int r = sRow; r <= eRow; r++)
                for (int c = sCol; c <= eCol; c++) board[r][c] = (Math.random() * 100) < percent;
        }
        catch(ArrayIndexOutOfBoundsException e) { throw new IOException(); }
    }

}
