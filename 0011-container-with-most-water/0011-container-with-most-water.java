class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = (j - i) * Math.min(height[i], height[j]);
        int limiter = 0;

        while (i < j) {
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }

            max = Math.max((j - i) * Math.min(height[i], height[j]), max);
        }

        return max;
    }
}