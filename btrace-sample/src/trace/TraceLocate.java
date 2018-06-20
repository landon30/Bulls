/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package trace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class TraceLocate {

    @OnMethod(clazz = "/practice.*/", method = "/.*/")
    public static void locateByRegex(@ProbeClassName String probeClass,
            @ProbeMethodName String probeMethod) {
        BTraceUtils.println("locateByRegex: entered:" + probeClass + "#" +
                probeMethod);
    }

    @OnMethod(clazz = "+practice.IHandler", method = "/.*/")
    public static void locateByInterface(@ProbeClassName String probeClass,
            @ProbeMethodName String probeMethod) {
        BTraceUtils.println("locateByInterface: entered:" + probeClass + "#" +
                probeMethod);
    }

    @OnMethod(clazz = "/practice.*/", method = "@practice.LogicMethod")
    public static void locateByAnnotation(@ProbeClassName String probeClass,
            @ProbeMethodName String probeMethod) {
        BTraceUtils.println("locateByAnnotation: entered:" + probeClass + "#" +
                probeMethod);
    }

    @OnMethod(clazz = "/practice.*/", method = "<init>")
    public static void locateConstructor(@ProbeClassName String probeClass,
            @ProbeMethodName String probeMethod) {
        BTraceUtils.println("locateConstructor: entered:" + probeClass + "#" +
                probeMethod);
    }
}
