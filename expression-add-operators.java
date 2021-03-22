// Time Complexity :
O(4 ^ n) where n = length of input 
// Space Complexity :

// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    
     //define result
    List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        helper(num,target, 0, 0, 0, ""); 
        return result;
    }
    
    
    private void helper(String num, int target, int ind, long prevSum, long prevOperand,
                       String exp){
        //Define base case
        
        if(ind == num.length()){
           if(prevSum == target){
               result.add(exp);
           } 
            return;
        }
        
        //To handle grouping
        for(int i=ind;i<num.length();i++){
            long temp = Long.parseLong(num.substring(ind,i+1));
            
            if(num.charAt(ind) == '0' && ind != i){
                continue;
            }
            
            //If the ind we are at is 0
        if(ind == 0){
          helper(num,target, i+1, temp, temp,exp + temp);  
        }else{
            
        //When we have to perform addition
        helper(num,target, i+1, prevSum + temp, temp, exp+"+"+ temp);
            
        //When we have to perform substraction
         helper(num,target, i+1, prevSum - temp, -temp, exp+"-"+ temp); 
            
        //When we have to perform multiplication
         helper(num,target, i+1, prevSum-prevOperand + prevOperand * temp, prevOperand * temp, exp+"*"+temp);
        
            
        }
        
        
}
        
    }
}