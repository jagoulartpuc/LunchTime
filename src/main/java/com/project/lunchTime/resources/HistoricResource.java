package com.project.lunchTime.resources;


import com.project.lunchTime.dto.HistoricDTO;
import com.project.lunchTime.exception.BusinessException;
import com.project.lunchTime.service.HistoricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/historic")
public class HistoricResource {

    private HistoricService service;

    @Autowired
    public HistoricResource(HistoricService historicService) {
        this.service = historicService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody HistoricDTO historic) throws BusinessException {
        service.create(historic);
    }

}
