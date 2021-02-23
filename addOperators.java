// Time Complexity : O(4^n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    
    List<String> result = new ArrayList<String>();
    public List<String> addOperators(String num, int target) {
        

        if(num == null || num.length() == 0) {
            return result;
        }

        // equation:String, num, target, prev, prevOp
        helper(0, num, target, "", 0, 0, 0);
        
        return result;
    }
    
    public void helper(int start, String num, int target, String eq, long prev, long prevMul, long eval) {
        
        
        if(start==num.length()) {
            
            if(target==eval) {
                
                result.add(eq);
                
            }
            return;
        }
        
        
        for(int i = start;i<num.length(); i++) {
            if(i != start && num.charAt(start) == '0') break;
            long val = Long.parseLong(num.substring(start, i + 1));
            
            if(start==0) {
            
                helper(i+1, num, target, eq+val, val, val, val);
            
            } else {
                
                // Add
                helper(i+1, num, target, eq+"+"+val, val, val, eval+val);
                
                // Sub
                helper(i+1, num, target, eq+"-"+val, val, -val, eval-val);
                
                // Mul
                helper(i+1, num, target, eq+"*"+val, val, val*prevMul, eval-prevMul + prevMul * val);
                
            }
            
        }
        
    }

}
