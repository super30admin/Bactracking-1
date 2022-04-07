import java.util.ArrayList;
import java.util.List;

//Time Complexity: Exponential. Close estimation O(2^((T/M)+n)); where T= Target and M is min number in given array.
//Space Complexity: O(T/M) 

public class CombinationSum {		
	List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res= new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), 0);
        return res;
    }
       
    /**Approach: Recursion + Backtracking **/
    private void helper(int[] candidates, int target, List<Integer> path, int index){
        //base
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        
        //logic    
        for(int i=index; i<candidates.length; i++){
            //ACTION
            path.add(candidates[i]);
            //RECURSE
            helper(candidates, target-candidates[i], path, i); 
            //BACKTRACK
            path.remove(path.size()-1);
        }  
    }    
    
	// Driver code to test above 
	public static void main (String[] args) {
		CombinationSum ob = new CombinationSum();
    	int[] candidates= {2,3,6,7};    
    	int target=7;
		System.out.println("Unique combinations to make sum "+target+" with given candidates are: "+ob.combinationSum(candidates,target));
	}
}
