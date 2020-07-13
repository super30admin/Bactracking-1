class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result= new ArrayList<>();
        helper(result,"",num,target,0, 0,0);
        return result;
    }
    private void helper(List<String> result,String path,String num, int target, int index,int sum, int chnge){
        if(index==num.length() && target==sum){
            result.add(path);
        }
        for(int i=index;i<num.length();i++){
            int cur=Integer.parseInt(num.substring(index,i+1));
            if(index==0)
                helper(result,path+cur,num,target,i+1, sum+cur,cur); 
        // construct path with 3 possible combinations
            else{
                helper(result,path+"+"+cur,num,target,i+1, sum+cur,cur);
                helper(result,path+"-"+cur,num,target,i+1, sum-cur,-cur);
                helper(result,path+"*"+cur,num,target,i+1, sum-chnge+chnge*cur,sum*cur);
            }

        }
        
    }
}
