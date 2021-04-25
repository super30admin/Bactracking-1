// combination Sum 
import java.util.ArrayList;
import java.util.List;
//tc - O(2^n) helper method
//sc-O(2^n) recursive stack, also path list


class Problem1{
    List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args){
        int[] arr = {2,3,6,7};
        Problem1 p = new Problem1();
        System.out.println(p.combinationSum(arr, 7));
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates == null || candidates.length==0){
            return res;
        }
        helper(candidates, 0, target, new ArrayList<>());
        return res;
    }
    public void helper(int[] candidates, int index,int target, List<Integer> path){
        ///base
        if(index== candidates.length || target < 0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        //logicc

        //first chose
        path.add(candidates[index]);
        helper(candidates,index,target-candidates[index],path);
        //then remove
        path.remove(path.size()-1);
        helper(candidates, index+1,target, path);




    }
    
}