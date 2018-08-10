package com.dstz.bpm.engine.action.handler.task;

import com.dstz.bpm.api.constant.ActionType;
import com.dstz.bpm.api.engine.action.cmd.BaseActionCmd;
import com.dstz.bpm.engine.action.cmd.DefualtTaskActionCmd;
import com.dstz.bpm.engine.action.handler.task.AbstractTaskActionHandler;
import org.springframework.stereotype.Component;

@Component
public class TaskAgreeActionHandler extends AbstractTaskActionHandler<DefualtTaskActionCmd> {
	public ActionType getActionType() {
		return ActionType.AGREE;
	}

	protected void d(DefualtTaskActionCmd actionModel) {
	}

	protected void e(DefualtTaskActionCmd actionModel) {
		this.c(actionModel);
	}

	public int getSn() {
		return 1;
	}

	public String getConfigPage() {
		return "/bpm/task/taskOpinionDialog.html";
	}

	protected void i(BaseActionCmd baseActionCmd) {
		this.d((DefualtTaskActionCmd) baseActionCmd);
	}

	protected void h(BaseActionCmd baseActionCmd) {
		this.e((DefualtTaskActionCmd) baseActionCmd);
	}
}