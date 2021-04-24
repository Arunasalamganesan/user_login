package com.example.demo.deo;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.mod.UserLogin;

@Repository
public interface UserRepository extends JpaRepository<UserLogin, Integer> {

//	FROM <user_login_table> WHERE user_name="<user_name>" AND 	passwordD="<password>"
	//select user_name=?1,password=?2 from user_login_table
	//@Query("select user_name,password from user_login_table")
	@Query("SELECT u FROM User u WHERE u.user_name = :username,u.password =:password")
//	@Query("select * from user_login_table as u where u.user_name = :user_name,u.password =:password")
	public UserLogin FindBYUserPassword(String username,String password);

	//@Query("Select User_name from UserLogin_table WHERE UserLogin_table.user_name = :username")
	//UserLogin findById(String username);

	//UserLogin findById(String user_name, String password);

//  public List<UserLogin2> FindAllUserr();

	//UserLogin findAllById(String password);

 	
	
	//UserLogin FindByPassword(String password);

    
	
}
