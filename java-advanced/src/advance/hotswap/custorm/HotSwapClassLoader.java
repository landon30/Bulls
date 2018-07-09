/**
 * Copyright (c) 2018 playcrab.All rights reserved.
 */

package advance.hotswap.custorm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义classloader实现
 * 
 * http://www.blogjava.net/landon/archive/2015/07/03/426025.html
 *
 * @date 2018-07-04
 * @author lvwenyong@playcrab.com
 */
public class HotSwapClassLoader extends ClassLoader {

    private URI reloadBaseDir;
    private Set<String> reloadClazzs;

    public HotSwapClassLoader(URI loadDir) {
        // 指定父加载器为null
        super(null);

        this.reloadBaseDir = loadDir;

        reloadClazzs = new HashSet<>();
    }

    /**
     * 指定加载的类
     * 
     * <p>
     * 通过根目录+Full-Name找到.class
     * 
     * @param clazzNames
     */
    public void assignLoadedClazzs(String... clazzNames) {
        for (String clazzName : clazzNames) {
            defineClassFromPath(getLoadedClassPath(clazzName), clazzName);
        }

        // 添加至加载的集合
        reloadClazzs.addAll(Arrays.asList(clazzNames));
    }

    /**
     * 根据类名获取所在路径
     * 
     * @param clazzName
     * @return
     */
    private Path getLoadedClassPath(String clazzName) {
        String pathName = clazzName.replace('.', File.separatorChar);
        String classPathName = pathName + ".class";

        return Paths.get(reloadBaseDir).resolve(classPathName);
    }

    /**
     * 从指定的Path接收类字节码->转换为Class实例
     * 
     * @param path
     * @param clazzFullName
     * @return
     */
    private Class<?> defineClassFromPath(Path path, String clazzFullName) {
        File classFile = path.toFile();
        int fileLength = (int) classFile.length();

        byte[] rawBytes = new byte[fileLength];

        try {
            InputStream in = Files.newInputStream(path);
            in.read(rawBytes);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Converts an array of bytes into an instance of class Class. Before
        // the Class can be used it must be resolved.
        return defineClass(clazzFullName, rawBytes, 0, fileLength);
    }

    // Loads the class
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz = null;

        clazz = findLoadedClass(name);

        if (!this.reloadClazzs.contains(name) && clazz == null) {
            clazz = getSystemClassLoader().loadClass(name);
        }

        if (clazz == null) {
            throw new ClassNotFoundException(name);
        }

        if (resolve) {
            // Links the specified class
            resolveClass(clazz);
        }

        return clazz;
    }
}
