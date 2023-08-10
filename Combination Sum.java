// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// Exhaustive approach: Here we choose each element and try to find as many combinations as poosible by choosing it and not choosing it to add up to target.
// When we keep subtracting the elements which we choose from the target until we get 0, and whenever we get it, we add it to result. O(n+m)


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result=new ArrayList<>();
        helper(candidates,0,target,new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] candidates,int i, int target,List<Integer> path)
    {
        //base
        if(target<0 || i==candidates.length) return;
        if(target==0) 
        {
            result.add(path);
            return;
        }

        //logic
        //not choose
        helper(candidates,i+1,target,new ArrayList<>(path));

        //choose
        path.add(candidates[i]);
         helper(candidates,i, target-candidates[i],new ArrayList<>(path));

    }
}


//Backtrack: Here we will choose the element first, add the elements in the path array, then when we have to check the not choose option we remove that element from the path list.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result=new ArrayList<>();
        helper(candidates,0,target,new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] candidates,int i, int target,List<Integer> path)
    {
        //base
        if(target<0 || i==candidates.length) return;
        if(target==0) 
        {
            result.add(path);
            return;
        }

        //logic
        //choose
        //action
        path.add(candidates[i]);
        //recurse
         helper(candidates,i, target-candidates[i],new ArrayList<>(path));
         //backtrack
         path.remove(path.size()-1);
        //not choose
        helper(candidates,i+1,target,new ArrayList<>(path));
 

    }
}

