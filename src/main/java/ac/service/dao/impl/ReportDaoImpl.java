package ac.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import ac.service.dao.ReportDao;
import ac.service.extractor.RepairingDetailExtractor;
import ac.service.pojo.CustomerReparingDetail;
import ac.service.pojo.ReportGenerator;

@Component
public class ReportDaoImpl implements ReportDao {

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
		List<CustomerReparingDetail> listResult = jdbcTemplate.query(query, new RepairingDetailExtractor(),
				args.toArray());
		return listResult;
	}

	public List<CustomerReparingDetail> monthlyReportGenerator(ReportGenerator reportGenerator) {

		if (StringUtils.isEmpty(reportGenerator.getYear())) {

			String query = "SELECT * FROM ac_service.customer_repairing_detail AS CRD INNER JOIN customer AS CUST WHERE "
					+ " CRD.customer_Id=CUST.customerId AND updated_date BETWEEN (STR_TO_DATE('01-01-"
					+ reportGenerator.getYear() + "','%d-%m-%Y')) " + "AND STR_TO_DATE('31-12-"
					+ reportGenerator.getYear() + "','%d-%m-%Y')";
			// List<String> args = new ArrayList<>();

			// args.add(reportGenerator.getYear());
			// args.add(reportGenerator.getYear());
			List<CustomerReparingDetail> listResult = jdbcTemplate.query(query, new RepairingDetailExtractor());
			return listResult;
		}
		return null;
	}
}