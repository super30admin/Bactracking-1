import java.util.List;
import java.util.ArrayList;

public class Combination{
    //recusrion
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)return result;
        helper(candidates,new ArrayList<>(),target, 0,0);
        return result;
    }
    private void helper(int[] candidates,List<Integer> temp,int target,int sum,int i){
        if(sum > target || i >= candidates.length)return;
        if(target == sum){
            result.add(temp);
            return;
        }
        //dont choose
        helper(candidates,new ArrayList<>(temp),target,sum,i+1);
        //choose
        temp.add(candidates[i]);
        helper(candidates,new ArrayList<>(temp),target,sum+candidates[i],i);
    }

    //backtracking
    public List<List<Integer>> combinationBacktrack(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)return result;
        backtrack(candidates,new ArrayList<>(),target, 0,0);
        return result;
    }
    private void backtrack(int[] candidates,List<Integer> temp,int target,int sum,int start){
        if(sum > target || start >= candidates.length)return;
        if(target == sum){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < candidates.length;i++){
            temp.add(candidates[i]);
            backtrack(candidates, temp, target, sum + candidates[i],i);
            temp.remove(temp.size()-1);
        }
    }

   
    
    public static void main(final String args[]) {
        Combination obj = new Combination();
        System.out.println(obj.combinationSum(new int[]{2,3,6,7},7));
        System.out.println(obj.combinationBacktrack(new int[]{2,3,6,7},7));

    }
}