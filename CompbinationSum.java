import java.util.ArrayList;
import java.util.List;
//Time Complexity : O(2^N) where N is the length of String
//Space Complexity :O(1)
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :

public class CompbinationSum {
	  List<List<Integer>> result = new ArrayList<>();
	  
	    public List<List<Integer>> combinationSumBacktracking(int[] candidates, int target) {
	      helperBacktracking(candidates,0,new ArrayList<>(),target);  
	        return result;
	    }
	    
	    public void helperBacktracking(int[] candidates, int idx,List<Integer> path, int target){
	        // base
	        if(target < 0 || idx==candidates.length)
	            return;
	      
	        if(target == 0){
	            result.add(new ArrayList<>(path));
	            return;
	        }
	        
	        // logic 
	        // choose
	        path.add(candidates[idx]);
	        helperBacktracking(candidates,idx,path,target-candidates[idx]);     
	        
	        // not choose 
	        path.remove(path.size()-1);
	        helperBacktracking(candidates,idx+1,path,target);     
	    }
	    
	    
	    public void helperBrutForceRecursion(int[] candidates, int idx,List<Integer> path, int target){
	        // base
	        if(target < 0 || idx==candidates.length)
	            return;
	      
	        if(target == 0){
	            result.add(path);
	            return;
	        }
	        
	        // logic 
	        // choose
	        List<Integer> li = new ArrayList<>(path);
	        li.add(candidates[idx]);
	        
	        helperBrutForceRecursion(candidates,idx,li,target-candidates[idx]);    
	                // not choose 
	    
	        helperBrutForceRecursion(candidates,idx+1,path,target);   
	       
	    }
	    
	    public void helperForLoopRecursionBacktracking(int[] candidates, int idx,List<Integer> path, int target){
	        // base
	        if(target < 0 || idx==candidates.length)
	            return;
	      
	        if(target == 0){
	            result.add(new ArrayList<>(path));
	            return;
	        }
	        
	         for(int i=idx;i<candidates.length;i++){
	            path.add(candidates[i]);
	            helperForLoopRecursionBacktracking(candidates,i,path,target-candidates[i]);
	            path.remove(path.size()-1);
	          }
	    }
	    
	    public void helperForLoopRecursionBrutforce(int[] candidates, int idx,List<Integer> path, int target){
	        // base
	        if(target < 0 || idx==candidates.length)
	            return;
	      
	        if(target == 0){
	            result.add(path);
	            return;
	        }
	        
	         for(int i=idx;i<candidates.length;i++){
	            List<Integer> li = new ArrayList<>(path);
	             li.add(candidates[i]);
	             helperForLoopRecursionBrutforce(candidates,i,li,target-candidates[i]);
	            
	          }
	    }
	    
	    
}
