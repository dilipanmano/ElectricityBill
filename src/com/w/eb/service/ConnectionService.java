packagecom.w.eb.service;
import com.w.eb.entity.Commercial;
import com.w.eb.entity.Domestic;
import com.w.eb.exception.*;

public class ConnectionService {
	
	public boolean validate(int
			currentReading, int previousReading,
			String type) throws
			InvalidReadingException,
			InvalidConnectionException
	{   
		if(currentReading-previousReading<0)
		{
			throw new InvalidReadingException();
		}
		else if(type!="Domestic" && type!="Commercial")
		{
			throw new InvalidConnectionException();
		}
		return true;
	}

	public float calculateBillAmt(int
			currentReading, int previousReading,
			String type)
	{
		int flag=0;
		float val=0;
		try {
			if(validate(currentReading,previousReading,type))
			{
				flag=flag+1;
			}
		}catch(InvalidReadingException e) {
			return -1;
		}catch(InvalidConnectionException e) {
			System.out.println(e);
			return -2;
		}
		if(flag==1)
		{
			if(type=="Domestic")
			{
				Domestic objD = new Domestic(currentReading,previousReading,(new float[]{(2.3f,4.2f,5.5f}));
				 val = objD.computeBill();
			}
		    if(type=="Commercial")
			{
				Commercial objC = new Commercial(currentReading,previousReading,(new float[]{5.2f,6.8f,8.3f,0.09f,0.06f,0.02f}));
				val = objC.computeBill();
			}
		}
		return val;
	}
	
	public String generateBill(int
			currentReading, int previousReading,
			String type)
	{
		float x;
		String y="asdf";
		x=calculateBillAmt(currentReading,previousReading,type);
		
		if(x>0)
		{
			y="Amount to be paid:"+x;	
		}
		else if(x==-1){
			y="Incorrect Reading";
		}
		else if(x==-2) {
			y="Invalid ConnectionaaaType";
		}
		
		return y;
		
		
	}
	
	
}


