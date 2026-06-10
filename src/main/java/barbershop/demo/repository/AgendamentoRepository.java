package barbershop.demo.repository;

import barbershop.demo.models.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository  extends JpaRepository<AgendamentoModel, Integer> {
}
