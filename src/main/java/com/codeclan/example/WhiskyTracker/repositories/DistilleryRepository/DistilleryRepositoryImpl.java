package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> findAllDistilleriesByRegion(String region){
        List<Distillery> results = null;

        Session session = entityManager.unwrap(Session.class);

        Criteria cr = session.createCriteria(Distillery.class);

        cr.add(Restrictions.eq("region", region));

        results = cr.list();
        return results;
    }

    @Transactional
    public List<Whisky> getWhiskyFromDistilleryByAge(Distillery dist, int age){
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);

        cr.createAlias("distillery.whiskies", "whisky");

        cr.add(Restrictions.eq("age", age));
        results = cr.list();
        return results;
    }

    @Transactional
    public List<Distillery> findAllDistilleryWithWhiskyOverAge(int age){
        List<Distillery> results = null;

        Session session = entityManager.unwrap(Session.class);

        Criteria cr = session.createCriteria(Distillery.class);

        cr.createAlias("whiskies", "whisky");
        cr.add(Restrictions.gt("whisky.age", age));

        results = cr.list();

        return results;
    }
}
