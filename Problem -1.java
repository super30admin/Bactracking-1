// Time Complexity : O(n^2), When we are not choosing , then the depth of the recursive tree is n , once the combination sums, we need to go over the path // which could be n as well.
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/*
We can solve it with Choose and not Choose
*/
class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();

        helper(candidates,target,0,new LinkedList<Integer>());
        return result;
    }

    private void helper(int[] candidates, int target, int idx,LinkedList<Integer> path){

        //base case
        if(target == 0){
            // create a new List from path and add it to the result
            result.add(new ArrayList<Integer>(path));
            return;
        }
        if(target < 0  || idx>=candidates.length){
            return; //solution not possible
        }

        //logic
        

            //choose 
            path.add(candidates[idx]); //action
            helper(candidates,target - candidates[idx],idx,path); //recurse
            path.removeLast();//backtrack
            //not choose
            helper(candidates,target,idx+1,path);//recurse and take the element out of the choice
        
        
        
    }

}