//exponetial time and space
//passed all leetcode cases
//used recursive approach discussed in class

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();

        helper(num,target,0,0,"",0);
        return result;

    }
    private void helper(String num, int target,long calc, long tail, String path,int index){
        if(index==num.length()){
            if(calc==target){
                result.add(path);
                return;
            }
        }


        for(int i=index;i<num.length();i++){
            if(index!=i &&num.charAt(index)=='0') break;
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index==0){
                calc = curr;
                tail = curr;
                helper(num,target,curr,curr,path+curr,i+1);
            }else{
                helper(num,target,calc+curr,curr,path+"+"+curr,i+1);
                helper(num,target,calc-curr,-curr,path+"-"+curr,i+1);
                helper(num,target,calc-tail+tail*curr,tail*curr,path+"*"+curr,i+1);
            }
        }
    }
}