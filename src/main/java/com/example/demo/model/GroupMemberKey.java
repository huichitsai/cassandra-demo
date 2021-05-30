package com.example.demo.model;

import java.io.Serializable;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@PrimaryKeyClass
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupMemberKey implements Serializable {

    @PrimaryKeyColumn(name="group_name", type = PrimaryKeyType.PARTITIONED)
    private String groupName;
    @PrimaryKeyColumn(name="state", type = PrimaryKeyType.CLUSTERED)
    private String state;
    @PrimaryKeyColumn(name="member_id", type = PrimaryKeyType.CLUSTERED)
    private String memberId;
    
}
