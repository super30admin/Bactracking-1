// Time Complexity : O(2*n). n is the length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    List<List<Integer>> intList;
    int targetSum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        intList = new ArrayList();
        targetSum=target;
        backTrack(candidates,new ArrayList(),0,0);
        return intList;
    }
    
    private void backTrack(int[] candidates,List<Integer> li,int index,int sum){
        
        if(index>=candidates.length || sum>targetSum) return;
        
        else if(sum==targetSum){
            intList.add(new ArrayList(li));
        }
        
       
         else{
             
          
        for(int i=index;i<candidates.length;i++){
            
            //action
             li.add(candidates[i]);
            //recurse
             backTrack(candidates,li,i,sum+candidates[i]);
            //backtrack
            li.remove(li.size()-1);
            
        }
             
         }
       
    }
}
