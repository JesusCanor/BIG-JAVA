package com.example.patterns.factoryMethodCompleteFlow.business.service.impl;

import com.example.patterns.factoryMethodCompleteFlow.business.service.DataProvider;
import com.example.patterns.factoryMethodCompleteFlow.domain.entity.Client;
import com.example.patterns.factoryMethodCompleteFlow.domain.enums.ReportTypeEnum;
import com.example.patterns.factoryMethodCompleteFlow.persistance.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientDataProvider implements DataProvider<Client> {

    private final ClientRepository clientRepository;

    public ClientDataProvider(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ReportTypeEnum getType() {
        return ReportTypeEnum.CLIENT;
    }

    @Override
    public List<Client> getData() {
        return clientRepository.findAll();
    }
}
