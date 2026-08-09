class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        boolean word = false;
        int end = s.length()-1;

        for (int i = s.length()-1; i >= 0; i--) {
            if (!word && s.charAt(i) != ' ') {
                word = !word;
                end = i+1;
                continue;
            }

            if (word && s.charAt(i) == ' ') {
                ans.append(s.substring(i+1, end) + " ");
                word = !word;
            }
        }

        if (s.charAt(0) != ' ') {
            ans.append(s.substring(0, end) + " ");
        }

        return ans.delete(ans.length()-1,ans.length()).toString();
    }
}