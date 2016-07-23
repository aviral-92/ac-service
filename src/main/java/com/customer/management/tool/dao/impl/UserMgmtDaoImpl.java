package com.customer.management.tool.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.apache.commons.lang3.*;

import com.customer.management.tool.configuration.Cipher;
import com.customer.management.tool.constants.CMTQueryConstant;
import com.customer.management.tool.dao.UserManagementDao;
import com.customer.management.tool.extractor.UserManagementExtractor;
import com.customer.management.tool.pojo.CMTLogin;
import com.customer.management.tool.pojo.UserDetail;
import com.customer.management.tool.pojo.UserDetailHistory;

@Component
public class UserMgmtDaoImpl implements UserManagementDao {

	static Logger LOG = Logger.getLogger(UserManagementDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private Cipher Cipher;

	@Override
	public boolean authenticateUser(CMTLogin login) {
		// TODO Auto-generated method stub
		return false;
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

	// isDetails Exist.
	@Override
	public boolean isUserExist(UserDetailHistory detail) {

		boolean isExist = false;
		if (!StringUtils.isEmpty(detail)) {
			if (!StringUtils.isEmpty(detail.getUsername())) {
				Object[] args = { detail.getUsername() };
				List<UserDetailHistory> detailHistories = jdbcTemplate
						.query("Select * from userdetail where username = ? ", new UserManagementExtractor(), args);
				if (!StringUtils.isEmpty(detailHistories) && !detailHistories.isEmpty()) {
					return true;
				}
			}
			if (!StringUtils.isEmpty(detail.getEmail())) {
				if (isEmailExist(detail.getEmail())) {
					return true;
				}
			}
			if (!StringUtils.isEmpty(detail.getMobile())) {
				if (isMobileExist(detail.getMobile())) {
					return true;
				}
			}
		}

		return isExist;
	}

	private boolean isEmailExist(String email) {

		boolean isExist = false;
		if (!StringUtils.isEmpty(email)) {
			Object[] args = { email };
			List<UserDetailHistory> detailHistories = jdbcTemplate.query("Select * from userdetail where email = ? ",
					new UserManagementExtractor(), args);
			if (!StringUtils.isEmpty(detailHistories) && !detailHistories.isEmpty()) {
				isExist = true;
			}
		}
		return isExist;
	}

	private boolean isMobileExist(String mobile) {

		boolean isExist = false;
		if (!StringUtils.isEmpty(mobile)) {
			Object[] args = { mobile };
			List<UserDetailHistory> detailHistories = jdbcTemplate.query("Select * from userdetail where mobile = ? ",
					new UserManagementExtractor(), args);
			if (!StringUtils.isEmpty(detailHistories) && !detailHistories.isEmpty()) {
				isExist = true;
			}
		}
		return isExist;
	}

	@Override
	public List<UserDetailHistory> getUsers(UserDetailHistory detail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(UserDetailHistory detail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String activateDeactivateUser(UserDetailHistory detailHistory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserDetailHistory(UserDetailHistory userDetailHistory) {
		// TODO Auto-generated method stub

	}

	public String userManagement(UserDetailHistory userDetailHistory) {

		String response = null;
		StringBuffer query = new StringBuffer("UPDATE userdetail SET status = ? ");
		List<String> args = new ArrayList<>();
		args.add(userDetailHistory.getStatus());
		if (!StringUtils.isEmpty(userDetailHistory)) {
			if (org.apache.commons.lang3.StringUtils.isNotEmpty(userDetailHistory.getUsername())) {
				query.append(" WHERE USERNAME = ? ");
				args.add(userDetailHistory.getUsername());
			} else if (org.apache.commons.lang3.StringUtils.isNotEmpty(userDetailHistory.getEmail())) {
				query.append(" WHERE EMAIL = ? ");
				args.add(userDetailHistory.getEmail());
			} else if (org.apache.commons.lang3.StringUtils.isNotEmpty(userDetailHistory.getMobile())) {
				query.append(" WHERE MOBILE = ? ");
				args.add(userDetailHistory.getMobile());
			}
			int executed = jdbcTemplate.update(query.toString(), args.toArray());
			if (executed > 0) {
				if (org.apache.commons.lang3.StringUtils.isNotEmpty(userDetailHistory.getUsername())
						&& org.apache.commons.lang3.StringUtils.isNotEmpty(userDetailHistory.getStatus())) {
					response = loginStatusChange(userDetailHistory.getUsername(), userDetailHistory.getStatus());
				} else {
					UserDetailHistory userDetails = getUser(userDetailHistory);
					if (org.apache.commons.lang3.StringUtils.isNotEmpty(userDetails.getUsername())
							&& org.apache.commons.lang3.StringUtils.isNotEmpty(userDetails.getStatus())) {
						response = loginStatusChange(userDetails.getUsername(), userDetails.getStatus());
					}
				}
				if (response != null) {
					if (userDetailHistory.getStatus().equalsIgnoreCase("A")) {
						response = "User Activated Successfully";
					} else if (userDetailHistory.getStatus().equalsIgnoreCase("D")) {
						response = "User Deactivated Successfully";
					} else {
						response = "User Deleted Successfully";
					}
				}
			} else {
				response = "Please provide valid username to activate User";
			}
		} else {
			response = "User status = " + userDetailHistory.getStatus() + " not able to change, try again later";
		}

		return response;
	}

	public String deactivateUser(String username) {

		String response;
		if (!StringUtils.isEmpty(username)) {
			Object[] args = { username };
			int executed = jdbcTemplate.update("UPDATE userdetail set status = 'd' WHERE username = ? ", args);
			if (executed > 0) {
				response = "User Deactivated Successfully";
			} else {
				response = "User remains Active, try again later";
			}
		} else {
			response = "Please provide valid username to deactivate User";
		}
		return response;
	}

	public UserDetailHistory getUser(UserDetailHistory userDetailHistory) {

		StringBuilder query = new StringBuilder("SELECT * FROM userdetail ");
		List<String> args = new ArrayList<>();
		if (!StringUtils.isEmpty(userDetailHistory)) {
			if (org.apache.commons.lang3.StringUtils.isNotEmpty(userDetailHistory.getUsername())) {
				query.append(" WHERE username = ? ");
				args.add(userDetailHistory.getUsername());
			} else if (org.apache.commons.lang3.StringUtils.isNotEmpty(userDetailHistory.getEmail())) {
				query.append(" WHERE EMAIL = ? ");
				args.add(userDetailHistory.getEmail());
			} else if (org.apache.commons.lang3.StringUtils.isNotEmpty(userDetailHistory.getMobile())) {
				query.append(" WHERE MOBILE = ? ");
				args.add(userDetailHistory.getMobile());
			}
		} else {
			return null;
		}
		List<UserDetailHistory> userDetail = jdbcTemplate.query(query.toString(), new UserManagementExtractor(),
				args.toArray());
		if (!StringUtils.isEmpty(userDetail) && !userDetail.isEmpty()) {
			return userDetail.get(0);
		}
		return null;
	}

	public String loginStatusChange(String username, String status) {

		String response = null;
		if (org.apache.commons.lang3.StringUtils.isNotEmpty(username)
				&& org.apache.commons.lang3.StringUtils.isNotEmpty(status)) {
			Object[] args = { status, username };
			int executed = jdbcTemplate.update("UPDATE LOGIN SET STATUS = ? WHERE USERNAME = ? ", args);
			if (executed > 0) {
				response = "Successfully updated";
			} else {
				response = "Not able to update, try again later";
			}
		} else {
			response = "Fields are empty";
		}
		return response;
	}

}
