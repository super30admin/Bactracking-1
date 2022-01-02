import java.util.*;

// Time Complexity : O(4^n) at every recursive step we have 4 decisions , and recursion continues till n , n being the length of the array
// Space Complexity :O(n) maximum calls in the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result= new ArrayList<>();
        if(num==null||num.length()==0){
            return result;
        }
        helper(num,target,0,0,"",0);
        return result;
    }
    private void helper(String num, int target, int index,long calc, String path,long tail){
        
        //base case
        if(index==num.length()){
            if(target==calc){
            result.add(path);
            }
            return;
        }
        
        //logic
        for(int i=index;i<num.length();i++){
            if(index!=i && num.charAt(index)=='0') continue;
            String n= num.substring(index,i+1);
            long digit=Long.parseLong(n);
            
            if(index==0)
            // to avoid adding operator at the first position
                helper(num,target,i+1,calc+digit,path+n,tail+digit);
            else
            {
                //case 1 addition
              helper(num,target,i+1,calc+digit,path+"+"+ n,digit);
            //case 2 substraction
            helper(num,target,i+1,calc-digit,path+"-"+ n,-digit);
            
            //case 3 multiplication
            helper(num,target,i+1,calc-tail+(tail*digit),path+"*"+ n,tail*digit);
            }
            
        }
    }
}