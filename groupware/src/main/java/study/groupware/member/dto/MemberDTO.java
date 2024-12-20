package study.groupware.member.dto;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import study.groupware.member.domain.Address;

import java.time.LocalDateTime;

@Getter @Setter
public class MemberDTO {
    private int memberId;
    private String name;
    private String loginId;
    private String email;
    private String gender;
    private String phone;
    private String zipCode;
    private String addr;
    private String addr_dtl;
    private LocalDateTime updateDate;
}
