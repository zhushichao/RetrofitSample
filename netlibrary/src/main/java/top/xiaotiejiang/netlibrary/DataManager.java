package top.xiaotiejiang.netlibrary;

import top.xiaotiejiang.netlibrary.client.BaseCallBack;
import top.xiaotiejiang.netlibrary.client.RetrofitClient;
import top.xiaotiejiang.netlibrary.resp.BaseModel;

/**
 * Created by ZhuSC on 2018/1/17.
 */

public class DataManager {

    public static <T, E extends BaseModel> void sendPostHttp(String postMethodName,T postBean, BaseCallBack<E> callBack){
        RetrofitClient.post(postMethodName, postBean, callBack);
    }

    public static <E extends BaseModel> void sendGetHttp(String getFuncName, String[] paramArray, BaseCallBack<E> baseCallback){
        RetrofitClient.get(getFuncName, paramArray, baseCallback);
    }

}
