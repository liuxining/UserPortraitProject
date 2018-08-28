package cn.liuxining.userportraitproject.dao;

import cn.liuxining.userportraitproject.pojo.Result;

import java.util.List;

public interface ResultDao {
    List<Result> getResult(String condition);
}
