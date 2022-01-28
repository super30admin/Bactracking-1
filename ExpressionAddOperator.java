// Time Complexity: O(4^n)
// Space Complexity: O(n)
// iterative recursion
public class ExpressionAddOperator {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();

        if(num == null || num.length() == 0)
            return result;

            iterativeRecursion(num, target, 0, 0, 0, "");
        
        return result;
    }

    // calc should be long as int multiplication can cause overflow
    // calc is value calculated so far
    // tail is the last operation perfomed that can be used to perform undo in case of multiplication
    private void iterativeRecursion(String num, int target, int index, long calc, long tail, String path)
    {
        // base
        // we need to consider path as answer only when all numbers are considered
        if(index == num.length() && calc == target)
        {
            result.add(path);
            return;
        }
        // logic
        for(int i = index ; i < num.length() ; i ++)
        {
            // if we have 05 or 0123 we need not consider leading zero
            if(index != i && num.charAt(index) == '0')
                continue;
            long no = Long.parseLong(num.substring(index, i+1));
            
            // if accepting very first number we cannot add operators before it
            if(index == 0)
            {
                iterativeRecursion(num, target, i + 1, no, no, path + no);
            }
            else
            {
                // + case
                iterativeRecursion(num, target, i + 1, calc + no, no, path + "+" + no);
                // - case
                iterativeRecursion(num, target, i + 1, calc - no, -no, path + "-" + no);
                // * case
                iterativeRecursion(num, target, i + 1, (calc - tail) + (tail * no) , tail * no, path + "*" + no);
            }
        }
    }
}

// Time Complexity: O(4^n)
// Space Complexity: O(n)
// iterative backtrack
public class ExpressionAddOperator {
    List<String> result;
    public List<String> addOperators(String num, int target) {
         result = new ArrayList<>();

        if(num == null || num.length() == 0)
            return result;

        interativeBacktrack(num, target, 0, 0, 0, new StringBuilder());
        
        return result;
    }

    // calc should be long as int multiplication can cause overflow
    private void interativeBacktrack(String num, int target, int index, long calc, long tail, StringBuilder path)
    {
        // base
        // we need to consider path as answer only when all numbers are considered
        if(index == num.length() && calc == target)
        {
            result.add(path.toString());
            return;
        }
        // logic
        for(int i = index ; i < num.length() ; i ++)
        {
            // if we have 05 or 0123 we need not consider leading zero
            if(index != i && num.charAt(index) == '0')
                continue;
            long no = Long.parseLong(num.substring(index, i+1));
            // old length of the path
            int len = path.length();
            // if accepting very first number we cannot add operators before it
            if(index == 0)
            {
                path.append(no);
                interativeBacktrack(num, target, i + 1, no, no, path);
                path.setLength(len);
            }
            else
            {
                // + case
                path.append("+");
                path.append(no);
                interativeBacktrack(num, target, i + 1, calc + no, no, path);
                path.setLength(len);
                // - case
                path.append("-");
                path.append(no);
                interativeBacktrack(num, target, i + 1, calc - no, -no, path);
                path.setLength(len);
                // * case
                path.append("*");
                path.append(no);
                interativeBacktrack(num, target, i + 1, (calc - tail) + (tail * no) , tail * no, path);
                path.setLength(len);
            }
        }
    }
}