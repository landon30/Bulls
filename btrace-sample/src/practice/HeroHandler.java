/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package practice;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class HeroHandler implements IHandler {

    @LogicMethod
    public void starUp(long heroId) {
        // test exception
        if (heroId >= 500000L) {
            throw new IllegalArgumentException("starUp illegal heroId," + heroId);
        }

        System.out.println("starUp:" + heroId);

        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @LogicMethod
    public void qualityUp(long heroId) {
        System.out.println("qualityUp:" + heroId);

        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
