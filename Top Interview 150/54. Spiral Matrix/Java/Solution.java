class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int x = 0;
        int y = 0;
        int dx = 0; // direction of rows
        int dy = 1; // direction of columns
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<rows*cols; i++) {
            // add result to array and nullify element 
            // (some element outside range -100 -> 100)
            result.add(matrix[x][y]);
            matrix[x][y] = 404;

            // if next element in current direction is null or out of bounds, 
            // change direction
            if(
                x+dx >= rows ||
                x+dy < 0 || 
                y+dy >= cols || 
                y+dy < 0 || 
                matrix[x+dx][y+dy] == 404
            ) {
                int temp = dy;
                dy = -dx;
                dx = temp;
            } 
            x += dx;
            y += dy;
        }

        return result;
    }
}