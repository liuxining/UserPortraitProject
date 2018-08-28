package cn.liuxining.userportraitproject.dao.impl;

import cn.liuxining.userportraitproject.dao.ResultDao;
import cn.liuxining.userportraitproject.pojo.Result;
import cn.liuxining.userportraitproject.util.JDBCUtil;
import cn.liuxining.userportraitproject.util.RowMap;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ResultDaoImpl implements ResultDao {
    @Override
    public List<Result> getResult(String condition) {
        String sql = "select * from result where `condition`=? order by num";
        List<Result> results = JDBCUtil.executeQuery("mysql", sql, new RowMap<Result>() {
            @Override
            public Result rowMapping(ResultSet rs) {
                Result result = new Result();
                try {
                    result.setTypeid(rs.getString("typeid"));
                    result.setNum(rs.getLong("num"));
                    result.setCondition(rs.getString("condition"));
                    result.setId(rs.getString("id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return result;
            }
        }, condition);
        return results;
    }
}
