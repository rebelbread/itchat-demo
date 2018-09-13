package com;

import cn.zhouyafeng.itchat4j.beans.BaseMsg;
import cn.zhouyafeng.itchat4j.face.IMsgHandlerFace;
import cn.zhouyafeng.itchat4j.utils.MyHttpClient;
import com.alibaba.fastjson.JSON;
import com.data.Results;
import com.data.TulingResult;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiwj
 * @date 2018/9/10
 */
public class MsgHandler implements IMsgHandlerFace {

    MyHttpClient myHttpClient = MyHttpClient.getInstance();
    String apiKey = "a9cb5a2c8e2d44abaf22f3ad94492010"; // 这里是我申请的图灵机器人API接口，每天只能5000次调用，建议自己去申请一个，免费的:)
    String userId = "267048";

    @Override
    public String textMsgHandle(BaseMsg msg) {
        String text = msg.getText();
        String result = "";
        String url = "http://openapi.tuling123.com/openapi/api/v2";
        Map<String, Object> paramMap = new HashMap<>();

        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("apiKey", apiKey);
        userInfo.put("userId", userId);

        Map<String, Object> perception = new HashMap<>();
        Map<String, String> inputText = new HashMap<>();
        inputText.put("text", text);
        perception.put("inputText", inputText);

        paramMap.put("perception", perception);
        paramMap.put("userInfo", userInfo);
        String paramStr = JSON.toJSONString(paramMap);
        try {
            HttpEntity entity = myHttpClient.doPost(url, paramStr);
            String resp = EntityUtils.toString(entity, "UTF-8");
            TulingResult tulingResult = JSON.parseObject(resp, TulingResult.class);
            List<Results> results = tulingResult.getResults();
            StringBuilder sb = new StringBuilder();
            for (Results resultText : results) {
                sb.append(resultText.getValues().getText());
                sb.append("\r\n");
            }

            if (sb.length() != 0) {
                result = sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String picMsgHandle(BaseMsg msg) {

        return "长是: "+msg.getImgHeight()+"...宽是:"+msg.getImgWidth();
    }

    @Override
    public String voiceMsgHandle(BaseMsg msg) {
        return null;
    }

    @Override
    public String viedoMsgHandle(BaseMsg msg) {
        return null;
    }

    @Override
    public String nameCardMsgHandle(BaseMsg msg) {
        return null;
    }

    @Override
    public void sysMsgHandle(BaseMsg msg) {

    }

    @Override
    public String verifyAddFriendMsgHandle(BaseMsg msg) {
        return null;
    }

    @Override
    public String mediaMsgHandle(BaseMsg msg) {
        return null;
    }
}
