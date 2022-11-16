import java.util.*;

class Problem1 {
    static List<Integer> currCombination;
    static List<List<Integer>> finalAnswer;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        currCombination = new ArrayList<>();
        finalAnswer = new ArrayList<>();
        backTrack(candidates, target, 0);
        return finalAnswer;

    }

    public  static void backTrack(int[] candidates, int target, int i) {

        if (target == 0) {
            finalAnswer.add(new ArrayList<>(currCombination));
            return;
        }
        if (target < 0 || i == candidates.length) {
            return;
        }
        backTrack(candidates, target, i + 1);
        currCombination.add(candidates[i]);
        backTrack(candidates, target - candidates[i], i);
        currCombination.remove(currCombination.size() - 1);
    }

    public static void main(String[] args) {
        int[] candidates = new int[] { 2, 3, 5, 7 };
        int target = 7;
        List<List<Integer>> answer = combinationSum(candidates, target);
        System.out.println(answer);
    }
}