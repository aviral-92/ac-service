package com.customer.management.tool.dao;

import java.util.List;

import com.customer.management.tool.pojo.CustomerReparingDetail;
import com.customer.management.tool.pojo.ReportGenerator;

public interface CMTReportDao {

	public List<CustomerReparingDetail> startToEndDate(ReportGenerator reportGenerator);
}
