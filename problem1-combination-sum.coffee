#https://leetcode.com/problems/combination-sum/
#// Time Complexity : O(N^N) visit all possible combinations
#// Space Complexity : O(N^N) stack space
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# not much way easier than previous backtracking
#
#// Your code here along with comments explaining your approach
#
# visit all combinations recursively
# deduct from target on each recursion
# if target hits 0, push to the output array
# return output

combinationSum = (candidates, target) ->
  output = []

  backtracking = (target, index, path) ->
    return if target < 0

    if target is 0
      output.push(path)
      return
    else if index >= candidates.length
      return

    for i in [index...candidates.length]
      backtracking(target-candidates[i], i, [].concat(path).concat(candidates[i]))

  backtracking(target, 0, [])

  output

combinationSum([2,3,6,7], 7)

