package com.anil.enablerannotation.commonheader.annotations;

import com.anil.enablerannotation.commonheader.CommonHeadersImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CommonHeadersImportSelector.class)
public @interface EnableCommonHeaders {

    boolean enableHostHeader() default true;

    boolean enableTraceIdHeader() default true;
}
