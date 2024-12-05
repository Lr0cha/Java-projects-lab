package Model.Services;

public class PaypalService implements OnlinePaymentService{
	public double paymentFee(double amount) {
		return amount + (amount*0.02);
	}
	public double interest(double amount,int month) {
		return amount + (amount*0.01)  * month;
	}
}
