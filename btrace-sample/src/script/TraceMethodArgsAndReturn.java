/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package script;

import static com.sun.btrace.BTraceUtils.field;
import static com.sun.btrace.BTraceUtils.get;
import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.str;
import static com.sun.btrace.BTraceUtils.strcat;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.Return;
import com.sun.btrace.annotations.Self;

@BTrace
public class TraceMethodArgsAndReturn {

    // 指定full name
    @OnMethod(clazz = "example.CaseObject", method = "execute", location = @Location(Kind.RETURN))
    public static void traceExecute(@Self Object instance, int sleepTime,
            @Return boolean result) {
        println("call CaseObject.execute");

        println(strcat("sleepTime is:", str(sleepTime)));

        // 这里也要full name
        println(strcat("sleepTotalTime is:",
                str(get(field("example.CaseObject", "sleepTotalTime"), instance))));

        println(strcat("return value is:", str(result)));
    }
}
