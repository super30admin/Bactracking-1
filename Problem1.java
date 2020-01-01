/**
LeetCode Submitted : YES
Space Complexity : O(target/Minimum of array)
Time Complexity : O(2^length(of array))

The idea is to recursively add the elements and return only if the sum of elements exceed target or equal to target or index goes out of bound. After recursion ends backtrack by removing the element.
**/

class Solution {
    
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates == null || candidates.length < 1)
            return results;
        
        int index = 0;
        int currSum = 0;
        combination(candidates,index,currSum,target,new ArrayList());
        
        return results;
    }
    
    private void combination(int [] candidates,int index, int currSum, int target, List<Integer> temp){
        if(index >= candidates.length){
            if(currSum == target)
                {
                    results.add(new ArrayList<>(temp));    
            }
            return;
        }
        
        if(currSum == target)
        {
            results.add(new ArrayList<>(temp));    
        }
        
        if(currSum > target)
            return;
        
        //iterate over the candiadates array
        for(int i = index; i< candidates.length; i++){
            temp.add(candidates[i]);
            combination(candidates,i,currSum + candidates[i],target,temp);
            //Remove the last element (Backtrack)
            temp.remove(temp.size() - 1); 
        }
        
    }
}
