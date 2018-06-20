/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package example;

import java.util.Random;

/**
 * btrace sample#case
 *
 * @date 2018-06-07
 * @author lvwenyong@playcrab.com
 */
public class Case {
    public static void main(String[] args) throws Exception {
        Random random = new Random();

        CaseObject object = new CaseObject();
        boolean result = true;

        while (result) {
            result = object.execute(random.nextInt(1000));
            Thread.sleep(1000);
        }
    }
}
