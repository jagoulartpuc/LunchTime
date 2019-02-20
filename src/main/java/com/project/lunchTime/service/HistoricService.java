package com.project.lunchTime.service;

import com.project.lunchTime.dto.HistoricDTO;
import com.project.lunchTime.exception.BusinessException;
import com.project.lunchTime.model.Historic;
import com.project.lunchTime.parser.HistoricParser;
import com.project.lunchTime.repository.HistoricRepository;
import com.project.lunchTime.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class HistoricService {

    private HistoricRepository repository;
    private Util util;
    private HistoricParser parser;

    @Autowired
    public HistoricService(HistoricRepository repository,
                           Util util,
                           HistoricParser parser) {
        this.repository = repository;
        this.util = util;
        this.parser = parser;
    }

    @Transactional(rollbackOn = Exception.class)
    public void create(HistoricDTO historicDTO) throws BusinessException {
        Historic historic = parser.fromEntity(historicDTO);
        repository.save(historic);
    }
}
