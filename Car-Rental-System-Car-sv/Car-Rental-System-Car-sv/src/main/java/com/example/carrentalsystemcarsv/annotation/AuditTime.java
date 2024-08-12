package com.example.carrentalsystemcarsv.annotation;

import jakarta.persistence.Table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Set Annotation On the Method
@Target(ElementType.METHOD)
//  Check RunTime
@Retention(RetentionPolicy.RUNTIME)
public @interface AuditTime {

}
