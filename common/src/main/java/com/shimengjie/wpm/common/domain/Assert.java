package com.shimengjie.wpm.common.domain;


import com.shimengjie.wpm.common.exception.ParamException;
import com.shimengjie.wpm.common.utils.CollectionUtil;

import java.util.Collection;
import java.util.Map;

/**
 * @author shimengjie
 */
public class Assert {

    protected Assert() {
    }

    public void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtil.isEmpty(collection)) {
            throw new ParamException(message);
        }
    }

    public void notEmpty(Map<?, ?> map, String message) {
        if (CollectionUtil.isMapEmpty(map)) {
            throw new ParamException(message);
        }
    }

    protected void sizeEqual(int size1, int size2, String message) {
        if (size1 != size2) {
            throw new ParamException(message);
        }
    }

    protected void notNull(Object anObject, String message) {
        if (anObject == null) {
            throw new ParamException(message);
        }
    }

    protected void notLess(int size, int limit, String message) {
        if (size < limit) {
            throw new ParamException(message);
        }
    }

    protected void assertArgumentRange(int value, int min, int max, String message) {
        if (value < min || value > max) {
            throw new ParamException(message);
        }
    }

    protected void assertArgumentRange(long value, long min, long max, String message) {
        if (value < min || value > max) {
            throw new ParamException(message);
        }
    }

}
