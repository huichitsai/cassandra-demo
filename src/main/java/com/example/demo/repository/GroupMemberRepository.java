package com.example.demo.repository;

import com.example.demo.model.GroupMember;
import com.example.demo.model.GroupMemberKey;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GroupMemberRepository extends CrudRepository<GroupMember, GroupMemberKey>{

    @Query("SELECT count(*) FROM group_member WHERE group_name = :groupName and state = :state")
    long countByGroupNameAndState(String groupName, String state);
    
    @Query("SELECT * FROM group_member WHERE member_id = :memberId LIMIT 1")
    GroupMember findOneByMemberId(String memberId);
}
