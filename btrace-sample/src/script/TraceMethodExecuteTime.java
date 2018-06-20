/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package script;

import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.str;
import static com.sun.btrace.BTraceUtils.strcat;
import static com.sun.btrace.BTraceUtils.timeMillis;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.Return;
import com.sun.btrace.annotations.TLS;

@BTrace
public class TraceMethodExecuteTime {
    @TLS
    static long beginTime;

    // fullname
    @OnMethod(clazz = "example.CaseObject", method = "execute")
    public static void traceExecuteBegin() {
        beginTime = timeMillis();
    }

    // fullname
    @OnMethod(clazz = "example.CaseObject", method = "execute", location = @Location(Kind.RETURN))
    public static void traceExecute(int sleepTime, @Return boolean result) {
        println(strcat(strcat("CaseObject.execute time is:", str(timeMillis() - beginTime)), "ms"));
    }
}
