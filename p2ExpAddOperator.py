"""

#time: O(3^N)
#space: O(N) N is depth of recursion

"""

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        exprs = []
        
        def recurse(idx, value, delta, exp):
            # base case here
            if idx == len(num):
                if value == target:
                    exprs.append("".join(exp))
            
            # the loop will create the current operand and recursively call
            # the next set of actions to be executed
            for i in range(idx, len(num)):
                # this is to avoid cases where the operand starts with a 0
                # we need to have a case with just the 0 but not something like
                # 05, so the condition will return early if we find such cases
                if num[idx] == '0' and i > idx:
                    return
                
                curr = int(num[idx:i+1])
                curr_str = num[idx:i+1]
                
                # when we start the problem we dont have a preceding operator or operand
                if idx == 0:
                    recurse(i+1, curr, curr, exp + [curr_str])
                else:
                    # We need to do 3 different recursions for each operator
                    # value stores the running value of the expression evaluated so far
                    # the crux of the logic lies in how we use and pass delta
                    # when the operation is '+' or '-' we don't care much about it and can just
                    # add or subtract it from the value 
                    # when '*' is involved, we need to follow the precedence relation,
                    # but we have already evaluated the previous operator. We know the
                    # previous operation that was performed and how much it contributed to the value i.e., delta
                    # so, we can revert that operation by subtracting delta from value and reapplying the multiplication
                    recurse(i+1, value+curr, curr, exp + ['+', curr_str])
                    recurse(i+1, value-curr, -curr, exp + ['-', curr_str])
                    recurse(i+1, (value-delta)+curr*delta, curr*delta, exp + ['*', curr_str])
                            
        recurse(0, 0, 0, [])
        return exprs