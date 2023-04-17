package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    public final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item); // 처음 데이터 저장할 때는 id가 없기 때문에 신규 등록
        } else {
            em.merge(item); // 업데이트 비슷
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
