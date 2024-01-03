package han.study.transaction.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReposiroty extends JpaRepository<Order, Long> {
}
