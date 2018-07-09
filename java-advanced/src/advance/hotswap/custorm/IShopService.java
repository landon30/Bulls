/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package advance.hotswap.custorm;

/**
 * 商店服务接口
 *
 * @date 2018-07-04
 * @author lvwenyong@playcrab.com
 */
public interface IShopService {

    void buy(long rid, int tid, int num);
}
