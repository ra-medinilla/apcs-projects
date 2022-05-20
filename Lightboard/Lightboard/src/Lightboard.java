import java.io.IOException;
import java.util.Arrays;

public class Lightboard {

    private boolean[][] board;
    public Lightboard() {
        board = generate(10, 10, 40);
    }
    public boolean[][] getBoard() { return board; }

    public void setLight(int row, int col, boolean isOn) throws IOException {
        try {
            board[row][col] = isOn;
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    public void toggleLight(int row, int col) throws IOException {
        try {
            board[row][col] = !board[row][col];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    public void setRow(int row, boolean isOn) throws IOException {
        try {
            Arrays.fill(board[row], isOn);
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    public void toggleRow(int row) throws IOException {
        try {
            for(int c = 0; c < board[row].length; c++) board[row][c] = !board[row][c];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    public void setCol(int col, boolean isOn) throws IOException {
        try {
            for(int r = 0; r < board.length; r++) board[r][col] = isOn;
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    public void toggleCol(int col) throws IOException {
        try {
            for(int r = 0; r < board.length; r++) board[r][col] = !board[r][col];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    public void setGrid(int sRow, int sCol, int eRow, int eCol, boolean isOn) throws IOException {
        try {
            for(int r = sRow; r <= eRow; r++) for(int c = sCol; c <= eCol; c++) board[r][c] = isOn;
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    public void toggleGrid(int sRow, int sCol, int eRow, int eCol) throws IOException {
        try {
            for(int r = sRow; r <= eRow; r++) for(int c = sCol; c <= eCol; c++) board[r][c] = !board[r][c];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new IOException();
        }
    }

    public void setAll(boolean isOn) {
        for (boolean[] booleans : board) Arrays.fill(booleans, isOn);
    }

    public void toggleAll() {
        for(int r = 0; r < board.length; r++) for(int c = 0; c < board[r].length; c++) board[r][c] = !board[r][c];
    }

    public boolean[][] generate(int numRows, int numCols, double percent) {
        if(percent < 0 || percent > 100) return null;
        boolean[][] retArr = new boolean[numRows][numCols];
        for(int r = 0; r < numRows; r++) for(int c = 0; c < numCols; c++)
            retArr[r][c] = (Math.random() * 100) < percent;
        board = retArr;
        return board;
    }

    public void randomize(double percent) {
        if(percent < 0 || percent > 100) return;
        for(int r = 0; r < board.length; r++) for(int c = 0; c < board[r].length; c++)
            board[r][c] = (Math.random() * 100) < percent;
    }

    public void randomize() {
        double percent = (Math.random()*100.0000000001);
        for(int r = 0; r < board.length; r++) for(int c = 0; c < board[r].length; c++)
            board[r][c] = (Math.random() * 100) < percent;
    }

    public void randomizeGrid(int sRow, int sCol, int eRow, int eCol, double percent) throws IOException {
        try {
            for (int r = sRow; r <= eRow; r++)
                for (int c = sCol; c <= eCol; c++) board[r][c] = (Math.random() * 100) < percent;
        }
        catch(ArrayIndexOutOfBoundsException e) { throw new IOException(); }
    }

    public void randomizeGrid(int sRow, int sCol, int eRow, int eCol) throws IOException {
        double percent = (Math.random()*100.0000000001);
        try {
            for (int r = sRow; r <= eRow; r++)
                for (int c = sCol; c <= eCol; c++) board[r][c] = (Math.random() * 100) < percent;
        }
        catch(ArrayIndexOutOfBoundsException e) { throw new IOException(); }
    }

}