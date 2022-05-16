package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    //@Enumerated(EnumType.ORDINAL) -> 을 하게되면, 실제 예상되는 READY, COMPARE 대신에 1, 2 등 정수형이 들어가게 된다.
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //READY, COMPARE


}
