public class Solution {
    public String intToRoman(int num) {

        // my initial approach only looked at single numerals
        // this is more efficient given the array size
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // StringBuilder more efficient for frequent concatenation
        StringBuilder result = new StringBuilder();

        // Look for the largest value just smaller than num
        for (int i = 0; i < vals.length; i++) {
            while (num >= vals[i]) {
                result.append(numerals[i]);
                num -= vals[i];
            }
        }

        return result.toString();
    }
}