class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(candidates,target,path,0);
        return answer;

    }

    List<List<Integer>> answer;

    public void backtracking(int[] candidates,int target, List<Integer> path, int index){
        // base

        if(target<0){
            return;
        }else if(target == 0){
            answer.add(new ArrayList<>(path));
            return;
        }else if(index >= candidates.length){
            return;
        }

        // backtracking

        for(int i=index; i<candidates.length;i++){

            // add
            path.add(candidates[i]);
            // backtrack
            backtracking(candidates,target-candidates[i],path,i);
            // remove
            path.remove(path.size()-1);

        }
    }
}