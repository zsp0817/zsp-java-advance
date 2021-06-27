package com.zsp.java;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * Created by zhangshaopeng on 2021/6/24.
 * <p>
 * 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，
 * 此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。
 */
public class XlassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new XlassLoader();
        Class<?> clazz = classLoader.loadClass("Hello");
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getMethod("hello");
        method.invoke(instance);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取resources下的xlass文件
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name + ".xlass")) {

            // 以字节的方式读取文件
            int length = inputStream.available();
            byte[] content = new byte[length];
            inputStream.read(content);

            byte[] result = decode(content);
            return defineClass(name, result, 0, result.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] decode(byte[] content) {
        // 转换成原来的字节
        byte[] result = new byte[content.length];
        for (int i = 0; i < content.length; i++) {
            result[i] = (byte) (255 - content[i]);
        }
        return result;
    }
}
