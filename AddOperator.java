import java.util.ArrayList;
import java.util.List;
//Time Complexity : O(N * 3^N) where N is the length of String,N is for SubString and 3^N for recursion
//Space Complexity :O(N) for String builder 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :

public class AddOperator {
	 List<String> result;
	    
	    public List<String> addOperators(String num, int target) {
	        result = new ArrayList<String>();
	        helper(num,0,new StringBuilder(),0,0,target);
	        return result;
	    }
	    
	    public void helper(String num, int idx,StringBuilder sb,long calc,long tail,int target){
	        // base case 
	        if(idx == num.length()){
	            if(target == calc){
	                result.add(sb.toString());
	            }
	            return;
	        }
	        
	        // logic 
	        for(int i=idx;i<num.length();i++){
	           // preeceding zero "105 ,5  test case should not have 1+05 as answer"
	            if(num.charAt(idx) =='0' && i!=idx)
	                continue;
	            long curr = Long.parseLong(num.substring(idx,i+1));
	            
	            int len = sb.length();
	           
	            if(idx==0){
	                sb.append(curr);
	                helper(num,i+1,sb,curr,curr,target);
	                sb.setLength(len);
	            }else{
	                // +
	                sb.append("+");
	                sb.append(curr);
	                helper(num,i+1,sb,calc+curr,+curr,target);
	                sb.setLength(len);
	                // - 
	                sb.append("-");
	                sb.append(curr);
	                helper(num,i+1,sb,calc-curr,-curr,target);
	                sb.setLength(len);
	                 // * 
	                sb.append("*");
	                sb.append(curr);
	                helper(num,i+1,sb,calc - tail + tail*curr,tail*curr,target);
	                sb.setLength(len);
	            }
	               
	        }
	    }
}
