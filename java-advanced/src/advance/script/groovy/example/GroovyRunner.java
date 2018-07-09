/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package advance.script.groovy.example;

import java.util.concurrent.TimeUnit;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;

/**
 * GroovyRunner
 *
 * @date 2018-07-09
 * @author lvwenyong@playcrab.com
 */
public class GroovyRunner {
    public static void main(String[] args) throws Exception {
        GroovyScriptEngine engine = new GroovyScriptEngine(
                GroovyRunner.class.getResource(".").getPath());

        while (true) {
            engine.run("test.groovy", new Binding());
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
