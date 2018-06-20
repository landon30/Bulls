/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package example;

/**
 * btrace sample#CaseObject
 *
 * @date 2018-06-07
 * @author lvwenyong@playcrab.com
 */
public class CaseObject {

    private static int sleepTotalTime = 0;

    public boolean execute(int sleepTime) throws Exception {
        System.out.println("sleep: " + sleepTime);

        sleepTotalTime += sleepTime;

        Thread.sleep(sleepTime);

        return true;
    }
}
