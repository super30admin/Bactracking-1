//Time complexity -- O(n) -- length od string
//Space complexity -- O(n) -- new arraylist for every positive case
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //sort the array
        Arrays.sort(candidates);
        backtrack(candidates, new ArrayList<>(), target, 0);
        return res;
        }
    public void backtrack(int[] candidate, List<Integer> curr,int result,int start){
        //base case
        if(result<0) return;
        else if(result == 0){
            res.add(new ArrayList(curr));
        }
        //logic
        else{
            for(int i=start;i<candidate.length; i++){
                curr.add(candidate[i]);
                backtrack(candidate, curr, result-candidate[i],i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}