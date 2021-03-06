package com.dstz.bpm.api.engine.action.handler;

import com.dstz.bpm.api.constant.ActionType;
import com.dstz.bpm.api.engine.action.cmd.ActionCmd;
import com.dstz.bpm.api.model.nodedef.BpmNodeDef;

/**
 * 动作执行处理器
 *
 * @author jeff
 */
public interface ActionHandler<T extends ActionCmd> {
    /**
     * 执行入口
     *
     * @param model
     */
    void execute(T model);

    /**
     * 定义动作的key name beanId
     *
     * @return
     */
    ActionType getActionType();

    // ========生成按钮配置项========

    /**
     * 排序
     *
     * @return
     */
    int getSn();

    /**
     * 判断是否支持改任务类型
     *
     * @param nodeDef
     * @return
     */
    Boolean isSupport(BpmNodeDef nodeDef);

    /**
     * 是否默认展示
     *
     * @return
     */
    Boolean isDefault();

    /**
     * 该action特殊配置获取页
     *
     * @return
     */
    String getConfigPage();

    /**
     * 默认groovy脚本
     *
     * @return
     */
    String getDefaultGroovyScript();

    /**
     * 默认前置脚本
     *
     * @return
     */
    String getDefaultBeforeScript();
}
