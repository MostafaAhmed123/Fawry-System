package abstractFactory;

public class donationsfactory implements servicesfactory {
	
	@Override
	public ServicesProviders getservice(String T)
	{ 
		if(T.equals("hospitals"))
		{
			return new hospitalsDonations();
		}
		else if(T.equals("NGOs"))
		{
			return new NGOsDonations();
		}
		else if (T.equals("schools"))
		{
			return new schoolsDonation();
		}
		return null;
		
	} ;
}

