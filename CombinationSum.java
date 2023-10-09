

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<List<Integer>>();
        }


        result = new ArrayList<>();
        recurse(candidates, 0, target, new ArrayList<>());
        return result;
    }

    public void recurse(int[] candidates, int index, int target, List<Integer> path){

        //base
        if(target < 0){
            return;
        }

     

        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }


        for(int i=index; i<candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recurse
            recurse(candidates, i, target -  candidates[i], path);
            //backtrack
            path.remove(path.size() - 1);
        }

   

    }
}