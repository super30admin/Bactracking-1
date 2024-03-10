class Solution {
    //TimeComplexity: O(2^n)
    //SpaceComplexity: O(2^n)
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        recursiveFunction(candidates,0,path,target);
        return result;
    }
    void recursiveFunction(int[] candidates, int pivot, List<Integer> path, int target) {
        //base condition
        /* if(index == candidates.length || target < 0) {
             
             return;
         }
         if(target == 0) {
             
             result.add(new ArrayList<>(path));
             return;
         }

        //logic

        // dont choose

        recursiveFunction(candidates,index+1, path, target);

        //choose
        path.add(candidates[index]);
        recursiveFunction(candidates, index,path,target-candidates[index]);
        path.remove(path.size()-1);*/

        //For loop based recursion
        if(target == 0) {
            result.add(new ArrayList<>(path));
        }
        if(target <0) {
            return;
        }
        for(int i = pivot; i<candidates.length;i++) {
            path.add(candidates[i]);
            recursiveFunction(candidates,i,path,target-candidates[i]);
            path.remove(path.size()-1);
        }
        

    }
}