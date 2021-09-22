// Time Complexity : O(n2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yeah finding Time Complexity, can you please explain me


// Your code here along with comments explaining your approach

// using recursion( on each recursive call pass the same path as the input) but add path as new arraylist in resultList

//1. this the case of choose or not choose
//2. draw the choose or not choose tree. notice what are the inputs we might need in recursive function 
//3. make two calls of same function one for choose and other for not choose
//4. if runningsum == 0 then add path to main result 
//5. else if reaches to end (index == length) or it is invalid path (runningsum <0) terminate the recursion call(return) 
//6. backtrack by removing last element from the list


class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates, target,0,new ArrayList<Integer>());
        return result;
    }
    private void helper(int[] candidates, int runningSum, int index , List<Integer> path)
    {   // ----- action
        //base
        if(index == candidates.length || runningSum < 0)
            return;
        if(runningSum == 0)
        {  
            result.add(new ArrayList<>(path));
            return;
        }
      //  ---- recursion
        // not choose
        helper(candidates,runningSum,  index+1, path);
        
            // choose
         path.add(candidates[index]);
        helper(candidates,runningSum -candidates[index] ,  index, path);
        
        // ----- backtracking
        path.remove(path.size()-1);
        
    }
}