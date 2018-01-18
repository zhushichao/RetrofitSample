package top.xiaotiejiang.netlibrary.client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import top.xiaotiejiang.netlibrary.resp.BaseModel;

/**
 * Created by ZhuSC on 2018/1/17.
 */

public abstract class BaseCallBack <T extends BaseModel> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        try {
            int code = response.raw().code();
            if (code == HttpCode.RESP_SUCCESS){
                T bean = response.body();
                int status = bean.getCode();
                if (status == HttpCode.RESP_OK){
                    on200Resp(bean);
                } else {
                    onNo200Resp(bean);
                }
            } else {
                onError(call, new Exception("response error, detail = " + response.raw().toString()));
            }
        } catch (Exception e){
            onError(call, new Exception("response error, detail = " + response.raw().toString()));
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError(call, t);
    }


    protected abstract void on200Resp(T bean);

    protected abstract void onNo200Resp(T bean);

    protected void onError(Call<T> call, Throwable t){
        onError(call, new Exception("response error, detail = " + t.toString()));
    }



}
