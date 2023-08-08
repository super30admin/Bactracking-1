package BackTracking;

import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(4^n)
// Space Complexity : O(h) h-> depth of recursive stack
// Did this code successfully run on Leetcode : Yes

public class ExpAddOperators {

    List<String> result;
    public List<String> addOperators(String num, int target) {

        result = new ArrayList<>();
        helper(num, target, new StringBuilder(),0, 0L,0L);
        return result;
    }

    public void helper(String num, int target, StringBuilder path, int pivot, Long tail, Long calc)
    {
        if(pivot == num.length() && calc == target)
        {
            result.add(new String(path));
            return;
        }

        for(int i=pivot; i<num.length(); i++)
        {
            Long curr = Long.parseLong(num.substring(pivot,i+1));
            int le = path.toString().length();

            //handle preceeding zeros
            if(i!=pivot && num.charAt(pivot)=='0') continue;

            if(pivot == 0)
            {
                path.append(curr);
                helper(num, target, path, i+1, curr, curr);
                path.setLength(le);
            }else{

                //+ operator
                path.append("+");
                path.append(curr);
                helper(num, target, path, i+1, curr, calc+curr);
                path.setLength(le);

                //-operator
                path.append("-");
                path.append(curr);
                helper(num, target, path,i+1, -curr, calc-curr);
                path.setLength(le);


                //* operator
                path.append("*");
                path.append(curr);
                helper(num, target, path,i+1, tail*curr, calc-tail+(tail*curr));
                path.setLength(le);


            }
        }

    }
}
