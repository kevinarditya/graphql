package com.btpn.chips.mskevingraphql.users;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersQueryResolver implements GraphQLQueryResolver {

    @Autowired
    UserService userService;

    public List<User> fetchAllUsers() {
        return userService.fetchAll();
    }

//    public UserCreationModel kafkaListener() throws Exception {
//        KafkaConsumerService kafkaConsumerService = new KafkaConsumerService();
//
//    }
}
