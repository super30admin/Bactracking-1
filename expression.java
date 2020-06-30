//Time complexity:O(4^n)
//Space complexity:O(n)

class Solution {
    List<String> result;
    int res;
    public List<String> addOperators(String num, int target) {
        result=new ArrayList();
        res=target;
        if(num==null || num.length()==0){
            return result;
        }
        helper(num,"",0,0,0);
           return result;  
    }
    
    private void helper(String num, String path,long calc,long tail,int start){
        //base
        if(start==num.length()){
            if(calc==res){
            result.add(path);
                return;
            }
        }
        //logic
        for(int i=start;i<num.length();i++){
            if(i!=start && num.charAt(start)=='0'){
                break;
            }
            long curr=Long.parseLong(num.substring(start,i+1));
            if(start==0){
                helper(num,path+curr,curr,curr,i+1);
            }
            else{
                helper(num,path+"+"+curr,calc+curr,curr,i+1);
                helper(num,path+"-"+curr,calc-curr,-curr,i+1);
                helper(num,path+"*"+curr,calc-tail+(tail*curr),tail*curr,i+1);
            }
        }
    }
}