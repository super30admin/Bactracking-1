//using approach normal 01 recursion but  not choose first and choose after
//Time complexity = O(2^m+n)
//Space complexity = O(m+n)
class SolutionUsing01Recursion {
        List<List<Integer>> result;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.result = new ArrayList<>();
            helper(candidates, 0, target, new ArrayList<>());
            return result;
        }

        public void helper(int[] candidates, int i, int target, List<Integer> path) {
            //base condition
            if (target < 0 || i == candidates.length) {
                return;
            }
            if (target == 0) {
                result.add(path);
                return;
            }
            // not choose
            helper(candidates, i + 1, target, new ArrayList<>(path));
            path.add(candidates[i]);
            //choose
            helper(candidates, i, target - candidates[i], new ArrayList<>(path));


            //otherway::
            // List<Integer> li = new ArrayList<>(path);
            // li.add(candidates[i]);
            // helper(candidates, i, target - candidates[i], li);
            // helper(candidates, i + 1, target, new ArrayList<>(path));
        }    

}


//using for loop approach
//Time complexity = O(2^m+n)
//Space complexity = O(m+n)
class SolutionUsingForLoop {
        List<List<Integer>> result;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.result = new ArrayList<>();
            helper(candidates,0, target, new ArrayList<>());
            return result;
        }

        public void helper(int[] candidates,int pivot, int target, List<Integer> path){
            //base condition
            for(int i = pivot; i<candidates.length; i++){
                if(target==0){
                    result.add(new ArrayList<>(path));
                    return;
                }
                if(target<0 || pivot == candidates.length){
                    return;
                }

                path.add(candidates[i]);
                helper(candidates, i, target-candidates[i], new ArrayList<>(path));
                path.remove(path.size()-1);
            }

        }
    }


