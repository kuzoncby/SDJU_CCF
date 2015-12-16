package edu.sdju.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sdju.dao.DataDao;
import edu.sdju.dao.ResultDao;
import edu.sdju.model.Data;
import edu.sdju.model.Result;

@Controller
public class HomeController {

	@Autowired
	private DataDao dataDao;

	@Autowired
	private ResultDao resultDao;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/")
	public ModelAndView getHome() {
		ModelAndView mv = new ModelAndView("index");
		String result = "成功";
		try {
			for (long count = 1; count <= resultDao.count(); count++) {
				double sum = 0;
				double averange = 0;
				for (Data d : dataDao.findByPlatform((int) count)) {
					sum += calcResult(d);
				}
				try {
					averange = sum / dataDao.count();
				} catch (Exception e) {
					result = "失败\r\n" + e.toString();
					logger.info(result);
				}
				Result r = new Result((int) count, averange);
				resultDao.save(r);
				logger.info(count + result);
			}
			List<Result> record = (List<Result>) resultDao.findAll();
			mv.addObject("record", record);
		} catch (Exception e) {
			result = "失败\r\n" + e.toString();
			logger.info(result);
		}

		mv.addObject("message", result);
		return mv;
	}

	public double calcResult(Data data) {
		double calc = (Double.parseDouble(data.getStatus()) + Double.parseDouble(data.getDay())
				+ Double.parseDouble(data.getRate()) + Double.parseDouble(data.getSex()) + data.getAge()
				+ Double.parseDouble(data.getEducation()) + Double.parseDouble(data.getMarriage())
				+ Double.parseDouble(data.getCity()) + Double.parseDouble(data.getHouse())
				+ Double.parseDouble(data.getCar()) + Double.parseDouble(data.getReward()))
				+ Double.parseDouble(data.getAmount()) + Double.parseDouble(data.getProfit());
		return calc;
	}

}
