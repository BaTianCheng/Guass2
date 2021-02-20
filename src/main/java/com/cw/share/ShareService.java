package com.cw.share;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

/**
 * 服务类
 * @author wicks
 *
 */
//@Service
public class ShareService {
    
    public static List<Map<String,String>> GetAAA() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(ShareConstants.TOKEN_KEY, ShareConstants.TOKEN_VALUE);
        paramMap.put(ShareConstants.API_KEY, "stock_basic");
        JSONObject jObject = new JSONObject();
        jObject.set("list_status", "L");
        paramMap.put(ShareConstants.PARAMS_KEY, jObject);
        paramMap.put(ShareConstants.FIELDS_KEY, "");

        String result= HttpUtil.post(ShareConstants.API_URL, JSON.toJSONString(paramMap));
        JSONArray shares = JSON.parseObject(result).getJSONObject("data").getJSONArray("items");
        List<Map<String,String>> listShares = new ArrayList<>();
        
        
        for(Object share : shares) {
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>)share;
            if("主板".equals(list.get(5)) || "中小板".equals(list.get(5))) {
                Map<String,String> map = new HashMap<>();
                map.put("code", list.get(0));
                map.put("name", list.get(2));
                listShares.add(map);
            }
            
        }

        return listShares;
        
    }
    
    public static Map<String, List<Double>> GetBBB() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(ShareConstants.TOKEN_KEY, ShareConstants.TOKEN_VALUE);
        paramMap.put(ShareConstants.API_KEY, "daily");
        JSONObject jObject = new JSONObject();
        paramMap.put(ShareConstants.FIELDS_KEY, "");

        List<String> dates = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        for(int i=90;i>0;i--) {
            calendar.add(Calendar.DATE, -1);
            dates.add(df.format(calendar.getTime()));
        }
        
        Map<String, List<Double>> hangqings = new HashMap<>();
        for (String date : dates) {
            System.out.println("正在访问"+date);
            jObject.set("trade_date", date);
            paramMap.put(ShareConstants.PARAMS_KEY, jObject);
            String result = HttpUtil.post(ShareConstants.API_URL, JSON.toJSONString(paramMap));
            
            JSONArray shares = JSON.parseObject(result).getJSONObject("data").getJSONArray("items");

            for (Object share : shares) {
                @SuppressWarnings("unchecked")
                List<Object> list = (List<Object>)share;
                if (!hangqings.containsKey(list.get(0))) {
                    hangqings.put((String)list.get(0), new ArrayList<Double>());
                } 

                BigDecimal close = (BigDecimal)list.get(5);
                
                hangqings.get(list.get(0)).add(close.doubleValue());
            }
            
        }

        return hangqings;
        
    }
    
    
    
    public static void main(String[] args) {
        List<Map<String,String>> gupiao  = GetAAA();
        Map<String, List<Double>> hangqingALL = GetBBB();
        Map<String, List<Double>> hangqing = new HashMap<>();
        for(Map<String,String> gp : gupiao) {
            if(!hangqingALL.containsKey(gp.get("code"))) {
                continue;
            }
            
            hangqing.put(gp.get("code"), hangqingALL.get(gp.get("code")));
            Double avg=new Double(0.0);
            Double max=new Double(0.0);
            Double min=new Double(999999.0);
            Double sum=new Double(0.0);
            int size = hangqing.get(gp.get("code")).size();
            for(Double bDecimal : hangqing.get(gp.get("code"))) {
                sum = sum+bDecimal;
                if(max < bDecimal) {
                    max = bDecimal;
                }
                if(min > bDecimal) {
                    min = bDecimal;
                }
            }
            
            avg =  new BigDecimal(sum / size).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            Double lastday = hangqing.get(gp.get("code")).get(0);
            
            //筛选
            //计算最高价，最低价，平均价
            //筛选出平均价误差在20%之间的
            //昨天的价格低于平均价的80%
          
            if(max / min <= 1.2) {
                if(lastday < avg &&  avg/lastday >= 1.05) {
                    System.out.println(gp.get("code") + "    " +gp.get("name"));
                    System.out.println(lastday + "    " + max + "    " +avg+ "    " +min);
                    System.out.println(avg/lastday + "  " + hangqing.get(gp.get("code")));
                } 
            }
        
        }
        
        System.out.println("结束");
        
    }
    
}
