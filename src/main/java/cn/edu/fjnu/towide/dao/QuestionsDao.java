package cn.edu.fjnu.towide.dao;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.stereotype.Repository;

import cn.edu.fjnu.towide.entity.Department;
import cn.edu.fjnu.towide.entity.Questions;

 

@Repository
public interface QuestionsDao {


	/**  
	 * @Description: 
	 */  
	@Select("SELECT * FROM questions ")
	List<Questions> getQuestionsList();
	
	/**  
	 * @Description: 
	 */  
	@Select("SELECT * FROM department where sequence_number=#{departmentId}")
	 Department getDepartmentList(String departmentId);
   
	/**
	 * @author xjw
	 *
	 * @Description: 88
	 */
	@Insert("INSERT INTO questions "
			+ "("
			+ "id,sequence_number,title,"
			+ "department_id,department_name,state,frequency,"
			+"username,real_name,nick_name,"
			+"top_or_not,create_date_time,last_update_date_time,"
			+"content"
			+ ")VALUES("
			+ "#{id},#{sequenceNumber},#{title},"
			+ "#{departmentId},#{departmentName},#{state},#{frequency},"
			+ "#{username},#{realName},#{nickName},"
			+ "#{topOrNot},#{createDateTime},#{lastUpdateDateTime},"
			+ "#{content}"
			+ ")")
	boolean addQuestion(Questions questions);
	
	

	 
	
	
	
}