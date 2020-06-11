package LeetCode;

public class Program1 {/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 * 
	 * 
	 * T.C =  O(2^n)
	 * S.C =  O(n)
	 */
	class Solution {
	    int count = 0;
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> result = new ArrayList<>();
	        findCombinations(candidates, 0, new ArrayList<>(), target, result);
	        return result;
	        
	    }
	    
	    public void findCombinations(int[] candidates, int index, List<Integer> current, int target, List<List<Integer>>result){
	        System.out.println(count+1);
	        count++;
	        if(target == 0)
	        {
	            result.add(new ArrayList<>(current));
	            return;
	        }
	        if(target<0)
	            return;
	        
	        for(int i = index ; i<candidates.length; i++){
	            if(i==index || candidates[i]!=candidates[i-1])
	            {
	            current.add(candidates[i]);
	            findCombinations(candidates, i , current, target-candidates[i], result);
	            current.remove(current.size()-1);
	            }
	        }
	        
	          }
	       
	    }
}