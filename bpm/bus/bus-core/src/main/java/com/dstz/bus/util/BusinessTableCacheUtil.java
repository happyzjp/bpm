package com.dstz.bus.util;

import com.dstz.base.core.util.AppUtil;
import com.dstz.bus.model.BusinessTable;
import java.util.HashMap;
import java.util.Map;

public class BusinessTableCacheUtil {
	private static String U = "businessTableMap";

	private BusinessTableCacheUtil() {
	}

	public static void put(BusinessTable businessTable) {
		HashMap<String, BusinessTable> map = (HashMap<String, BusinessTable>) AppUtil.getCache().getByKey(U);
		if (map == null) {
			map = new HashMap<String, BusinessTable>();
		}
		map.put(businessTable.getKey(), businessTable);
		AppUtil.getCache().add(U, map);
	}

	public static BusinessTable get(String key) {
		Map map = (Map) AppUtil.getCache().getByKey(U);
		if (map == null) {
			return null;
		}
		return (BusinessTable) map.get(key);
	}
}