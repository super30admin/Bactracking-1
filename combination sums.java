//Time complexity:- O(N^target/min);(N^height of tree in which height of tree will be untill target/min.
//space complexity:- O(target/min) no of nodes.
//Did it run on leetcode?:-yes.
//What problems did you face?:- took lot of time to get correct answer.
// if we choose one value subtracting that value and passing it as target backtracking is applied with progrresion index
//and target-taken value.when target reaches to zero adding covered values to output list.




class Solution {
    List<List<Integer>> result= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> track=new ArrayList<>();
        combinationsumhelper(candidates,0,target,track);
    return result;}
    private void combinationsumhelper(int[] candidates,int index,int target,List<Integer> track){
        if(target<0){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(track));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            track.add(candidates[i]);
            combinationsumhelper(candidates,i,target-candidates[i],track);
            track.remove(track.size()-1);
        }
    }
}