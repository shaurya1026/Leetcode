class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
         Arrays.sort(nums);
 
        List<List<Integer> > pair
          = new ArrayList<>();
        TreeSet<String> set
          = new TreeSet<String>();
        List<Integer> triplets
          = new ArrayList<>();
 
        /* Iterate over the array from the start
        and consider it as the first element*/
        for (int i = 0;
             i < nums.length - 2;
             i++) {
 
            // index of the first element in the
            // remaining elements
            int j = i + 1;
 
            // index of the last element
            int k = nums.length - 1;
 
            while (j < k) {
 
                if (nums[i] + nums[j]
                    + nums[k] == 0){
 
                    String str
                      = nums[i] + ":" + nums[j]
                                 + ":" + nums[k];
 
                    if (!set.contains(str))
                    {
 
                        // To check for the unique triplet
                        triplets.add(nums[i]);
                        triplets.add(nums[j]);
                        triplets.add(nums[k]);
                        pair.add(triplets);
                        triplets = new ArrayList<>();
                        set.add(str);
                    }
 
                     // increment the second value index
                    j++;
                    
                     // decrement the third value index
                    k--;
                }
                else if (nums[i]
                         + nums[j]
                         + nums[k] <0)
                    j++;
 
                else
                    k--;
            }
        }
        return pair;
    }
 
        
    }
