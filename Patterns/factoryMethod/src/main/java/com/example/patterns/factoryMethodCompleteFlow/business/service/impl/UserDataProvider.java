package com.example.patterns.factoryMethodCompleteFlow.business.service.impl;

import com.example.patterns.factoryMethodCompleteFlow.business.service.DataProvider;
import com.example.patterns.factoryMethodCompleteFlow.domain.entity.User;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.example.patterns.factoryMethodCompleteFlow.persistance.UserRepository;

import java.util.List;

public class UserDataProvider implements DataProvider<User> {

    private final UserRepository userRepository;

    public UserDataProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ReportTypeEnum getType() { return ReportTypeEnum.USER; }

    @Override
    public List<User> getData() { return userRepository.findAll(); }
}
