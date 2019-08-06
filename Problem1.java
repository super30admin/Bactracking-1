// Time Complexity : exponential , don't know exact complexity
// Space Complexity :O(1) ~ O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach:
//1 . For each candidate we have two options, whether to choose or not.
//2 .  If we choose him , then we can subtract target from candidate value and repeat same process till target reaches 0
//and add it to resultant list if target is 0.
//3. If we don't choose then we repeat the above process with remaining elements and same target value.
List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> templist = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,0,target,templist);
        return result;
    }
    
    public void helper(int[] candidates,int start,int remaining,List<Integer> templist){
        if(start>=candidates.length|| (remaining<candidates[start] && remaining >0))   return;
        if(remaining == 0){
            //templist.add(candidates[start]);
            result.add(templist);
            templist = new ArrayList<>();
            return;
        }
       
        helper(candidates,start+1,remaining,new ArrayList<>(templist));
         //List<Integer> empty = new ArrayList<>();
        templist.add(candidates[start]);
        
        helper(candidates,start,remaining-candidates[start],templist);
    }
