package com.teresol.core.api.core_api_CurdQuarkus.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.agroal.api.AgroalDataSource;

@ApplicationScoped
public class DBConnection {
    
        Connection connection=null;

        @Inject
        AgroalDataSource dataSource;

        public Connection GlobalDbConnection() {
            try {
                connection= dataSource.getConnection();
                if(connection!=null){
                    System.out.println("............................"+connection);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    
}
