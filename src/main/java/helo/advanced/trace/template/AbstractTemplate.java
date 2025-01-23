package helo.advanced.trace.template;

import helo.advanced.trace.TraceStatus;
import helo.advanced.trace.logTrace.LogTrace;

public abstract class AbstractTemplate<T> {
    private final LogTrace trace;
    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }
    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            //로직 호출 (추상화)
            T result = call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
    protected abstract T call();
}
