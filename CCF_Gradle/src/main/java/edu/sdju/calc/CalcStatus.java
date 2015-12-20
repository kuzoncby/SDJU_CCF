package edu.sdju.calc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.sdju.dao.DataDao;
import edu.sdju.dao.ResultDao;
import edu.sdju.model.Data;

public class CalcStatus implements Runnable {

	@Autowired
	private DataDao dataDao;

	@Autowired
	private ResultDao resultDao;

	private static final Logger logger = LoggerFactory.getLogger(CalcStatus.class);

	public double[] Status;

	@Override
	public void run() {
		String result = "无风险";
		try {
			for (long count = 1; count <= resultDao.count(); count++) {
				double sum = 0;
				double averange = 0;
				if (count > 30) {
					result = "有风险";
				}

				for (Data d : dataDao.findByPlatform((int) count)) {
					sum += Double.parseDouble(d.getStatus());
				}

				try {
					averange = sum / dataDao.count();
					this.Status[(int)count] = averange;
				} catch (Exception e) {
					logger.info(e.toString());
				}
				logger.info(count + result);
			}
		} catch (Exception e) {
			result = "失败\r\n" + e.toString();
			logger.info(result);
		}
	}

}
