package com.example.Job_Portal.Repository;

import com.example.Job_Portal.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContantRepository extends JpaRepository<Contact,Long> {
}
