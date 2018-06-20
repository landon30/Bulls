/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package practice;

public class Player {

    private final String rid;

    public Player(String rid) {
        this.rid = rid;
    }

    /**
     * @return the rid
     */
    public String getRid() {
        return rid;
    }

    @Override
    public String toString() {
        return "Player [rid=" + rid + "]";
    }
}
