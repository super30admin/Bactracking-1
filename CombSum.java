
	//Backtracking
public class CombSum {
	     List<List<Integer>> result;
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        result = new ArrayList<>();
	        if(candidates == null || candidates.length == 0) return result;
	        helper(candidates, target, 0 , new ArrayList<>());
	        return result;
	    }
	    
	    private void helper( int[] candidates, int target, int i, List<Integer> path ){
	        //base
	        if(target == 0){
	            result.add(new ArrayList<>(path));
	            return;
	        }   
	        if(i == candidates.length || target < 0 ) return;
	                

	        //not choose
	         helper(candidates, target, i+1, path);   
	        
	        //choose
	        path.add(candidates[i]);
	        helper(candidates, target - candidates[i], i , path);
	        path.remove(path.size()-1);
	           
	    }
	}