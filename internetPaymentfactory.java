package abstractFactory;

public class internetPaymentfactory implements servicesfactory {
	@Override
	public ServicesProviders getservice(String T) {
		
		if (T.equals("vodafone"))
		{
			return new vodafoneInternetPayment();
		}
		else  if (T.equals("orange"))
		{
			return new orangeInternetPayment() ;
		}
		else  if (T.equals("we"))
		{
			return new weInternetPayment() ;
		}
		else  if (T.equals("etisalat")) 
		{
			return new etisalatInternetPayment() ;
		}
		

		return null; 
			
	};
}