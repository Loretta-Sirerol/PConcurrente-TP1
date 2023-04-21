package utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {
    private final String namePrefix;
    private final AtomicInteger count = new AtomicInteger(1);

    public NamedThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public Thread newThread(Runnable r) {
        return new Thread(r, namePrefix + "-" + count.getAndIncrement());
    }

}
