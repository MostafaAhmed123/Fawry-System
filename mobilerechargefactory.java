package abstractFactory;

public class mobilerechargefactory implements servicesfactory {
	@Override
	public ServicesProviders getservice(String T)
	{
		if (T.equals("vodafone"))
		{
			return new vodafoneMobileRecharge();
		}
		else  if (T.equals("orange"))
		{
			return new orangeMobileRecharge() ;
		}
		else  if (T.equals("we"))
		{
			return new weMobileRecharge() ;
		}
		else  if (T.equals("etisalat"))
		{
			return new etisalatMobileRecharge() ;
		}
		

		return null ;
	} ;

}
