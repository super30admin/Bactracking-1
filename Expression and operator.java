// Time complexity 0(4^n) exponential
// sapce complexity 0(n) length of string
// code successfully executed in leetcode
class Solution {
    List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
         //edge case 
        if(num == null) return result;
        backtrack("",num,target,0,0,0);
        return result;
    }
    private void backtrack(String path,String num, int target,long calculated,long tail,int index){
        //edge case
         if(index == num.length() && calculated==target ){
                 result.add(path);
                 return;
         }
        
        //base case 
        for(int i=index;i<num.length();i++)
        {
            long curr = Long.parseLong(num.substring(index,i+1));
            if(i!=index && num.charAt(index)=='0') break;
            if(index==0){
                backtrack(path+curr,num,target,curr,curr,i+1);
            } else {
                backtrack(path + "+" + curr, num, target, calculated+curr, +curr, i+1);
                backtrack(path + "-" + curr,num,target,calculated-curr,-curr,i+1);
                backtrack(path + "*" + curr,num,target, calculated-tail + (tail*curr), (tail*curr),i+1);

            }
        }
    }
}
    
