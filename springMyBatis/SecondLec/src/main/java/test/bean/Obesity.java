package test.bean;

public class Obesity {
	String result = "";
	String img = "";
	public void calcObesity(int tall, int weight){
		double stdWeight = (tall-100)*0.85; //표준체중
		double obesity = weight / stdWeight * 100; //비만도
		if (obesity <= 90) {
			this.result = "저체중";
			this.img = "../image/under.png";
		}
		else if (obesity>90 && obesity <=100) {
			this.result = "정상";
			this.img = "../image/normal.png";
		}
		else if (obesity>110 && obesity <=120) {
			this.result = "과체중";
			this.img="../image/over.png";
		}
		else {
			this.result = "비만";
			this.img="../image/obese.png";
		}		
	}
	public String getResult() {
		return result;
	}
	public String getImg() {
		return img;
	}
	
}
