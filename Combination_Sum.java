import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(2^N)
//Space Complexity : O(N)
public class Combination_Sum {
   private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates,target,0,new ArrayList<>());
        return result;
    }
    
    public void helper(int[] candidates, int target, int pivot, List<Integer> path){
        //base
        //if sum list of numbers = target number
        if(target == 0){
          result.add(new ArrayList<>(path));
          return;
        }
        //if list has value in negative return 
        if(target < 0) return;
        
        //logic
        for(int i = pivot; i < candidates.length; i++){
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size()-1);
        }
    }
}