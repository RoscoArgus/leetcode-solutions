class Solution {

    // simply start with first string and for every charcter it doesn't
    // have in common with the current string, remove the last character.
    // Might be improved by checking the individual characters of the prefix from the 
    // end instead of using startsWith, but for sample size it's fine
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder(strs[0]);
        for(int i=1; i<strs.length; i++) {
            while(!strs[i].startsWith(prefix.toString())) {
                prefix.deleteCharAt(prefix.length()-1);
                if(prefix.length() == 0) 
                    return "";
            }            
        }
        return prefix.toString();
    }
}