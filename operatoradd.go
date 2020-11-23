// Time Complexity : O(n raised to m choices)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if length of num is 0 if sum is target then append blank to res and return

for each in num
attach next digit
if l is 0
copy buf digits from l index
search with updated num and sum and l
else
3 cases here
search with updated values of + operator
search with updated values of - operator
search with updated values of * operator

special case if i=0 and nums[i]=0 break
*/
package main

import (
	"fmt"
)

func addOperators(num string, target int) []string {
	var ret = []string{}
	var buf = make([]byte, len(num)*2) // shared bytes buffer

	search(num, target, &ret, 0, 0, buf, 0)

	return ret
}

// `l` is the length of valid content in `buf`
func search(num string, target int, ret *[]string, sum, diff int, buf []byte, l int) {
	if len(num) == 0 {
		if sum == target {
			*ret = append(*ret, string(buf[0:l]))
		}
		return
	}

	var n = 0
	for i := 0; i < len(num); i++ {
		n = n*10 + int(num[i] - '0')
		var digits = num[0:i+1]

		if l == 0 {
			copy(buf[l:], digits)
			search(num[i+1:], target, ret, sum + n, n, buf, l+i+1)
		} else {
			copy(buf[l+1:], digits)

			buf[l] = '+'
			search(num[i+1:], target, ret, sum + n, n, buf, l+1+i+1)

			buf[l] = '-'
			search(num[i+1:], target, ret, sum - n, -n, buf, l+1+i+1)

			buf[l] = '*'
			search(num[i+1:], target, ret, sum - diff + diff * n, diff * n, buf, l+1+i+1)
		}

		if i == 0 && num[i] == '0' {
			break
		}
	}
}

func MainOperatorAdd() {
	fmt.Println(addOperators("123", 6)) //expected ["1+2+3", "1*2*3"]
}
