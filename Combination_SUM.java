/*

    Time complexity : 2^n

    space complexity: O(N)

    is worked on leetcode : YES

*/

public class Combination_SUM {
    int targ;
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        targ = target;
        result =  new ArrayList();
        
        backtrack( candidates, new ArrayList(),0,0);
        return result;
    }
    
    private void backtrack(int[] candidates, List<Integer> temp, int sum, int index){
        
        // base
        if( sum ==  targ) {
            result.add(new ArrayList(temp));
            return;   
        }
        
        if( sum > targ) return;
        
        for( int i = index;i < candidates.length; i++){
            // action
            temp.add(candidates[i]);
            
            // recurse
            backtrack(candidates, temp, sum+ candidates[i],i);
            
            // backtrack
 
 
            temp.remove(temp.size() -1 );
        }
    }


}

/*
    You choose it or not and then maintain new list at each recursion

    Using recursion

    class Solution {
    int targ;
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        targ = target;
        result =  new ArrayList();
        
        helper( candidates, new ArrayList(),0,0);
        return result;
    }
    
    private void helper(int[] candidates, List<Integer> temp, int sum, int index){
        
        // base case
        
        if( sum ==  targ){
            // System.out.println("index : "+index +"temp "+temp.toString());
            result.add(temp);
            return;
        }
        
        if( sum > targ || index ==  candidates.length) {
            // System.out.println("hey"+sum);
            return;}
        
        // logic
        
        //  if you don't choose move to the next element
        helper( candidates, new ArrayList(temp), sum, index + 1);
        
        // System.out.println("index : "+index + " element "+ candidates[index]); 
        // if you choose
        temp.add(candidates[index]);
        
        helper(candidates, new ArrayList(temp), sum + candidates[index], index);
    }
}


*/