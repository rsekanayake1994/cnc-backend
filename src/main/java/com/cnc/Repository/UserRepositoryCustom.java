package com.cnc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cnc.Model.UserModel;

public interface UserRepositoryCustom extends JpaRepository<UserModel,String>{
	/*@Query("select * from user  where telephone = ?1 ")
	UserModel findUserByTelephone(String telephone);*/
	
	@Query(nativeQuery=true,value="select * from user   where username =:username AND  password =:password")
	UserModel findUserByCreditials(@Param("username")String username, @Param("password")String password);
}
