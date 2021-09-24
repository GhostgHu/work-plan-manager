package com.shimengjie.wpm.common.response;

/**
 * @param <T>
 * @author shimengjie
 */
public class Response<T> extends AbstractResponse {

    private T data;

    public Response() {
        super();
    }

    public T getData() {
        return data;
    }

    public Response(T data) {
        super();
        this.data = data;
    }

    public Response(Integer status, String msg, T data) {
        super(status, msg);
        this.data = data;
    }

    /**
     * 返回一个成功状态的Response, 不附带数据
     *
     * @return Response<Object>
     */
    public static <T> Response<T> ofSuccess(T data) {
        return new Response<>(data);
    }

}
