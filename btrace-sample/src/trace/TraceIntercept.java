/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package trace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.TargetInstance;
import com.sun.btrace.annotations.TargetMethodOrField;
import com.sun.btrace.annotations.Where;

@BTrace
public class TraceIntercept {

    @OnMethod(clazz = "practice.LoginHandler", method = "login", location = @Location(Kind.ENTRY))
    public static void interceptKindEntry(String rid) {
        BTraceUtils.println("interceptKindEntry.login:" + rid);
    }

    @OnMethod(clazz = "practice.LoginHandler", method = "login", location = @Location(Kind.RETURN))
    public static void interceptKindReturn(String rid, @Duration long duration) {
        BTraceUtils.println("interceptKindReturn.login:" + rid + ",process time:"
                + duration / 1000000 + " ms");
    }

    @OnMethod(clazz = "+practice.IHandler", method = "/.*/", location = @Location(Kind.THROW))
    public static void interceptKindThrow(@ProbeMethodName String pmn) {
        BTraceUtils.println("interceptKindThrow:" + pmn);
    }

    @OnMethod(clazz = "practice.LoginHandler", method = "login", location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/", where = Where.AFTER))
    public static void interceptKindCall(@TargetInstance Object instance,
            @TargetMethodOrField String method, @Duration long duration) {
        Class<?> clazz = BTraceUtils.classOf(instance);
        String clazzName = BTraceUtils.name(clazz);
        BTraceUtils.println("interceptKindCall.login.call:" + clazzName + "." + method);
    }

    @OnMethod(clazz = "practice.HeroHandler", method = "starUp", location = @Location(value = Kind.LINE, line = 16))
    public static void interceptKindLine() {
        BTraceUtils.println("interceptKindLine.startUp#16L,trigger throw exception");
    }
}
