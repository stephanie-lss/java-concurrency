package com.lss.phase3.ch3;

import java.io.*;

/**
 * @author LiSheng
 * @date 2020/7/1 12:35
 */
public class MyClassLoader extends ClassLoader {
    private final static String DEFAULT_DIR = "F:\\app\\classloader1";

    private String dir = DEFAULT_DIR;

    private String classLoaderName;

    public MyClassLoader() {
        super();
    }

    public MyClassLoader(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(String classLoaderName, ClassLoader parent) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File classFile = new File(dir, classPath + ".class");
        if (!classFile.exists()) {
            throw new ClassNotFoundException("The class " + name + " not found.");
        }

        byte[] classBytes = loadClassBytes(classFile);
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("load the class " + name + "failed");
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    //破坏双亲委托机制，重写loadclass方法，改变类加载的顺序
    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        Class<?> clazz = null;

        if (name.startsWith("java.")) {
            try {
                ClassLoader system = ClassLoader.getSystemClassLoader();
                clazz = system.loadClass(name);
                if (clazz != null) {
                    if (resolve) {
                        resolveClass(clazz);
                        return clazz;
                    }
                }
            } catch (Exception e) {
                //ignore
            }
        }

        try {
            clazz = findClass(name);
        } catch (Exception e) {

        }
        if (clazz == null && getParent() != null) {
            getParent().loadClass(name);
        }
        return clazz;
    }


    private byte[] loadClassBytes(File classFile) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(classFile)) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDefaultDir() {
        return DEFAULT_DIR;
    }

    public String getDir() {
        return dir;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }
}
