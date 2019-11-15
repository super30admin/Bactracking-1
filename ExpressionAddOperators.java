// Time Complexity : O(exp^N)
// Space Complexity :O(1) + recursion stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Nope.


// Your code here along with comments explaining your approach
class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if(null == num || num.length() == 0)return result;
        helper("",num,target,0,0,0,result);
        return result;
    }
    private void helper(String path, String num, int target, int index, long calculated,long tail,List<String> result){
        if(index == num.length()){
            if(calculated == target){
                result.add(path);
            }
            return;
        }
        for(int i = index; i < num.length(); i++){
            if(i != index && num.charAt(index) == '0'){break;}
            Long curr = Long.parseLong(num.substring(index,i+1));
            if( 0 == index){
                helper(path +curr,num,target,i+1,curr,curr,result);
            }else{
                helper(path +'+'+curr,num,target,i+1,calculated+curr,curr,result);
                helper(path +'-'+curr,num,target,i+1,calculated-curr,-curr,result);
                helper(path +'*'+curr,num,target,i+1,calculated-tail+tail*curr,tail*curr,result);
            }
        }
    }
}