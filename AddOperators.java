/*
 * The time complexity and space complexity of this implementation is O(n)*/
import java.util.ArrayList;
import java.util.List;

class AddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtrack(res, num, target, "", 0, 0, 0);
        return res;
    }

    private void backtrack(List<String> res, String num, int target, String expr, int start, long val, long prev) {
        if (start == num.length()) {
            if (val == target) {
                res.add(expr);
            }
            return;
        }

        for (int i = start; i < num.length(); i++) {
            if (i != start && num.charAt(start) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(start, i + 1));
            if (start == 0) {
                backtrack(res, num, target, expr + cur, i + 1, cur, cur);
            } else {
                backtrack(res, num, target, expr + "+" + cur, i + 1, val + cur, cur);
                backtrack(res, num, target, expr + "-" + cur, i + 1, val - cur, -cur);
                backtrack(res, num, target, expr + "*" + cur, i + 1, val - prev + prev * cur, prev * cur);
            }
        }
    }
    public static void main(String[] args) {
        AddOperators sol = new AddOperators();
        String num = "123";
        int target = 6;
        List<String> res = sol.addOperators(num, target);
        System.out.println(res); // should print ["1+2+3", "1*2*3"]
    }

}
