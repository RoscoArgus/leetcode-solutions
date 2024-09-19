class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> counts = new HashMap<>();

        // count characters in magazine
        for(char c : magazine.toCharArray()) {
            int count = counts.getOrDefault(c,0);
            counts.put(c,++count);
        }

        // check if ransomNote can be constructed
        for(char c : ransomNote.toCharArray()) {
            int count = counts.getOrDefault(c,0);
            if(count == 0) return false;
            counts.put(c,--count);
        }

        return true;
    }
}