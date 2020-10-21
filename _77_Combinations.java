package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {

	public static void main(String[] args) {
		System.out.println(new _77_Combinations().combine(4, 3));
	}

	public static List<List<Integer>>  result = null;

	public List<List<Integer>> combine(int n, int k) {
		result = new ArrayList<List<Integer>>();
		combine(1,  n,k, new ArrayList<Integer>());
		return result;
	}

	public void combine(int pos , int n, int k , List<Integer> temp) {

		if(temp.size() == k) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}

		for(int i=pos; i<=n; i++) {
			temp.add(pos);
			pos = pos + 1;
			combine(pos, n, k, temp);
			temp.remove(temp.size()-1);
		}
	}

}
