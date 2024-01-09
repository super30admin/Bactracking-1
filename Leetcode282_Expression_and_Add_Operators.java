//approach - For loop base , move pivot, take substring, add operators and check for the result==target when reached bound of string.
//sc: 4^L ; total number of Path; L is string length
//tc: 4^L; because we have 4 choices at each level for a string with length L

class Solution {
    List<String> result;
    String Num;
    int tgt;

    public List<String> addOperators(String num, int target) {
        Num = num;
        tgt = target;
        result = new ArrayList<>();

        // base case
        if (num == null || num.length() <= 0)
            return result;

        int index = 0;
        long curr = 0, calc = 0;
        String path = "";

        helper(index, path, calc, curr);

        return result;
    }

    private void helper(int idx, String path, long calc, long currentTail) {
        // base case
        if (idx == Num.length()) {
            // check if we found the target
            if (calc == tgt)
                result.add(path);
            return; // in any case as we reached the bound.
        }

        // logic
        for (int i = idx; i < Num.length(); i++) {

            // for handling case when 0 is in middle ex: 105
            if (idx != i && Num.charAt(idx) == '0')
                continue; // no trees needs to be build here!

            // if index ==0 then that's just one number, so we advance to the next ponter
            long curr = Long.parseLong(Num.substring(idx, i + 1));
            if (idx == 0) {
                // call helper for next index!
                helper(i + 1, path + curr, curr, curr);
            } else {
                // we are adding operators here!

                // + case
                helper(i + 1, path + "+" + curr, calc + curr, curr);
                // -case
                helper(i + 1, path + '-' + curr, calc - curr, -curr);

                // *val
                long calculated = calc - currentTail + curr * currentTail;
                long curr_tail = curr * currentTail;

                helper(i + 1, path + '*' + curr, calculated, curr_tail);
            }
        }
    }
}

// same approach can be used, using Stringbuilder, to avoid copying string at
// every level.
// we'll save space here, when used backtracking cause we just have one global
// string builder running for us.