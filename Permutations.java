class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> state = new LinkedList<>();
        Set<Integer> candidateSet = new HashSet<>();
        for(int n : nums) {
            candidateSet.add(n);
        }
        backtrack(result, state, candidateSet);
        return result;
    }
    
    private boolean isValidSolution(Set<Integer> state) {
        return state.size() == 0;
    }
    
    private List<Integer> getCandidates(Set<Integer> candidateSet) {
        List<Integer> candidates = new LinkedList<>();
        for(int c : candidateSet) {
            candidates.add(c);
        }
        return candidates;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> state, Set<Integer> candidateSet) {
        if(isValidSolution(candidateSet)) {
            result.add(new LinkedList<>(state));
        }
        
        for(int c : getCandidates(candidateSet)) {
            candidateSet.remove(c);
            state.add(c);
            backtrack(result, state, candidateSet);
            state.remove(state.size() - 1);
            candidateSet.add(c);
        }
    }
}
