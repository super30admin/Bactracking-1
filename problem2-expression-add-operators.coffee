#https://leetcode.com/problems/expression-add-operators/
#// Time Complexity : O(N^N) basically visit all combinations of the nums and operators
#// Space Complexity : O(N^N) stack usage
#// Did this code successfully run on Leetcode : base case yes, not all test cases I still have a bug somewhere
#// Any problem you faced while coding this :
#
# knowing the difference between substr and substring!!!  (indices vs index+length!!!!!)
#
#// Your code here along with comments explaining your approach
#
# traverse the nums input from length [1, nums.length)
# at each recursive level
#   recurse on the 3 operators +, -, * calculating the sums and expr for each
#   if you have reached the end of indices within nums
#      store the expr to output IF it results in the target
#
# return the output array

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

    for i in [index...nums.length]
      curNum = nums.substring(index, i + 1)
      curr = parseInt(curNum)

      if nums[index] is '0' and i isnt index
        continue

      if index is 0
        backtracking(index + 1, curNum, curr, curr)
      else
        # +
        backtracking(index + 1, "#{expr}+#{curNum}", prevSum + curr, curr)

        # -
        backtracking(index + 1, "#{expr}-#{curNum}", prevSum - curr, curr * -1)

        # *
        backtracking(index + 1, "#{expr}*#{curNum}",
          prevSum - prevAddition + prevAddition * curr, prevAddition * curr)

  backtracking(0, '', 0, 0)

  output

addOperators("12", 3)
#addOperators("123", 6)
