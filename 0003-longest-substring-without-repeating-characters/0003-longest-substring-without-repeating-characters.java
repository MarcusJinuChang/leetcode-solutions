class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int[] ar = new int[255];
        int l = 0, size = 0;
        char c;
        
        for (int r = 0; r < str.length; r++) {
            c = str[r];
            ar[c+0]++;

            // if (ar[c+0] > 1) {
            //     while (str[l] != c) {
            //         l++;
            //     }
            //     l++;
            //     ar[c+0]--;
            //     size = Math.max(r-l + 1, size);
            //     continue;
            // }

           

            while(ar[c] > 1) {
                ar[str[l]]--;
                l++;
            }

            size = Math.max(size, r-l+1);
            // System.out.println(s.substring(l, r+1));
        }

        return size;
    }
}