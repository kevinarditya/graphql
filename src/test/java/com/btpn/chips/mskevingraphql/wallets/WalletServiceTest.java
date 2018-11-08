package com.btpn.chips.mskevingraphql.wallets;

import com.btpn.chips.mskevingraphql.users.User;
import com.btpn.chips.mskevingraphql.users.UserService;
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
public class WalletServiceTest {

    @Autowired
    WalletService walletService;

    @Autowired
    UserService userService;

    @After
    public void cleanUp(){
        walletService.clear();
        userService.clear();
    }

    public User myUser() throws JsonProcessingException {
        User user = new User("Kevin");
        userService.create(user);
        return user;
    }

    @Test
    public void create_ExpectCreateNewWallet() throws JsonProcessingException {
        User user = myUser();
        Wallet wallet = walletService.create(Long.valueOf(0), user);

        List<Wallet> expectedWallet = walletService.fetchAll();

        assertEquals(expectedWallet.size(), 2);
        assertTrue(expectedWallet.contains(wallet));
    }

    @Test
    public void fetchAll_ExpectGetAllUserWallet() throws JsonProcessingException {
        User user = myUser();
        Wallet secondWallet = walletService.create(Long.valueOf(0), user);
        Wallet thirdWallet = walletService.create(Long.valueOf(0), user);

        List<Wallet> expectedWallet = new ArrayList<>();
        expectedWallet.add(secondWallet);
        expectedWallet.add(thirdWallet);

        assertTrue(walletService.fetchAll().containsAll(expectedWallet));
    }

    @Test
    public void fetch_ExpectGetSpecificUserWallet_WhenWalletIdGiven() throws JsonProcessingException {
        User user = myUser();
        Wallet wallet = walletService.create(Long.valueOf(0), user);

        assertEquals(walletService.fetch(wallet.getId()), wallet);
    }
}