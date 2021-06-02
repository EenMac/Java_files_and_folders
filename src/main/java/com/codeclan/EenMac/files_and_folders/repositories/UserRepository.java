package com.codeclan.EenMac.files_and_folders.repositories;

import com.codeclan.EenMac.files_and_folders.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
