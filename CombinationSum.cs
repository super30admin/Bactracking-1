using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity : O(n)
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No
    public class CombinationSum
    {
        IList<IList<int>> result;
        public IList<IList<int>> CombinationSumREC(int[] candidates, int target)
        {
            result = new List<IList<int>>();
            if (candidates == null || candidates.Length == 0) return result;
            helper(candidates, target, 0, new List<int>());
            return result;
        }

        private void helper(int[] candidates, int target, int idx, List<int> path)
        {
            //base
            if (target == 0)
            {
                result.Add(new List<int>(path));
                return;
            }
            if (target < 0) return;
            //logic
            for (int i = idx; i < candidates.Length; i++)
            {
                //action
                path.Add(candidates[i]);
                //recurse
                helper(candidates, target - candidates[i], i, path);
                //backtrack
                path.RemoveAt(path.Count - 1);
            }
        }
    }
}
