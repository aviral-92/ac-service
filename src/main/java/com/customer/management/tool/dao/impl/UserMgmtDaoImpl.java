package com.customer.management.tool.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.customer.management.tool.configuration.Cipher;
import com.customer.management.tool.constants.CMTQueryConstant;
import com.customer.management.tool.dao.UserManagementDao;
import com.customer.management.tool.extractor.UserManagementExtractor;
import com.customer.management.tool.pojo.CMTLogin;
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

	public String activateUser(String username) {

		String response;
		if (!StringUtils.isEmpty(username)) {
			Object[] args = { username };
			int executed = jdbcTemplate.update("UPDATE userdetail set status = 'a' WHERE username = ? ", args);
			if (executed > 0) {
				response = "User Activated Successfully";
			} else {
				response = "User remains Deactive, try again later";
			}
		} else {
			response = "Please provide valid username to activate User";
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

}
