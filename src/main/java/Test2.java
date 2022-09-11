import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Project name(项目名称)：java并发编程_AQS
 * Package(包名): PACKAGE_NAME
 * Class(类名): Test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/11
 * Time(创建时间)： 13:31
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test2
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(Test2.class);

    /**
     * 不可重入锁
     */
    private static final MyLock lock = new MyLock();

    /**
     * 可重入锁
     */
    //private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args)
    {
        log.debug("尝试获取锁");
        lock.lock();
        try
        {
            log.debug("获取到锁");
            m1();
        }
        finally
        {
            lock.unlock();
            log.debug("释放锁");
        }

    }

    private static void m1()
    {
        log.debug("尝试获取锁");
        lock.lock();
        try
        {
            log.debug("获取到锁");
            m2();
        }
        finally
        {
            lock.unlock();
            log.debug("释放锁");
        }
    }

    private static void m2()
    {
        log.debug("尝试获取锁");
        lock.lock();
        try
        {
            log.debug("获取到锁");
            m3();
        }
        finally
        {
            lock.unlock();
            log.debug("释放锁");
        }
    }

    private static void m3()
    {
        log.debug("尝试获取锁");
        lock.lock();
        try
        {
            log.debug("获取到锁");
        }
        finally
        {
            lock.unlock();
            log.debug("释放锁");
        }
    }
}
