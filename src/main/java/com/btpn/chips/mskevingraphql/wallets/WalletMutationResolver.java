package com.btpn.chips.mskevingraphql.wallets;

import com.btpn.chips.mskevingraphql.users.User;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WalletMutationResolver implements GraphQLMutationResolver {

    @Autowired
    WalletService walletService;

    public Wallet create(Long balance, User user) {
        return walletService.create(balance, user);
    }
}
