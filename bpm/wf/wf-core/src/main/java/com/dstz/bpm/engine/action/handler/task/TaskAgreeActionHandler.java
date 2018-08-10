 package com.dstz.bpm.engine.action.handler.task;
 
 import com.dstz.bpm.api.constant.ActionType;
 import com.dstz.bpm.engine.action.cmd.DefualtTaskActionCmd;
 import org.springframework.stereotype.Component;
 
 
 @Component
 public class TaskAgreeActionHandler
   extends AbstractTaskActionHandler<DefualtTaskActionCmd>
 {
   public ActionType getActionType()
   {
     return ActionType.AGREE;
   }
   
 
 
 
   protected void d(DefualtTaskActionCmd actionModel) {}
   
 
 
 
   protected void e(DefualtTaskActionCmd actionModel)
   {
     c(actionModel);
   }
   
   public int getSn()
   {
     return 1;
   }
   
 
   public String getConfigPage()
   {
     return "/bpm/task/taskOpinionDialog.html";
   }
 }


/* Location:              E:\repo\com\dstz\agilebpm\wf-core\1.1.5\wf-core-1.1.5-pg.jar!\com\dstz\bpm\engine\action\handler\task\TaskAgreeActionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */