package com.las.lasbackendinformation4000.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunyinuo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Violations {
    public int id;
    public String minecraftUUID;
    public String websiteUUID;
    public String reason;
    public String bannedTime;
    public String permitTime;
}
