package wvs.ecommerceapi.service;

import org.springframework.stereotype.Service;
import wvs.ecommerceapi.controller.dto.CreateUserDto;
import wvs.ecommerceapi.entity.BillingAddressEntity;
import wvs.ecommerceapi.entity.UserEntity;
import wvs.ecommerceapi.repository.BillingAddressRepository;
import wvs.ecommerceapi.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public UserEntity createUser(CreateUserDto data) {
        var billingAddress = new BillingAddressEntity();

        billingAddress.setAddress(data.address());
        billingAddress.setNumber(data.number());
        billingAddress.setComplement(data.complement());

        billingAddressRepository.save(billingAddress);

        var user = new UserEntity();
        user.setFullName(data.fullName());
        user.setBillingAddress(billingAddress);
        return userRepository.save(user);
    }

    public Optional<UserEntity> findUserById(UUID userId) {
        return userRepository.findById(userId);
    }

    public boolean deleteUserById(UUID userId) {
        var user = userRepository.findById(userId);

        if (user.isPresent()) {
            userRepository.deleteById(userId);
            billingAddressRepository.deleteById(user.get().getBillingAddress().getBilligAddressId());
        }

        return user.isPresent();
    }
}
