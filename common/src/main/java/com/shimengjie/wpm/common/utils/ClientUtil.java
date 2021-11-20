package com.shimengjie.wpm.common.utils;

import com.shimengjie.wpm.common.constantt.IReturnCode;
import com.shimengjie.wpm.common.exception.ClientException;
import com.shimengjie.wpm.common.exception.ParamException;
import com.shimengjie.wpm.common.exception.ResponseException;
import com.shimengjie.wpm.common.exception.SystemErrorException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.function.Supplier;

/**
 * 客户端工具类，用于取出响应中的数据和状态消息
 *
 * @author shimengjie
 * @date 2021/3/8 10:29
 **/
@Slf4j
public class ClientUtil {

    /**
     * 取出响应的数据体 data ，适用于 GET 请求
     */
    public static <D, R> D convertData(Supplier<R> supplier) {
        R response = convertResponse(supplier);
        return getTargetFieldValue(response, "data");
    }

    /**
     * 转换远程调用响应
     */
    public static <R> R convertResponse(Supplier<R> supplier) {
        R response;
        try {
            response = supplier.get();
        } catch (Exception e) {
            log.error("ClientUtil -- convertResponse 失败, supplier: {}", supplier.getClass().getName(), e);
            throw new ClientException(e.getMessage());
        }
        if (null == response) {
            throw new ClientException("调用服务失败");
        }
        // 取出 response 的 status 和 message 字段值
        Integer status = getTargetFieldValue(response, "status");
        if (IReturnCode.OK != status) {
            String message = getTargetFieldValue(response, "message");

            throw new ClientException(status, message);
        }
        return response;
    }

    /**
     * 取出对象指定字段的值，如果找不到会到父类找，如果父类还找不到，就报错
     */
    public static <T> T getTargetFieldValue(Object object, String fieldName) {
        if (null == object || StringUtil.isBlank(fieldName)) {
            throw new ParamException("getTargetFieldValue 失败，object 或 filedName 为空");
        }

        try {
            Field field = null;
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field tmp : fields) {
                if (fieldName.equals(tmp.getName())) {
                    field = tmp;
                }
            }
            if (field == null) {
                field = object.getClass().getSuperclass().getDeclaredField(fieldName);
            }
            field.setAccessible(true);
            return safeCast(field.get(object));
        } catch (NoSuchFieldException | IllegalAccessException | ClassCastException e) {
            log.error("ClientUtil -- getTargetFieldValue 失败, error: ", e);
            throw new SystemErrorException();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T safeCast(Object obj) {
        return (T) obj;
    }
}
