package com.customer.management.tool.dao;

import java.util.List;

import com.customer.management.tool.pojo.CustomerJobDetail;
import com.customer.management.tool.pojo.ReportGenerator;

public interface RevenueReportDao {

	public List<CustomerJobDetail> startToEndDate(ReportGenerator reportGenerator);
}
