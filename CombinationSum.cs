using System;
using System.Collections.Generic;
using System.Text;

namespace BackTracking
{
    public class CombinationSum
    {
        /*
         * T.C: 2 power of n where 2 is no of recursion call and n is number of condiates
         * S.C: In case of Recursion it is exponetial as we are creating new path every recursive call
         * IN case of Backtracking it is O(n) as we create only one list with n number of element.
         * 
         */
        List<IList<int>> result;
        public IList<IList<int>> GetCombinationSum(int[] candidates, int target)
        {
            result = new List<IList<int>>();
            helper(candidates, 0, target, new List<int>());

            return result;
        }


        //Recursion
        //private void helper(int[] candidates, int index, int target, List<int> path)
        //{
        //    //base
        //    if (target < 0 || index == candidates.Length)
        //    {
        //        return;
        //    }

        //    //logic
        //    if (target == 0)
        //    {
        //        result.Add(path);
        //        return;
        //    }

        //    // not choose case 0
        //    helper(candidates, index + 1, target, new List<int>(path));

        //    //case 1 choose
        //    path.Add(candidates[index]);
        //    helper(candidates, index, target - candidates[index], new List<int>(path));
        //}


        //backtracking
        private void helper(int[] candidates, int index, int target, List<int> path)
        {
            //base
            if (target < 0 || index == candidates.Length)
            {
                return;
            }

            //logic
            if (target == 0)
            {
                result.Add(new List<int>(path));
                return;
            }

            // not choose case 0
            helper(candidates, index + 1, target, path);

            //case 1 choose
            //action
            path.Add(candidates[index]);
            //recurse
            helper(candidates, index, target - candidates[index], path);

            //backtrack
            path.RemoveAt(path.Count - 1);
        }


    }
}
