package peaksoft.config;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JBDConfig {
      public static Connection getConnection (){
        try {
           return DriverManager.getConnection(
                   "jdbc:postgresql://localhost:5432/postgres",
                   "postgres",
                   "3335");
        }catch (SQLException e){
            throw  new RuntimeException();
        }

    }
}
