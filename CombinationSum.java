/**
    This algorithm creates a N-ary tree of depth T/M. 
    T is the target value.
    M is the minimum value in the candidates array. A smaller valued M means we keep adding that candidate to the combination and go deep into the tree until, combination sum >= 0.


Time Complexity - O(N ^(T/M + 1)) In the below recursive approach, 
                    the number of operations is loosely equal to the no. of nodes in N -ary tree. 
                    Max depth is (T/M) 
                    Max width or max no of children for each node is N (size of the candidates array)
                    total no of nodes is (N^ (T/M + 1)).

Space Complexity -  Auxillary space - all combinations are stored in list which is represented by every path from root to all leaves. 
                    Max length of such path is max depth of the tree which is O(T/M).
                    Stack space - again the max depth of the tree. O(T/M).
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> combs = new LinkedList<>();
        getCombinations(candidates, target, 0, combs, result);
        return result;
    }

    public void getCombinations(int[] candidates, int remain, int index, LinkedList<Integer> combs, List<List<Integer>> result) {

        if(remain == 0) {
            result.add(new ArrayList<Integer>(combs));
            return;
        }
        if(remain < 0)
            return;
        
        for(int start = index; start < candidates.length; start++) {
            combs.add(candidates[start]);
            getCombinations(candidates, remain - candidates[start], start, combs, result);
            combs.removeLast();
        }
    } 
}
