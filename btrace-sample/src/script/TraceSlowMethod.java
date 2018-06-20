/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package script;

import static com.sun.btrace.BTraceUtils.println;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;

@BTrace
public class TraceSlowMethod {

    @OnMethod(clazz = "example.CaseObject", method = "execute", location = @Location(Kind.RETURN))
    public static void traceSlow(@ProbeClassName String pcn, @Duration long duration) {
        if (duration > 600 * 1000000) {
            println(pcn + ",duration:" + duration / 1000000);
        }
    }
}
