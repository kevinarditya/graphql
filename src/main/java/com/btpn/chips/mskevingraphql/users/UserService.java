package com.btpn.chips.mskevingraphql.users;

import com.btpn.chips.mskevingraphql.kafka.model.UserCreationModel;
import com.btpn.chips.mskevingraphql.kafka.service.KafkaProducerService;
import com.btpn.chips.mskevingraphql.wallets.Wallet;
import com.btpn.chips.mskevingraphql.wallets.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final WalletService walletService;
    private final KafkaProducerService kafkaProducerService;

//    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    UserService(UserRepository userRepository, WalletService walletService, KafkaProducerService kafkaProducerService) {
        this.userRepository = userRepository;
        this.walletService = walletService;
        this.kafkaProducerService = kafkaProducerService;
    }

    public void clear() {
        userRepository.deleteAll();
    }

    public User create(User user) {
        User newUser = userRepository.save(user);
        Wallet wallet = walletService.create(Long.valueOf(0), newUser);

        UserCreationModel userCreationModel = new UserCreationModel(user.getName(), wallet.getBalance());
//        kafkaProducerService.sendData("User-Wallet-Creation", objectMapper.writeValueAsString(userCreationModel));
        kafkaProducerService.sendData("test", userCreationModel);

        return newUser;
    }

    public List<User> fetchAll() {
        return userRepository.findAll();
    }

    public User fetch(int id) {
        return userRepository.findUserById(id);
    }
}
