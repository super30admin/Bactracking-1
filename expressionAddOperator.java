/*Time COmplexity O(4^n) we are making 4 decisions at each character
Space complexity exponential*/

class Solution {
    List<String> result;
    int t;
    public List<String> addOperators(String num, int target) {
        result=new ArrayList<>();
        t=target;
        if(num.length()==0||num==null) return result;
        helper(num,0,0,0,"");
        return result;
    }
    private void helper(String num,int index,long calc,long tail,String path){
        //base condition when index reaches to the last check if calculated value is equal to         target and add to result
        if(index==num.length()){
            if(calc==t){
               result.add(path);
            }  
            return;
        }
        //logic
        
        for(int i=index;i < num.length();i++){
            //if there are any preceding zeros then continue
            if(index!=i && num.charAt(index)=='0') continue;
            //parse the substring
            long curr=Long.parseLong(num.substring(index,i+1));
            //if index is at 0 no operation to be performed just add it to path
            if(index==0){
                helper(num,i+1,curr,curr,path+curr);
            }
            else{
                //+
                helper(num,i+1,calc+curr,curr,path+"+"+curr);
                //-
                helper(num,i+1,calc-curr,-curr,path+"-"+curr);
                //*
                helper(num,i+1,calc - tail + tail * curr,tail*curr,path+"*"+curr);
                
            }
        }
        
    }
}