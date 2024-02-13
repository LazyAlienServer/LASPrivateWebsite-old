package com.las.lasbackendinformation4000.service.db.impl;

import com.las.lasbackendinformation4000.mapper.ViolationsMapper;
import com.las.lasbackendinformation4000.model.Violations;
import com.las.lasbackendinformation4000.service.db.ViolationsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunyinuo
 */
@Service
public class ViolationsServiceImpl implements ViolationsService {

    @Resource
    public ViolationsMapper violationsMapper;


    /**
     * 获取所有封禁信息
     * @return list
     */
    @Override
    public List<Violations> getViolationsList() {
        return violationsMapper.getViolationsList();
    }

    /**
     * 根据id查询封禁信息
     * @param id
     * @return info
     */
    @Override
    public Violations getViolationsById(int id) {
        return violationsMapper.getViolationsById(id);
    }

    /**
     * 根据mc uuid查询封禁信息
     * @param minecraftUUID minecraft uuid
     * @return list
     */
    @Override
    public List<Violations> getViolationsByMinecraftUUID(String minecraftUUID) {
        return violationsMapper.getViolationsByMinecraftUUID(minecraftUUID);
    }

    /**
     * 根据网站用户id查询封禁信息
     * @param websiteUUID 网站用户uuid
     * @return list
     */
    @Override
    public List<Violations> getViolationsByWebsiteUUID(String websiteUUID) {
        return violationsMapper.getViolationsByWebsiteUUID(websiteUUID);
    }

    /**
     * 根据原因查询封禁信息
     * @param reason 原因
     * @return list
     */
    @Override
    public List<Violations> getViolationsByReason(String reason) {
        return violationsMapper.getViolationsByReason(reason);
    }

    /**
     * 根据封禁日期查询封禁信息
     * @param bannedTime 时间
     * @return list
     */
    @Override
    public List<Violations> getViolationsByBannedTime(String bannedTime) {
        return violationsMapper.getViolationsByBannedTime(bannedTime);
    }

    /**
     * 根据解禁时间查询封禁信息
     * @param permitTime 时间
     * @return list
     */
    @Override
    public List<Violations> getViolationsByPermitTime(String permitTime) {
        return violationsMapper.getViolationsByPermitTime(permitTime);
    }

    /**
     * 添加封禁信息
     * @param violations model
     * @return 影响
     */
    @Override
    public int addViolations(Violations violations) {
        return violationsMapper.addViolations(violations);
    }

    /**
     * 根据minecraft uuid删除封禁信息(解禁)
     * @param minecraftUUID minecraft uuid
     * @return 影响
     */
    @Override
    public int deleteViolationsByMinecraftUUID(String minecraftUUID) {
        return violationsMapper.deleteViolationsByMinecraftUUID(minecraftUUID);
    }
}
