package site.liuming.truismcms.core.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aop Log.
 */
@Aspect
public class AopLog {

  @Pointcut()
  private void getRequestUrl() {}



}
