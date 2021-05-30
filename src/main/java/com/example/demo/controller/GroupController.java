package com.example.demo.controller;

import com.example.demo.dto.CreateGroupRequest;
import com.example.demo.dto.GroupDetailResponse;
import com.example.demo.service.GroupServcie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("group")
@Slf4j
public class GroupController {

    private GroupServcie groupServcie;
    
    GroupController(GroupServcie groupServcie) {
        this.groupServcie = groupServcie;
    }

    @GetMapping("/{name}")
    public GroupDetailResponse getGroupDetailNoAuth(@PathVariable String name) {
        return groupServcie.getGroupDetail(name);
    }

    @GetMapping("/")
    public GroupDetailResponse getGroupDetailWithAuth(@RequestHeader("Authorization") String user) {
        log.info("======> user:{}", user);
        return groupServcie.getGroupDetailByMember(user);
    }

    @PostMapping("/")
    public GroupDetailResponse createGroup(@RequestBody CreateGroupRequest request, @RequestHeader("Authorization") String user) {
        return groupServcie.createGroup(request.getName(), user);
    }


    
}
