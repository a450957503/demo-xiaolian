package cn.edu.fjnu.towide.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceDao {

	/**  
	 * @Description: 部门可用序号
	 */  
	@Select("SELECT number FROM sequence WHERE id=#{department}")
	int getNumber(String sequenceId);
	
	//@Select("SELECT number FROM sequence WHERE id=#{question}")
	//int getQuestionNumber(String sequenceId);
	
	
	//@Select("SELECT id FROM department WHERE sequence_number=#{id}")
	//int getNumber(String sequenceId);
//
//
//	@Update("UPDATE sequence SET number=#{number}+1 "
//			+ "WHERE "
//			+ "id=#{id} AND number=#{number}")
//	boolean numberAddOne(@Param("id")String id,@Param("number") int number);


}
