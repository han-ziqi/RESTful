package com.ziqi.util;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class jsonResult {
    private int code; //successful 200, fail 500
    private String msg;  // Message aabout result
    private Object data; // Reponse

    public jsonResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static jsonResult error(String msg){
        return new jsonResult(500,msg,null);
    }
    public static jsonResult error(String msg, Object data){
        return new jsonResult(500,msg,data);
    }

    public static jsonResult success(){
        return new jsonResult(200, "Successful", null);
    }
    public static jsonResult success(String msg, Object data){
        return new jsonResult(200,"Successful",data);
    }
}
