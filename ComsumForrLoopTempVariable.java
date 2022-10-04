import java.util.ArrayList;
import java.util.List;

class ComsumForrLoopTempVariable {
     //tc&sc-o(2(m*n))

     public static void main(String args[])
     {
      int[] candi = {2,3,6,7};
      List<List<Integer>> res = combinationSum(candi,7);

     }
    static List<List<Integer>> result;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates.length == 0) return result;
       helper(candidates,target,0,new ArrayList<>());
        return result;
    }
    private static void helper(int[] candidates, int amount,int pivot,List<Integer> path)
    {
     //basecase
        if(amount == 0) 
        {
            result.add(path);
            return;
        }
        if(amount <0) return;
      //logic  
        for(int i = pivot;i<candidates.length;i++)
        {
            List<Integer> temp = new ArrayList<>(path);
            temp.add(candidates[i]);
            helper(candidates,amount-candidates[i],i,temp);
        }
        
    }
 
}