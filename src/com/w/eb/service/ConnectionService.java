package com.w.eb.service;
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
				Domestic objD = new Domestic(currentReading,previousReading,(new float[]{(float) 2.3,(float) 4.2,(float) 5.5}));
				 val = objD.computeBill();
			}
		    if(type=="Commercial")
			{
				Commercial objC = new Commercial(currentReading,previousReading,(new float[]{(float) 5.2,(float) 6.8,(float) 8.3,(float) 0.09,(float) 0.06,(float) 0.02}));
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


