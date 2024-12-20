package study.groupware.member.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Address {

    private String zipCode;
    private String addr;
    private String addr_dtl;

    protected Address() {}

    public Address(String zipCode, String addr, String addr_dtl) {
        this.zipCode = zipCode;
        this.addr = addr;
        this.addr_dtl = addr_dtl;
    }
}
