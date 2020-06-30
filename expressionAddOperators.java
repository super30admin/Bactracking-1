// Time Complexity :O(4^n) n-length of the String
// Space Complexity :O(n)  
// Did this code successfully run on Leetcode :yes
// Problems Faced: -
//BackTracking
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result=new ArrayList<String>();
        if(num==null || num.length()==0) return result;
        backtracking(num,target,new StringBuilder(),0,0,0);  
        return result;
    }
    private void backtracking(String num,int target,StringBuilder path,long calc,long tail,int index)
    {
        if(index==num.length())
        {
          if(target==calc)
          result.add(path.toString());
            return;
        }
        
        for(int i=index;i<num.length();i++)
        {
            if(num.charAt(index)=='0' && index!=i) break;
            long curr=Long.parseLong(num.substring(index,i+1));
            int len=path.length();
            if(index==0)
            {
                path.append(curr);
                backtracking(num,target,path,curr,curr,i+1);
                path.setLength(len);
            }else
            {
                path.append("+");
                path.append(curr);
                backtracking(num,target,path,calc+curr,curr,i+1);
                path.setLength(len);                
                
                path.append("-");
                path.append(curr);
                backtracking(num,target,path,calc-curr,-curr,i+1);
                path.setLength(len);
                
                path.append("*");
                path.append(curr);
                backtracking(num,target,path,calc-tail+tail*curr,tail*curr,i+1);
                path.setLength(len);
            }
        }
    }
}

// Recursion
/*
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result=new ArrayList<String>();
        if(num==null || num.length()==0) return result;
        helper(num,target,"",0,0,0);  
        return result;
    }
    private void helper(String num,int target,String path,long calc,long tail,int index)
    {
        if(index==num.length())
        {
          if(target==calc)
          result.add(path);
            return;
        }
        
        for(int i=index;i<num.length();i++)
        {
            if(num.charAt(index)=='0' && index!=i) break;
            long curr=Long.parseLong(num.substring(index,i+1));
            if(index==0)
            {
                helper(num,target,path+curr,curr,curr,i+1);
            }else
            {
                helper(num,target,path+"+"+curr,calc+curr,curr,i+1);
                helper(num,target,path+"-"+curr,calc-curr,-curr,i+1);
                helper(num,target,path+"*"+curr,calc-tail+tail*curr,tail*curr,i+1);
            }
        }
    }
}
*/