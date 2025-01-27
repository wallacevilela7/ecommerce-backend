package wvs.ecommerceapi.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(name = "full_name")
    private String fullName;

    //BillingAddress mapeamento unidirecional
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id")
    private BillingAddressEntity billingAddressEntity;

    public UserEntity() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BillingAddressEntity getBillingAddress() {
        return billingAddressEntity;
    }

    public void setBillingAddress(BillingAddressEntity billingAddressEntity) {
        this.billingAddressEntity = billingAddressEntity;
    }
}
