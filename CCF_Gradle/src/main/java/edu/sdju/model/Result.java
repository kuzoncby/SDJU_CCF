package edu.sdju.model;

import javax.persistence.*;

@Entity
@Table(name = "result")
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "platform")
	private int platform;

	@Column(name = "result")
	private double result;

	public Result() {

	}

	public Result(int platform, double result) {
		super();
		this.platform = platform;
		this.result = result;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Result [platform=" + platform + ", result=" + result + "]";
	}

}
