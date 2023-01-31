package main

import "fmt"

// this attempt is with 0-1 recursion
// time : 2^n since at each level I am making a decission of either choosing or not choosing, I have two choices to make for n numbers -
// space : the recursive stack will at max hold n calls so O(n)
func combinationSum(candidates []int, target int) [][]int {
	result := [][]int{}
	var helper func(candidates []int, target int, idx int, sum int, path []int)

	helper = func(candidates []int, target int, idx int, sum int, path []int) {
		//base case
		if idx == len(candidates) || sum > target {
			return
		}

		if sum == target {
			r := make([]int, len(path))
			copy(r, path)
			fmt.Println(path)
			result = append(result, r)
			return
		}

		//choose
		path = append(path, candidates[idx])
		sum = sum + candidates[idx]
		helper(candidates, target, idx, sum, path)

		fmt.Println("after choose", path)

		path = path[:len(path)-1]
		sum = sum - candidates[idx]

		// not choose
		fmt.Println("before not choose", path)
		helper(candidates, target, idx+1, sum, path)

		//backtrack
	}
	helper(candidates, target, 0, 0, []int{})
	return result
}