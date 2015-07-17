package com.nih.processor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Processor<T> {
	class RunnableHandler implements Runnable {

		private IRequestHandler<T> handler;
		private T request;

		public RunnableHandler(IRequestHandler<T> requestHandler, T req) {
			handler = requestHandler;
			request = req;
		}

		@Override
		public void run() {
			try {
				handler.processRequests(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	ExecutorService executorService;
	IRequestHandler<T> requestHandler;

	/**
	 * Processes requests from the queue with no more than
	 * maxThreads threads
	 * For each request object calls
	 * IRequestHandler<T>.processRequest(o) only once in a separate thread
	 * When the queue is empty and all processing is finished
	 * no threads exist.
	 *
	 * @param rh         - an object that handles requests
	 * @param maxThreads - total number of threads
	 */
	public Processor(final IRequestHandler<T> rh, int maxThreads) {
		requestHandler = rh;
		executorService = Executors.newFixedThreadPool(maxThreads);
	}

	/**
	 * Puts the request into a queue, does not wait
	 * for the request to complete
	 *
	 * @param o - request object
	 */
	public void addRequest(T o) {
		executorService.submit(new RunnableHandler(requestHandler, o));
	}

	/**
	 * OPTIONAL
	 * Asynchronous shutdown, returns immediately.
	 * Instructs the processor to stop accepting requests
	 * and finish existing tasks
	 *
	 * @param o – if not null, notifies all waiting threads on
	 *          this object upon successful shutdown
	 */
	public void shutDown(Object o) {
		executorService.shutdown();
		if (o != null) {
			while (!executorService.isTerminated()) {
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {}
			}

			synchronized (o) {
				o.notifyAll();
			}
		}
	}

	/**
	 * OPTIONAL
	 *
	 * @returns true if the processor is shut down
	 */
	public boolean isShutDown() {
		return executorService.isShutdown();
	}
}
