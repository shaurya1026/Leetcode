class Solution {
public int[] shuffle(int[] nums, int n) {
int[] res = new int[nums.length];
int j=0;
for(int i=0;i<(nums.length);i=i+2){
res[i] = nums[j];
res[i+1] = nums[j+n];
j++;
}
return res;
}
}