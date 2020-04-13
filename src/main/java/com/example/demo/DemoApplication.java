package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 声明这是一个springboot应用
 * @ResponseBody 声明返回的数据直接写给浏览器。(如果返回的是对象则转为json数据)
 * @RequestMapping("/xxx") 声明获取数据的地址
 * @RestController=@ResponseBody+@Controller
 * @ConfigurationProperties(prefix = "xxxx") 告诉springboot将本类中的所有属性和配置文件中相关的配置进行绑定,需要先使用@Component加入到容器中。
 */
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

    public static void main(String[] args) {

        //启动应用
        SpringApplication.run(DemoApplication.class, args);

    }

}
