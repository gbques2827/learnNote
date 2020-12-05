package  com.gbques.ly.cloud.seataorderservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.gbques.ly.cloud.seataorderservice.dao"})
public class MyBatisConfig {
}
