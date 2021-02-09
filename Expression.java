// Time Complexity : O(3^n) n is length of number string
// Space Complexity : Not sure 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No 
class Solution {
    List<String> result;
    int targetValue;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>(); 
        targetValue = target;
        if(num.length()==0 || num==null) return result;
        helper(num,"",0,0,0);
        return result;
    }
    
    public void helper(String num, String path,int index,long calc, long tail)
    {
        //base
        if(index==num.length())
        {
            if(calc == targetValue)
            {
                result.add(path);
            }
            return;
        }
        
        
        // logic
        for(int i=index;i<num.length();i++)
        {
            // preceeding 0's
            if(index!=i && num.charAt(index) =='0') continue;
            
            
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index==0)
            {
             helper(num,path+curr,i+1,curr,curr);
            }else{
                
                // +
                helper(num,path+"+"+curr,i+1,calc+curr,curr);
                
                // -
                helper(num,path+"-"+curr,i+1,calc-curr,-curr);
                
                // *
                helper(num,path+"*"+curr,i+1,calc-tail+tail*curr,tail*curr);
            }   
        }
    }
}
