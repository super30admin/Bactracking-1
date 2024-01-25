#Expression Add Operators (https://leetcode.com/problems/expression-add-operators/)
#Space Complexity = O(n)
#Time Complexity = O(4^n)

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        #Store combinations
        res = []

        #dfs function to traverse 
        def dfs(currentIndex, currentResult, currentSum, prevElement):
            if currentIndex >= len(num):
                if currentSum == target:
                    res.append("".join(currentResult))

                return
            else:
                for i in range(currentIndex, len(num)):
                    currentString = num[currentIndex: i + 1]
                    currentNum = int(currentString)

                    if not currentResult:
                        dfs(i+1, [currentString], currentNum, currentNum)
                    else:
                        dfs(i+1, currentResult + ["+"] + [currentString], currentSum + currentNum, currentNum)
                        dfs(i+1, currentResult + ["-"] + [currentString], currentSum - currentNum, -currentNum)
                        dfs(i+1, currentResult + ["*"] + [currentString], currentSum - prevElement + currentNum * prevElement, currentNum * prevElement)

                    #Handling number starts with 0 case
                    if num[currentIndex] == "0":
                        break

        dfs(0, [], 0, 0)

        return res