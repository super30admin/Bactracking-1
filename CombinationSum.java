import java.util.ArrayList;
import java.util.List;

//Time Complexity=O(Traget/Min)+O(n)
//Space Complexity=O(n)
public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        helper(candidates,target,0, new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] candidates, int target,int i,List<Integer> path){
        //base
        if(i==candidates.length || target<0 ) return;
        if(target==0){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        //logic
        //no choose
        helper(candidates,target,i+1, path);
        // choose
        path.add(candidates[i]);
        helper(candidates,target-candidates[i],i, path);
        path.remove(path.size()-1);

    }
}
