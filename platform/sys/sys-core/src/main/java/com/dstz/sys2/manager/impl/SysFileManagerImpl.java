package com.dstz.sys2.manager.impl;

import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dstz.base.db.id.UniqueIdUtil;
import com.dstz.base.manager.impl.BaseManager;
import com.dstz.sys2.dao.SysFileDao;
import com.dstz.sys2.manager.SysFileManager;
import com.dstz.sys2.model.SysFile;
import com.dstz.sys2.upload.IUploader;
import com.dstz.sys2.upload.UploaderFactory;

/**
 * 系统附件 Manager处理实现类
 * 
 * @author aschs
 * @email aschs@qq.com
 * @time 2018-06-07 23:54:49
 */
@Service("sysFileManager")
public class SysFileManagerImpl extends BaseManager<String, SysFile> implements SysFileManager {
	@Resource
	SysFileDao sysFileDao;

	@Override
	public SysFile upload(InputStream is, String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf('.'));
		String id = UniqueIdUtil.getSuid();

		// 1 先上传文件
		IUploader uploader = UploaderFactory.getDefault();
		String path = uploader.upload(is, id + ext);//以id为文件名保证不重复

		// 2 建立SysFile数据
		SysFile sysFile = new SysFile();
		sysFile.setId(id);
		sysFile.setName(fileName);
		sysFile.setUploader(uploader.type());
		sysFile.setPath(path);
		create(sysFile);

		return sysFile;
	}

	@Override
	public InputStream download(String fileId) {
		SysFile sysFile = get(fileId);
		IUploader uploader = UploaderFactory.getUploader(sysFile.getUploader());
		return uploader.take(sysFile.getPath());
	}
	
	@Override
	public void delete(String fileId) {
		SysFile sysFile = get(fileId);
//		IUploader uploader = UploaderFactory.getUploader(sysFile.getUploader());
//		uploader.remove(sysFile.getPath());
//		remove(fileId);
		//做逻辑删除
		sysFile.setDelete(true);
		update(sysFile);
	}
}
