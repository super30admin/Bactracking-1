
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// 	Simple but still not intuitive

// Your code here along with comments explaining your approach
class Solution {
   List<String> result = new ArrayList();
    
    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) return result;
        
        dfsHelper("",0,0,0,num,target);
        
        return result;
        
    }
    
    
    public void dfsHelper(String candidate, int index, int total, int prev_add, String num, int target)
    {
        // Base case 
        
        if(index == num.length() && total == target)  result.add(candidate);
        
        
        for(int j = index + 1 ; j <= num.length(); j++)
        {
              String s = "";
        try{
                
              s  = num.substring(index,j);
            
              int d = Integer.parseInt(s);
            
              if(num.charAt(index) == '0' && !s.equals("0")) continue;
            
            
            if(candidate.isEmpty()) 
                dfsHelper(s, j,d,d,num,target);
            
            else{
                
                dfsHelper(candidate + '+' + s, j, total+d,d,num,target);
                dfsHelper(candidate + '-' + s, j, total-d,-d,num,target);
                dfsHelper(candidate + '*' + s, j, total-prev_add + prev_add*d, prev_add*d,num,target);
                
            }
                
        }catch(Exception e)
        {
               System.out.println(s) ;
        }
               
        }
    }
}