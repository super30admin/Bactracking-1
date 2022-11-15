//time = 2^(t/min)
//space = t/min

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> arr = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        combinationSum(candidates, 0, target);

        return result;
    }

    private void combinationSum(int[] candidates, int index, int target) {

        if (target == 0) {
            result.add(new ArrayList<>(arr));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        combinationSum(candidates, index + 1, target);

        arr.add(candidates[index]);

        combinationSum(candidates, index, target - candidates[index]);

        arr.remove(arr.size() - 1);

    }

}