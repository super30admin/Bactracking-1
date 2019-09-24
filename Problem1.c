/* Problem Statement:
Verified on leetcode

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

 *
 * Time Complexity : O(4 ^ N) where N is the max depth upto which we have to go till either target is reached
   or a combination is not possible 
 * Space Complexity : O(n) (where n is max length of combination made for reaching target value )excluding the result set 
 */



/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */

void combinationSum_helper(int st_idx, int *candidates, int candidateSize, int *res_arr, int res_size, int remaining, int target, int *returnSize, int **final_arr, int *ret_col) {
    int **fin_arr = final_arr;
    int idx = 0, idx1 = 0;
    int *new_res = res_arr;
    
    /* Got a result, copy ,it to result array */
    if (remaining == 0) {
        fin_arr[*returnSize] = (int *)malloc(sizeof(int) * res_size);
        
        ret_col[*returnSize] = res_size;
        for (idx = 0; idx < res_size; idx++) {
            fin_arr[*returnSize][idx] = res_arr[idx];
        }
        *returnSize = *returnSize + 1;
    } else {

        /* Run a loop from the current st_idx to the candidate size*/
        for (idx1 = st_idx; idx1 < candidateSize; idx1++) {
            /* optimization, skip this part if we get anumber higher than requested */
            if (candidates[idx1] > remaining) {
                continue;
            }
            /* Make a choice and then call recursion again with that choice */
            new_res[res_size] = candidates[idx1];
            combinationSum_helper(idx1, candidates, candidateSize, new_res, res_size + 1, remaining - new_res[res_size], target, returnSize, final_arr, ret_col);
            /* Undo the choice, for this, we dont need to do anything extra as it will anyways be overwritten in next iteration */
        }
    }
}
int** combinationSum(int* candidates, int candidatesSize, int target, int* returnSize, int** returnColumnSizes){
    int **final_arr = NULL;
    *returnSize = 0;
    int *ret_col = NULL;
    
    if (!candidatesSize) {
        return final_arr;
    }
    /* Memory allocation */
    #define FINAL_ARR 500
    final_arr = (int **)calloc(FINAL_ARR, sizeof(int *));
    ret_col = (int *)malloc(sizeof(int) * FINAL_ARR);
    
    int *temp_res = NULL;
    temp_res = (int *)calloc(1, sizeof(int) * FINAL_ARR);
    combinationSum_helper(0, candidates, candidatesSize, temp_res, 0, target, target, returnSize, final_arr, ret_col);
    free(temp_res);
    
    *returnColumnSizes = ret_col;
    return final_arr;
}

/* use leetcode platform to test it */


