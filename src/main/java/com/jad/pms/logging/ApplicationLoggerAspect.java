package com.jad.pms.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApplicationLoggerAspect {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Pointcut("within(com.jad.pms.controllers..*)"
			+ "|| within(com.jad.pms.dao..*)")
	public void definePackagePointcuts() {
		//empty method to name the location specified in the pointcut
		
	}
	@Before("definePackagePointcuts()")
	public void Log() {
		log.debug("--------------------------");
	}
}
