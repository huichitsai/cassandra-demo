package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table("group_member")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupMember {
    
    @PrimaryKey
    private GroupMemberKey key;
    @Column("last_updated_time")
    private LocalDateTime lastUpdatedTime;
    @Column("last_updated_reason")
    private String lastUpdatedReason;
}
