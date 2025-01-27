package wvs.ecommerceapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_billing_address")
public class BillingAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billing_address_id")
    private Long billigAddressId;

    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private String number;

    @Column(name = "complement")
    private String complement;

    //mapeamento user


    public BillingAddressEntity() {
    }

    public Long getBilligAddressId() {
        return billigAddressId;
    }

    public void setBilligAddressId(Long billigAddressId) {
        this.billigAddressId = billigAddressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
