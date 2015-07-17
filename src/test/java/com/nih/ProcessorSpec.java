package com.nih;

import com.nih.processor.IRequestHandler;
import com.nih.processor.Processor;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ProcessorSpec
		extends TestCase {

	private static final int THREAD_POOL_SIZE = 2;

	public ProcessorSpec(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(ProcessorSpec.class);
	}


	public void testSimple3() {
		Processor<Integer> processor = new Processor<Integer>(new IRequestHandler<Integer>() {
			@Override
			public void processRequests(Integer o) throws Exception {
				System.out.println("Processed " + o);
			}
		}, THREAD_POOL_SIZE);
		processor.addRequest(1);
		processor.addRequest(2);
		processor.addRequest(3);
		processor.shutDown(this);
		assertTrue(true);
	}

}
