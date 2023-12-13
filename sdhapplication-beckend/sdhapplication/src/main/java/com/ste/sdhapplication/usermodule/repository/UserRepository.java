package com.ste.sdhapplication.usermodule.repository;

import com.ste.sdhapplication.usermodule.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
}
