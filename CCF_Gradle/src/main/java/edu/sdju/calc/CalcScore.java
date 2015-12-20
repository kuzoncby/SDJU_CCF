package edu.sdju.calc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.sdju.dao.DataDao;
import edu.sdju.dao.ResultDao;
import edu.sdju.model.Data;

public class CalcScore {

	@Autowired
	private DataDao dataDao;

	@Autowired
	private ResultDao resultDao;

	private static final Logger logger = LoggerFactory.getLogger(CalcScore.class);

	public double[] Score;

	public CalcScore() {

		CalcAge age = new CalcAge();
		CalcAmount amount = new CalcAmount();
		CalcCar car = new CalcCar();
		CalcCity city = new CalcCity();
		CalcDay day = new CalcDay();
		CalcEducation education = new CalcEducation();
		CalcHouse house = new CalcHouse();
		CalcMarriage marriage = new CalcMarriage();
		CalcProfit profit = new CalcProfit();
		CalcRate rate = new CalcRate();
		CalcReward reward = new CalcReward();
		CalcSex sex = new CalcSex();
		CalcStatus status = new CalcStatus();

		Thread ageThread = new Thread(age);
		Thread amountThread = new Thread(amount);
		Thread carThread = new Thread(car);
		Thread cityThread = new Thread(city);
		Thread dayThread = new Thread(day);
		Thread educationThread = new Thread(education);
		Thread houseThread = new Thread(house);
		Thread marriageThread = new Thread(marriage);
		Thread profitThread = new Thread(profit);
		Thread rateThread = new Thread(rate);
		Thread rewardThread = new Thread(reward);
		Thread sexThread = new Thread(sex);
		Thread statusThread = new Thread(status);

		ageThread.start();
		amountThread.start();
		carThread.start();
		cityThread.start();
		dayThread.start();
		educationThread.start();
		houseThread.start();
		marriageThread.start();
		profitThread.start();
		rateThread.start();
		rewardThread.start();
		sexThread.start();
		statusThread.start();
/*
		String Score = "无风险";
		try {
			for (long count = 1; count <= resultDao.count(); count++) {
				double score = 0;
				if (Double.parseDouble(data.getRate()) >= 1) {
					score += 1 / Double.parseDouble(data.getRate());

				} else {
					score += 0.5 * Double.parseDouble(data.getRate());
				}

				score += 0.4 * Double.parseDouble(data.getEducation());
				score += 0.3 * Double.parseDouble(data.getAmount());
				score += 0.2 * Double.parseDouble(data.getCity());
				score += 0.1 * data.getAge();
			}

			for (long count = 1; count <= resultDao.count(); count++) {
				double sum = 0;
				double averange = 0;
				if (count > 30) {
					Score = "有风险";
				}

				for (Data d : dataDao.findByPlatform((int) count)) {
					sum += Double.parseDouble(d.getScore());
				}

				try {
					averange = sum / dataDao.count();
					this.Score[(int) count] = averange;
				} catch (Exception e) {
					logger.info(e.toString());
				}
				logger.info(count + Score);
			}
		} catch (Exception e) {
			Score = "失败\r\n" + e.toString();
			logger.info(Score);
		}*/
	}

}
