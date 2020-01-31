// Time complexity is O(4^N) as we are making four decisions
// Space complexiy is O(n+m) where n is num length and m is binary operation
// This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.List;

public class Big67BinaryoperatorOnString {
	    List<String> result = new ArrayList<>();
	    public List<String> addOperators(String num, int target) {
	        backtrack("",num,target,0,0,0);
	        return result;
	    }
	    private void backtrack(String path,String num, int target, long cal, long tail, int index){
	        // base case:
	        if(index== num.length()){
	            if(cal==target){
	                result.add(path);
	                return;
	            }
	        }
	        // logic:
	        for(int i = index;i<num.length();i++){
	            if(i!=index && num.charAt(index)=='0') break;
	            long curr = Long.parseLong(num.substring(index,i+1));
	            if(index == 0){
	                backtrack(path + curr,num, target, curr,curr,i+1);
	            }
	            else{
	                backtrack(path + "+" + curr,num,target, cal+curr,+curr,i+1);
	                backtrack(path + "-" + curr,num,target,cal-curr,-curr,i+1);
	                backtrack(path + "*" + curr,num,target,cal-tail+ tail*curr,tail*curr,i+1);
	            }
	        }
	    }
	}