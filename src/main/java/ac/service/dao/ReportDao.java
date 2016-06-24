package ac.service.dao;

import java.util.List;

import ac.service.pojo.CustomerReparingDetail;
import ac.service.pojo.ReportGenerator;

public interface ReportDao {

	public List<CustomerReparingDetail> startToEndDate(ReportGenerator reportGenerator);
}
