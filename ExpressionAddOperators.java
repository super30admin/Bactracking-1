// Time Complexity : O(4 ^ n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();

        // helperRecusion(num, target, "", 0, 0, 0);
        // helper01Recursion(num, target, "", 0, 0, 0, 0, 0);
        helperBackTrack(num, target, new StringBuilder(), 0, 0, 0);

        return result;
    }

    private void helper01Recursion(String num, int target, String path, int pivot, int i, long calc, long tail, int cnt) {

        //base
         if(i == num.length()){
            if(target == calc && cnt == num.length()){
                result.add(path);
            }
            return;
        }

        //Preceding zero
          if(num.charAt(pivot) == '0' && pivot != i) return;

        //don't choose
        helper01Recursion(num, target, path, pivot, i+1, calc, tail, cnt);

        //choose    
        long curr = Long.parseLong(num.substring(pivot, i+1));
        if(pivot == 0) {
             helper01Recursion(num, target, path + curr, i+1, i+1, curr, curr, cnt + i+ 1-pivot);
        } else {
             helper01Recursion(num, target, path + '+' + curr, i+1, i+1, calc + curr, curr, cnt + i+ 1-pivot);
             helper01Recursion(num, target, path + '-' +  curr, i+1, i+1, calc  - curr, -curr, cnt + i+ 1-pivot);
             helper01Recursion(num, target, path + '*' + curr, i+1, i+1, calc - tail + tail * curr , tail * curr, cnt + i+ 1-pivot);

        }
    }
    private void helperBackTrack(String num, int target, StringBuilder path, int pivot, long calc, long tail) {
         // base
        if (pivot == num.length()) {
            if (target == calc) {
                result.add(path.toString());
            }
        }
        // logic
        // create number
        for (int i = pivot; i < num.length(); i++) {
            //preceding zero
            if (num.charAt(pivot) == '0' && i != pivot) {
                break;
            }
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            int le = path.length();
            if (pivot == 0) {
                path.append(curr);
                helperBackTrack(num, target, path, i + 1, curr, curr);
                path.setLength(le);

            } else {
                // +
                path.append('+');
                path.append(curr);
                helperBackTrack(num, target, path , i + 1, calc + curr, curr);
                path.setLength(le);

                // -
                path.append('-');
                path.append(curr);
                helperBackTrack(num, target, path , i + 1, calc - curr, -curr);
                path.setLength(le);

                // *
                path.append('*');
                   path.append(curr);
                helperBackTrack(num, target, path, i + 1, calc - tail + tail * curr, tail * curr);
                path.setLength(le);
            }
        }

    }
    private void helperRecusion(String num, int target, String path, int pivot, long calc, long tail) {

        // base
        if (pivot == num.length()) {
            if (target == calc) {
                result.add(path);
            }
        }
        // logic
        // create number
        for (int i = pivot; i < num.length(); i++) {
            if (num.charAt(pivot) == '0' && i != pivot) {
                break;
            }
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            if (pivot == 0) {
                helperRecusion(num, target, path + curr, i + 1, curr, curr);
            } else {
                // +
                helperRecusion(num, target, path + '+' + curr, i + 1, calc + curr, curr);

                // -
                helperRecusion(num, target, path + '-' + curr, i + 1, calc - curr, -curr);

                // *
                helperRecusion(num, target, path + '*' + curr, i + 1, calc - tail + tail * curr, tail * curr);
            }
        }

    }
}