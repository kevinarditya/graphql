package com.btpn.chips.mskevingraphql.users;

import com.btpn.chips.mskevingraphql.wallets.WalletService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    WalletService walletService;

    @After
    public void cleanUp(){
        walletService.clear();
        userService.clear();
    }

    @Test
    public void create_ExpectCreateUser() throws JsonProcessingException {
        User myUser = new User("Kevin");
        userService.create(myUser);

        List<User> expectedUser = userService.fetchAll();

        assertEquals(expectedUser.size(), 1);
        assertTrue(expectedUser.contains(myUser));
    }

    @Test
    public void fetchAll_ExpectFetchAllUsers() throws JsonProcessingException {
        User firstUser = new User("Kevin");
        User secondUser = new User("Harold");
        userService.create(firstUser);
        userService.create(secondUser);

        List expectedUsers = new ArrayList();
        expectedUsers.add(firstUser);
        expectedUsers.add(secondUser);

        assertEquals(userService.fetchAll(), expectedUsers);
    }

    @Test
    public void fetch_ExpectFetchSpecificUser_WhenUserIdIsGiven() throws JsonProcessingException {
        User myUser = new User("Meita");
        userService.create(myUser);

        assertEquals(userService.fetch(myUser.getId()), myUser);
    }
}