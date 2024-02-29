// https://leetcode.com/problems/expression-add-operators/

// Time Complexity: O(3^N)
// Space Complexity: O(N)

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, 0, target, 0, 0, new StringBuilder());
        return result;
    }

    private void helper(String num, int pivot, int target, long calc, long tail, StringBuilder path) {
        //base
        if(pivot == num.length()) {
            if(calc == target) {
                result.add(path.toString());
            }
            return;
        }
        //logic
        //for loop to create the permutation of numbers
        for(int i = pivot; i < num.length(); i++) {
            //preceding zero
            if(num.charAt(pivot) == '0' && pivot != i) continue;

            Long curr = Long.parseLong(num.substring(pivot, i+1));
            int pathLen = path.length();
            if(pivot == 0) {
                //action
                path.append(curr);

                //recurse
                helper(num, i+1, target , curr, curr, path);

                //backtrack
                path.setLength(pathLen);
            } else {
                // +
                //action
                path.append("+");
                path.append(curr);
                //recurse
                helper(num, i+1, target, calc + curr, curr, path);
                //backtrack
                path.setLength(pathLen);

                // -
                //action
                path.append("-");
                path.append(curr);
                //recurse
                helper(num, i+1, target, calc - curr, -curr, path);
                //backtrack
                path.setLength(pathLen);


                // *
                //action
                path.append("*");
                path.append(curr);
                //recurse
                helper(num, i+1, target, calc - tail + tail * curr,  tail * curr, path);
                //backtrack
                path.setLength(pathLen);
            }
        }
    }
}