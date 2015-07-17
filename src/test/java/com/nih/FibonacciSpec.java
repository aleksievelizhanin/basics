package com.nih;

import com.nih.fib.Fibonacci;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FibonacciSpec
    extends TestCase
{
    public FibonacciSpec(String testName)
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( FibonacciSpec.class );
    }

    public void testFirst10()
    {
        Fibonacci.printSequence(10);
        assertTrue(true);
    }

    public void testRecursiveFirst10() {
        Fibonacci.pringSequenceRecursively(10);
        assertTrue(true);
    }

    public void testRecursiveFirst45() {
        System.out.println(Fibonacci.fib(45));
        assertTrue(true);
    }
}
