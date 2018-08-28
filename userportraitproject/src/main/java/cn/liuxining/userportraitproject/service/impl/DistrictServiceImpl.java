package cn.liuxining.userportraitproject.service.impl;

import cn.liuxining.userportraitproject.mapper.DistrictMapper;
import cn.liuxining.userportraitproject.pojo.District;
import cn.liuxining.userportraitproject.pojo.DistrictExample;
import cn.liuxining.userportraitproject.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictMapper dm;

    @Override
    public List<District> getDistrict(Integer pid) {
        DistrictExample example = new DistrictExample();
        example.createCriteria().andPidEqualTo(pid.shortValue());
        return dm.selectByExample(example);
    }
}
