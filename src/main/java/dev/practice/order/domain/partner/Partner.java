package dev.practice.order.domain.partner;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Slf4j
@Table(name = "partners")
@Getter
@Entity
@NoArgsConstructor
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partnerToken;

    private String partnerName;

    private String businessNo;

    private String email;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }

    @Builder
    public Partner(String partnerName, String businessNo, String email) {
        if (StringUtils.isEmpty(partnerName)) throw new RuntimeException("empty partnerName");
        if (StringUtils.isEmpty(businessNo)) throw new RuntimeException("empty businessNo");
        if (StringUtils.isEmpty(email)) throw new RuntimeException("empty email");

        this.partnerToken = "abcde";
        this.partnerName = partnerName;
        this.businessNo = businessNo;
        this.email = email;
        this.status = Status.ENABLE;
        this.createdAt = ZonedDateTime.now();
        this.updatedAt = ZonedDateTime.now();
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"), DISABLE("비활성화");

        private final String description;
    }

}
