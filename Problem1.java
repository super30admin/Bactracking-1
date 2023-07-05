//Time Complexity: O(n * n)
//Space Complexity: O(n * n)


class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        output = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>());

        return output;
    }

    private void dfs(int[] candidates, int target, int idx, List<Integer> res) {

        if(target == 0) {
            System.out.println(res);
            output.add(new ArrayList<>(res));
            return;
        }

        if(idx >= candidates.length || candidates[idx] > target) {
            return;
        }

        res.add(candidates[idx]);  
        dfs(candidates, target - candidates[idx], idx, res);
        res.remove(res.size()  - 1);
        dfs(candidates, target, idx + 1, res);
    }
}