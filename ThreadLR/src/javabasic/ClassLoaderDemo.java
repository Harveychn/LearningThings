package javabasic;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream io = getClass().getResourceAsStream(filename);
                    if (io == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[io.available()];
                    io.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object object = classLoader.loadClass("");
    }
}
