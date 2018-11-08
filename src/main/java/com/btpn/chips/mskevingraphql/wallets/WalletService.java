package com.btpn.chips.mskevingraphql.wallets;

import com.btpn.chips.mskevingraphql.kafka.model.WalletCreationModel;
import com.btpn.chips.mskevingraphql.kafka.service.KafkaProducerService;
import com.btpn.chips.mskevingraphql.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public WalletService(WalletRepository walletRepository, KafkaProducerService kafkaProducerService) {
        this.walletRepository = walletRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    public void clear() {
        walletRepository.deleteAll();
    }

    public Wallet create(Long balance, User user) {
        Wallet wallet = new Wallet(balance, user);

        WalletCreationModel walletCreationModel = new WalletCreationModel(user.getId(), wallet.getId(), user.getName(), wallet.getBalance());
        kafkaProducerService.sendData("test", walletCreationModel);

        return walletRepository.save(wallet);
    }

    public List<Wallet> fetchAll() {
        return walletRepository.findAll();
    }

    public Wallet fetch(int id) {
        return walletRepository.findWalletById(id);
    }
}
