/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package advance.script.js.example;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Test;

/**
 * NashornExample
 * 
 * http://www.importnew.com/22667.html
 *
 * @date 2018-07-09
 * @author lvwenyong@playcrab.com
 */
public class NashornExample {

    @Test
    public void test1() throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("print('Hello World!');");
    }

    @Test
    public void test2() throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        String jsPath = getClass().getResource("script.js").getFile();
        engine.eval(new FileReader(jsPath));

        Invocable invocable = (Invocable) engine;

        // fun1
        Object result = invocable.invokeFunction("fun1", "Peter Parker");

        System.out.println(result);
        System.out.println(result.getClass());

        System.out.println("----------------------------------");

        // fun2

        invocable.invokeFunction("fun2", new Date());
        invocable.invokeFunction("fun2", LocalDateTime.now());

        // fun3

        System.out.println("----------------------------------");

        invocable.invokeFunction("fun3");
    }

    @Test
    public void test3() throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        String jsPath = getClass().getResource("script_extend.js").getFile();
        engine.eval(new FileReader(jsPath));

        Invocable invocable = (Invocable) engine;

        // fun1
        invocable.invokeFunction("fun1");

        System.out.println("----------------------------------");

        // fun2
        invocable.invokeFunction("fun2");
    }
}
