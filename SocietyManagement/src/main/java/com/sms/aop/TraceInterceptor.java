package com.sms.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;


public class TraceInterceptor extends CustomizableTraceInterceptor {

	private static final long serialVersionUID = 5603543136419872016L;
	
	private Logger loggerSlf4j = LoggerFactory.getLogger(getClass());

    @Override
    protected void writeToLog(Log logger, String message, Throwable ex) {
        if (ex != null) {
            loggerSlf4j.error(message, ex);
        } else {
            loggerSlf4j.debug(message);
        }
    }

    @Override
    protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) {
        return true;
    }
}
