package org.example.student;

import jakarta.annotation.PostConstruct;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("org.example.student.Mapper")
public class StudentApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(StudentApplication.class, args);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Autowired
    private DataSource dataSource;
    @PostConstruct
    public void checkDatabaseConnection() {
        try {
            dataSource.getConnection();
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}
