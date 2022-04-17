class Solution {
    public int search(int[] nums, int target) {
         int left =0 ,right= nums.length-1;
    
    //check so that pointers don't go out of balance
    while(left <= right)
    {
        int mid = (left+right)/2;
        
        //if middle is the target return the index of middle value
        if(nums[mid] == target)
        {
            return mid;
        }
        
       
        // if we are the left sorted portion of the array
        if(nums[mid]>=nums[left])
        {
            //if target is greater than middle element
            //then we have to search the right portion
            //also if the target is less than left then
            //also we have to search for the right portion
            if(target>nums[mid] ||target < nums[left] )
            {
                left = mid+1;
            }
            else
            {
               right = mid-1;
            }
            
        }
        //if we are in the right sorted portion of the array
        else
        {
            if(target <nums[mid] ||target > nums[right])
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
            
        }
    }
    
    return -1;
    
}
}
        
    