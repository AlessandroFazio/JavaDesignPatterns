package github.alessandrofazio.design.patter.builder.exercise.exercise1;

public final class ThreadBuilder {
    public ThreadBuilder(Runnable runnable, String name) {
        this.runnable = runnable;
        this.name = name;
    }

    private ThreadGroup group = Thread.currentThread().getThreadGroup();
    private Runnable runnable;
    private String name;
    private long stackSize = 0;
    private Boolean daemon;
    private Integer priority;
    private boolean inheritThreadLocal = true;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    public ThreadBuilder group(ThreadGroup group) {
        this.group = group;
        return this;
    }

    public ThreadBuilder runnable(Runnable runnable) {
        this.runnable = runnable;
        return this;
    }

    public ThreadBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ThreadBuilder stackSize(long stackSize) {
        this.stackSize = stackSize;
        return this;
    }

    public ThreadBuilder daemon(boolean daemon) {
        this.daemon = daemon;
        return this;
    }

    public ThreadBuilder priority(int priority) {
        this.priority = priority;
        return this;
    }

    public ThreadBuilder uncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        return this;
    }

    public ThreadBuilder inheritThreadLocal(boolean inheritThreadLocal) {
        this.inheritThreadLocal = inheritThreadLocal;
        return this;
    }

    public Thread build() {
        Thread thread = new Thread(group, runnable, name, stackSize, inheritThreadLocal);
        if(daemon != null) thread.setDaemon(daemon);
        if(priority != null) thread.setPriority(priority);
        if(uncaughtExceptionHandler != null) thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        return thread;
    }
}
