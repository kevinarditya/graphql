package com.btpn.chips.mskevingraphql.wallets;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WalletQueryResolver implements GraphQLQueryResolver {

    @Autowired
    WalletService walletService;

    public List<Wallet> fetchAllWallets() {
        return walletService.fetchAll();
    }
}
