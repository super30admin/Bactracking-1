# As taught in class, I use backtracking to recurse through all possible solutions to get sum equal to target
# Time Complexity: O(2^n)
#Space Complexity: exponential
result = list()
def combinationSum(arr,target):
    if len(arr) == 0 or target is None:
        return None
    helper(arr,target,[],0,0)
    
def helper(arr,target,temp,index,currSum):
    if index >= len(arr) or currSum > target:
        return
    if target == currSum:
        result.append(list(temp))
        return

    for i in range(index,len(arr)):
        temp.append(arr[i])
        helper(arr,target,temp,i,currSum+arr[i])
        temp.pop()

arr = [2,3,6,7]
target = 7
combinationSum(arr,target)
print(result)