package com.nih;

import com.nih.uniqlist.UniqueList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;

public class UniqueListSpec
		extends TestCase {

	public UniqueListSpec(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(UniqueListSpec.class);
	}


	public void testSimple3() {
		Integer[] input = {10, 11, 12, 13, 14, 15, 16, 15, 16, 19, 20};
		List<Integer> uniqueResult = UniqueList.get5and7(input);
		System.out.println(uniqueResult);
		assertTrue(uniqueResult.size() == 3);
	}

	public void testUniqueResult() {
		Integer[] input = {10, 11, 12, 13, 16, 15, 16, 15, 16, 19, 20};
		List<Integer> uniqueResult = UniqueList.get5and7(input);
		System.out.println(uniqueResult);
		assertTrue(uniqueResult.size() == 2);
	}

}
