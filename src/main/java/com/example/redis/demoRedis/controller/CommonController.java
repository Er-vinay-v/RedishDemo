package com.example.redis.demoRedis.controller;

@org.springframework.web.bind.annotation.RestController
public class CommonController {

    //org.springframework.beans.factory.annotation.Autowired
    com.example.redis.demoRedis.util.RedisUtil redisUtil;

    @org.springframework.web.bind.annotation.GetMapping
    @org.springframework.web.bind.annotation.RequestMapping("/get/data")
    public String getData(){

        return "inside getData controller";
    }

    //set data in caching
    @org.springframework.web.bind.annotation.PostMapping
    @org.springframework.web.bind.annotation.RequestMapping("/create/person")
    public boolean createData(@org.springframework.web.bind.annotation.RequestBody(required = false)com.example.redis.demoRedis.model.Person person){

        redisUtil.setNonExperiableRedisKey(person.getId() +" ",person);
        return true;
    }

    //get data by using caching
    @org.springframework.web.bind.annotation.GetMapping
    @org.springframework.web.bind.annotation.RequestMapping("/get/person/{id}")
    public org.springframework.http.ResponseEntity<Object> createData(@org.springframework.web.bind.annotation.PathVariable("id") String id){

        com.example.redis.demoRedis.model.Person p=(com.example.redis.demoRedis.model.Person) redisUtil.getNonExperiableRedisValue(id);
        if(p==null){
            return new org.springframework.http.ResponseEntity<>("Not found", org.springframework.http.HttpStatus.NOT_FOUND);

        }
        return new org.springframework.http.ResponseEntity<>(p, org.springframework.http.HttpStatus.FOUND);

    }
}
