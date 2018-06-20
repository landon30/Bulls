/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package practice;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class LoginHandler implements IHandler {

    // 登录
    public void login(String rid) {
        System.out.println("login:" + rid);

        loadFromDB(rid);
        doLoginEvent(rid);

        PlayerService.INSTANCE.onPlayerLogin(rid);
    }

    private void loadFromDB(String rid) {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doLoginEvent(String rid) {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(200));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 登出
    public void logout(String rid) {
        System.out.println("logout:" + rid);

        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(500));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 重连
    public void reconnect(String rid) {
        System.out.println("reconnect:" + rid);

        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(100));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void error(String rid) {
        System.out.println("error:" + rid);
        // throw exception
        System.out.println(10 / 0);
    }
}
