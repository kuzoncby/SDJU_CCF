package edu.sdju.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class Data {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "platform")
	private int platform;

	@Column(name = "amount")
	private String amount;

	@Column(name = "status")
	private String status;

	@Column(name = "day")
	private String day;

	@Column(name = "rate")
	private String rate;

	@Column(name = "sex")
	private String sex;

	@Column(name = "age")
	private int age;

	@Column(name = "education")
	private String education;

	@Column(name = "marriage")
	private String marriage;

	@Column(name = "city")
	private String city;

	@Column(name = "house")
	private String house;

	@Column(name = "car")
	private String car;

	@Column(name = "reward")
	private String reward;

	@Column(name = "profit")
	private String profit;

	public Data() {

	}

	public Data(long id, int platform, String amount, String status, String day, String rate, String sex, int age,
			String education, String marriage, String city, String house, String car, String reward, String profit) {
		super();
		this.id = id;
		this.platform = platform;
		this.amount = amount;
		this.status = status;
		this.day = day;
		this.rate = rate;
		this.sex = sex;
		this.age = age;
		this.education = education;
		this.marriage = marriage;
		this.city = city;
		this.house = house;
		this.car = car;
		this.reward = reward;
		this.profit = profit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getplatform() {
		return platform;
	}

	public void setplatform(int platform) {
		this.platform = platform;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", platform=" + platform + ", amount=" + amount + ", status=" + status
				+ ", day=" + day + ", rate=" + rate + ", sex=" + sex + ", age=" + age + ", education=" + education
				+ ", marriage=" + marriage + ", city=" + city + ", house=" + house + ", car=" + car + ", reward="
				+ reward + ", profit=" + profit + "]";
	}

}
