/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package practice;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class BtraceMain {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        LoginHandler loginHandler = new LoginHandler();
        HeroHandler heroHandler = new HeroHandler();

        while (true) {
            try {
                String rid = String.valueOf(ThreadLocalRandom.current().nextInt(10000));
                loginHandler.login(rid);
                loginHandler.logout(rid);
                loginHandler.reconnect(rid);

                TimeUnit.SECONDS.sleep(1);

                long heroId = ThreadLocalRandom.current().nextLong(1000000L);
                heroHandler.qualityUp(heroId);
                heroHandler.starUp(heroId);

                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
