class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] arr=new int[target+1];
        Arrays.fill(arr,-1);
        return combination(arr,target,nums,0);
    }
    
    public int combination(int[] arr,int target,int[] nums,int sum)
    {
        if(sum>target)
            return 0;
        if(sum==target)
            return 1;
        if(arr[sum]!=-1)
        {
            return arr[sum];
        }
        int i=0,count=0;
        while(i<nums.length)
        {
            count+=combination(arr,target,nums,sum+nums[i]);
            i++;
        }
        arr[sum]=count;
        return arr[sum];
    }
}

// Initially it was failing while doing it with only backtracking. So I used memoization here which is storing previous results in array which increases speed of process.
// Time Complexity: O(n^m) , Not sure about this -- need to discuss
// Space Complexity: O(n+m) , Not sure about this as well.