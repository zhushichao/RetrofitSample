package top.xiaotiejiang.netlibrary.resp;

/**
 * Created by ZhuSC on 2018/1/17.
 */

public abstract class BaseModel {

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
