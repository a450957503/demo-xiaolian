package cn.edu.fjnu.towide.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import cn.edu.fjnu.towide.entity.Department;

@Repository
public interface DepartmentDao {



	
	/**  
	 * @Description: 
	 */  
	@Select("SELECT * FROM department ORDER BY sequence_number ")//序号
	List<Department> getDepartmentList();

	/**  
	 *  @Description: add部门信息
	 */
	@Insert("INSERT INTO department "
			+ "("
			+ "id,sequence_number,name,"
			+ "introduction,create_date_time,last_update_time"
			+ ")VALUES("
			+ "#{id},#{sequenceNumber},#{name},"
			+ "#{introduction},#{createDateTime},#{lastUpdateTime}"
			+ ")")
	boolean addDepartment(Department department);

	
	

     
	
	
}