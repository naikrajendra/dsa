package com.rpk.dsa;

public class Sudoku {

    private static final int GRID_SIZE = 9;
    private static final int SUBGRID_SIZE = 3;

    public int[] validDigits(String inputGrid, int rowNum, int colNum) {
        if (inputGrid == null || inputGrid.length() != GRID_SIZE * GRID_SIZE) {
            return new int[0];
        }

        char[][] grid = parseGrid(inputGrid);
        if (rowNum < 0 || rowNum >= GRID_SIZE || colNum < 0 || colNum >= GRID_SIZE) {
            return new int[0];
        }

        if (grid[rowNum][colNum] != '0') {
            return new int[] { Character.getNumericValue(grid[rowNum][colNum]) };
        }

        int[] valid = new int[9];
        int count = 0;
        for (int digit = 1; digit <= GRID_SIZE; digit++) {
            char candidate = (char) ('0' + digit);
            if (canPlaceDigit(grid, rowNum, colNum, candidate)) {
                valid[count++] = digit;
            }
        }

        int[] result = new int[count];
        System.arraycopy(valid, 0, result, 0, count);
        return result;
    }

    public String fillSudoku(String inputGrid) {
        if (inputGrid == null || inputGrid.length() != GRID_SIZE * GRID_SIZE) {
            return inputGrid;
        }

        char[][] grid = parseGrid(inputGrid);
        if (!isBoardValid(grid)) {
            return inputGrid;
        }

        if (solveSudoku(grid)) {
            return gridToString(grid);
        }

        return inputGrid;
    }

    private static char[][] parseGrid(String inputGrid) {
        String clean = inputGrid.replaceAll("\\s+", "");
        char[][] grid = new char[GRID_SIZE][GRID_SIZE];

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                int index = row * GRID_SIZE + col;
                if (index < clean.length()) {
                    grid[row][col] = clean.charAt(index);
                } else {
                    grid[row][col] = '0';
                }
            }
        }
        return grid;
    }

    private static String gridToString(char[][] grid) {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                builder.append(grid[row][col]);
            }
        }
        return builder.toString();
    }

    private static boolean isBoardValid(char[][] grid) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                char current = grid[row][col];
                if (current == '0') {
                    continue;
                }
                if (!canPlaceDigit(grid, row, col, current)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean canPlaceDigit(char[][] grid, int row, int col, char digit) {
        if (digit < '1' || digit > '9') {
            return false;
        }

        for (int index = 0; index < GRID_SIZE; index++) {
            if (index != col && grid[row][index] == digit) {
                return false;
            }
            if (index != row && grid[index][col] == digit) {
                return false;
            }
        }

        int startRow = (row / SUBGRID_SIZE) * SUBGRID_SIZE;
        int startCol = (col / SUBGRID_SIZE) * SUBGRID_SIZE;

        for (int subRow = startRow; subRow < startRow + SUBGRID_SIZE; subRow++) {
            for (int subCol = startCol; subCol < startCol + SUBGRID_SIZE; subCol++) {
                if ((subRow != row || subCol != col) && grid[subRow][subCol] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean solveSudoku(char[][] grid) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col] == '0') {
                    for (int digit = 1; digit <= GRID_SIZE; digit++) {
                        char candidate = (char) ('0' + digit);
                        if (canPlaceDigit(grid, row, col, candidate)) {
                            grid[row][col] = candidate;
                            if (solveSudoku(grid)) {
                                return true;
                            }
                            grid[row][col] = '0';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        String inputGrid = "530070000600195000098000060800060003400803001700020006060000280000419005000080079";
        // String solvedGrid = sudoku.fillSudoku(inputGrid);
        int[] gridArray = sudoku.validDigits(inputGrid, 0, 0);
        for (int digit : gridArray) {
            System.out.print(digit + " ");
        }
        System.out.println();
        // System.out.println(solvedGrid);
    }
}
