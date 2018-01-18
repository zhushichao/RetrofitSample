package top.xiaotiejiang.netlibrary.client;

import android.util.Log;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import okhttp3.Interceptor;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import top.xiaotiejiang.netlibrary.resp.BaseModel;

/**
 * Created by ZhuSC on 2018/1/17.
 */

public class RetrofitClient {

    private static final String TAG = "RetrofitClient";

    private static HttpService httpService;

    /**
     * 初始化 service
     */
    private static void initRetrofit(){
        if (httpService == null) {
            synchronized (RetrofitClient.class) {
                if (httpService == null) {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    httpService = retrofit.create(HttpService.class);
                }
            }
        }
    }


    public static <T, E extends BaseModel> void post(String postMethodName, T postBean, BaseCallBack<E> callBack){
        initRetrofit();
        try {
            Method method = HttpService.class.getDeclaredMethod(postMethodName, postBean.getClass());
            Call<E> call = (Call<E>) method.invoke(httpService, postBean);
            call.enqueue(callBack);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Log.e(TAG, "detail = " + e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Log.e(TAG, "detail = " + e.getMessage());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            Log.e(TAG, "detail = " + e.getMessage());
        }
    }

    private static class ClientInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            return null;
        }
    }

}
