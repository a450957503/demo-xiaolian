package cn.edu.fjnu.towide.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import cn.edu.fjnu.towide.entity.DemoEntity;

@Repository
public interface DemoEntityDao {

	//向数据库插入demoentity对象示例
	@Insert("INSERT INTO event_processing_log"
			+ "("
			+ "id,event_name,event_description,event_content,"
			+ "event_initiator_username,event_initiator_real_name,"
			+ "logistics_storage_center_id,logistics_storage_center_name,"
			+ "process_state,process_result,process_result_description,time_consuming"
			+ ")"
			+ "VALUES"
			+ "("
			+ "#{id},#{eventName},#{eventDescription},#{eventContent},"
			+ "#{eventInitiatorUsername},#{eventInitiatorRealName},"
			+ "#{logisticsStorageCenterId},#{logisticsStorageCenterName},"
			+ "#{processState},#{processResult},#{processResultDescription},#{timeConsuming}"
			+ ")")
	boolean addDemoEntity(DemoEntity DemoEntity);

	//读取数据库并创建实体类对象示例
	@Select("Select * from demo_entity Where id=demoEntityId")
	DemoEntity getDemoEntityById(String demoEntityId);

	
	
}
