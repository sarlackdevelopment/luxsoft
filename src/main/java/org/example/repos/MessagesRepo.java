package org.example.repos;

import org.example.domain.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepo extends JpaRepository<Messages, Long>  { }
