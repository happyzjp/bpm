package com.dstz.bpm.api.engine.action.cmd;

import com.dstz.bpm.api.model.inst.IBpmInstance;


/**
 * 描述：流程实例对象命令对象
 */
public interface InstanceActionCmd extends ActionCmd {

    public String getSubject();

    public String getBusinessKey();

    public String getInstanceId();

    public IBpmInstance getBpmInstance();

}
