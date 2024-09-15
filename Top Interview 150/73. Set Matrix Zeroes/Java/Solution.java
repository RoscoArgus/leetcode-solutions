class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // to do this in place, must mark rows/cols for deletion in place (i.e. set start of row/col to 0)
        // however there is an overlap at 0,0 between row[0] and col[0] being marked for deletion
        // therefore let 0,0 represent row[0] deletion and use this boolean to mark col deletion
        boolean zeroFirstRow = false;

        // mark rows and columns for zeroing
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                // if the element is 0...
                if(matrix[row][col] == 0) {
                    // mark row for zeroing
                    matrix[0][col] = 0;
                    // if not first column, mark for zeroing
                    if(row > 0)
                        matrix[row][0] = 0;
                    // otherwise, mark for later
                    else 
                        zeroFirstRow = true;
                }
            }
        }

        // from row 1, col 1, mark elements as zero if row or column marked for zeroing
        for(int row=1; row<rows; row++) {
            for(int col=1; col<cols; col++) {
                if(matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // if first row marked for zeroing, zero the first row
        if(matrix[0][0] == 0) {
            for(int row = 0; row<rows; row++) {
                matrix[row][0] = 0;
            }
        }

        // if first column marked for zeroing, zero the first col
        if(zeroFirstRow) 
            for(int col = 0; col<cols; col++) {
                matrix[0][col] = 0;
            }
    }
}