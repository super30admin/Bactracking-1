//time = O(n^4)
//space = O(n)

class Solution {

    private List<String> results;
    private List<String> expr;
    private int target;

    public List<String> addOperators(String num, int target) {

        expr = new ArrayList<>();
        results = new ArrayList<>();
        this.target = target;

        addOperators(num, 0, 0, 0);

        return results;
    }

    private void addOperators(String s, int index, long res, long tail) {

        // base
        if (index == s.length()) {

            if (res == target) {
                StringBuilder exprStr = new StringBuilder();
                for (String x : expr) {
                    exprStr.append(x);
                }
                results.add(exprStr.toString());
            }
            return;
        }

        for (int end = index; end < s.length(); end++) {

            long curr = Long.parseLong(s.substring(index, end + 1));

            if (expr.size() == 0) {

                expr.add(curr + "");
                addOperators(
                        s, end + 1, curr, curr);
                expr.remove(expr.size() - 1);

            } else {

                // Add
                expr.add("+");
                expr.add(curr + "");
                addOperators(
                        s, end + 1, res + curr, curr);
                expr.remove(expr.size() - 1);
                expr.remove(expr.size() - 1);

                // Sub
                expr.add("-");
                expr.add(curr + "");
                addOperators(
                        s, end + 1, res - curr, -curr);
                expr.remove(expr.size() - 1);
                expr.remove(expr.size() - 1);

                // Mul
                expr.add("*");
                expr.add(curr + "");
                addOperators(
                        s, end + 1, res - tail + tail * curr, tail * curr);
                expr.remove(expr.size() - 1);
                expr.remove(expr.size() - 1);

            }
            if (curr == 0) {
                break;
            }

        }

    }
}