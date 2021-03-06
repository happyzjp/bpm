package com.dstz.bpm.core.manager.impl;

import com.dstz.base.api.constant.IStatusCode;
import com.dstz.base.api.exception.BusinessException;
import com.dstz.base.core.util.BeanUtils;
import com.dstz.base.core.util.StringUtil;
import com.dstz.base.db.id.UniqueIdUtil;
import com.dstz.base.manager.impl.BaseManager;
import com.dstz.bpm.api.exception.BpmStatusCode;
import com.dstz.bpm.api.model.task.IBpmTask;
import com.dstz.bpm.core.dao.TaskIdentityLinkDao;
import com.dstz.bpm.core.manager.TaskIdentityLinkManager;
import com.dstz.bpm.core.model.TaskIdentityLink;
import com.dstz.org.api.model.IGroup;
import com.dstz.org.api.service.GroupService;
import com.dstz.sys.api.model.SysIdentity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(value = "taskIdentityLinkManager")
public class TaskIdentityLinkManagerImpl extends BaseManager<String, TaskIdentityLink>
		implements
			TaskIdentityLinkManager {
	@Resource
	TaskIdentityLinkDao m;
	@Resource
	GroupService n;

	public void removeByTaskId(String taskId) {
		this.m.removeByTaskId(taskId);
	}

	public void removeByInstanceId(String instId) {
		this.m.removeByInstanceId(instId);
	}

	public void bulkCreate(List<TaskIdentityLink> list) {
		this.m.bulkCreate(list);
	}

	public Boolean checkUserOperatorPermission(String userId, String instanceId, String taskId) {
		if (StringUtil.isEmpty((String) instanceId) && StringUtil.isEmpty((String) taskId)) {
			throw new BusinessException("检查权限必须提供流程或者任务id", (IStatusCode) BpmStatusCode.PARAM_ILLEGAL);
		}
		Set<String> rights = this.getUserRights(userId);
		return this.m.checkUserOperatorPermission(rights, taskId, instanceId) > 0;
	}

	public Set<String> getUserRights(String userId) {
		List<IGroup> list = this.n.getGroupsByUserId(userId);
		HashSet<String> rights = new HashSet<String>();
		rights.add(String.format("%s-%s", userId, "user"));
		if (BeanUtils.isEmpty((Object) list)) {
			return rights;
		}
		for (IGroup group : list) {
			rights.add(String.format("%s-%s", group.getGroupId(), group.getGroupType()));
		}
		return rights;
	}

	public void createIdentityLink(IBpmTask bpmTask, List<SysIdentity> identitys) {
		ArrayList<TaskIdentityLink> identityLinks = new ArrayList<TaskIdentityLink>();
		for (SysIdentity identity : identitys) {
			TaskIdentityLink link = new TaskIdentityLink();
			link.setId(UniqueIdUtil.getSuid());
			link.setIdentity(identity.getId());
			link.setIdentityName(identity.getName());
			link.setType(identity.getType());
			link.setPermissionCode(identity.getId() + "-" + identity.getType());
			link.setTaskId(bpmTask.getId());
			link.setInstId(bpmTask.getInstId());
			identityLinks.add(link);
		}
		this.bulkCreate(identityLinks);
	}

	public List<TaskIdentityLink> getByTaskId(String taskId) {
		return this.m.getByTaskId(taskId);
	}
}