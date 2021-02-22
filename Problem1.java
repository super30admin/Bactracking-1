//Time complexity:  O(N^N)
//Space copmplexity:O(max depth of recursion tree)
//Ran on leetcode:Yes
//Solution with comments:

class Solution {
      List<List<Integer>> out= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         recursive(candidates,0,target,new ArrayList<>());//starting with first value
         return out;
    }
    
    public void recursive(int[] candidates, int index ,int target, List<Integer> path){
        if(target<0) return ;
        if(target==0) {
                out.add(new LinkedList<>(path));//target reached so we are at correct path
                return;
        }
        for(int i=index;i<candidates.length;i++){
            path.add(candidates[i]);//adding all the indexes for the array length
            recursive(candidates,i,target-candidates[i],path);// check if next candidate can achieve target, next candidate can be the same candidate.
            path.remove(path.size()-1);
        }
    }
}