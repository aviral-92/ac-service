package ac.service.impl;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;

public class AcServiceImpl extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	protected AcServiceUserImpl acServiceUserImpl;
	@Autowired
	protected AcServiceCustomerImpl acServiceCustomerImpl;
//	public JFrame frame = new JFrame();
	

}
