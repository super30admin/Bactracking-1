class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        result = []
        def helper(num, target, sb, calc, tail, index):
            if index == len(nums):
                if calc == target:
                    result.append(sb)
                    return
            for i in range(index, len(nums)):
                # Preceeding zero
                if index != i and nums[index] == '0': continue
                curr = nums[index:i+1]
                len = len(sb)
                if index == 0:
                    sb.append(curr)
                    helper(num, target, sb, curr, curr, i+1)
                else:
                    # +
                    sb.append("+")
                    sb.append(curr)
                    helper(num, target, sb, calc+curr, curr, i+1)
                    sb = sb[len]
                    
                    # -
                    sb.append("-")
                    sb.append(curr)
                    helper(num, target, sb, calc-curr, -curr, i+1)
                    sb = sb[len]
                    
                    # *
                    sb.append("*")
                    sb.append(curr)
                    helper(num, target, sb, calc-tail, tail*curr, i+1)
                    sb = sb[len]
                    
        helper(num, target, [], 0, 0, 0)
        return result