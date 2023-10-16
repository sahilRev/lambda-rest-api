package org.consultadd.lambdarestapi.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class BeanContext {

    private static BeanContext beanContext;

    private static HashMap<Class, Object> context = new HashMap<>();

    private BeanContext() {
    }

    public synchronized static BeanContext getInstance() {
        if (beanContext == null) {
            beanContext = new BeanContext();
        }
        return beanContext;
    }

    public Object getBean(Class clazz) throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException, IllegalArgumentException {
        if (!context.containsKey(clazz)) {
            if (null == clazz || clazz.isArray() || clazz.isEnum() || clazz.isPrimitive() || clazz.isAnonymousClass()) {
                throw new IllegalAccessException("Invalid class type, a class should now be a ArrayClass, Enum, " +
                        "Primitive or Abstract class");
            }
            context.put(clazz, clazz.getDeclaredConstructor().newInstance());
        }
        return clazz.cast(context.get(clazz));
    }

}
