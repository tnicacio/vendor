package com.tnicacio.vendor.entities.enums;

import java.util.HashMap;
import java.util.Map;

public enum SaleStatus {
	
	PENDING(0), DELIVERED(1);
	
	private static final Map<Integer, SaleStatus> BY_STATUS = new HashMap<>();
	
	static {
		for (SaleStatus s : values()) {
			BY_STATUS.put(s.code, s);
		}
	}
	
	private final int code;

	private SaleStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public static SaleStatus valueOf(int code) {
		return BY_STATUS.get(code);
	}
}
