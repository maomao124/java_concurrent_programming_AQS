import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Project name(项目名称)：java并发编程_AQS
 * Package(包名): PACKAGE_NAME
 * Class(类名): MyLock
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/11
 * Time(创建时间)： 13:13
 * Version(版本): 1.0
 * Description(描述)： 自定义锁
 */

public class MyLock implements Lock
{
    private static final MySync sync = new MySync();

    @Override
    public void lock()
    {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException
    {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock()
    {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException
    {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock()
    {
        sync.tryRelease(1);
    }

    @Override
    public Condition newCondition()
    {
        return sync.newCondition();
    }
}
