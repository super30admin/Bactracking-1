class Solution {
    private List<List<Integer>> r;
    private List<Integer> c;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        c = new ArrayList<>();
        r = new ArrayList<>();
       combinationSum(candidates, target, 0);
       return r;
    }
    private void combinationSum(int[] candidates,int target,int i){
        if(target == 0){
            r.add(new ArrayList<>(c));
            return;
        }
        if(target < 0 || i==candidates.length){
            return;
        }

        combinationSum(candidates,target,i+1);
        c.add(candidates[i]);
        combinationSum(candidates,target-candidates[i],i);
        c.remove(c.size()-1);

    }
}
//tc=2^t/min
//sc=t/min
