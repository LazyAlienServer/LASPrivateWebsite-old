package com.las.lasbackendinformation4000.mapper;

import com.las.lasbackendinformation4000.model.Violations;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author sunyinuo
 */
@Mapper
public interface ViolationsMapper {

    /**
     * 获取所有封禁信息
     * @return list
     */
    List<Violations> getViolationsList();


    /**
     * 根据id查询封禁信息
     * @return info
     */
    Violations getViolationsById(int id);

    /**
     * 根据mc uuid查询封禁信息
     * @param minecraftUUID minecraft uuid
     * @return list
     */
    List<Violations> getViolationsByMinecraftUUID(String minecraftUUID);

    /**
     * 根据网站用户id查询封禁信息
     * @param websiteUUID 网站用户uuid
     * @return  list
     */
    List<Violations> getViolationsByWebsiteUUID(String websiteUUID);

    /**
     * 根据原因查询封禁信息
     * @param reason 原因
     * @return list
     */
    List<Violations> getViolationsByReason(String reason);

    /**
     * 根据封禁日期查询封禁信息
     * @param bannedTime 时间
     * @return list
     */
    List<Violations> getViolationsByBannedTime(String bannedTime);

    /**
     * 根据解禁时间查询封禁信息
     * @param permitTime 时间
     * @return list
     */
    List<Violations> getViolationsByPermitTime(String permitTime);

    /**
     * 添加封禁信息
     * @param violations model
     * @return 影响
     */
    int addViolations(Violations violations);

    /**
     * 根据minecraft uuid删除封禁信息(解禁)
     * @param minecraftUUID minecraft uuid
     * @return 影响
     */
    int deleteViolationsByMinecraftUUID(String minecraftUUID);

}
