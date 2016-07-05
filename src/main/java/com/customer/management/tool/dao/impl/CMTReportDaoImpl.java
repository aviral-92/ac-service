package com.customer.management.tool.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.customer.management.tool.dao.CMTReportDao;
import com.customer.management.tool.extractor.CustomerRepairingDetailExtractor;
import com.customer.management.tool.pojo.CustomerReparingDetail;
import com.customer.management.tool.pojo.ReportGenerator;

@Component
public class CMTReportDaoImpl implements CMTReportDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<CustomerReparingDetail> startToEndDate(ReportGenerator reportGenerator) {

		String query = "SELECT * FROM ac_service.customer_repairing_detail AS CRD INNER JOIN customer AS CUST WHERE "
				+ " CRD.customer_Id=CUST.customerId AND updated_date BETWEEN (STR_TO_DATE(?,'%d-%m-%Y')) AND STR_TO_DATE(?,'%d-%m-%Y')";
		List<String> args = new ArrayList<>();
		if (StringUtils.isEmpty(reportGenerator.getStartDate()) || StringUtils.isEmpty(reportGenerator.getEndDate())) {

			return null;
		}
		args.add(reportGenerator.getStartDate());
		args.add(reportGenerator.getEndDate());
		List<CustomerReparingDetail> listResult = jdbcTemplate.query(query, new CustomerRepairingDetailExtractor(),
				args.toArray());
		return listResult;
	}

	public List<CustomerReparingDetail> monthlyReportGenerator(ReportGenerator reportGenerator) {

		if (!StringUtils.isEmpty(reportGenerator.getYear())) {

			String query = "SELECT SUM(actual_amount) AS amount,DATE_FORMAT(updated_date,'%M-%Y') AS updatedDate "
					+ "FROM ac_service.customer_repairing_detail GROUP BY STR_TO_DATE(DATE_FORMAT(updated_date,'%m-%Y'),'%m-%Y')";
			List<CustomerReparingDetail> listResult = jdbcTemplate.query(query, new CustomerRepairingDetailExtractor());
			return listResult;
		}
		return null;
	}
}