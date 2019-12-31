#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Dec 31 12:48:18 2019

@author: tanvirkaur
"""

# time complexity = O(2^n)
# space complexity = O(n)
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.result = []
        if not candidates:
            return self.result
        self.backtrack(candidates, target, 0 , [] , 0)
        return self.result
    def backtrack(self, candidates, target, summ, tmp, index):
        # base case
        if summ > target:
            return 
        if summ == target:
            self.result.append(list(tmp))
        # logic
        for i in range(index,len(candidates)):
            tmp.append(candidates[i])
            self.backtrack(candidates, target, summ+candidates[i], tmp, i)
            #backtrack
            tmp.pop()  #exit from the for lop and in the next iteration index is increment by one 