class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left<right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            // if invalid char (left)
            if(!Character.isLetterOrDigit(leftChar)) {
                left++;
            }
            // and if invalid char (right)
            else if(!Character.isLetterOrDigit(rightChar)) {
                right--;
            }
            // else, compare
            else {
                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) 
                    return false;
                left++;
                right--;
            }
        }

        return true;
    }
}