package com.vesatile.core.algorithm;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public abstract class AbstractRecordTimeTestCase {
	private static Logger logger = Logger
			.getLogger(AbstractRecordTimeTestCase.class);

	protected Object execute(Object target, String methodName, Object[] args) {
		Object result = null;
		long start = currentTime();
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
					+ (currentTime() - start));
		}

		return result;
	}

	private long currentTime() {
		return System.nanoTime();
	}
}
