package com.app.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by User on 04.06.2017.
 */
public class ConnectionToDB {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionToDB.class);

    private static final String DBURL = "jdbc:postgresql://localhost:5432/jdbc_work";
    private static final String DBUser = "postgres";
    private static final String DBUserPassword = "123581321lL";
    private static final String DBDriver = "org.postgresql.Driver";

    /*
    private static final String DBURL= "jdbc:mysql://localhost:3306/persons?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DBUser = "root";
    private static final String DBUserPassword= "123581321lL";
    private static final String DBDriver= "com.mysql.jdbc.Driver";
    */


    static {
        try {
            LOGGER.info("Loading jdbc driver: " + DBDriver);
            Class.forName(DBDriver);
            LOGGER.info("Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Cannot find driver: " + DBDriver);
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    //TODO 1 Нормально расставила логгеры?
    //TODO 2 Зачем в этом методе ловить исключение и возвращать null? Если не будет connection все равно дальше работать не будем.
    //Может кидать єто исключение наверх и там "оборачивать"  в пользовательский exception?
    public static Connection getConnection() {
        Connection connection = null;

        try {
            LOGGER.info("Getting connection to DB: " + DBURL);
            connection = DriverManager.getConnection(DBURL, DBUser, DBUserPassword);
            LOGGER.info("Successfully connected to DB.");
            if (connection != null) { //TODO 3 Что это за случай, когда connection = null
                return connection;
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB: " + DBURL, e);
            e.printStackTrace();
        }
        return connection;
    }

}
