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