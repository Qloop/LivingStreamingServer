package com.boris.livingstreaming.utils;

import com.baidubce.BceClientConfiguration;
import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.http.RetryPolicy;
import com.baidubce.services.lss.LssClient;
import com.boris.livingstreaming.config.Config;
import org.springframework.stereotype.Service;

/**
 * Created by Qloop on 2017/3/14.
 */
@Service
public class LssClientUtils {

    public static LssClient createLssClient() {
        String ACCESS_KEY_ID = Config.ACCESS_KEY_ID;
        String SECRET_ACCESS_KEY = Config.SECRET_ACCESS_KEY;

        //初始化一个LssClient
        BceClientConfiguration config = new BceClientConfiguration();
        config.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY));

        /*以下测试 最后调试更改 还有其他的设置未加*/
        config.setConnectionTimeoutInMillis(5000);//设置建立连接的超时时间 5s
        config.setMaxConnections(10);// 设置允许打开的最大连接数 10
        config.setRetryPolicy(RetryPolicy.DEFAULT_RETRY_POLICY);  //连接重试策略

        return new LssClient(config);
    }
}
