package top.xiaotiejiang.retrofitsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import top.xiaotiejiang.netlibrary.DataManager;
import top.xiaotiejiang.netlibrary.client.BaseCallBack;
import top.xiaotiejiang.netlibrary.req.RegisterReq;
import top.xiaotiejiang.netlibrary.resp.RegisterResp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataManager.sendPostHttp("register", new RegisterReq("1234", "13333333333", "klafjs;ldkfj;aksldfj")
                , new BaseCallBack<RegisterResp>() {
            @Override
            protected void on200Resp(RegisterResp bean) {
                Log.e("kjllkjl", "" + bean.getCode());
            }

            @Override
            protected void onNo200Resp(RegisterResp bean) {
                Log.e("kjllkjl", "" + bean.getCode());
            }
        });

    }
}
