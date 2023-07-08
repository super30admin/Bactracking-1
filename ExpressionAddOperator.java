import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, num, target, "", 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, String num, int target, String expression, int index, long value,
            long prev) {
        if (index == num.length()) {
            if (value == target) {
                result.add(expression);
            }
            return;
        }

        // Generate all possible operands starting from the current index
        for (int i = index; i < num.length(); i++) {
            // Avoid leading zeros
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            long operand = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                // If it's the first operand, simply recurse with the operand value
                backtrack(result, num, target, expression + operand, i + 1, operand, operand);
            } else {
                // Try all possible operators: +, -, *
                backtrack(result, num, target, expression + "+" + operand, i + 1, value + operand, operand);
                backtrack(result, num, target, expression + "-" + operand, i + 1, value - operand, -operand);
                backtrack(result, num, target, expression + "*" + operand, i + 1, value - prev + prev * operand,
                        prev * operand);
            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperator solution = new ExpressionAddOperator();
        List<String> result = solution.addOperators("123", 6);
        System.out.println(result); // Output: ["1+2+3", "123"]

        result = solution.addOperators("232", 8);
        System.out.println(result); // Output: ["2+3*2", "2*3+2"]

        result = solution.addOperators("105", 5);
        System.out.println(result); // Output: ["1*0+5","10-5"]

        result = solution.addOperators("00", 0);
        System.out.println(result); // Output: ["0+0", "0-0", "0*0"]

        result = solution.addOperators("3456237490", 9191);
        System.out.println(result); // Output: []
    }
}
