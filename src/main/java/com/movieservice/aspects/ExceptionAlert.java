package com.movieservice.aspects;

import net.bytebuddy.asm.Advice;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAlert {

    public ExceptionAlert() {
        System.err.println("Class Scanned");
    }

    @After(value = "execution(* com.movieservice.advices.*.*(..))")
    public void sendEmail(JoinPoint joinPoint) {
        //enviar email;
        System.err.println("Enviando email");
    }
}
