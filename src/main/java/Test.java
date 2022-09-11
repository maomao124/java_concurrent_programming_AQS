import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project name(项目名称)：java并发编程_AQS
 * Package(包名): PACKAGE_NAME
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/11
 * Time(创建时间)： 13:19
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(Test.class);
    /**
     * 锁
     */
    private static final MyLock lock = new MyLock();

    public static void main(String[] args)
    {
        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.debug("尝试获取锁");
                lock.lock();
                try
                {
                    log.debug("获取到锁");
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    lock.unlock();
                    log.debug("释放锁");
                }
            }
        }, "t1");

        Thread thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.debug("尝试获取锁");
                lock.lock();
                try
                {
                    log.debug("获取到锁");
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    lock.unlock();
                    log.debug("释放锁");
                }
            }
        }, "t2");

        thread1.start();
        thread2.start();
    }
}
