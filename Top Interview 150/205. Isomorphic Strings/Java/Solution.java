class Solution {
    public boolean isIsomorphic(String s, String t) {
        // if strings have different lengths, return false
        if(s.length() != t.length()) return false;

        // mappings of each character in s to t and vice versa
        int[] stot = new int[256];
        int[] ttos = new int[256];

        for(int i=0; i<s.length(); i++) {
            if(stot[s.charAt(i)] != ttos[t.charAt(i)])
                return false;
            // map last index of each character in s and t
            stot[s.charAt(i)] = i+1;
            ttos[t.charAt(i)] = i+1;
        }

        return true;
    }
}