/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package advance.hotswap.custorm;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * main
 *
 * @date 2018-07-04
 * @author lvwenyong@playcrab.com
 */
public class Demo {

    public static IShopService service = new ShopService();

    public static void main(String[] args) throws Exception {
        run();
    }

    public static void run() throws Exception {
        // 调用service某个方法
        service.buy(ThreadLocalRandom.current().nextInt(10000),
                ThreadLocalRandom.current().nextInt(1000),
                ThreadLocalRandom.current().nextInt(100));

        TimeUnit.SECONDS.sleep(10);

        // 从输出中发现service代码bug，可直接ide中编辑源代码，然后hotswap
        checkHotswap();

        // hotswap后的业务逻辑
        service.buy(ThreadLocalRandom.current().nextInt(10000),
                ThreadLocalRandom.current().nextInt(1000),
                ThreadLocalRandom.current().nextInt(100));
    }

    public static void checkHotswap() throws Exception {
        System.out.println("------------------- begin hotswap -------------------");

        HotSwapClassLoader classLoader = new HotSwapClassLoader(
                ClassLoader.getSystemResource("").toURI());
        classLoader.assignLoadedClazzs("advance.hotswap.custorm.ShopService");

        // 调用loadClass方法加载类
        Class<?> clazz = classLoader.loadClass("advance.hotswap.custorm.ShopService");

        // 替换实例
        service = (IShopService) clazz.newInstance();

        System.out.println("------------------- end hotswap -------------------");
    }
}
