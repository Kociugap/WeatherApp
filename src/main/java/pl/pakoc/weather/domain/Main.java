package pl.pakoc.weather.domain;

public class Main {

	private float temp;
	private float tempMin;
	private float tempMax;
	private long humidity;
	private long pressure;
	
	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getTempMin() {
		return tempMin;
	}

	public void setTempMin(float tempMin) {
		this.tempMin = tempMin;
	}

	public float getTempMax() {
		return tempMax;
	}

	public void setTempMax(float tempMax) {
		this.tempMax = tempMax;
	}

	public float getHumidity() {
		return humidity;
	}

	public long getPressure() {
		return pressure;
	}

	public void setPressure(long pressure) {
		this.pressure = pressure;
	}
	

}
