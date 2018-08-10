package com.dstz.bus.model;

import com.dstz.base.core.model.BaseModel;
import com.dstz.bus.api.model.IBusColumnCtrl;
import org.hibernate.validator.constraints.NotEmpty;

public class BusColumnCtrl extends BaseModel implements IBusColumnCtrl {
	/**
	 * 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 * 
	 */
	private static final long serialVersionUID = -1717378058777116112L;

	@NotEmpty
	private String columnId;
	@NotEmpty
	private String type;
	private String config;
	private String validRule;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColumnId() {
		return this.columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getConfig() {
		return this.config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getValidRule() {
		return this.validRule;
	}

	public void setValidRule(String validRule) {
		this.validRule = validRule;
	}
}