class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a[]=new int[2];
        Map<Integer,Integer> indexes= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int curentVal=nums[i];
            int otherNo=target-curentVal;
            if(indexes.containsKey(otherNo)){
                a[0]=indexes.get(otherNo);
                a[1]=i;
                break;
            }indexes.put(curentVal,i);
        }return a;
    }
}