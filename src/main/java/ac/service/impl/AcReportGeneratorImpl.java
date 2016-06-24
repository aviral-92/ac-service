package ac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ac.service.dao.impl.ReportDaoImpl;
import ac.service.pojo.CustomerReparingDetail;
import ac.service.pojo.ReportGenerator;

@Component
public class AcReportGeneratorImpl {

	@Autowired
	private ReportDaoImpl reportDaoImpl;

	public List<CustomerReparingDetail> startToEndDateRecords(
			ReportGenerator reportGenerator) {
		return reportDaoImpl.startToEndDate(reportGenerator);
	}
}
