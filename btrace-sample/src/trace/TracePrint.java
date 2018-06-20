/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package trace;

import java.lang.reflect.Field;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.Return;
import com.sun.btrace.annotations.Self;
import com.sun.btrace.annotations.TLS;

@BTrace
public class TracePrint {

    @TLS
    private static String rid = "";

    @OnMethod(clazz = "practice.HeroHandler", method = "/.*/", location = @Location(Kind.RETURN))
    public static void printMethodSignature(@Self Object self, long heroId, @Return AnyType result,
            @ProbeMethodName String pmn) {
        BTraceUtils.println(pmn + " args:" + heroId + " result:" + result);
    }

    @OnMethod(clazz = "practice.PlayerService", method = "onPlayerLogin")
    public static void printField(@Self Object self) {
        Field field = BTraceUtils.field("practice.PlayerService", "playerMap");
        BTraceUtils.println("PlayerService.playerMap:" + BTraceUtils.get(field, self));
    }

    @OnMethod(clazz = "practice.Player", method = "<init>")
    public static void tlsSet(String rid) {
        TracePrint.rid = rid;
    }

    @OnMethod(clazz = "practice.PlayerService", method = "onPlayerLogin")
    public static void tlsGet() {
        BTraceUtils.println("onPlayerLogin.rid:" + TracePrint.rid);
    }
}
