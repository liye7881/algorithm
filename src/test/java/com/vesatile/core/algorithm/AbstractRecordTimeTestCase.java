package com.vesatile.core.algorithm;

import java.lang.reflect.Method;
import java.text.NumberFormat;

import org.apache.log4j.Logger;

public abstract class AbstractRecordTimeTestCase {
	private static Logger logger = Logger
			.getLogger(AbstractRecordTimeTestCase.class);

	protected Object execute(Object target, String methodName, Object[] args) {
		Object result = null;
		long start = currentTime(true);
		for (Method method : target.getClass().getMethods()) {
			if (method.getName().equals(methodName)) {
				try {
					result = method.invoke(target, args);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if (logger.isInfoEnabled()) {
			String cost = NumberFormat.getInstance().format(
					currentTime(true) - start);
			String message = "Execute " + methodName + " in " + cost;
			logger.info(message);
		}

		return result;
	}

	protected Object execute(Object target, String methodName, Object[] args,
			boolean nano) {
		Object result = null;
		long start = currentTime(nano);
		for (Method method : target.getClass().getMethods()) {
			if (method.getName().equals(methodName)) {
				try {
					result = method.invoke(target, args);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("Execute " + methodName + " in "
					+ (currentTime(nano) - start));
		}

		return result;
	}

	private long currentTime(boolean nano) {
		long result = System.currentTimeMillis();
		if (nano) {
			result = System.nanoTime();
		}
		return result;
	}
}
