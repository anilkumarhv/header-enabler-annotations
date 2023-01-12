package com.anil.enablerannotation.commonheader;

import com.anil.enablerannotation.commonheader.annotations.EnableCommonHeaders;
import com.anil.enablerannotation.commonheader.filter.HostHeaderFilter;
import com.anil.enablerannotation.commonheader.filter.TraceIdHeaderFilter;
import com.anil.enablerannotation.commonheader.service.UUIDTraceIdGenerator;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;

public class CommonHeadersImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        var attrs = importingClassMetadata.getAnnotationAttributes(EnableCommonHeaders.class.getName());
        assert attrs != null;
        var enableHostHeader = (Boolean) attrs.get("enableHostHeader");
        var enableTraceIdHeader = (Boolean) attrs.get("enableTraceIdHeader");
        var registeredClassNameList = new ArrayList<String>();
        if (enableHostHeader) {
            registeredClassNameList.add(HostHeaderFilter.class.getName());
        }
        if (enableTraceIdHeader) {
            registeredClassNameList.add(TraceIdHeaderFilter.class.getName());
            registeredClassNameList.add(UUIDTraceIdGenerator.class.getName());
        }
        return registeredClassNameList.toArray(String[]::new);
    }
}
