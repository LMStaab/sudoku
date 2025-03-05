import static help.Color.*;
import static help.Helper.*;
import java.util.*;

public class Board 
{
    private int[][] board = new int[9][9];
    private ArrayList<int[]> usedIndexes = new ArrayList<>();
    private int numRemoved;

    public Board(int num) 
    {
        numRemoved = num;
        fillBoard();
        removeRandomNums();
    }

    
    private void fillBoard()
    {
        clearBoard();
        for(int row = 0; row < 9; row++)
        {
            ArrayList<ArrayList<Integer>> useableNums = new ArrayList<>();
            for(int col = 0; col < 9; col ++)
            {
                ArrayList<Integer> colNums = new ArrayList<>();
                for (int num = 1; num <= 9; num++)
                {
                    if(isSafe(row, col, num))
                    {
                        colNums.add(num);
                    }
                }
                useableNums.add(colNums);
            }

            for(int index = 0; index < 9; index ++)
            {
                if(board[row][index] == 0)
                {
                    if(useableNums.get(index).size() == 1)
                    {
                        board[row][index] = useableNums.get(index).get(0);
                        clearVal(useableNums, useableNums.get(index).get(0));
                    } 
                    else if(useableNums.get(index).isEmpty())
                    {
                        fillBoard();
                    }
                    else
                    {
                        int val =  useableNums.get(index).get((int)(Math.random()*useableNums.get(index).size()));
                        board[row][index] = val;
                        clearVal(useableNums, val);
                    }
                }
            }
        }
        
    }

    private void clearBoard()
    {
        for (int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col ++)
            {
                board[row][col] = 0;
            }
        }
    }
    
    private void clearVal(ArrayList<ArrayList<Integer>> list, int val)
    {
        for(ArrayList<Integer> nums : list)
        {
            for(int i = 0; i < nums.size(); i++)
            {
                if(nums.get(i)==val)
                {
                    nums.remove(i);
                }
            }
        }
    }

    private void removeRandomNums() 
    {
        usedIndexes.clear();
        
        int counter = 0;
        
        while (counter < numRemoved) 
        {
            int randomRow = (int) (Math.random()*9);
            int randomCol = (int) (Math.random()*9);
            int[] temp = {randomRow, randomCol};
            
            if (!usedIndexes.contains(temp)) 
            {
                board[randomRow][randomCol] = 0;
                counter++;
            }
        }
    }

    private boolean isSafe(int row, int col, int val) 
    {
        return (!checkRow(row, val) && !checkColumn(col, val) && !checkBox(row, col, val));
    }

    private boolean checkRow(int row, int value) 
    {
        for (int i = 0; i < 9; i++)
        {
            if (board[row][i] == value) 
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(int column, int value) 
    {
        for (int i = 0; i < 9; i++) 
        {
            if (board[i][column] == value) 
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkBox(int row, int column, int value) 
    {
        int boxRowStart = row - (row % 3);
        int boxColStart = column - (column % 3);
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if (board[boxRowStart + i][boxColStart + j] == value) 
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard() {
        for (int row = 0; row < 9; row++) 
        {
            if (row % 3 == 0) 
            {
                println("|---------|---------|---------|");
            }
            for (int column = 0; column < 9; column++) 
            {
                if (column % 3 == 0) 
                {
                    print("|");
                }
                
                if(board[row][column] == 0)
                {
                    print("[" + board[row][column] + "]", GREEN);
                }
                else
                {
                    print("[" + board[row][column] + "]", RED);
                }
                
            }
            println("|");
        }
        println("|---------|---------|---------|");
    }
}