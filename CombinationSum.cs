using System;
using System.Collections.Generic;
using System.Text;

namespace BackTracking
{
    class CombinationSumLC
    {
        List<List<int>> result;
        public List<List<int>> CombinationSum(int[] candidates, int target)
        {
            result = new List<List<int>>();
            if (candidates == null || candidates.Length == 0)
            {
                return result;
            }
            recurse(candidates, target, 0, new List<int>());
            //backtrack(candidates, target, 0, new List<int>());
            return result;
        }
        private void recurse(int[] candidates, int target, int index, List<int> path)
        {
            //base
            if (target == 0)
            {
                result.Add(path);
                return;
            }
            if (index == candidates.Length || target < 0)
            {
                return;
            }
            //logic
            ////choose Alternative way to run choose first
            //List<int> copy = new List<int>(path);
            //copy.Add(candidates[index]);
            //recurse(candidates, target - candidates[index], index, copy);

            //Do not choose
            recurse(candidates, target, index + 1, new List<int>(path));
            //choose
            recurse(candidates, target - candidates[index], index, new List<int>(path));
        }

        private void backtrack(int[] candidates, int target, int index, List<int> path)
        {
            //base
            if (target == 0)
            {
                result.Add(new List<int>(path));
                return;
            }
            if (index == candidates.Length || target < 0)
            {
                return;
            }
            //logic
            //Do not choose
            backtrack(candidates, target, index + 1, path);
            //Choose
            //action
            path.Add(candidates[index]);
            //recurse
            backtrack(candidates, target - candidates[index], index, path);
            //backtrack
            path.RemoveAt(path.Count - 1);
        }

        private void RecurseNewOption(int[] candidates, int target, int index, List<int> path)
        {
            //base
            if (target == 0)
            {
                result.Add(path);
                return;
            }
            if (target < 0)
            {
                return;
            }
            //logic
            for (int i = index; i < candidates.Length; i++)
            {
                List<int> copy = new List<int>(path);
                copy.Add(candidates[i]);
                //recurse
                recurse(candidates, target - candidates[i], i, copy);
            }
        }

        private void BackTrackNewOption(int[] candidates, int target, int index, List<int> path)
        {
            //base
            if (target == 0)
            {
                result.Add(new List<int>(path));
                return;
            }
            if (target < 0)
            {
                return;
            }
            //logic
            for (int i = index; i < candidates.Length; i++)
            {
                //action
                path.Add(candidates[i]);
                //recurse
                backtrack(candidates, target - candidates[i], i, path);
                //backtrack
                path.RemoveAt(path.Count - 1);
            }
        }

    }
}
