package com.zz.eureka.respdefine;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;

/**
 * ************************************
 * create by Intellij IDEA
 * 路由失败的响应
 *
 * @author Francis.zz
 * @date 2020-04-17 15:41
 * ************************************
 */
public interface IFailResponse {
    Response failResp(String code, String msg, ServerWebExchange exchange);
    
    default int httpStatus() {
        return HttpStatus.OK.value();
    }
    
    class Response {
        int code;
        String msg;
        
        public static Response instance(int code, String msg) {
            return new Response(code, msg);
        }
        
        private Response(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    
        public int getCode() {
            return code;
        }
    
        public String getMsg() {
            return msg;
        }
    }
}
