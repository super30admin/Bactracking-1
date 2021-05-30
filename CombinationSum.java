//space : O(m+n), m=target, n=number of element in input array
//time : O(m+n), m=target, n=number of element in input array
//Run successfully on leetcode : yes
class CombinationSum {
    //list to store result
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //initializing result list
        result = new ArrayList<>();
        //if empty candidates array
        if(candidates == null || candidates.length == 0) return result;
        //call method to find paths
        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }

    public void helper(int[] candidates, int index, List<Integer> path, int target){
        //base
        //if target sum is found
        if(target == 0){
            //add path to result
            result.add(new ArrayList<>(path));
            return;
        }
        //if index reaches the ends or sum exceeds target
        if(index==candidates.length||target<0) return;


        //logic
        //case1 : not select anything
        helper(candidates, index+1, path, target);
        //update path
        path.add(candidates[index]);
        //case2: select current index
        helper(candidates, index, path, target-candidates[index]);
        //backtrack i.e. undo path update
        path.remove(path.size()-1);

    }
}