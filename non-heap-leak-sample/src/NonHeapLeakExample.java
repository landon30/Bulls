import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;

/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

/**
 * 堆外内存检测example
 *
 * @date 2018-06-12
 * @author lvwenyong@playcrab.com
 */
public class NonHeapLeakExample {

    public static void main(String[] args) throws Exception {
        testLeak();
    }

    public static void testLeak() throws Exception {
        String originData = "Duty,Honor, Country.Those three hallowed words reverently dictate "
                + "what you ought to be, "
                + "what you can be,"
                + " what you will be";
        byte[] input = originData.getBytes("UTF-8");

        System.out.println("origin.size:" + input.length);

        int loop = Integer.MAX_VALUE;

        for (int i = 0; i < loop; i++) {
            byte[] output = new byte[512];

            Deflater deflater = new Deflater();
            deflater.setInput(input);
            deflater.finish();
            int compressedSize = deflater.deflate(output);
            // deflater.end();

            System.out.println("compressed.size:" + compressedSize);

            TimeUnit.SECONDS.sleep(1);
        }
    }
}
