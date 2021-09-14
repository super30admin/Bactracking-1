using System;
using System.Collections.Generic;
using System.Text;

namespace BackTracking
{
    //TC: O(n * 2^n)
    //SC: O(n) recursive stack
    class ExpressionAddOperatorsLC
    {
        List<string> result;
        int goal;
        public List<string> AddOperators(string num, int target)
        {
            result = new List<string>();
            if (num == null || num.Length == 0)
            {
                return result;
            }
            goal = target;
            helper(num, 0, 0, 0, "");
            return result;
        }
        //recursion
        private void helper(string num, int index, long calc, long tail, string path)
        {
            //base

            //logic
            for (int i = index; i < num.Length; i++)
            {
                if (num[index] == '0' && index != i)
                {
                    continue;
                }
                long curr = long.Parse(num.Substring(index, i + 1));
                if (index == 0)
                {
                    helper(num, i + 1, curr, curr, path + curr);
                }
                else
                {
                    //+
                    helper(num, i + 1, calc + curr, curr, path + "+" + curr);
                    //-
                    helper(num, i + 1, calc - curr, -curr, path + "-" + curr);
                    //*
                    helper(num, i + 1, calc - tail + (tail * curr), tail * curr, path + "*" + curr);
                }
            }
        }
    }
}
