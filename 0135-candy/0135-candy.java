class Solution {
    public int candy(int[] ratings) {
        int[] kids = new int[ratings.length];
        Arrays.fill(kids, 1);

        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                kids[i] = kids[i-1] + 1;
            }
        }
        
        int sum = kids[kids.length-1];

        for (int i = ratings.length-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1] && kids[i] <= kids[i+1]) {
                kids[i] = kids[i+1] + 1;
            }
            sum += kids[i];
        }

        return sum;
    }
}