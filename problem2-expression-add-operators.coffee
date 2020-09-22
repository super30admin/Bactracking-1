#https://leetcode.com/problems/expression-add-operators/
#// Time Complexity :
#// Space Complexity :
#// Did this code successfully run on Leetcode :
#// Any problem you faced while coding this :
#
#
#// Your code here along with comments explaining your approach

#/**
# * @param {string} num
# * @param {number} target
# * @return {string[]}
# */
addOperators = (nums, target) ->
  output = []

  backtracking = (index, expr, prevSum, prevAddition) ->
    if index >= nums.length
      output.push(expr) if prevSum is target
      return

    curr = parseInt(nums[index])

    if index is 0
      backtracking(index + 1, nums[index], curr, curr)
    else
      # +
      backtracking(index + 1, expr + '+' + nums[index], prevSum + curr, curr)

      # -
      backtracking(index + 1, expr + '-' + nums[index], prevSum - curr, curr * -1)

      # *
      backtracking(index + 1, expr + '*' + nums[index],
        prevSum - prevAddition + prevAddition * curr, prevAddition * curr)

  backtracking(0, '', 0, 0)

  output

addOperators("123", 6)
