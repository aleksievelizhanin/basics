package com.nih.uniqlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueList {

	public static List<Integer> get5and7(Integer[] arr) {
		Set<Integer> unique = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if ((i+1) % 5 == 0 || (i+1) % 7 == 0) {
				unique.add(arr[i]);
			}
		}
		List result = new ArrayList(unique.size());
		result.addAll(unique);
		return result;
	}
}
