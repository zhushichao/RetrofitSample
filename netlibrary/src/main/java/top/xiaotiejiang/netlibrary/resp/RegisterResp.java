package top.xiaotiejiang.netlibrary.resp;

/**
 * Created by ZhuSC on 2017/12/13.
 */

public class RegisterResp extends BaseModel {


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
