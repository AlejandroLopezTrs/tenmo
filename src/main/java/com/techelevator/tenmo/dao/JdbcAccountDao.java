package com.techelevator.tenmo.dao;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class JdbcAccountDao {
    @Component
    public class JdbcAccount implements AccountDao {
        @Override
        public BigDecimal getBalance(int userId) {
            return null;
        }
        //TODO: implement Account JDBC for database connection.
    }
}
