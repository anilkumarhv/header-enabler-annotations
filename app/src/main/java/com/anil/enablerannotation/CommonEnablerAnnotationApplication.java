package com.anil.enablerannotation;

import com.anil.enablerannotation.commonheader.annotations.EnableCommonHeaders;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCommonHeaders(enableHostHeader = true, enableTraceIdHeader = true)
public class CommonEnablerAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonEnablerAnnotationApplication.class, args);
    }
}
