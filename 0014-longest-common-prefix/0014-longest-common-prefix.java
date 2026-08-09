class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        ans.append(strs[0]); 

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];

            ans.delete(Math.min(ans.length(), s.length()), ans.length());
            for (int j = 0; j < ans.length(); j++) {
                if (ans.charAt(j) != s.charAt(j)) {
                    ans.delete(j, ans.length());
                    break;
                }
            }
        }

        return ans.toString();        
    }
}