 package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.mapper.CoffeeMapper;
import lombok.extern.slf4j.Slf4j;

//系统设计题目
 //设计一个服务，任何⼈调⽤这个服务，都返回⼀个unique id，不能重复；
 

//思路：建立一张用户关系表 ID name （ID 自增长 ）根据用户的名字 去得到ID 保证唯一性
 @RestController
 @RequestMapping("/test")
 @Slf4j
 public class Test5 {
     
     @Autowired
     private CoffeeMapper coffeeMapper;
     
     //   @Mapper
     //   public interface CoffeeMapper {
    //             @Select("select id from t_coffee where name = #{name}")
    //             Long getId(@Param("name") String name);
     //    }
     
     
     @GetMapping("/getId/{name}")
     public Long getUniqueId(@PathVariable(name = "name")String name) {
         log.info("unique id:{}",coffeeMapper.getId(name));
         return coffeeMapper.getId(name);
         
     }

}
