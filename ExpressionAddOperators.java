// Time Complexity : O(4^n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Make 4 choices every time, whether to append next number or 
// to place a + between two numbers or
// place a - betwen two numbers or
// place a * between two numbers

//Backtracking
class Solution {
  List<String> result;

  public List<String> addOperators(String num, int target) {
    result = new ArrayList<>();
    if (num == null || num.length() == 0)
      return result;

    helper(num, target, new StringBuilder(), 0, 0, 0);

    return result;
  }

  private void helper(String num, int target, StringBuilder path, long cal, long tail, int index) {
    if (index == num.length()) {
      if (cal == target)
        result.add(path.toString());
      return;
    }

    for (int i = index; i < num.length(); i++) {
      if (num.charAt(index) == '0' && index != i)
        continue;

      long cur = Long.parseLong(num.substring(index, i + 1));
      int length = path.length();

      if (index == 0) {
        path.append(cur);
        helper(num, target, path, cur, cur, i + 1);
        path.setLength(length);
      } else {
        path.append('+');
        path.append(cur);
        helper(num, target, path, cal + cur, cur, i + 1);
        path.setLength(length);

        path.append('-');
        path.append(cur);
        helper(num, target, path, cal - cur, -cur, i + 1);
        path.setLength(length);

        path.append('*');
        path.append(cur);
        helper(num, target, path, cal - tail + tail * cur, tail * cur, i + 1);
        path.setLength(length);
      }
    }
  }
}