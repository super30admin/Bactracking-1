#TC: O(4^n)
#SC: O(n x 4^n)->Recursion
#    O(n)->Backtracking

class Solution(object):

    def __init__(self):
        self.finalList = []

    def __recursion(self, num, target, calc, tail, path, index):

        if (index == len(num)):
            if (calc == target):
                self.finalList.append(''.join(path))
                return

        for i in range(index, len(num)):

            if (index != i and num[index] == '0'):
                break

            curr = long(num[index: i + 1])

            if (index == 0):
                self.__recursion(num, target, curr, curr, [str(curr)], i + 1)
            else:
                path.append('+'); path.append(str(curr))                        
                self.__recursion(num, target, calc + curr, curr, path, i + 1)   
                path.pop(); path.pop()                                          

                path.append('-'); path.append(str(curr))                        
                self.__recursion(num, target, calc - curr, -curr, path, i + 1)  
                path.pop(); path.pop()                                          

                path.append('*'); path.append(str(curr))                                                   #   action
                self.__recursion(num, target, (calc - tail) + (tail * curr), (tail * curr), path, i + 1)   
                path.pop(); path.pop()                                                                 

        return

    def addOperators(self, num, target):
        
        if (num == None or len(num) == 0):
            return self.finalList

        self.__recursion(num, target, 0, 0, [], 0)

        return self.finalList