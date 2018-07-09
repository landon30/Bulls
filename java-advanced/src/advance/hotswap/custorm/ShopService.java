/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package advance.hotswap.custorm;

/**
 * 商店服务实现
 *
 * @date 2018-07-04
 * @author lvwenyong@playcrab.com
 */
public class ShopService implements IShopService {

    @Override
    public void buy(long rid, int tid, int num) {
        System.out.println(rid + " buy: " + tid + ":" + num);

        if (num > 100) {
            // do something else
            System.err.println("num:" + num + " may be wrong");
        }

        System.out.println("ShopService.classLoader:" + getClass().getClassLoader().getClass());

        // operate player data
    }
}
