/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package script;

import static com.sun.btrace.BTraceUtils.jstack;
import static com.sun.btrace.BTraceUtils.println;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

@BTrace
public class TraceMethodCallee {
    // full name
    @OnMethod(clazz = "example.CaseObject", method = "execute")
    public static void traceExecute() {
        println("who call CaseObject.execute :");
        jstack();
    }
}
