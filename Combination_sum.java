TC:O(2^n)
SC:O(n)

168 / 168 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 37.8 MB



class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
       List<List<Integer>> results = new ArrayList<>();
           
           if (candidates==null || candidates.length==0){
               return results;
           }
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        tofindCombinationstoTarget(results,combination,candidates,target,0);
        
            return results;
    }      
    private void tofindCombinationstoTarget(List<List<Integer>> results,List<Integer> combination, int [] candidates,int target,int startIndex)
    {
    if (target==0){
        results.add(new ArrayList<>(combination));
        return ;
    }
    
    for (int i=startIndex;i<candidates.length;i++){
        if(candidates[i] > target){
            break;
        }
        
      combination.add(candidates[i])  ;
      tofindCombinationstoTarget(results,combination,candidates,target-candidates[i],i);
      combination.remove(combination.size()-1);
    }
  }
 }
