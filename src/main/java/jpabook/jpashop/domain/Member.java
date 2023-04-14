package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // Order 테이블에 있는 member 필드에 의해 맵핑됨. 이 컬럼에 값을 넣는다고 해서 Order 테이블의 member(FK)값이 변경되지 않는다.
    private List<Order> orders = new ArrayList<>();
}
