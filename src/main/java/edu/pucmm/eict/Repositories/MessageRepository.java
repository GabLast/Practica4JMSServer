package edu.pucmm.eict.Repositories;

import edu.pucmm.eict.Models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAll();

}
