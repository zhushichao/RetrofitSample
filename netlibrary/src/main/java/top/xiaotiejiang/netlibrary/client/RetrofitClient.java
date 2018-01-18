package top.xiaotiejiang.netlibrary.client;

import com.google.gson.Gson;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import top.xiaotiejiang.netlibrary.resp.BaseModel;

/**
 * Created by ZhuSC on 2018/1/17.
 */

public class RetrofitClient {
    private static HttpService httpService;

    private void initRetrofit(){
        if (httpService == null) {
            synchronized (RetrofitClient.class) {
                if (httpService == null) {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(null)
                            .build();
                    httpService = retrofit.create(HttpService.class);
                }
            }
        }
    }

    public static <T, E extends BaseModel> void post(String postMethodName, T postBean, BaseCallBack<E> callBack){
        RequestBody requestBody = createRequestBody(postBean);

        try {
            Method method = HttpService.class.getDeclaredMethod(postMethodName, RequestBody.class);
            Call<E> call = (Call<E>) method.invoke(httpService, requestBody);
            call.enqueue(callBack);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static  <T> RequestBody createRequestBody(T bean){
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(bean));
    }

}
