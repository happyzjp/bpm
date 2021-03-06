package com.dstz.bpm.engine.plugin.session.impl;

import com.dstz.bpm.api.constant.ActionType;
import com.dstz.bpm.api.constant.EventType;
import com.dstz.bpm.api.engine.action.cmd.BaseActionCmd;
import com.dstz.bpm.api.engine.context.BpmContext;
import com.dstz.bpm.api.model.inst.IBpmInstance;
import com.dstz.bpm.api.model.task.IBpmTask;
import com.dstz.bpm.engine.action.cmd.DefualtTaskActionCmd;
import com.dstz.bpm.engine.plugin.session.BpmExecutionPluginSession;
import com.dstz.bus.api.model.IBusinessData;
import com.dstz.org.api.model.IUser;
import com.dstz.sys.util.ContextUtil;
import java.util.HashMap;
import java.util.Map;
import org.activiti.engine.delegate.VariableScope;

public class DefaultBpmExecutionPluginSession extends HashMap<String, Object> implements BpmExecutionPluginSession {
	private static final long serialVersionUID = 4225343560381914372L;
	private Map<String, IBusinessData> bM;
	private EventType bN;
	private VariableScope variableScope;
	private IBpmInstance bpmInstance;

	public DefaultBpmExecutionPluginSession() {
		BaseActionCmd cmd = (BaseActionCmd) BpmContext.submitActionModel();
		ActionType actionType = cmd.getActionType();
		this.put("submitActionDesc", actionType.getName());
		this.put("submitActionName", actionType.getKey());
		if (cmd instanceof DefualtTaskActionCmd) {
			DefualtTaskActionCmd taskCmd = (DefualtTaskActionCmd) cmd;
			this.put("isTask", true);
			this.put("submitOpinion", taskCmd.getOpinion());
			this.put("currentUser", ContextUtil.getCurrentUser());
			this.put("submitTaskname", taskCmd.getBpmTask().getName());
		}
	}

	public Map<String, IBusinessData> getBoDatas() {
		return this.bM;
	}

	public void setBoDatas(Map<String, IBusinessData> boDatas) {
		this.putAll(boDatas);
		this.bM = boDatas;
	}

	public IBpmInstance getBpmInstance() {
		return this.bpmInstance;
	}

	public void setBpmInstance(IBpmInstance bpmInstance) {
		this.put("bpmInstance", bpmInstance);
		this.bpmInstance = bpmInstance;
	}

	public EventType getEventType() {
		return this.bN;
	}

	public void setEventType(EventType eventType) {
		this.put("eventType", eventType.getKey());
		this.bN = eventType;
	}

	public VariableScope getVariableScope() {
		return this.variableScope;
	}

	public void setVariableScope(VariableScope variableScope) {
		this.put("variableScope", variableScope);
		this.variableScope = variableScope;
	}
}