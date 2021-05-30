package com.example.demo.service;

import java.time.LocalDateTime;

import com.example.demo.dto.GroupDetailResponse;
import com.example.demo.model.Group;
import com.example.demo.model.GroupMember;
import com.example.demo.model.GroupMemberKey;
import com.example.demo.repository.GroupMemberRepository;
import com.example.demo.repository.GroupRepository;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GroupServcie {

    private GroupRepository groupRepository;
    private GroupMemberRepository groupMemberRepository;

    public GroupServcie(GroupRepository groupRepository, GroupMemberRepository groupMemberRepository) {
        this.groupRepository = groupRepository;
        this.groupMemberRepository = groupMemberRepository;
    }

    public GroupDetailResponse createGroup(String groupName, String requestMember) {
        String groupKey = groupName.toLowerCase();
        Group group = Group.builder().name(groupKey).originalName(groupName).build();

        GroupMember groupMember = GroupMember.builder()
                .key(GroupMemberKey.builder().groupName(groupKey).state("Activated").memberId(requestMember).build())
                .lastUpdatedTime(LocalDateTime.now())
                .lastUpdatedReason("Create Group")
                .build();

        groupRepository.save(group);
        groupMemberRepository.save(groupMember);

        return getGroupDetail(groupKey);
    }

    public GroupDetailResponse getGroupDetail(String groupName) {
        String groupKey = groupName.toLowerCase();
        long memberCount = groupMemberRepository.countByGroupNameAndState(groupKey, "Activated");
        Group model = groupRepository.findById(groupKey).get();
        return GroupDetailResponse.builder()
                .status("200")
                .message("success")
                .name(model.getOriginalName())
                .referenceURL("http://my.test.com/group/" + model.getName())
                .activeMemberCount(memberCount).build();
    }

    public GroupDetailResponse getGroupDetailByMember(String memberId) {        
        GroupMember member = groupMemberRepository.findOneByMemberId(memberId);
        if (member == null) return null;
        return getGroupDetail(member.getKey().getGroupName());
    }
}
