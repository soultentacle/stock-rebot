package com.gw.idea.stock.collector;

import com.gw.idea.stock.entity.KLineTarget;
import com.sun.javafx.binding.StringFormatter;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 采集历史K线数据
 * Created by dell on 2018/7/26.
 */
@Service
public class HistoryKLineDataCollector {

    public void execute() {

    }

    public List<String[]> downloadData(String code, String year) {
        List<String[]> datas = new ArrayList<String[]>();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(StringFormatter.format("http://data.gtimg.cn/flashdata/hushen/daily/%s/%s.js?visitDstTime=1", year, code).getValue());
        CloseableHttpResponse response1 = null;
        try {
            response1 = httpclient.execute(httpGet);
            HttpEntity entity1 = response1.getEntity();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity1.getContent()));
            String str = null;
            int lineNum = 0;
            while ((str = bufferedReader.readLine()) != null) {
                lineNum++;
                if (lineNum > 2 && !"\";".equals(str)) {
                    String clearStr = str.replace("\\n\\", "");
                    String[] attrs = clearStr.split(" ");
                    datas.add(attrs);
                }
            }
        } catch (IOException e) {
            if (response1 != null) {
                try {
                    response1.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return datas;
    }


    public static void main(String[] args) {
        System.out.println(new HistoryKLineDataCollector().downloadData("sh000001", "18").toArray());
    }
}
