class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res= new ArrayList<>();
        helper(num, target, "", 0, 0, 0);
        return res;
    }
    private void helper(String num, int target, String path, long calc, long tail, int index){
        //when index is at the end we return, if valid we add to result or simply return
        if(index==num.length()){
            if(calc==target){
                res.add(path);    
            }
            return;
        }
        
        for(int i=index;i<num.length();i++){
            long curr = Long.parseLong(num.substring(index, i+1));
            //to avoid numbers formation without zero
            if(index!=i && num.charAt(index)=='0') continue;
            //for the first index
            if(index ==0){
                helper(num, target, curr+path,curr, curr, i+1);
            }
            else{
                //+
                helper(num,target,path+'+'+curr,curr+calc, curr,i+1);
                //-
                helper(num,target,path+'-'+curr,calc-curr,-curr,i+1 );
                //*
                helper(num,target,path+'*'+curr,calc-tail+curr*tail, curr*tail,i+1);
            }
        }
    }
}