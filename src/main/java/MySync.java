import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * Project name(项目名称)：java并发编程_AQS
 * Package(包名): PACKAGE_NAME
 * Class(类名): MySync
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/11
 * Time(创建时间)： 13:06
 * Version(版本): 1.0
 * Description(描述)： 自定义同步器
 */

public final class MySync extends AbstractQueuedSynchronizer
{
    @Override
    protected boolean tryAcquire(int arg)
    {
        if (arg == 1)
        {
            if (compareAndSetState(0, 1))
            {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg)
    {
        if (arg == 1)
        {
            if (getState() == 0)
            {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        return false;
    }

    @Override
    protected boolean isHeldExclusively()
    {
        return getState() == 1;
    }

    Condition newCondition()
    {
        return new ConditionObject();
    }
}
