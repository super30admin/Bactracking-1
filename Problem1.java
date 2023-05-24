// Time: (2^N)

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] candidates, int target ,int idx,List<Integer> list ){
        if(target<0) return;
        if(target == 0){
            result.add(new ArrayList<>(list));
        }
        for(int i = idx ; i < candidates.length ; i++){
            list.add(candidates[i]);
            System.out.println(list);

            dfs(candidates,target-candidates[i],0,list);
            list.remove(list.size()-1);
        }
    }
}
