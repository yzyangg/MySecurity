package com.yzy.mysecurity.pojo;
import lombok.Data;
/**
 * @projectName: MySecurity
 * @package: com.yzy.mysecurity.pojo
 * @className: Result
 * @date: 2022/11/13 22:19
 * @author: yzy
 * @description:
 */
/**
 * 统一结果返回类
 * @param <T>
 */
@Data
public class Result<T> {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, T data) {
        this.code = code;
        this.data = data;
    }
}
