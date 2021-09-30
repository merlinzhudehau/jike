package com.zdh.home.jvm;




import sun.misc.Launcher;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class JvmClassLoaderPrintPath {

    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器");
        for (URL urL : urLs) {
            System.out.println("====>" + urL.toExternalForm());
        }

        printClassloader("扩展类加载器", JvmClassLoaderPrintPath.class.getClassLoader().getParent());

        printClassloader("应用类加载器",JvmClassLoaderPrintPath.class.getClassLoader());
    }


    private static void printClassloader(String name, ClassLoader classLoader) {
        System.out.println();

        if (null!=classLoader){
            System.out.println(name+"ClassLoader->"+classLoader.toString());
            printUrlForClassLoader(classLoader);
        }else {
            System.out.println(name+"ClassLoader-> null");
        }

    }

    private static void printUrlForClassLoader(ClassLoader classLoader) {
        Object ucp=insightField(classLoader,"ucp");
        Object path=insightField(ucp,"path");
        ArrayList ps = (ArrayList) path;

        for (Object p : ps) {
            System.out.println("====>"+p.toString());
        }

    }

    private static Object insightField(Object obj, String fName) {
        try {
            Field f=null;
            if (obj instanceof URLClassLoader){
                f=URLClassLoader.class.getDeclaredField(fName);
            }else {
                f=obj.getClass().getDeclaredField(fName);
            }
            f.setAccessible(true);
            return f.get(obj);
        } catch ( Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
