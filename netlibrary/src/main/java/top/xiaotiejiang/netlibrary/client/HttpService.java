package top.xiaotiejiang.netlibrary.client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import top.xiaotiejiang.netlibrary.req.RegisterReq;
import top.xiaotiejiang.netlibrary.resp.RegisterResp;
import top.xiaotiejiang.netlibrary.resp.ResultResp;

/**
 * Created by ZhuSC on 2018/1/17.
 */

public interface HttpService {

    @GET("users/list")
    Call<ResultResp> getUserList();

    @Headers({"Content-Type: application/json", "Accept: application/json"})//需要添加头
    @POST("login/register")
    Call<RegisterResp> register(@Body RegisterReq request);

}
