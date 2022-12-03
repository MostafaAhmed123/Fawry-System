package abstractFactory;

public class landlinefactory implements servicesfactory {
	@Override
	public ServicesProviders getservice(String T)
	{
		if (T.equals("quarter"))
		{
			return new quarterLandline() ;
		}
		else  if (T.equals("monthly"))
		{
			return new monthlyLandline();
		}
	
	
		return null; 
		
	} ;

}
