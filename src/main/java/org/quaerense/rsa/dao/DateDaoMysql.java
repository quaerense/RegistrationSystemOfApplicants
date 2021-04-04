package org.quaerense.rsa.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;

@Repository
public class DateDaoMysql implements DateDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Date getTheCurrentDate() {
        return (Date) entityManager.createNativeQuery("SELECT CURRENT_DATE").getSingleResult();
    }
}
