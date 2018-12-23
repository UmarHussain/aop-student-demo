package com.tutorialspoint.aopstudentdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Logger {

    /** Following is the definition for a PointCut to select
     *  all the methods available. So advice will be called
     *  for all the methods.
     */
    @Pointcut("execution(* com.tutorialspoint.aopstudentdemo.entity.*.*(..))")
    private void selectAll(){}

    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    @Before("selectAll()")
    public void beforeAdvice(){
        System.out.println("Going to setup student profile.");
    }

    /** Following is the definition for a PointCut to select
     *  all the methods available. So advice will be called
     *  for all the methods.
     */
    @Pointcut("execution(* com.tutorialspoint.aopstudentdemo.entity.Student.getAge(..))")
    private void selectGetAge(){}

    /**
     * This is the method which I would like to execute
     * after a selected method execution.
     */
    @After("selectGetAge()")
    public void afterAdvice(){
        System.out.println("Student profile setup completed.");
    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution.
     * when the method has been executed sucessfully
     */
    @AfterReturning(pointcut = "execution(* com.tutorialspoint.aopstudentdemo.entity.Student.getName(..))",returning = "retVal")
    public void afterReturningAdvice(JoinPoint jp, Object retVal){
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Returning:" + retVal.toString() );
    }

    /**
     * This is the method which I would like to execute
     * around a selected method execution.
     */
    @Around("selectGetAge()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("Around advice");
        Object[] args = proceedingJoinPoint.getArgs();
        if(args.length>0){
            System.out.print("Arguments passed: " );
            for (int i = 0; i < args.length; i++) {
                System.out.print("arg "+(i+1)+": "+args[i]);
            }
        }

        Object result = proceedingJoinPoint.proceed(args);
        System.out.println("Returning " + result);
    }



}
