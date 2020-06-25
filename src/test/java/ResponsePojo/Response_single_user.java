package ResponsePojo;

import pojo.Ad;
import pojo.Data;

public class Response_single_user {
	private Data data;
	private Ad ad;
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public Ad getAd() {
		return ad;
	}
	public void setAd(Ad ad) {
		this.ad = ad;
	}	
}