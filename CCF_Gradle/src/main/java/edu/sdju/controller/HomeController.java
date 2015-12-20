package edu.sdju.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.sdju.calc.CalcSex;
import edu.sdju.config.CalcConfig;
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
	public ModelAndView Index() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/result")
	public ModelAndView Result() {
		ModelAndView mv = new ModelAndView("result");
		List<Result> record = (List<Result>) resultDao.findAll();
		mv.addObject("record", record);
		return mv;
	}

	@RequestMapping(value = "/calc")
	public ModelAndView doCalc() {
		ModelAndView mv = new ModelAndView("index");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CalcConfig.class);
		
		CalcSex sexThread = (CalcSex) ctx.getBean("CalcSex");
		sexThread.setName("Sex Thread");
		sexThread.start();
		/*
		String result = "无风险";
		try {
			for (long count = 1; count <= resultDao.count(); count++) {
				double sum = 0;
				double averange = 0;
				if (count > 30) {
					result = "有风险";
				}

				for (Data d : dataDao.findByPlatform((int) count)) {
					/*
					 * Calc calc = new Calc(d); Thread calcThread = new
					 * Thread(calc); calcThread.start(); sum = calc.result;
					 */
		/*
					sum = calcResult(d);
				}

				try {
					averange = sum / dataDao.count();
				} catch (Exception e) {

					logger.info(result);
				}
				Result r = new Result((int) count, averange, result);
				resultDao.save(r);
				logger.info(count + result);
			}
		} catch (Exception e) {
			result = "失败\r\n" + e.toString();
			logger.info(result);
		}
*/
		/*mv.addObject("message", result);*/
		return mv;
	}

	public double calcResult(Data data) {

		/**
		 * 用比例，利率大于1的就用倒数小于的就直接乘以0.5， 加上职业乘以0.4， 收入乘以0.3，加上地区乘以0.2，年龄乘以0.1
		 */

		double calc = 0;
		/*
		 * calc = (Double.parseDouble(data.getStatus()) +
		 * Double.parseDouble(data.getDay()) +
		 * Double.parseDouble(data.getRate()) +
		 * Double.parseDouble(data.getSex()) + data.getAge() +
		 * Double.parseDouble(data.getEducation()) +
		 * Double.parseDouble(data.getMarriage()) +
		 * Double.parseDouble(data.getCity()) +
		 * Double.parseDouble(data.getHouse()) +
		 * Double.parseDouble(data.getCar()) +
		 * Double.parseDouble(data.getReward())) +
		 * Double.parseDouble(data.getAmount()) +
		 * Double.parseDouble(data.getProfit());
		 */
		if (Double.parseDouble(data.getRate()) >= 1) {
			calc += 1 / Double.parseDouble(data.getRate());

		} else {
			calc += 0.5 * Double.parseDouble(data.getRate());
		}

		calc += 0.4 * Double.parseDouble(data.getEducation());
		calc += 0.3 * Double.parseDouble(data.getAmount());
		calc += 0.2 * Double.parseDouble(data.getCity());
		calc += 0.1 * data.getAge();

		return calc;
	}

}