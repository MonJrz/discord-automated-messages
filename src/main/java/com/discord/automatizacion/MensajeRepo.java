package com.discord.automatizacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MensajeRepo extends JpaRepository<Mensaje, Long> {
    List <Mensaje> findByFechaBefore(LocalDateTime now);
}
