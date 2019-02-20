package com.project.lunchTime.parser;

import com.project.lunchTime.dto.HistoricDTO;
import com.project.lunchTime.exception.BusinessException;
import com.project.lunchTime.model.Historic;
import com.project.lunchTime.model.Restaurant;
import com.project.lunchTime.model.User;
import com.project.lunchTime.repository.RestaurantRepository;
import com.project.lunchTime.repository.UserRepository;
import com.project.lunchTime.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class HistoricParser {

    private Util util;
    private RestaurantRepository restaurantRepository;
    private UserRepository userRepository;

    @Autowired
    public HistoricParser(Util util,
                          RestaurantRepository restaurantRepository,
                          UserRepository userRepository) {
        this.util = util;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    public Historic fromEntity(HistoricDTO historicDTO) throws BusinessException {

        /** verifica se existe restaurant ou usuario */
        Optional<User> user = this.getUser(historicDTO);
        Optional<Restaurant> restaurant = this.getRestaurant(historicDTO);

        if(!user.isPresent() || !restaurant.isPresent())
            throw new BusinessException("Resource not found");

        Historic historic = new Historic();
        historic.setRestaurant(restaurant.get());
        historic.setUser(user.get());
        historic.setDate(new Date());
        historic.setWeek(util.getWeekday());
        historic.setMonthNumber(util.getMonthNumber());

        return historic;
    }

    private Optional<User> getUser(HistoricDTO historicDTO) {
       return userRepository.findById(historicDTO.userId);
    }

    private Optional<Restaurant> getRestaurant(HistoricDTO historicDTO) {
        return restaurantRepository.findById(historicDTO.restaurantId);
    }
}
