/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package practice;

import java.util.HashMap;
import java.util.Map;

public enum PlayerService {
    INSTANCE;

    private Map<String, Player> playerMap = new HashMap<>();

    public void onPlayerLogin(String rid) {
        System.out.println("onPlayerLogin:" + rid);

        playerMap.putIfAbsent(rid, new Player(rid));
    }

    /**
     * @return the playerMap
     */
    public Map<String, Player> getPlayerMap() {
        return playerMap;
    }
}
