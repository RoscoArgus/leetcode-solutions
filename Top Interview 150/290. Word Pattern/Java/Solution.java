class Solution {
    public boolean wordPattern(String pattern, String s) {
        String []arr=s.split(" ");
        if(arr.length!=pattern.length())
            return false;
 
        HashMap<Character,String> map = new HashMap<>();
        char c;

        for(int i=0; i<pattern.length(); i++) {
            c = pattern.charAt(i);
            // if the mapping doesn't exist and value hasn't been mapped, create mapping
            if(!map.containsKey(c)&&!map.containsValue(arr[i])) {
                map.put(c,arr[i]);
            }
            // otherwise, if the mapping does exist put it doesn't equal our expected word, return false
            else if(map.containsKey(c) && !map.get(c).equals(arr[i])) {
                return false;
            }
            // otherwise, if the value has been mapped, but not to the current key, return false
            else if(map.containsValue(arr[i]) && !map.containsKey(c)) {
                return false;
            }
        }

        return true;
    }
}