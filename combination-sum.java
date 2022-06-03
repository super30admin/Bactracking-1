//Time Complexity: O(n)
//Space Complexity:o(1)
//Did this code successfully run on Leetcode :Yes

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> scombo = new ArrayList<>();
        tryCombo(candidates, target, 0, new ArrayList<>(), scombo);
        return scombo;
    }

    public void tryCombo(int[] candidates, int target, int idxCandidate, List<Integer> currentCombo, List<List<Integer>> combos)
    {
        if (target == 0)
        {
            combos.add(currentCombo);
            return;
        }
        if (target < 0)
        {
            return;
        }

        for (int i = idxCandidate; i < candidates.length; i++)
        {
            int cur = candidates[i];
            if (target - cur < 0)
            {
                continue;
            }

            List<Integer> list = new ArrayList<>(currentCombo);
            list.add(cur);

            tryCombo(candidates, target - cur, i, list, combos);
        }
    }
}