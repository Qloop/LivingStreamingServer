package com.boris.livingstreaming.utils;

import com.baidubce.BceClientConfiguration;
import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.http.RetryPolicy;
import com.baidubce.services.lss.LssClient;
import org.springframework.stereotype.Service;

/**
 * Created by Qloop on 2017/3/14.
 */
@Service
public class LssClientUtil {

    private boolean createLssClient() {
        String ACCESS_KEY_ID = "d50441c6531e4fec8faf415abd8b8511";
        String SECRET_ACCESS_KEY = "de4ea1d9e60d4b2b910817e52d9a31e8";

        //初始化一个LssClient
        BceClientConfiguration config = new BceClientConfiguration();
        config.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY));

        /*以下测试 最后调试更改 还有其他的设置未加*/
        config.setConnectionTimeoutInMillis(5000);//设置建立连接的超时时间 5s
        config.setMaxConnections(10);// 设置允许打开的最大连接数 10
        config.setRetryPolicy(RetryPolicy.DEFAULT_RETRY_POLICY);  //连接重试策略

        LssClient client = new LssClient(config);
        return true;
    }
}
