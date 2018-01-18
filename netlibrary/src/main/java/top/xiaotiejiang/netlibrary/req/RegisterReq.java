package top.xiaotiejiang.netlibrary.req;

/**
 * Created by ZhuSC on 2017/11/25.
 */

public class RegisterReq {

    private String phone_identity_code;
    private String phone_number;
    private String password;

    public RegisterReq(String phone_identity_code, String phone_number, String password) {
        this.phone_identity_code = phone_identity_code;
        this.phone_number = phone_number;
        this.password = password;
    }

    public String getPhone_identity_code() {
        return phone_identity_code;
    }

    public void setPhone_identity_code(String phone_identity_code) {
        this.phone_identity_code = phone_identity_code;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
