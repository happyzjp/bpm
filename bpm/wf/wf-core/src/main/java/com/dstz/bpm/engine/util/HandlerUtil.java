package com.dstz.bpm.engine.util;

import com.dstz.base.core.util.AppUtil;
import com.dstz.base.core.util.StringUtil;
import com.dstz.bpm.api.engine.action.cmd.ActionCmd;
import java.lang.reflect.Method;

public class HandlerUtil {
	public static int h(String handler) {
		if (handler.indexOf(".") == -1) {
			return -1;
		} else {
			String[] aryHandler = handler.split("[.]");
			if (aryHandler.length != 2) {
				return -1;
			} else {
				String beanId = aryHandler[0];
				String method = aryHandler[1];
				Object serviceBean = null;

				try {
					serviceBean = AppUtil.getBean(beanId);
				} catch (Exception var8) {
					return -2;
				}

				if (serviceBean == null) {
					return -2;
				} else {
					try {
						serviceBean.getClass().getDeclaredMethod(method, ActionCmd.class);
						return 0;
					} catch (NoSuchMethodException var6) {
						return -3;
					} catch (Exception var7) {
						return -4;
					}
				}
			}
		}
	}

	public static void a(ActionCmd actionModel, String handler) throws Exception {
		if (!StringUtil.isEmpty(handler)) {
			String[] aryHandler = handler.split("[.]");
			if (aryHandler != null && aryHandler.length == 2) {
				String beanId = aryHandler[0];
				String method = aryHandler[1];
				Object serviceBean = AppUtil.getBean(beanId);
				if (serviceBean != null) {
					Method invokeMethod = serviceBean.getClass().getDeclaredMethod(method, ActionCmd.class);
					invokeMethod.invoke(serviceBean, actionModel);
				}
			}
		}
	}
}