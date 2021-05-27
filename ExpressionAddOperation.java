/*
Desc : We check fo rall combinations of the numbers in the num string and the operators
for every wrong combination we backtrack and proceed the dfs.
Time Complexity : O(2^n)
Space Complexity : O(1)
*/

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length()==0) return result;
        helper(num,target,"",0,0,0);
        return result;
    }
    private void helper(String num, int target,String path,long calc,long tail,int index){
        //base
        if(index == num.length()){
            if(target == calc){
                result.add(path);
                return;
            }
        }
        //logic
        for(int i=index;i<num.length();i++){
            if(num.charAt(index)=='0' && index!=i) continue;
            long curr = Long.parseLong(num.substring(index,i+1));
            if(index == 0){
                helper(num,target,path+curr,curr,curr,i+1);
            }else{
                //+
                helper(num,target,path+'+'+curr,calc+curr,curr,i+1);
                //-
                helper(num,target,path+'-'+curr,calc-curr,-curr,i+1);
                //*
                helper(num,target,path+'*'+curr,calc-tail+tail*curr,tail*curr,i+1);
            }
        }
    }
}
