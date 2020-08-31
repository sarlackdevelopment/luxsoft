package org.example.repos;

import org.example.domain.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessagesRepo extends JpaRepository<Messages, Long>  {
}
