
// Time - O(N * 4^N)
// Space - O(N)


class Solution {

    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, "", 0, 0, 0);
        return result;

    }

    private void helper(String num, int target, String path, int index, long calc, long tail) {

        // base case
        if(index == num.length()) {

            if(calc == target) {
                result.add(path);
            }
            return;

        }


        // logic

        for(int i = index; i< num.length(); i++) {

            // preceding zero case
            if(num.charAt(index) == '0' && index != i ) continue;

            // convert substring to long
            long curr = Long.parseLong(num.substring(index,i+1));

            // if index 0 dont need to do operators '+', '-' & '*'
            if(index == 0) {

                helper(num,target,path + curr, i+1, curr, curr);

            }

            else {

                // '+' case
                helper(num,target,path + '+' + curr, i+1, calc + curr, curr);

                // '-' case

                helper(num,target,path + '-' + curr, i+1, calc - curr, -curr);

                // '*' case

                helper(num,target,path + '*' + curr, i+1, calc - tail + (tail * curr), tail * curr);



            }


        }


    }
}