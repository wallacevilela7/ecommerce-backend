package wvs.ecommerceapi.service;

import org.springframework.stereotype.Service;
import wvs.ecommerceapi.controller.dto.CreateUserDto;
import wvs.ecommerceapi.entity.BillingAddressEntity;
import wvs.ecommerceapi.entity.UserEntity;
import wvs.ecommerceapi.repository.BillingAddressRepository;
import wvs.ecommerceapi.repository.UserRepository;

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
}
