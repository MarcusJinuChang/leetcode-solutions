class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        for (int i = citations.length; i > 0; i--) {
            if(citations[citations.length - i] >= i) {
                return i;
            }
        }

        return Math.min(citations[0], 1);
    }
}