/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.customer.management.tool.configuration.Cipher;
import com.customer.management.tool.constants.CMTQueryConstant;
import com.customer.management.tool.dao.UserManagementDao;
import com.customer.management.tool.extractor.CMTLoginExtractor;
import com.customer.management.tool.extractor.UserManagementExtractor;
import com.customer.management.tool.pojo.CMTLogin;
import com.customer.management.tool.pojo.UserDetail;
import com.customer.management.tool.pojo.UserDetailHistory;

/**
 *
 * @author Aviral
 */

@Component
@Scope("prototype")
public class UserManagementDaoImpl implements UserManagementDao {

	static Logger LOG = Logger.getLogger(UserManagementDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private Cipher Cipher;

	@Override
	public boolean authenticateUser(CMTLogin login) {
		boolean loginSuccess = false;
		List<String> args = new ArrayList<>();
		args.add(login.getUsername());
		args.add(Cipher.encode(login.getPassword()));
		args.add(login.getRole());
		CMTLogin loginDetail = jdbcTemplate.query(CMTQueryConstant.AUTHENTICATE_USER_CREDENTIALS,
				new CMTLoginExtractor(), args.toArray());
		if (!StringUtils.isEmpty(loginDetail)) {
			loginSuccess = true;
			LOG.info(login.getUsername() + " Successfully Login");
		}
		return loginSuccess;
	}

	public CMTLogin getUsernamePassword(String username) {

		Object[] args = { username };
		CMTLogin cmtLogin = jdbcTemplate.query(CMTQueryConstant.GET_LOGIN_DETAIL, new CMTLoginExtractor(), args);
		return cmtLogin;
	}

	@Override
	public String addUser(UserDetailHistory userDetail, CMTLogin login) throws Exception {

		String response = null;
		if (!isUserExist(userDetail)) {
			List<String> args = null;
			args = new ArrayList<>();
			args.add(login.getUsername());
			args.add(Cipher.encode(login.getPassword()));
			args.add(login.getRole());
			int success = jdbcTemplate.update(CMTQueryConstant.INSERT_IN_LOGIN, args.toArray());
			if (success > 0) {
				args = new ArrayList<>();
				args.add(userDetail.getName());
				args.add(userDetail.getEmail());
				args.add(userDetail.getMobile());
				args.add(userDetail.getUsername());
				int temp = jdbcTemplate.update(CMTQueryConstant.INSERT_USERDETAIL, args.toArray());
				if (temp > 0) {
					response = "Successfully added.";
				} else {
					response = "Unable to insert User";
				}
			} else {
				response = "Unable to insert in CMTLogin";
			}
		} else {
			response = "User already Exist";
		}
		LOG.info(response);
		return response;
	}

	@Override
	public boolean isUserExist(UserDetailHistory detail) {

		boolean isExist = isUsernameExist(detail);
		if (!isExist) {
			if (!StringUtils.isEmpty(getUserList(detail)) && getUserList(detail).size() > 0) {
				isExist = true;
			}
		}
		return isExist;
	}

	private boolean isUsernameExist(UserDetailHistory detail) {

		boolean isExist = false;
		if (!StringUtils.isEmpty(detail) && !StringUtils.isEmpty(detail.getUsername())) {
			Object[] args = { detail.getUsername() };
			List<UserDetailHistory> exist = jdbcTemplate.query(CMTQueryConstant.IS_USERNAME_EXIST,
					new UserManagementExtractor(), args);
			if (!StringUtils.isEmpty(exist) && exist.size() > 0) {
				detail.setStatus(exist.get(0).getStatus());
				isExist = true;
				LOG.error("Username already Exist");
			}
		}
		return isExist;
	}

	@Override
	public List<UserDetailHistory> getUserList(UserDetailHistory detail) {

		boolean isUsername = false, isEmail = false;
		StringBuilder query = new StringBuilder(CMTQueryConstant.GET_USERDETAIL);
		List<String> args = new ArrayList<>();
		if (!StringUtils.isEmpty(detail)) {
			args.add(detail.getStatus());
			if (!StringUtils.isEmpty(detail.getUsername())) {
				query.append(" AND username = ? ");
				args.add(detail.getUsername());
				isUsername = true;
			}
			if (isUsername) {
				if (!StringUtils.isEmpty(detail.getEmail())) {
					query.append(" OR email = ? ");
					args.add(detail.getEmail());
				}
			} else if (!StringUtils.isEmpty(detail.getEmail())) {
				query.append(" AND email = ? ");
				args.add(detail.getEmail());
				isEmail = true;
			}
			if (isUsername || isEmail) {
				if (!StringUtils.isEmpty(detail.getMobile())) {
					query.append(" OR mobile = ? ");
					args.add(detail.getMobile());
				}
			} else if (!StringUtils.isEmpty(detail.getMobile())) {
				query.append(" AND mobile = ? ");
				args.add(detail.getMobile());
			}
		}
		List<UserDetailHistory> userDetailList = jdbcTemplate.query(query.toString(), new UserManagementExtractor(),
				args.toArray());
		return userDetailList;
	}

	@Override
	public String updateUser(UserDetail detail) {

		String updated = null;
		Object[] args = { detail.getName(), detail.getEmail(), detail.getMobile(), String.valueOf(detail.getUserId()) };
		int update = jdbcTemplate.update(CMTQueryConstant.UPDATE_USER, args);
		if (update > 0) {
			updated = "Updated Successfully";
			LOG.info(detail.getName() + " " + update);
		} else {
			LOG.error("Something Went Wrong... Try again Later.");
		}
		return updated;
	}

	@Override
	public String activateDeactivateUser(UserDetailHistory detailHistory) {

		String activeDeactive = null;
		List<String> args = new ArrayList<>();
		boolean isusername = false, isEmail = false;
		StringBuilder query = new StringBuilder(CMTQueryConstant.DELETE_USER);
		if (!StringUtils.isEmpty(detailHistory)) {
			args.add(detailHistory.getStatus());
			if (!StringUtils.isEmpty(detailHistory.getUsername())) {
				query.append(" WHERE username = ? ");
				args.add(detailHistory.getUsername());
				isusername = true;
			}
			if (isusername) {
				if (!StringUtils.isEmpty(detailHistory.getEmail())) {
					query.append(" OR email = ? ");
					args.add(detailHistory.getEmail());
				}
			} else {
				if (!StringUtils.isEmpty(detailHistory.getEmail())) {
					query.append(" WHERE email = ? ");
					args.add(detailHistory.getEmail());
					isEmail = true;
				}
			}
			if (isEmail | isusername) {
				if (!StringUtils.isEmpty(detailHistory.getMobile())) {
					query.append(" OR mobile = ? ");
					args.add(detailHistory.getMobile());
				}
			} else {
				if (!StringUtils.isEmpty(detailHistory.getMobile())) {
					query.append(" WHERE mobile = ? ");
					args.add(detailHistory.getMobile());
				}
			}
		}
		int response = jdbcTemplate.update(query.toString(), args.toArray());
		CMTLogin cmtLogin = null;
		if (response > 0) {
			if (detailHistory.getStatus().equalsIgnoreCase("d")) {
				activeDeactive = "Successfully Deleted";
				LOG.info(activeDeactive);
			} else if (detailHistory.getStatus().equalsIgnoreCase("a")) {
				if (isUsernameExist(detailHistory)) {
					cmtLogin = getUsernamePassword(detailHistory.getUsername());
				} else {
					List<UserDetailHistory> userList = getUserList(detailHistory);
					if (!StringUtils.isEmpty(userList) && userList.size() > 0) {
						cmtLogin = getUsernamePassword(userList.get(0).getUsername());
					}
				}
				activeDeactive = "User Successfully Activated, username = " + cmtLogin.getUsername()
						+ " AND password = " + cmtLogin.getPassword();
				LOG.info("User Successfully Activated");
			}
		} else {
			LOG.error("Something Went Wrong... Try again Later.");
		}
		return activeDeactive;
	}

	@Override
	public void addUserDetailHistory(UserDetailHistory userDetailHistory) {

		if (!StringUtils.isEmpty(userDetailHistory)) {
			List<UserDetailHistory> history = getUserList(userDetailHistory);
			if (!StringUtils.isEmpty(history) && history.size() > 0) {
				userDetailHistory.setEmail(history.get(0).getEmail());
				userDetailHistory.setMobile(history.get(0).getMobile());
				userDetailHistory.setName(history.get(0).getName());
				userDetailHistory.setRegisteredDate(history.get(0).getRegisteredDate());
				userDetailHistory.setUsername(history.get(0).getUsername());
				userDetailHistory.setUserId(history.get(0).getUserId());
				userDetailHistory.setStatus(history.get(0).getStatus());
				if ("add".equalsIgnoreCase(userDetailHistory.getDescription())) {
					commonsAddUserDetailHistory("User Successfully Added", userDetailHistory);
				} else if ("update".equalsIgnoreCase(userDetailHistory.getDescription())) {
					commonsAddUserDetailHistory("User Successfully Updated", userDetailHistory);
				} else if ("delete".equalsIgnoreCase(userDetailHistory.getDescription())) {
					commonsAddUserDetailHistory("User Successfully deleted", userDetailHistory);
				}
			}
		}
	}

	private void commonsAddUserDetailHistory(String description, UserDetailHistory userDetailHistory) {

		Object[] args = { userDetailHistory.getUserId(), userDetailHistory.getName(), userDetailHistory.getUsername(),
				userDetailHistory.getEmail(), userDetailHistory.getMobile(), userDetailHistory.getRegisteredDate(),
				description, userDetailHistory.getStatus() };
		int executed = jdbcTemplate.update(CMTQueryConstant.INSERT_USERDETAILHISTORY, args);
		if (executed > 0) {
			LOG.info("Successfully Added in History");
		} else {
			LOG.error("Unable to Add History");
		}
	}
}
