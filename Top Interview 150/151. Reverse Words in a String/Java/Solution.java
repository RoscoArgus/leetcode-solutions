class Solution {
    public String reverseWords(String s) {
        // split by whitespace
        String[] words = s.trim().split("\\s+");
        // use StringBuilder to append words in reverse order
        StringBuilder ans = new StringBuilder();
        // go until first word (it will be appended without space)
        for(int i=words.length-1; i>=1; i--) {
            ans.append(words[i] + " ");
        }
        // append first word
        return ans.toString() + words[0];
    }
}