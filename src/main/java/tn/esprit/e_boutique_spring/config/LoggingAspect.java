package tn.esprit.e_boutique_spring.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    private Long t1 = System.currentTimeMillis();
    private Long t2 = System.currentTimeMillis();
    @Before ("execution(public * tn.esprit.e_boutique_spring.Service.ServiceImpl.*(..))")
    public void Before(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

    }
    @After ("execution(public * tn.esprit.e_boutique_spring.Service.ServiceImpl.*(..))")
    public void After(JoinPoint joinPoint) {
        log.info ( "Exuction Time " + (t2 - t1) + "ms");
        log.info(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

    }


}
