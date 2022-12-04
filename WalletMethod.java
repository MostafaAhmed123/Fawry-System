public class WalletMethod extends Payment{
	public WalletMethod(Service s) {
		description="using wallet";
		service = s;
	}
	@Override
	public  double calculate() {
		return service.getCost();
	}

}
