/****
 * 
 * Time Complexity: O(N×4^N)
 * Space complexity: O(N)
 */

class Solution {
    
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result =  new ArrayList<>();
        helper(num,target,new String(),0,0,0);
        return result;
    }
    
    public void helper(String input, int target, String expr, long prev, long curr, int index)
    {
        if(index == input.length())
        {
            if(curr == target)
            {
                result.add(expr);
            }
            return;
        }
        
        for(int i = index;i<input.length();i++)
        { 
            if(index!=i && input.charAt(index) == '0') break;
            
            long elem = Long.parseLong(input.substring(index,i+1));
            if(index==0)
            {
                helper(input,target,expr+elem,elem,elem,i+1);   
            }
            else
            {
                helper(input,target,expr+"+"+elem,elem,curr+elem,i+1);
                helper(input,target,expr+"-"+elem,-elem,curr-elem,i+1);
                helper(input,target,expr+"*"+elem,elem*prev,curr-prev +prev*elem,i+1 );
            }
        }
    }
}