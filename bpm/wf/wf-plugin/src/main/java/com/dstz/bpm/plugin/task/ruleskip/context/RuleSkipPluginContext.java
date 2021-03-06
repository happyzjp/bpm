package com.dstz.bpm.plugin.task.ruleskip.context;

import com.alibaba.fastjson.JSON;
import com.dstz.bpm.api.constant.EventType;
import com.dstz.bpm.api.engine.plugin.def.BpmPluginDef;
import com.dstz.bpm.api.engine.plugin.runtime.RunTimePlugin;
import com.dstz.bpm.engine.plugin.context.AbstractBpmTaskPluginContext;
import com.dstz.bpm.plugin.task.ruleskip.def.JumpRule;
import com.dstz.bpm.plugin.task.ruleskip.def.RuleSkipPluginDef;
import com.dstz.bpm.plugin.task.ruleskip.plugin.RuleSkipPlugin;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class RuleSkipPluginContext extends AbstractBpmTaskPluginContext<RuleSkipPluginDef> {
	private static final long serialVersionUID = 8784633971785686365L;

	public List getEventTypes() {
		ArrayList<EventType> eventTypes = new ArrayList<EventType>();
		eventTypes.add(EventType.TASK_PRE_COMPLETE_EVENT);
		return eventTypes;
	}

	public Class<? extends RunTimePlugin> getPluginClass() {
		return RuleSkipPlugin.class;
	}

	public String getTitle() {
		return "任务消息插件";
	}

	protected RuleSkipPluginDef parseFromJson(JSON json) {
		RuleSkipPluginDef def = new RuleSkipPluginDef();
		List list = JSON.parseArray((String) json.toJSONString(), JumpRule.class);
		def.setJumpRules(list);
		return def;
	}

//	protected BpmPluginDef parseFromJson(JSON jSON) {
//		return this.e(jSON);
//	}
}