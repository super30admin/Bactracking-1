//Time Complexity: O(2^n)  where n is the number of elements
//Space Complexity: O(target/min(n)) n is the smallest number in the array

<----Backtrack using for loop---->
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(candidates, 0, target, 0, temp, result);
        return result;
    }
 
    private void backtrack(int[] candidates, int start, int target, int sum, List<Integer> list, List<List<Integer>> result){
        if(sum>target){
            return;
        }

        if(sum==target){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            list.add(candidates[i]);
            backtrack(candidates, i, target, sum+candidates[i], list, result); // not i+1 because we can reuse same elements
            list.remove(list.size()-1); //backtrack - remove invalid candidates
        }
    }
}

<-----Recursive---->
class Solution {
    List<List<Integer>> result;
    int targetToReach;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        targetToReach = target;
        result = new ArrayList<>();        
        backtrack(candidates, temp, 0, 0);
        return result;
    }
 
    private void backtrack(int[] candidates, List<Integer> temp, int sum, int i){
        
        if(i == candidates.length) return;
        
        if(sum > targetToReach){
            return;
        }

        if(sum == targetToReach){
            result.add(new ArrayList<>(temp));
            return;
        }
	    backtrack(candidates, temp, sum, i + 1);         
        temp.add(candidates[i]);
        backtrack(candidates, temp, sum+candidates[i], i); 
        temp.remove(temp.size()-1);        
    }
}

<------DP------>

class Solution {
     public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // sort candidates to try them in asc order
        Arrays.sort(candidates);         
        List<List<Integer>>[] dp = new ArrayList[target+1];    
    
        for(int t=0; t<=target; t++) {          
            dp[t] = new ArrayList();         
            List<List<Integer>> combList = new ArrayList();
            
            // for each t, find possible combinations
            for(int j=0; j<candidates.length && candidates[j] <= t; j++) {
                if(candidates[j] == t) {
                    combList.add(Arrays.asList(candidates[j])); // itself can form a list
                } else{
                    for(List<Integer> prevlist: dp[t-candidates[j]]) {  
                        if(candidates[j] >= prevlist.get(prevlist.size()-1)){
                            List temp = new ArrayList(prevlist); // temp is needed since 
                            temp.add(candidates[j]); // cannot edit prevlist inside for each loop
                            combList.add(temp);
                        }
                    }
                }
            }
                dp[t] = combList;
        }
        return dp[target];
    }    
}