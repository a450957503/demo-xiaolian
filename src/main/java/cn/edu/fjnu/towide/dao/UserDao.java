package cn.edu.fjnu.towide.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.edu.fjnu.towide.entity.User;

@Repository
public interface UserDao {


	@Update("UPDATE users SET verification_code=#{verificationCode} WHERE username=#{userName}")
	boolean updateVerificationCodeByUserName(@Param("userName")String userName, @Param("verificationCode")String verificationCode);


	@Select("SELECT u.username,u.password,u.verification_code,ud.* "
			+ "FROM "
			+ "users as u "
			+ "LEFT JOIN user_details as ud ON u.username=ud.username "
			+ "WHERE (u.username=#{searchCondition})or(ud.phone=#{searchCondition})")
	User getUserByUserNameOrPhone(String searchCondition);


	@Update("update users set password=#{newPassword} where username=#{userName}  AND verification_code=#{verificationCode} AND UNIX_TIMESTAMP(NOW())-UNIX_TIMESTAMP(verification_code_generate_time)<"+User.VERIFICATION_CODE_MAXIMUM_PERIOD)
	boolean updatePasswordByVerification(@Param("userName")String userName,@Param("verificationCode")String verificationCode, @Param("newPassword")String newPassword);


	@Select("SELECT u.username,ud.* FROM "
			+ "users as u "
			+ "LEFT JOIN user_details as ud ON u.username=ud.username "
			+ "WHERE u.username=#{useName}")
	User getUserByUserName(String userName);
	
	
	
/*	@Select("select ud.*,u.password from users as u left join user_details as ud on u.username=ud.username where u.username=#{userName} and ud.type="+User.TYPE_CONTROL_COMPUTER_MANAGER)
	Manager getControlComputerManager(@Param("userName")String userName);
*/

	@Update("update users set password=#{newPassword} where username=#{username}")
	boolean changePassword(@Param("username")String username, @Param("newPassword")String newPassword);


	@Select("SELECT COUNT(1) FROM user_details WHERE username=#{username}")
	boolean checkUserExist(String username);

	@Insert("INSERT INTO users (username,password) VALUES (#{username},#{password})")
	boolean addUserToUsers(User user);

	@Insert("INSERT INTO user_details (username,real_name,gender,create_date_time,last_update_time) "
			+ "VALUES "
			+ "(#{username},#{realName},#{gender},#{createDateTime},#{lastUpdateTime})")
	boolean addUserToUserDetails(User user);

	@Update("UPDATE users SET password=#{password} WHERE username=#{username}")
	boolean setPassword(@Param("username")String username, @Param("password")String password);


	@Delete("DELETE FROM users WHERE username=#{username}")
	boolean deleteUserFromUsers(String username);


	@Delete("DELETE FROM user_details WHERE username=#{username}")
	boolean deleteUserFromUserDetails(String username);


//	@Update("UPDATE user_details SET real_name=#{realName},phone=#{phone} WHERE username=#{userName}")
//	boolean updateBaicInfoOfUser(@Param("userName")String userName, @Param("realName")String realName, @Param("cardId")String cardId,@Param("phone")String phone);

	@Update("UPDATE user_details SET real_name=#{realName},gender=#{gender},last_update_time=#{lastUpdateTime} WHERE username=#{username}")
	boolean updateBaicInfoOfUser(User user);


	@Select("SELECT password FROM users WHERE username=#{username}")
	String getUserPasswordByUserName(String userName);

/*	@Update("UPDATE user_details SET unread_message_number=unread_message_number+1 WHERE "
			+ "type="+User.TYPE_STUDENT+" "
			+ "OR "
			+ "type="+User.TYPE_TEACHER)
	boolean updateUserUnReadPublicMessageNumber();
*/

	@Update("UPDATE user_details SET unread_private_message_number=unread_private_message_number+1 WHERE username=#{username}")
	boolean updateUserUnReadPrivateMessageNumber(String username);


	@Update("UPDATE user_details SET unread_private_message_number=0 WHERE username=#{username}")
	boolean clearUserUnReadPrivateMessageNumber(String username);


	@Select("SELECT unread_private_message_number FROM user_details WHERE username=#{username}")
	int getUnreadPrivateMessageNumber(String username);


	/**  
	 * @Description: 获取人员列表
	 */  
	@Select("SELECT * "
			+ "FROM "
			+ "user_details ")
	List<User> getPersonnelList();


	
}

