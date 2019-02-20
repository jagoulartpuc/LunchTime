package com.project.lunchTime.repository;

import com.project.lunchTime.dto.HistoricDTO;
import com.project.lunchTime.model.Historic;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;

import static java.util.Objects.nonNull;

@Repository
public class HistoricRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Historic historic) {
        entityManager.persist(historic);
    }

    public List<Historic> search(HistoricDTO filterDTO) {
        HashMap<String, Object> params = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT historic ");
        sb.append("FROM  " + Historic.class.getCanonicalName() + " historic ");
        sb.append("JOIN historic.restaurant restaurant ");
        sb.append("WHERE 1 = 1 ");

        if (nonNull(filterDTO.date)) {
            sb.append(" AND historic.date = :date ");
            params.put("date", filterDTO.date);
        }

        if (nonNull(filterDTO.week)) {
            sb.append(" AND historic.week = :week ");
            params.put("week", filterDTO.week);
        }

        if (nonNull(filterDTO.monthNumber)) {
            sb.append(" AND historic.monthNumber = :monthNumber ");
            params.put("monthNumber", filterDTO.monthNumber);
        }

        if (nonNull(filterDTO.restaurantId)) {
            sb.append(" AND restaurant.id = :restaurantId ");
            params.put("restaurantId", filterDTO.restaurantId);
        }

        Query query = entityManager.createQuery(sb.toString());
        params.forEach(query::setParameter);
        return query.getResultList();
    }
}
