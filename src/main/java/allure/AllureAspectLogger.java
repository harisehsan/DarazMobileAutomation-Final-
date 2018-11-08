package allure;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AllureAspectLogger {
    @AfterThrowing(
            pointcut = "execution(* base.BaseSteps+.*(..))",
            throwing= "error")
    public void logAfterFailed(JoinPoint joinPoint, Throwable error) {
        AllureAttachment.attachScreenShot("Failed Screenshot");
        AllureAttachment.attachHtml("Failed HTML");
        AllureAttachment.attachURL("Current URL");
    }
}
