import java.util.LinkedList;
import java.util.List;

class CombinationSum39 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        //solution
        List<List<Integer>> result = new LinkedList<>();

        //state
        List<Integer> state = new LinkedList<>();

        //backtrackig
        backTrack(result,state,candidates,target,0,0);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> state, int[] candidates, int target, int index,
            int sum) {
    
                //isvalid
                if(sum>target) return;

                //isgoal
                if(sum==target) result.add(new LinkedList<>(state));

                //combinations
                for(int i=index; i < candidates.length; i++){
                    state.add(candidates[i]);
                    backTrack(result, state, candidates, target, i++, sum + candidates[i]);
                    state.remove(state.size()-1);
                
            }
            }


public static void main(String[] args) {
    
    CombinationSum39 cs = new CombinationSum39();
    int arr[] = {2,3,6,7};    
    for(List<Integer> l : cs.combinationSum(arr, 7)){
        System.out.println();
        for(int i : l){
            System.out.print(i);
        }
    }
}

}