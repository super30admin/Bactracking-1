class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        helper(result, target, candidates, 0, new ArrayList<Integer>());
        return result;
    }

    public static void helper(List<List<Integer>> result, int remaining, int candidates[], int index, List<Integer> currentRes){
        if(remaining==0)
            result.add(new ArrayList<>(currentRes));

        for(int i=index;i<candidates.length;i++){
            if(candidates[i]<=remaining){
                currentRes.add(candidates[i]);
                helper(result, remaining-candidates[i], candidates, i, currentRes);
                currentRes.remove(new Integer(candidates[i]));
            }
        }
        return;
    }
}