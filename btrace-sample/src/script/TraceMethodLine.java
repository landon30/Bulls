/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package script;

import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.strcat;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class TraceMethodLine {

    // fullname
    @OnMethod(clazz = "example.CaseObject", location = @Location(value = Kind.LINE, line = 18))
    public static void traceExecute(@ProbeClassName String pcn, @ProbeMethodName String pmn,
            int line) {
        println(strcat(strcat(strcat("call ", pcn), "."), pmn));
    }
}
