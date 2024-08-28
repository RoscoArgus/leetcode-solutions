class Solution {
    public int hIndex(int[] citations) {
        // sort the array so all following papers have at least as many citations as the current paper
        Arrays.sort(citations); 

        // iterate through the array
        for(int i=0; i<citations.length; i++) {
            // number of papers with at least as many citations as the current paper
            int numPapers = citations.length-i;
            // if the number of papers is less than or equal to the number of citations, 
            // return the number of papers
            if(numPapers <= citations[i]) {
                return numPapers;
            }
        }

        // if no h-index is found, return 0
        return 0;
    }
}