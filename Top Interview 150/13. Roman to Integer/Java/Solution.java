class Solution {
    public int romanToInt(String s) {
        int[] nums = new int[s.length()]; // array of numeric values of each numeral
        int total = 0;
        for(int i=0; i<s.length(); i++) {
            char numeral = s.charAt(i);
            nums[i] = getNumeralValue(numeral); // custom method to get numeric value of numeral
        }

        for(int i=0; i<nums.length; i++) {
            // if the current numeral is less than the next numeral, subtract the current numeral
            if(i<nums.length-1 && nums[i] < nums[i+1]) {
                total-=nums[i];
            }
            // else add the current numeral
            else {
                total+=nums[i];
            }
        }

        return total;
    }

    public int getNumeralValue(char numeral) {
        switch(numeral) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}