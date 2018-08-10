package com.dstz.bus.manager.impl;

import com.dstz.base.manager.impl.BaseManager;
import com.dstz.bus.dao.BusinessColumnDao;
import com.dstz.bus.manager.BusinessColumnManager;
import com.dstz.bus.model.BusinessColumn;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BusinessColumnManagerImpl extends BaseManager<String, BusinessColumn> implements BusinessColumnManager {
	@Resource
	BusinessColumnDao f;

	public void removeByTableId(String tableId) {
		this.f.removeByTableId(tableId);
	}

	public List<BusinessColumn> getByTableId(String tableId) {
		return this.f.getByTableId(tableId);
	}
}