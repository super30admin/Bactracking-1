// 113.

//time - O(n) - visitng all nodes
//space - O(n) for recursive stack and a list is created at each node

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumUtil(root, 0, sum, path, result);
        return result;
    }
    
    private void pathSumUtil(TreeNode root, int currentSum, int target, List<Integer> path, List<List<Integer>> result) {
        //base
        if(root == null)
        {
            return;
        }
        if(root.left == null && root.right == null) //leaf
        {
            if(root.val + currentSum == target) //valid path -> add root to path and add path to result
            {
                path.add(root.val);
                result.add(path);
            }
            return;
        }
        //logic
        currentSum += root.val; //update current sum with root's value
        path.add(root.val); //adding root to path to pass a copy of this path(with root) to left & right
        pathSumUtil(root.left, currentSum, target, new ArrayList<>(path), result);
        pathSumUtil(root.right, currentSum, target, new ArrayList<>(path), result);
    }
}

//bactracking
//time - O(n)
//space - constant excluding the result
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        pathSumUtil(root, result, currentPath, 0, sum);
        return result;
    }
    
    private void pathSumUtil(TreeNode root, List<List<Integer>> result, List<Integer> currentPath, int currentSum, int target) {
        //base
        if(root == null)
        {
            return;
        }
        if(root.left == null && root.right == null) //leaf
        {
            if(root.val + currentSum == target) //valid path
            {
                List<Integer> temp = new ArrayList<Integer>(currentPath); //create a new list and copy the current path
                temp.add(root.val);
                result.add(temp);
            }
            return;
        }
        //logic
        currentSum += root.val; //add value of internal node to currentSum
        currentPath.add(root.val); //add node to currentPath which is a potential answer
        //recurse
        pathSumUtil(root.left, result, currentPath, currentSum, target);
        pathSumUtil(root.right, result, currentPath, currentSum, target);
        //backtrack and remove root to return to previous state i.e before adding this root to path
        //this is done to track all paths
        currentPath.remove(currentPath.size() - 1);
    }
}
