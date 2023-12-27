package com.techwave.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.techwave.Bank.models.bao.Bao;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
	@Bean
    public Bao newBao() {
        return new Bao(); 
    }
}

//package com.techwave.Bank;
//
//import java.sql.*;
//import java.util.*;
//import java.util.logging.Logger;
//
//public class BankApplication {
//
//    private static final Logger log;
//
//    static {
//        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
//        log =Logger.getLogger(BankApplication.class.getName());
//    }
//
//    public static void main(String[] args) throws Exception {
//        log.info("Loading application properties");
//        Properties properties = new Properties();
//        properties.load(BankApplication.class.getClassLoader().getResourceAsStream("application.properties"));
//
//        log.info("Connecting to the database");
//        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
//        log.info("Database connection test: " + connection.getCatalog());
//
//        log.info("Create database schema");
//        Scanner scanner = new Scanner(BankApplication.class.getClassLoader().getResourceAsStream("schema.sql"));
//        Statement statement = connection.createStatement();
//        while (scanner.hasNextLine()) {
//            statement.execute(scanner.nextLine());
//        }
//
//		/*
//		Todo todo = new Todo(1L, "configuration", "congratulations, you have set up JDBC correctly!", true);
//        insertData(todo, connection);
//        todo = readData(connection);
//        todo.setDetails("congratulations, you have updated data!");
//        updateData(todo, connection);
//        deleteData(todo, connection);
//		*/
//
//        log.info("Closing database connection");
//        connection.close();
//    }
//}