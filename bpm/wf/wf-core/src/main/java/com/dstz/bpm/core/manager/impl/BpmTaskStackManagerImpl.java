 package com.dstz.bpm.core.manager.impl;
 
 import com.dstz.base.db.id.UniqueIdUtil;
 import com.dstz.base.manager.impl.BaseManager;
 import com.dstz.bpm.api.model.task.IBpmTask;
 import com.dstz.bpm.core.dao.BpmTaskStackDao;
 import com.dstz.bpm.core.manager.BpmTaskStackManager;
 import com.dstz.bpm.core.model.BpmTaskStack;
 import java.util.Date;
 import javax.annotation.Resource;
 import org.springframework.stereotype.Service;
 
 
 
 
 
 
 @Service("bpmExecutionStackManager")
 public class BpmTaskStackManagerImpl
   extends BaseManager<String, BpmTaskStack>
   implements BpmTaskStackManager
 {
   @Resource
   BpmTaskStackDao l;
   
   public BpmTaskStack getByTaskId(String taskId)
   {
     return this.l.getByTaskId(taskId);
   }
   
   public BpmTaskStack createStackByTask(IBpmTask task, BpmTaskStack parentStack)
   {
     BpmTaskStack stack = new BpmTaskStack();
     String id = UniqueIdUtil.getSuid();
     stack.setId(id);
     stack.setNodeId(task.getNodeId());
     stack.setNodeName(task.getName());
     stack.setTaskId(task.getId());
     
     stack.setStartTime(new Date());
     stack.setInstId(task.getInstId());
     
     if (parentStack == null) {
       stack.setPath(id + ".");
       stack.setParentId("0");
     } else {
       stack.setPath(parentStack.getPath() + id + ".");
       stack.setParentId(parentStack.getId());
     }
     create(stack);
     
     return stack;
   }
   
   public void removeByInstanceId(String instId)
   {
     this.l.removeByInstanceId(instId);
   }
 }


/* Location:              E:\repo\com\dstz\agilebpm\wf-core\1.1.5\wf-core-1.1.5-pg.jar!\com\dstz\bpm\core\manager\impl\BpmTaskStackManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */