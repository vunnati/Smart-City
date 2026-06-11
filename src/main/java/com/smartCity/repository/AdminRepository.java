package com.smartCity.repository;

import com.smartCity.objects.users.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admins, Integer> {

    Admins findByAdminID(Integer adminID);

    Admins findByUsername(String username);
}
