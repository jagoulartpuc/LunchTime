package com.project.lunchTime.service;

import com.project.lunchTime.dto.HistoricDTO;
import com.project.lunchTime.model.Historic;
import com.project.lunchTime.model.Restaurant;
import com.project.lunchTime.repository.HistoricRepository;
import com.project.lunchTime.repository.RestaurantRepository;
import com.project.lunchTime.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private RestaurantRepository repository;
    private HistoricRepository historicRepository;
    private Util util;

    @Autowired
    public RestaurantService(RestaurantRepository repository,
                             HistoricRepository historicRepository,
                             Util util) {
        this.repository = repository;
        this.historicRepository = historicRepository;
        this.util = util;
    }

    @Transactional(rollbackOn = Exception.class)
    public void create(Restaurant restaurant) {
        repository.save(restaurant);
    }

    public List<Restaurant> findAll() {
        return repository.findAll();
    }

    public List<Restaurant> search() {
        HistoricDTO dto = new HistoricDTO();
        dto.week = util.getWeekday();
        dto.monthNumber = util.getMonthNumber();

        List<Historic> historics = historicRepository.search(dto);

        if(CollectionUtils.isEmpty(historics))
            return repository.findAll();


        List<Historic> collect = historics.stream()
                .filter(h -> this.isCurrentYear(h.getDate()))
                .collect(Collectors.toList());


        return null;
    }

    private boolean isCurrentYear(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("YYYY");
        return df.format(date).equals(df.format(new Date()));
    }

}
