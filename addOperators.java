
// Runtime complexity = O(N*4^N) - 4 because of the 4 operators available so 4 exponential
// Space complexity - O(N) where N is the length of the nums array

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result=new ArrayList<>();
        if(num==null || num.length()==0)
            return result;
        helper(num,target,"",0,0,0);
        return result;
        
        
    }
    
    private void helper(String num,int target,String path,long calc,long tail,int index)
    {
        if(index==num.length()){
            if(target==calc)
            {
                result.add(path);
            }
        return;
        }
        for(int i=index;i<num.length();i++)
        {
            long curr=Long.parseLong(num.substring(index,i+1));
            if(index!=i && num.charAt(index)=='0') continue;
            if(index==0)
            {
                helper(num,target,path+curr,curr,curr,i+1);
            }
            else
            {
                // +
                helper(num,target,path+"+"+curr,calc+curr,curr,i+1);
                // -
                helper(num,target,path+"-"+curr,calc-curr,-curr,i+1);
                // * (Need to take care of precedance)
                helper(num,target,path+"*"+curr,calc-tail+curr*tail,curr*tail,i+1);
            }
        }
            
    }
}
