package cn.liuxining.userportraitproject.controller;

import cn.liuxining.userportraitproject.pojo.District;
import cn.liuxining.userportraitproject.pojo.Result;
import cn.liuxining.userportraitproject.service.DistrictService;
import cn.liuxining.userportraitproject.service.LogService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/log")
public class LogController {

    @Autowired
    private LogService logService;

    @Autowired
    private DistrictService districtService;

    @RequestMapping(value = "getStatisticResult.action")
    public String getStatisticResult(String course,String region,String type){
        //查询MySQL数据库，查看是否已存在
        List<Result> results = logService.getResult(course,region,type);
        if(results != null && results.size() > 0){
            Result result = results.get(0);
//        String id = result.getId();
            StringBuffer buffer = new StringBuffer();
            buffer.append("{\"text\":\"日志统计\",");
            buffer.append("\"subText\":\"");
            buffer.append(result.getCondition());
            buffer.append(" Top");
            buffer.append(results.size());
            buffer.append("\",");
            buffer.append("\"resultType\":\"");
            if("sum".equalsIgnoreCase("type")){
                buffer.append("流量\",");
            }
            else{
                buffer.append("访问量\",");
            }
            buffer.append("\"result\":");
            buffer.append(JSON.toJSONString(results));
            buffer.append("}");
            return buffer.toString();
        }
        return "none";

    }

    @RequestMapping(value = "getDistrict.action")
    public List<District> getDistrict(Integer pid){
        return districtService.getDistrict(pid);
    }

}
