// Time Complexity : O(4^n)
// Space Complexity : O(n) + O(n) -> O(n)   (1st n for path, 2nd n for recursive stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Backtracking
 */
class Solution {

    List<String> result;
    public List<String> addOperators(String num, int target) {

        this.result = new ArrayList<>();
        helper(num, target, 0, 0, new StringBuilder(), 0);
        return result;
    }

    private void helper(String num, int target, long calc, long tail, StringBuilder path, int pivot) {

        int len = path.length();

        if(pivot == num.length() && calc == target)
            result.add(new String(path));

        for(int i=pivot; i<num.length(); i++) {

            if(i != pivot && num.charAt(pivot) == '0') continue;

            long curr = Long.parseLong(num.substring(pivot, i+1));

            if(pivot == 0) {
                path.append(curr);
                helper(num, target, curr, curr, path, i+1);
                path.setLength(len);
            }
            else {
                //+
                path.append("+");
                path.append(curr);
                helper(num, target, calc+curr, curr, path, i+1);
                path.setLength(len);
                //-
                path.append("-");
                path.append(curr);
                helper(num, target, calc-curr, -curr, path, i+1);
                path.setLength(len);
                //*
                path.append("*");
                path.append(curr);
                helper(num, target, (calc-tail)+(tail*curr), tail*curr, path,i+1);
                path.setLength(len);
            }
        }
    }
}


// Time Complexity : O(n * (4^n))
// Space Complexity :
class Solution {

    List<String> result;
    public List<String> addOperators(String num, int target) {

        this.result = new ArrayList<>();
        helper(num, target, 0, 0, "", 0);
        return result;
    }

    private void helper(String num, int target, long calc, long tail, String path, int pivot) {

        if(pivot == num.length() && calc == target)
            result.add(new String(path));

        for(int i=pivot; i<num.length(); i++) {

            if(i != pivot && num.charAt(pivot) == '0') continue;

            long curr = Long.parseLong(num.substring(pivot, i+1));

            if(pivot == 0) {
                helper(num, target, curr, curr, path+curr, i+1);
            }
            else {
                //+
                helper(num, target, calc+curr, curr, path+"+"+curr, i+1);
                //-
                helper(num, target, calc-curr, -curr, path+"-"+curr, i+1);
                //*
                helper(num, target, (calc-tail)+(tail*curr), tail*curr, path+"*"+curr,i+1);
            }
        }
    }
}