package com.eot.autoLogJ;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DynamicLogger implements MethodInterceptor {
    public DynamicLogger(String configFile) {
        Path path = Paths.get(configFile)
                         .toAbsolutePath();
        File configToLoad = new File(path.toString());
    }

    public Object intercept(Object object, Method method, Object[] methodArgs, MethodProxy methodProxy)
            throws Throwable {

        String className = method.getDeclaringClass()
                                 .getName();
        String simpleClassName = method.getDeclaringClass()
                                       .getSimpleName();
        String methodName = method.getName();
        if (shouldTrackPackage(className, methodName)) {
            if (shouldAddStepInReport(className, method)) {
                System.out.println(String.format(">> Adding Step - %s::%s", simpleClassName, methodName));
            }
            System.out.println(String.format(">> Started  - %s::%s", className, methodName));
        }
        Object superMethodResult = methodProxy.invokeSuper(object, methodArgs);
        if (shouldTrackPackage(className, methodName)) {
            System.out.println(String.format(">> Finished - %s::%s", className, methodName));
        }
        return superMethodResult;
    }

    private boolean shouldAddStepInReport(String className, Method method) {
        return ((className.contains("com.myntra.core.business")) || (className.contains("com.myntra.core.pages")));
    }

    private boolean isMethodPublic(Method method) {
        try {
            int modifiers = method.getDeclaringClass()
                                  .getMethod(method.getName(), null)
                                  .getModifiers();
            return Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers) || Modifier.isStatic(modifiers);
        } catch (NoSuchMethodException e) {
            System.out.println(String.format("Method - %s - not found in class - %s", method.getName(),
                    method.getDeclaringClass()
                          .getName()));
            return false;
        }
    }

    private boolean shouldTrackPackage(String className, String methodName) {
        return true;
        }
}
