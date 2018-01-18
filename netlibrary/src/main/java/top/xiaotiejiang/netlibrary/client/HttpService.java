package top.xiaotiejiang.netlibrary.client;

import retrofit2.Call;
import retrofit2.http.GET;
import top.xiaotiejiang.netlibrary.resp.ResutlResp;

/**
 * Created by ZhuSC on 2018/1/17.
 */

public interface HttpService {

    @GET("users/list")
    Call<ResutlResp> getUserList();
}
