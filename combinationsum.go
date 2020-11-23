// Time Complexity : O(n raised to m choices)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
in recursive function set base case if sum is target append to res if its greater return
for each candidate
append current to temp
call recursive with new sum, new temp and new index
remove current from temp
*/
package main

import "fmt"

var temp []int
var res [][]int
func combinationSum(candidates []int, target int) [][]int {
	temp = []int{}
	res = [][]int{}
	h(candidates, target, 0, 0, temp)
	return res
}

func h(candidates []int, target int, index int, sum int, temp []int) {
	//base
	if target == sum {
		temp1 := []int{}
		for x:=0;x <len(temp);x++{
			temp1 = append(temp1, temp[x])
		}
		res = append(res, temp1)
		return
	}
	if sum > target {
		return
	}

	for i:=index;i<len(candidates);i++ {
		temp = append(temp, candidates[i])
		h(candidates, target, i, sum + candidates[i], temp)
		temp = temp[:len(temp)-1]
	}
}

func MainCombinationSum() {
	fmt.Println(combinationSum([]int{2,3,6,7}, 7)) //expected [[2,2,3],[7]]
}


