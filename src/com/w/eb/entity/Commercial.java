package com.w.eb.entity;

public class Commercial extends Connection {

	public Commercial(int currentReading, int previousReading, float[] slabs) {
		super(currentReading, previousReading, slabs);
		this.currentReading=currentReading;
		this.previousReading=previousReading;
		this.slabs=slabs;
	}
	
	public float computeBill()
	{
		int Reading;
		float ini,val,ed;
		Reading=currentReading-previousReading;
		if(Reading<50)
		{
			ini=Reading*slabs[0];
		}
		else if(Reading<100)
		{
			int updReading=Reading-50;
			ini=260+(updReading*slabs[1]);
		}
		else
		{
			int updReading=Reading-100;
			ini=600+(updReading*slabs[2]);
		} 
		
		//electrical duty
		if(ini>=10000)
		{
			ed=ini*slabs[3];
			val=ini+ed;
		}
		else if(ini>=5000)
		{
			ed=ini*slabs[4];
			val=ini+ed;
		}
		else
		{
			ed=ini*slabs[5];
			val=ini+ed;
		}
		return val;
	}


}
