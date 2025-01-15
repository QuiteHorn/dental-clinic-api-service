package ru.meerake.serverside.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.meerake.serverside.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String login);
}
