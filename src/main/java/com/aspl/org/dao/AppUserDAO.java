package com.aspl.org.dao;

import com.aspl.org.entity.AppUser;

public interface AppUserDAO {
	AppUser findUserAccount(String userName);
}
