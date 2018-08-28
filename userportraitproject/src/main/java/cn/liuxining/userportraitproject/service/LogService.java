package cn.liuxining.userportraitproject.service;

import cn.liuxining.userportraitproject.pojo.Result;

import java.util.List;

public interface LogService {
    List<Result> getResult(String course, String region, String type);

//    String getInfo(String conditionStr, Integer n, String type);
}
