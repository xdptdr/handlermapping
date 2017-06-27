package com.github.xdptdr.mbjaxrs.b.holm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jboss.resteasy.annotations.ContentEncoding;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@ContentEncoding("UTF-8")
public @interface HOLM {

}
