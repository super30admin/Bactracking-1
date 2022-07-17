//Time : O(L*4^L)
//Space : O(L)
class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0, 0, 0, new StringBuilder(), target);
        return result;
    }

    private void helper(String num, int idx, long calc, long tail, StringBuilder path, int target) {
        // base
        if (idx == num.length()) {
            if (calc == target) {
                result.add(path.toString());
            }
            return;
        }

        // logic
        for (int i = idx; i < num.length(); i++) {
            if (i != idx && num.charAt(idx) == '0')
                continue;
            long curr = Long.parseLong(num.substring(idx, i + 1));
            int le = path.length();
            if (idx == 0) {
                path.append(curr);
                helper(num, i + 1, curr, curr, path, target);
                path.setLength(le);
            } else {
                // +
                path.append('+');
                path.append(curr);
                helper(num, i + 1, calc + curr, curr, path, target);
                path.setLength(le);
                // -
                path.append('-');
                path.append(curr);
                helper(num, i + 1, calc - curr, -curr, path, target);
                path.setLength(le);
                // *
                path.append('*');
                path.append(curr);
                helper(num, i + 1, calc - tail + tail * curr, tail * curr, path, target);
                path.setLength(le);
            }
        }
    }
}