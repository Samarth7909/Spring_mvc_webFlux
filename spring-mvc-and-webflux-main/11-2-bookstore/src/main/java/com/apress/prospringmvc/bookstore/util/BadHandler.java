package com.apress.prospringmvc.bookstore.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * on 15/08/2025
 */
@Target(value = { ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.SOURCE)
public @interface BadHandler {
}