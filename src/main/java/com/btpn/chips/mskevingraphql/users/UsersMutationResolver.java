package com.btpn.chips.mskevingraphql.users;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersMutationResolver implements GraphQLMutationResolver {

    @Autowired
    UserService userService;

    public User create(String name) throws JsonProcessingException {
        User user = new User(name);
        return userService.create(user);
    }
}
