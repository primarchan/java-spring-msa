package dev.practice.order.domain.item;

import com.google.common.collect.Lists;
import dev.practice.order.common.exception.InvalidParamException;
import dev.practice.order.domain.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "items")
@Entity
@NoArgsConstructor
public class Item extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemToken;

    private Long partnerId;

    private String itemName;

    private Long itemPrice;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<ItemOptionGroup> itemOptionGroupList = Lists.newArrayList();

    @Enumerated(EnumType.STRING)
    private Status status;

    private int ordering;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        PREPARE("판매준비중"),
        ON_SALE("판매중"),
        END_OF_SALES("판매종료");

        private final String description;
    }

    public void changePrepare() {
       this.status = Status.PREPARE;
    }

    public void changeOnSales() {
        this.status = Status.ON_SALE;
    }

    public void endOFSales() {
        this.status = Status.END_OF_SALES;
    }

}
