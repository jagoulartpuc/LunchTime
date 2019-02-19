package com.project.lunchTime.service;

import com.project.lunchTime.model.Historic;
import com.project.lunchTime.repository.HistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HistoricService {

    private HistoricRepository repository;

    @Autowired
    public HistoricService(HistoricRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackOn = Exception.class)
    public void create(Historic restaurant) {
        repository.save(restaurant);
    }

    public List<Historic> findAll() {
        return repository.findAll();
    }
}
