package cn.edu.fjnu.towide.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import cn.edu.fjnu.towide.entity.EventProcessingLog;

@Repository
public interface EventProcessingLogDao {

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
	boolean addEventLog(EventProcessingLog eventProcessingLog);

	
}
