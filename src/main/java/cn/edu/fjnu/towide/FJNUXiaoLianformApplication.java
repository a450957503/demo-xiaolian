package cn.edu.fjnu.towide;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableCaching
@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("cn.edu.fjnu.towide.dao")
public class FJNUXiaoLianformApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(FJNUXiaoLianformApplication.class, args);
//		System.out.println("ok");	
	}	
}
