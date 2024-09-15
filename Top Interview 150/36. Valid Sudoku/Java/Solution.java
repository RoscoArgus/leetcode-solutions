class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        // check rows
        for(int row = 0; row<n; row++) {
            if(!isValidRange(board,row,row,0,8)) {
                return false;
            }
        }

        // check cols
        for(int col = 0; col<n; col++) {
            if(!isValidRange(board,0,8,col,col)) {
                return false;
            }
        }
        
        // check each block
        for(int i=0; i<3; i++) {
            for(int j=0; j<3;j++) {
                // range for blocks in a 9*9 board
                if(!isValidRange(board,i*3,i*3+2,j*3,j*3+2)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidRange(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd) {
        boolean[] numUsed = new boolean[10];

        for(int row=rowStart; row<=rowEnd; row++) {
            for(int col=colStart; col<=colEnd; col++) {
                if(board[row][col] != '.') {
                    if(numUsed[board[row][col]-'0']) {
                        return false;
                    }
                    numUsed[board[row][col]-'0'] = true;
                }
            }
        }

        return true;
    }
}