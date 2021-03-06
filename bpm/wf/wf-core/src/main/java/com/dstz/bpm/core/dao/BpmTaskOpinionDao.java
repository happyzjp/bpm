package com.dstz.bpm.core.dao;

import com.dstz.base.dao.BaseDao;
import com.dstz.bpm.core.model.BpmTaskOpinion;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface BpmTaskOpinionDao extends BaseDao<String, BpmTaskOpinion> {
	public BpmTaskOpinion getByTaskId(String taskId);

	public List<BpmTaskOpinion> getByInstAndNode(@Param(value = "instId") String instId,
			@Param(value = "nodeId") String nodeId);
}