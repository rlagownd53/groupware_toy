package study.groupware.member.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    private int memberId;

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String name;
    private String gender;

    @NotEmpty
    private String phone;
    private String email;

    private String status;

    @Embedded
    private Address addr;

    private LocalDateTime regDate;
}
