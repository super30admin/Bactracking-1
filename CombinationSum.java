/*Running Time Complexity: O(2^n)
Space Complexity: Constant path list data type is used to store the path 
Successfully Run and Compiled on leetcode
*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        int index = 0;
        BackTracking(candidates,target,path,index);
        return result;
    }
    public void BackTracking(int[] candidates,int target, List<Integer> path, int index){
        //Base case
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }else if(target<0 || index == candidates.length){
            return ;
        }
        for(int i = index;i<candidates.length;i++){//First mistake
            
            path.add(candidates[i]);
            BackTracking(candidates, target-candidates[i], path, i);//Second mistake
            path.remove(path.size()-1);
        }
    }
}