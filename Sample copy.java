//Time Complexity:O(2^n)
//Space Complexity:O(2^n)
class Solution {
    List<List<Integer>> result;
    int tar;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result= new ArrayList();
        tar=target;
        if(candidates.length==0||candidates==null)
           return result;
        
        helper(candidates,0,new ArrayList(),0);
        
        return result;
    }
    private void helper(int[] candidates,int index,List<Integer> temp,int sum)
    {
        //base case
        if(index==candidates.length||sum>tar)
        {
            return;
        }
        if(sum==tar)
        {
            result.add(temp);
            return;
        }
        //dont pick the coin
        helper(candidates,index+1,new ArrayList(temp),sum);
        //pick the coin
        temp.add(candidates[index]);
        helper(candidates,index,new ArrayList(temp),sum+candidates[index]);
    }
}
-------------------------------------------------------------------------------------
//Time Complexity:O(2^n)
//Space Complexity:O(2^n)
//Backtrack Solution
class Solution {
    List<List<Integer>> result;
    int tar;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result= new ArrayList();
        tar=target;
        if(candidates.length==0||candidates==null)
           return result;
        
        helper(candidates,new ArrayList(),0,0);
        
        return result;
    }
    private void helper(int[] candidates,List<Integer> temp,int sum,int index)
    {
        //base case
        if(sum>tar)
        {   
            return;
        }
        if(sum==tar)
        {
            result.add(new ArrayList(temp));
            return;
        }
        //dont pick the coin
        for(int i=index;i<candidates.length;i++)
        {
            temp.add(candidates[i]);
        helper(candidates,temp,sum+candidates[i],i);
            temp.remove(temp.size() - 1);

        }
        }
}

------------------------------------------------------------------------
//Time Complexity:O(3^n)
//Space Complexity:O(3^n)

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}
