TC:Exponential
SC:o(n*n) n length of string
 
used normal for loop based recursion through out the length of the string





class Solution {
    List<String>result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        helper(num,target,0,0,0,"");
        return result;
    }
    private void helper(String num,int target,int idx,long calc,long tail,String s){
        //base
        if(idx == num.length()){
            if(calc==target)
            {
                result.add(s);
            
            }
            return;
        }
        
        //logic
        for(int i=idx;i<num.length();i++){
            if(num.charAt(idx)=='0' &&  i!=idx) continue;
            String substr = num.substring(idx,i+1);
            long cur = Long.parseLong(substr);
            //first character of every i
            if(idx == 0)  helper(num,target,i+1,calc+cur,cur,s+cur);
            else{
                //+
                helper(num,target,i+1,calc+cur,cur,s+"+"+cur);
                //-
                helper(num,target,i+1,calc-cur,-cur,s+"-"+cur);
                //*
                helper(num,target,i+1,calc-tail+tail*cur,tail*cur,s+"*"+cur);
            }
            
        }
    }
}