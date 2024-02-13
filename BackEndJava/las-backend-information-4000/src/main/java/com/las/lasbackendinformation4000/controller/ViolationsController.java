package com.las.lasbackendinformation4000.controller;

import com.alibaba.fastjson.JSONObject;
import com.las.lasbackendinformation4000.model.Violations;
import com.las.lasbackendinformation4000.service.db.impl.ViolationsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/information/violations")
public class ViolationsController {

    public final ViolationsServiceImpl violationsService;

    public ViolationsController(ViolationsServiceImpl violationsService) {
        this.violationsService = violationsService;
    }

    @GetMapping("/getViolationsList")
    public List<Violations> getViolationsList(){
        return violationsService.getViolationsList();
    }

    @PostMapping("/getViolationsById")
    public Violations getViolationsById(int id){
        return violationsService.getViolationsById(id);
    }

    @PostMapping("/getViolationsByMinecraftUUID")
    public List<Violations> getViolationsByMinecraftUUID(String minecraftUUID){
        return violationsService.getViolationsByMinecraftUUID(minecraftUUID);
    }

    @PostMapping("/getViolationsByWebsiteUUID")
    public List<Violations> getViolationsByWebsiteUUID(String websiteUUID){
        return violationsService.getViolationsByWebsiteUUID(websiteUUID);
    }
    @PostMapping("/getViolationsByReason")
    public List<Violations> getViolationsByReason(String reason){
        return violationsService.getViolationsByReason(reason);
    }

    @PostMapping("/getViolationsByBannedTime")
    public List<Violations> getViolationsByBannedTime(String bannedTime){
        return violationsService.getViolationsByBannedTime(bannedTime);
    }
    @PostMapping("/getViolationsByPermitTime")
    public List<Violations> getViolationsByPermitTime(String permitTime){
        return violationsService.getViolationsByPermitTime(permitTime);
    }

    @PostMapping("/addViolations")
    public int addViolations(@RequestBody JSONObject jsonParam){
        String minecraftUUID = (String) jsonParam.get("minecraftUUID");
        String websiteUUID = (String) jsonParam.get("websiteUUID");
        String reason = (String) jsonParam.get("reason");
        String bannedTime = (String) jsonParam.get("bannedTime");
        String permitTime = (String) jsonParam.get("permitTime");

        Violations violations = new Violations(0,minecraftUUID,websiteUUID,reason,bannedTime,permitTime);

        return violationsService.addViolations(violations);

    }

    @PostMapping("/deleteViolationsByMinecraftUUID")
    public int deleteViolationsByMinecraftUUID(String minecraftUUID){
        return violationsService.deleteViolationsByMinecraftUUID(minecraftUUID);
    }


}
