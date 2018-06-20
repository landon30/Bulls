import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

@BTrace
public class TraceDeflate {

    @OnMethod(clazz = "java.util.zip.Deflater", method = "<init>")
    public static void traceStack() {
        BTraceUtils.jstack();
    }
}
