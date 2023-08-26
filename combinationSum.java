class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] cdts, int trgt) {
        result = new ArrayList<>();
        if(cdts == null ) return result;
        helper(cdts ,0,trgt,new ArrayList<>());
            return result;
    }

    private void helper(int[] cdts , int i ,int amount,List<Integer> path){
        if(amount ==0){
            result.add(path);
            return;
        }
        if(amount<0 || i == cdts.length) return;
        List<Integer> temp = new ArrayList<>(path);
        temp.add(cdts[i]);
        helper(cdts ,i, amount-cdts[i] , temp);
        helper(cdts,i+1,amount,new ArrayList<>(path));
       
    }
}