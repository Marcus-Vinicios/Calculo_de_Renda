package entities;

import java.time.LocalDate;

public class HourContract {

	private LocalDate date;
	private Double valuePerHour;
	private Integer hours;

	public HourContract() {
	}

	public HourContract(LocalDate date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return this.valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return this.hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public double totalValue() {
		return valuePerHour * hours;
	}

}
