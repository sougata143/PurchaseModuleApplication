package com.aspl.org.dao;

import java.util.List;

public interface AppRoleDAO {
	
	List<String> getRoleNames(Long userId);
}
