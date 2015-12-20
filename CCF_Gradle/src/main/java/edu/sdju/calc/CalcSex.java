package edu.sdju.calc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.sdju.dao.DataDao;
import edu.sdju.dao.ResultDao;
import edu.sdju.model.Data;

@Component
@Scope("prototype")
public class CalcSex extends Thread {

	@Autowired
	private DataDao dataDao;

	@Autowired
	private ResultDao resultDao;

	private static final Logger logger = LoggerFactory.getLogger(CalcSex.class);

	public double[] Sex;

	@Override
	public void run() {
		logger.info(getName() + "is Running");
		String result = "无风险";
		try {
			for (long count = 1; count <= resultDao.count(); count++) {
				double sum = 0;
				double averange = 0;
				if (count > 30) {
					result = "有风险";
				}

				for (Data d : dataDao.findByPlatform((int) count)) {
					sum += Double.parseDouble(d.getSex());
				}

				try {
					averange = sum / dataDao.count();
					this.Sex[(int) count] = averange;
				} catch (Exception e) {
					logger.info(e.toString());
				}
				logger.info(count + result);
			}
		} catch (Exception e) {
			logger.error("失败：\t", e);
		}
	}

}
