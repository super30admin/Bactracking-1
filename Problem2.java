import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    List<String> result;
    int tgt;

    //Recursion
    // TC : O(4^n)
    // SC : O (n)
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        tgt = target;
        if (num == null || num.length() == 0) return result;

        helper(num, 0, 0, 0, new StringBuilder());
        return result;
    }

    private void helper(String num, long calC, long tail, int index, String path) {
        //base case
        if (index == num.length()) {
            if (calC == tgt) {
                result.add(path);
                return;
            }
        }
        //logic
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                helper(num, curr, curr, i + 1, path + curr);
            } else {
                //+
                helper(num, calC + curr, curr, i + 1, path + "+" + curr);
                //-
                helper(num, calC - curr, -curr, i + 1, path + "-" + curr);
                //*
                helper(num, (calC - tail) + (tail * curr), (tail * curr), i + 1, path + "*" + curr);
            }
        }
    }

    //BackTracking
    // TC : O(4^n)
    // SC : O (n)

    private void helper(String num, long calC, long tail, int index, StringBuilder path) {
        //base case
        if (index == num.length()) {
            if (calC == tgt) {
                result.add(path.toString());
                return;
            }
        }
        //logic
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') continue;
            long curr = Long.parseLong(num.substring(index, i + 1));
            int length = path.length();
            if (index == 0) {
                path.append(curr);
                helper(num, curr, curr, i + 1, path);
                path.setLength(length);
            } else {
                //+
                path.append("+");
                path.append(curr);
                helper(num, calC + curr, curr, i + 1, path);
                path.setLength(length);
                //-
                path.append("-");
                path.append(curr);
                helper(num, calC - curr, -curr, i + 1, path);
                path.setLength(length);

                //*
                path.append("*");
                path.append(curr);
                helper(num, (calC - tail) + (tail * curr), (tail * curr), i + 1, path);
                path.setLength(length);

            }
        }
    }


    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        List<String> result = problem2.addOperators("123", 9);
        System.out.println("final output" + result);
    }
}
