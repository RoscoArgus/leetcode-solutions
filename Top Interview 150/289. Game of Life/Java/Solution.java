class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // mark cells for next state
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                int count = 0;
                // check neighbours in segment
                for(int i=Math.max(0,row-1); i<=Math.min(rows-1,row+1); i++) {
                    for(int j=Math.max(0,col-1); j<=Math.min(cols-1,col+1); j++) {
                        if(board[i][j] > 0)                        
                            count++;
                    }
                }
                count -= board[row][col]; // remove self from count
                // if live and neighbours < 2 or > 3, mark for death
                if(board[row][col] == 1 && (count < 2 || count > 3)) {                    
                    board[row][col] = 2;
                }
                // else if dead and neighbours == 3, mark for life
                else if (board[row][col] <= 0 && count == 3) {
                    board[row][col] = -1;
                }
            }
        }

        // update states
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                switch(board[row][col]) {
                    case -1: // dead to live
                        board[row][col] = 1;
                        break;
                    case 2: // live to dead
                        board[row][col] = 0;
                        break;
                    default:
                        break;
                }
            }
        }

    }
}