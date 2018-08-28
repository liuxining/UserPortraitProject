package cn.liuxining.userportraitproject.service.impl;

import cn.liuxining.userportraitproject.dao.ResultDao;
import cn.liuxining.userportraitproject.mapper.ResultMapper;
import cn.liuxining.userportraitproject.pojo.Result;
import cn.liuxining.userportraitproject.pojo.ResultExample;
import cn.liuxining.userportraitproject.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private ResultMapper rm;

    @Autowired
    private ResultDao rd;

    @Override
    public List<Result> getResult(String course, String region, String type) {
        StringBuffer buffer = new StringBuffer();
        if(course != null && course.length() > 0){
            buffer.append(course);
            buffer.append("_");
        }
        if(region != null && region.length() > 0){
            buffer.append(region);
            buffer.append("_");
        }
        if("sum".equalsIgnoreCase(type)){
            buffer.append("traffic_");
        }
        if(buffer.charAt(buffer.length() - 1) == '_'){
            buffer.deleteCharAt(buffer.length() - 1);
        }
//        ResultExample example = new ResultExample();
//        example.createCriteria().andConditionEqualTo(buffer.toString());
        List<Result> results = rm.selectResult(buffer.toString());
//        List<Result> results = rd.getResult(buffer.toString());
        return results;
    }



//    @Override
//    public String getInfo(String conditionStr, Integer n, String type) {
//        List<Condition> conditions = JSON.parseArray(conditionStr, Condition.class);
//        String resultType = null;
//        StringBuffer buffer = new StringBuffer();
//        buffer.append("\"text\":\"日志统计\"");
//        buffer.append(",\"subText\":\"");
//        for (Condition condition : conditions
//             ) {
//            if("region".equalsIgnoreCase(condition.getKey())){
//                buffer.append(condition.getValue());
//                buffer.append(" ");
//            }
//            if("type".equalsIgnoreCase(condition.getKey())) {
//                if ("video".equalsIgnoreCase(condition.getValue())) {
//                    buffer.append("视频 ");
//                } else {
//                    buffer.append("文章 ");
//                }
//            }
//        }
//        if("num".equalsIgnoreCase(type)){
//            buffer.append("访问量 ");
//            resultType = "访问量";
//        }
//        else{
//            buffer.append("访问流量 ");
//            resultType = "流量";
//        }
//        buffer.append("Top");
//        buffer.append(n);
//        buffer.append("\"");
//        buffer.append(",\"resultType\":\"");
//        buffer.append(resultType);
//        buffer.append("\"");
//        return buffer.toString();
//
//    }
}
