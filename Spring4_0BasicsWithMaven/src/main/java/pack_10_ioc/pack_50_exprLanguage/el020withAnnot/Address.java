package pack_10_ioc.pack_50_exprLanguage.el020withAnnot;

import org.springframework.stereotype.Component;

@ Component
public class Address {
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String pin;
	
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	@Override
    public String toString() {
        return String.format("\n\tAddress:%s\n\t\t%s\n\t\t%s\n\t\t%s\n\t\t%s",
                this.line1, this.line2, this.city, this.state, this.pin);
    }
}
