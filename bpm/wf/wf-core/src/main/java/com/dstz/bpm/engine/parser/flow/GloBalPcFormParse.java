/*    */ package com.dstz.bpm.engine.parser.flow;
/*    */ 
/*    */ import com.dstz.bpm.api.model.form.DefaultForm;
/*    */ import com.dstz.bpm.engine.model.DefaultBpmProcessDef;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ @Component
/*    */ public class GloBalPcFormParse
/*    */   extends AbsFlowParse<DefaultForm>
/*    */ {
/*    */   public String getKey()
/*    */   {
/* 14 */     return "globalForm";
/*    */   }
/*    */   
/*    */   public void a(DefaultBpmProcessDef bpmProcessDef, Object object)
/*    */   {
/* 19 */     DefaultForm form = (DefaultForm)object;
/* 20 */     bpmProcessDef.setGlobalForm(form);
/*    */   }
/*    */ }


/* Location:              E:\repo\com\dstz\agilebpm\wf-core\1.1.5\wf-core-1.1.5-pg.jar!\com\dstz\bpm\engine\parser\flow\GloBalPcFormParse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */