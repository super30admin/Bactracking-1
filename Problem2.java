import java.util.*;

class Problem2 {
    public static List<String> ans = new ArrayList<>();
    public static String s;
    public static int target;

    public static List<String> addOperators(String input, int target1) {
        s = input;
        target = target1;
        backtrack(0, "", 0, 0);
        return ans;
    }

    public static void backtrack(int i, String path, long resSoFar, long prevNum) {
        if (i == s.length()) {
            if (resSoFar == target)
                ans.add(path);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (j > i && s.charAt(i) == '0')
                break; // Skip leading zero number
            long num = Long.parseLong(s.substring(i, j + 1));
            if (i == 0) {
                backtrack(j + 1, path + num, num, num); // First num, pick it without adding any operator!
            } else {
                backtrack(j + 1, path + "+" + num, resSoFar + num, num);
                backtrack(j + 1, path + "-" + num, resSoFar - num, -num);
                backtrack(j + 1, path + "*" + num, resSoFar - prevNum + prevNum * num, prevNum * num); // Can imagine
                                                                                                       // with example:
                                                                                                       // 1-2*3
            }
        }
    }

    public static void main(String[] args) {
        String input = "123";
        int target = 6;
        List<String> result = addOperators(input, target);
        System.out.print(result);
    }
}