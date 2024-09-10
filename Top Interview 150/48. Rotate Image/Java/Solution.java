class Solution {
    public void rotate(int[][] matrix) {
        int n =  matrix.length;
        // first transpose the matrix
        transpose(matrix);
        for(int r=0; r<n; r++) {
            // ...then reverse each row
            reverseRow(matrix[r]);
        }        
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int r=0; r<n; r++) {
            for(int c=r+1; c<n; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

    public void reverseRow(int[] row) {
        int left=0;
        for(int right=row.length-1; left<right; right--) {
            int temp = row[left];
            row[left] =  row[right];
            row[right] = temp;
            left++;
        }
    }
}