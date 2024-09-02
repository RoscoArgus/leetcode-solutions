class Solution {
    public String convert(String s, int numRows) {
        // if 1 row or more rows than characters, string is the same
        if(numRows == 1 || numRows >= s.length()) return s;

        // build each row, then append to result
        List<Character>[] rows = new ArrayList[numRows];
        for(int i=0; i<numRows; i++) {
            rows[i] = new ArrayList<>();
        }

        // track direction as pos or neg distance
        int currentRow = 0;
        int direction = 1;
        for(int i=0; i<s.length(); i++) {
            rows[currentRow].add(s.charAt(i));
            // if at top or bottom, reverse direction;
            if(currentRow == 0) {
                direction = 1;
            }
            else if(currentRow == numRows-1) {
                direction = -1;
            }
            currentRow += direction;
        }

        StringBuilder result = new StringBuilder();
        for(List<Character> row : rows) {
            for(char c : row) {
                result.append(c);
            }
        }

        return result.toString();
    }
}