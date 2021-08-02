class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();

        // num, target, index, calculated value, path
        helper(num, target, 0, 0, 0, new StringBuilder());
        return res;
    }

    private void helper(String num, int target, int index, long calc, long tail, StringBuilder sb) {

        //base case
        if(index == num.length()) {
            if(calc == target) res.add(sb.toString());
            return;
        }

        for(int i=index; i<num.length(); i++) {
            // for preceding 0
            if(num.charAt(index) == '0' && i!=index) break;
            Long curr = Long.parseLong(num.substring(index,i+1));
            int len = sb.toString().length();

            if(index == 0) {
                sb.append(curr);
                helper(num, target, i+1, curr, curr, sb);
                sb.setLength(len);
            } else {
                //calculate for +
                sb.append("+");
                sb.append(curr);
                helper(num, target, i+1, calc+curr, curr, sb);
                sb.setLength(len);

                //calculate for -
                sb.append("-");
                sb.append(curr);
                helper(num, target, i+1, calc-curr, -curr, sb);
                sb.setLength(len);

                //calculate for *
                sb.append("*");
                sb.append(curr);
                helper(num, target, i+1, calc-tail+tail*curr,tail*curr, sb);
                sb.setLength(len);
            }

        }

    }
}