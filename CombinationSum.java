import java.util.*;
public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        if(candidates==null) return result;
        helper(candidates,target,0,new ArrayList<>());
        return result;

    }
    private void helper(int[] candidates,int amount,int pivot,List<Integer> path){
        //base
        if(amount<0) return;
        if(amount==0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=pivot;i< candidates.length;i++){
            path.add(candidates[i]);
            helper(candidates,amount-candidates[i],i,path);
            path.remove(path.size()-1);


        }
    }

    public static void main(String[] args) {
        CombinationSum s = new CombinationSum();
        List<List<Integer>> res = s.combinationSum(new int[]{2,3,6,7} , 7);
        System.out.println(res);
    }
}
