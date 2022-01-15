

package com.devsuperior.dsm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.devsuperior.dsm.entities.User;

public interface UserRepository extends JpaRepository<User, Long>  {
	
	
	User findByEmail(String email);

}
 