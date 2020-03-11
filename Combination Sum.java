// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> result =new LinkedList<>();
      List<Integer> stage =new LinkedList<>();
      dfs(candidates,target,result,stage,0,0);
      return result;
      
}
  private void dfs(int[] candidates, int target,List<List<Integer>> result,  List<Integer> stage,int sum,int index)
  {
      if(sum == target){
          result.add(new LinkedList<>(stage));
          return;
      }
      if(sum > target){return;}
      for(int i=index;i<candidates.length;i++){
          stage.add(candidates[i]);
        dfs(candidates,target,result,stage,sum+candidates[i],i);
          stage.remove(stage.size()-1);
      }
  }
}