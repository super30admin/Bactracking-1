// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public void backTrack(List<List<Integer>> result,LinkedList<Integer> lst,int idx,int[] arr,int sum)
    {
        if(sum == 0)
        {
            result.add(new ArrayList(lst));
            return;
        }
        for(int i = idx;i<arr.length;i++)
        {
            if(sum - arr[i] >=0)
            {
                lst.add(arr[i]);
                backTrack(result,lst,i,arr,sum-arr[i]);
                lst.removeLast();
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        backTrack(result,temp,0,candidates,target);
        return result;
    }
}