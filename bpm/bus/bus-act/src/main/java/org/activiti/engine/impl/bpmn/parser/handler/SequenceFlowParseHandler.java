/*    */ package org.activiti.engine.impl.bpmn.parser.handler;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.activiti.bpmn.model.BaseElement;
/*    */ import org.activiti.bpmn.model.SequenceFlow;
/*    */ import org.activiti.engine.delegate.Expression;
/*    */ import org.activiti.engine.impl.Condition;
/*    */ import org.activiti.engine.impl.bpmn.parser.BpmnParse;
/*    */ import org.activiti.engine.impl.el.ExpressionManager;
/*    */ import org.activiti.engine.impl.el.GroovyCondition;
/*    */ import org.activiti.engine.impl.pvm.process.ActivityImpl;
/*    */ import org.activiti.engine.impl.pvm.process.ScopeImpl;
/*    */ import org.activiti.engine.impl.pvm.process.TransitionImpl;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SequenceFlowParseHandler
/*    */   extends AbstractBpmnParseHandler<SequenceFlow>
/*    */ {
/*    */   public static final String PROPERTYNAME_CONDITION = "condition";
/*    */   public static final String PROPERTYNAME_CONDITION_TEXT = "conditionText";
/*    */   
/*    */   public Class<? extends BaseElement> getHandledType()
/*    */   {
/* 36 */     return SequenceFlow.class;
/*    */   }
/*    */   
/*    */   protected void a(BpmnParse bpmnParse, SequenceFlow sequenceFlow)
/*    */   {
/* 41 */     ScopeImpl scope = bpmnParse.getCurrentScope();
/*    */     
/* 43 */     ActivityImpl sourceActivity = scope.findActivity(sequenceFlow.getSourceRef());
/* 44 */     ActivityImpl destinationActivity = scope.findActivity(sequenceFlow.getTargetRef());
/*    */     Expression skipExpression;
/*    */     Expression skipExpression;
/* 47 */     if (StringUtils.isNotEmpty(sequenceFlow.getSkipExpression())) {
/* 48 */       ExpressionManager expressionManager = bpmnParse.getExpressionManager();
/* 49 */       skipExpression = expressionManager.createExpression(sequenceFlow.getSkipExpression());
/*    */     } else {
/* 51 */       skipExpression = null;
/*    */     }
/*    */     
/* 54 */     TransitionImpl transition = sourceActivity.createOutgoingTransition(sequenceFlow.getId(), skipExpression);
/* 55 */     bpmnParse.getSequenceFlows().put(sequenceFlow.getId(), transition);
/* 56 */     transition.setProperty("name", sequenceFlow.getName());
/* 57 */     transition.setProperty("documentation", sequenceFlow.getDocumentation());
/* 58 */     transition.setDestination(destinationActivity);
/*    */     
/* 60 */     if (StringUtils.isNotEmpty(sequenceFlow.getConditionExpression())) {
/* 61 */       Condition expressionCondition = new GroovyCondition(sequenceFlow.getConditionExpression());
/* 62 */       transition.setProperty("conditionText", sequenceFlow.getConditionExpression());
/* 63 */       transition.setProperty("condition", expressionCondition);
/*    */     }
/*    */     
/* 66 */     createExecutionListenersOnTransition(bpmnParse, sequenceFlow.getExecutionListeners(), transition);
/*    */   }
/*    */ }


/* Location:              E:\repo\com\dstz\agilebpm\wf-act\1.1.5\wf-act-1.1.5-pg.jar!\org\activiti\engine\impl\bpmn\parser\handler\SequenceFlowParseHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */