/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package trace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.BTraceUtils.Sys;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.OnTimer;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class TraceTypicalScenes {

    @OnMethod(clazz = "+practice.IHandler", method = "/.*/", location = @Location(Kind.RETURN))
    public static void traceSlowCalls(@ProbeClassName String pcn, @ProbeMethodName String pmn,
            @Duration long duration) {
        // >500ms
        if (duration > 500 * 1000000L) {
            BTraceUtils.println(pcn + "." + pmn + " slow:" + duration / 1000000L);
        }
    }

    @OnMethod(clazz = "practice.PlayerService", method = "onPlayerLogin")
    public static void traceCallee() {
        BTraceUtils.println("enter method:practice.PlayerService.onPlayerLogin");
        BTraceUtils.jstack();
    }

    @OnTimer(5000)
    public static void printMem() {
        BTraceUtils.println("Heap:");
        BTraceUtils.println(Sys.Memory.heapUsage());
        BTraceUtils.println("Non-Heap:");
        BTraceUtils.println(Sys.Memory.nonHeapUsage());
    }
}
