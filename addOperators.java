class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<String>();
        if(num.length()==0) return res;
        helper(num,target,0,"",0,0);
        
        return res;
    }
    
    private void helper(String num, int target,int index,String path, long tail,long cal){
        
        //Base
        if(index==num.length()){
            if(cal==target){
                res.add(path);
            }
            return;
        }

        //Logic
        for(int i=index;i<num.length();i++){
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index!=i && num.charAt(index)=='0') continue;
            if(index==0){
                helper(num,target,i+1,path + curr,curr,curr);
            }
            else{
                
                //- case
                    helper(num,target,i+1,path+"-"+curr,-curr,cal-curr);
                //+ case
                    helper(num,target,i+1,path+"+"+curr,curr,cal+curr);
                //* case
                    helper(num,target,i+1,path+"*"+curr,tail*curr,cal-tail + curr*tail);
                
            }
        }
        
    }
}