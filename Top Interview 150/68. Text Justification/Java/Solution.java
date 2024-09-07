class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // early exit
        if(maxWidth == 0 || words.length == 0) {
            return Arrays.asList("");
        }

        // build an array of arrays of Strings representing each line
        // calculate necessary spaces
        List<List<String>> lines = new ArrayList<>();
        List<Integer> lineLengths = new ArrayList<>();

        lines.add(new ArrayList<String>());
        int currentLength = 0;
        int currentLine = 0;
        for(String word : words) {
            if(currentLength != 0 && currentLength + word.length() >= maxWidth) {
                lineLengths.add(currentLength - (lines.get(currentLine).size()-1));
                currentLine++;
                currentLength = 0;
                lines.add(new ArrayList<String>());
            }
            currentLength += word.length();
            if(currentLength != word.length()) {
                currentLength++;
            }
            lines.get(currentLine).add(word);
        }

        lineLengths.add(currentLength - (lines.get(currentLine).size()-1));
        currentLine++;
        currentLength = 0;
        lines.add(new ArrayList<String>());

        // now process each string
        List<String> result = new ArrayList<>();
        for(int l=0; l<currentLine; l++) {
            int evenSpaces = 0;
            int leftSpaces = 0;
            if(lines.get(l).size() == 1) {
                evenSpaces = maxWidth - lines.get(l).get(0).length();
            }
            else {
                evenSpaces =  (maxWidth-lineLengths.get(l)) / (lines.get(l).size()-1); // aaaa aaaa aaa a
                leftSpaces = (maxWidth-lineLengths.get(l)) % (lines.get(l).size()-1);
            }
            
            StringBuilder lineString = new StringBuilder();
            
            for(int w=0; w<lines.get(l).size(); w++) {
                lineString.append(lines.get(l).get(w));
                // as long as it isn't the last line and the line isn't a single word...
                if(l != currentLine-1 && lines.get(l).size() != 1) {
                    if(w == lines.get(l).size()-1) break;
                    for(int s=0; s<evenSpaces; s++) {
                        lineString.append(" ");
                    }
                    if(leftSpaces > 0) {
                        lineString.append(" ");
                        leftSpaces--;
                    }
                }
                // otherwise, add spaces to the end of the line
                else {
                    int spaces = 1;
                    if(w == lines.get(l).size()-1) {
                        spaces = maxWidth-lineString.length();
                    }
                    for(int s=0; s<spaces; s++) {
                        lineString.append(" ");
                    }
                }
                
            }
            result.add(lineString.toString());
        }
        return result;
    }
}