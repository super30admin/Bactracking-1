'''
Time Complexity: O(4**n)
space Complexity: O(n)
'''
class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        op = []
        def dfs(index, expr, calc, tail):
            # print(index, expr, calc, tail)
            # print("___________________________")
            if(calc==target and index == len(num)-1):
                #print(index, expr, calc, tail)
                # print("if---------")
                op.append(expr)
                # print(op)
                return
            if(index>=len(num)-1):
                return
            for i in range(4):
                strv = num[index+1]
                intv = int(num[index+1])
                if(i==0):
                    valexpr = str(expr)+str(strv)
                    val = eval(valexpr)
                    dfs(index+1, valexpr, val, val)
                if(i==1):
                    dfs(index+1, expr+"+"+strv, calc+intv, intv)
                if(i==2):
                    dfs(index+1, expr+"-"+strv, calc-intv, -intv)
                if(i==3):
                    val = (calc-tail)+(tail*intv)
                    dfs(index+1, expr+"*"+strv, val, tail*intv)        
        dfs(0, num[0], int(num[0]), int(num[0]))
        return op