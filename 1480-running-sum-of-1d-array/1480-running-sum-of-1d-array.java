class Solution {
    public int[] runningSum(int[] nums) {
       int lentgh = nums.length;
     int [] runningsum = new int[lentgh];
    int count =0;
    for(int i = 0; i<lentgh;i++){
        
          count+=nums[i];
        runningsum[i]=count;
        
    }
    return runningsum;
       
}
}