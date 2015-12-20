package edu.sdju.calc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.sdju.dao.DataDao;
import edu.sdju.dao.ResultDao;
import edu.sdju.model.Data;

public class CalcHouse implements Runnable {

	@Autowired
	private DataDao dataDao;

	@Autowired
	private ResultDao resultDao;

	private static final Logger logger = LoggerFactory.getLogger(CalcHouse.class);

	public double[] House;

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
					sum += Double.parseDouble(d.getHouse());
				}

				try {
					averange = sum / dataDao.count();
					this.House[(int)count] = averange;
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
