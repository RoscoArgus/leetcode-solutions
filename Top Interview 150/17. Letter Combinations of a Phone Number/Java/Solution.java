class Solution {
    // global mapping to store the possible characters for each digit
    public char[][] digitToChar = new char[8][0];

    public List<String> letterCombinations(String digits) {
        // populate list
        digitToChar[0] = new char[]{'a','b','c'};
        digitToChar[1] = new char[]{'d','e','f'};
        digitToChar[2] = new char[]{'g','h','i'};
        digitToChar[3] = new char[]{'j','k','l'};
        digitToChar[4] = new char[]{'m','n','o'};
        digitToChar[5] = new char[]{'p','q','r','s'};
        digitToChar[6] = new char[]{'t','u','v'};
        digitToChar[7] = new char[]{'w','x','y','z'};

        List<String> result = new ArrayList<>();
        return buildResult(digits);
    }

    public List<String> buildResult (String digits) {
        List<String> result = new ArrayList<>();
        // early exit
        if(digits==null || digits.length()==0) {
            return result;
        }

        // start recursive call with empty result, empty combination, digits and index 0
        buildResultRecursive(result,new StringBuilder(),digits,0);
        return result;
    }

    public void buildResultRecursive (List<String> result, StringBuilder combination, String digits, int index) {
        // base case
        if(index >= digits.length()) {
            result.add(combination.toString());
            return;
        }

        // get the digit and convert it to integer
        int digit = digits.charAt(index)-'0';
        
        // iterate over the possible characters for the digit
        for(char l : digitToChar[digit-2]) {
            combination.append(l);
            buildResultRecursive(result,combination,digits,index+1);
            combination.deleteCharAt(combination.length()-1);
        }
    }

}