package abstractFactory;
import java.util.Scanner; 
public class Demo {

	 public static void main(String[] args)
	 {
		  servicesfactory s ;
		 Scanner myObj = new Scanner(System.in); 
		 System.out.println("choose from the menu " ) ;
		 System.out.println("1-landline 2-mobileRecharge 3-donations 4-internetPayment" ) ;
		 String type = myObj.nextLine();
		
		 	if(type.equals("landline"))
		 	{	 System.out.println("1-quarter 2-monthly" ) ;
		 		s = new landlinefactory() ;
		 		String T = myObj.nextLine();
		 		if(T.equals("quarter") || T.equals("monthly"))
		 		{
		 			s.getservice(T).createservice();
		 		}
		 	 /*else if (T.equals("monthly"))
		 		{
		 			s.getservice(T).createservice();
		 		} */
		 	}
		 	else if (type.equals("mobileRecharge"))
		 	{
		 		 System.out.println("1-vodafone 2-etisalat 3-we 4-orange");
		 		s = new mobilerechargefactory() ;
		 		String T = myObj.nextLine();
		 		if(T.equals("vodafone") || T.equals("etisalat")||T.equals("orange")||T.equals("we"))
		 		{
		 			s.getservice(T).createservice();
		 		}
		 		/*else if (T.equals("etisalat"))
		 		{
		 			s.getservice(T).createservice();
		 		}
		 		else if (T.equals("we"))
		 		{
		 			s.getservice(T).createservice();
		 		}
		 		else if (T.equals("etisalat"))
		 		{
		 			s.getservice(T).createservice();
		 		}*/
		 	}
		 	else if (type.equals("internetPayment"))
		 	{
		 		 System.out.println("1-vodafone 2-etisalat 3-we 4-orange");
			 		s = new internetPaymentfactory() ;
			 		String T = myObj.nextLine();
			 		if(T.equals("vodafone") || T.equals("etisalat")||T.equals("orange")||T.equals("we"))
			 		{
			 			s.getservice(T).createservice();
			 		}
		 	}
			else if (type.equals("donations"))
			{
				 System.out.println("1-schools 2-hospitals 3-NGOs");
				 s = new donationsfactory() ;
			 		String T = myObj.nextLine();
			 		if(T.equals("schools") || T.equals("hospitals") || T.equals("NGOs"))
			 		{
			 			s.getservice(T).createservice();
			 		}
				
			}
		 	
		 
		 
	 
	 } 
}
