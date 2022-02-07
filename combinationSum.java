Time complexity : O(n!)
space complexity : O(1) as we are returning the same array list
was able to run on leetcode : yes



class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path=new ArrayList<>();
        helper(candidates,target,path,0);
        return result;
    }
    public void helper(int[] candidates,int target ,List<Integer>path,int index){
        if(target==0) {
            result.add(new ArrayList(path));
            return;
        }
        else if(target<0 || index>=candidates.length){
            return;
        }
        else{

            for(int i=index;i<candidates.length;i++){
                path.add(candidates[i]);
                helper(candidates,target-candidates[i],path,index);
                path.remove(path.size()-1);
                index=index+1;
            }

        }
    }}
