// Time Complexity :O(4^N)
// Space Complexity :O(4^N)
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
  public List<String> addOperators(String num, int target) {
      List<String> result = new ArrayList<>();
      backtrack(num,target,result,0,"",0,0);
      return result;
  }
  
  private void backtrack(String num, int target,List<String> result,int index,String expression,long Val,long prevsigned ){
 
      if(index==num.length()){
          if(Val==target){
                  result.add(expression); 
          }
          return;
      }
      for(int i=index;i<num.length();i++){
          if(index!=i && num.charAt(index)=='0')break;
         Long operand =Long.parseLong(num.substring(index,i+1));
          if(index ==0){
              backtrack(num,target,result,i+1,""+operand ,operand,operand);
          }
          else{
         backtrack(num,target,result,i+1,expression+"+"+operand ,Val+operand,operand);
         backtrack(num,target,result,i+1,expression+"-"+operand ,Val-operand,-1*operand);
         backtrack(num,target,result,i+1,expression+"*"+operand, Val-prevsigned + operand*prevsigned , operand*prevsigned);
         }
  }
  }
}