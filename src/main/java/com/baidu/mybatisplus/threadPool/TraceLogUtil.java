package com.baidu.mybatisplus.threadPool;

import org.slf4j.MDC;

import java.util.UUID;

public class TraceLogUtil {

    public static String getTraceId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void setTraceId(){
        MDC.put("traceId", UUID.randomUUID().toString());
    }

    public static void setTraceId( String traceId){
        MDC.put("traceId",traceId);
    }


}
