using System;
using System.Collections.Generic;
using System.Text;

namespace BackTracking
{
    public class ExpressionAddOperator
    {
        /*
       * T.C: 4 to the power n where 4 is number of recersive calls and n is length of string
       * S.C: exponetial as we are creating n number of strings 
       */
        List<string> Result;
        public IList<string> AddOperators(string num, int target)
        {
            Result = new List<string>();
            if (num == null || num.Length == 0)
                return Result;

            //helper(num, target, 0, 0, 0, "");

            BackTracking(num, target, 0, 0, 0, new StringBuilder());

            return Result;
        }

        private void helper(string num, int target, int index, long calc, long tail, string path)
        {
            //base
            if (index == num.Length)
            {
                if (calc == target)
                {
                    Result.Add(path);
                }
                return;
            }


            //logic
            for (int i = index; i < num.Length; i++)
            {
                if (i != index && num[index] == '0')
                    continue;
                long curr = long.Parse(num.Substring(index, i - index + 1));
                if (index == 0)
                {
                    helper(num, target, i + 1, curr, curr, path + curr);
                }
                else
                {
                    //+
                    helper(num, target, i + 1, calc + curr, curr, path + "+" + curr);

                    //-
                    helper(num, target, i + 1, calc - curr, -curr, path + "-" + curr);

                    //*
                    helper(num, target, i + 1, (calc - tail) + (tail * curr), (tail * curr), path + "*" + curr);
                }
            }

        }


        /*
         * T.C: 4 to the power n where 4 is number of recersive calls and n is length of string
         * S.C: n number of characters in the string builder.
         */

        private void BackTracking(string num, int target, int index, long calc, long tail, StringBuilder sb)
        {
            //base
            if (index == num.Length)
            {
                if (calc == target)
                {
                    Result.Add(sb.ToString());
                }
                return;
            }


            //logic
            for (int i = index; i < num.Length; i++)
            {
                if (i != index && num[index] == '0')
                    continue;
                int len = sb.Length;
                long curr = long.Parse(num.Substring(index, i - index + 1));
                if (index == 0)
                {
                    sb.Append(curr);
                    helper(num, target, i + 1, curr, curr, sb);
                    sb.Length = len;
                }
                else
                {
                    //+
                    sb.Append("+");
                    sb.Append(curr);
                    helper(num, target, i + 1, calc + curr, curr, sb);
                    sb.Length = len;

                    //-
                    sb.Append("-");
                    sb.Append(curr);
                    helper(num, target, i + 1, calc - curr, -curr, sb);
                    sb.Length = len;

                    //*
                    sb.Append("*");
                    sb.Append(curr);
                    helper(num, target, i + 1, (calc - tail) + (tail * curr), (tail * curr), sb);
                    sb.Length = len;
                }
            }

        }

    }
    }
}
