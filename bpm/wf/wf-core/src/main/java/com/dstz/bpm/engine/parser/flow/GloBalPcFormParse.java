package com.dstz.bpm.engine.parser.flow;

import com.dstz.bpm.api.model.form.BpmForm;
import com.dstz.bpm.api.model.form.DefaultForm;
import com.dstz.bpm.engine.model.DefaultBpmProcessDef;
import com.dstz.bpm.engine.parser.flow.AbsFlowParse;
import org.springframework.stereotype.Component;

@Component
public class GloBalPcFormParse extends AbsFlowParse<DefaultForm> {
	
	public String getKey() {
		return "globalForm";
	}

	public void setDefParam(DefaultBpmProcessDef bpmProcessDef, Object object) {
		DefaultForm form = (DefaultForm) object;
		bpmProcessDef.setGlobalForm((BpmForm) form);
	}

}