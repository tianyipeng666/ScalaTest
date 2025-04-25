package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableUtil {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableCheck callableCheck = new CallableCheck();
        // 创建FutureTask，传入Callable
        FutureTask futureTask = new FutureTask<>(callableCheck);
        // 构建Thread执行futureTask
        Thread thread = new Thread(futureTask);
        thread.start();
        // 阻塞获取结果
        Object count = futureTask.get();
    }
}

class CallableCheck implements Callable{
    @Override
    public Object call() throws Exception {
        int count = 1;
        return count;
    }
}
