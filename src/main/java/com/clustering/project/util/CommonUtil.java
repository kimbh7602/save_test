package com.clustering.project.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CommonUtil {
	public String gerUniqueSequence() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
}
