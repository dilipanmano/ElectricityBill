package com.w.eb.entity;

public class Domestic extends Connection {
	

	public Domestic(int currentReading, int previousReading, float[] slabs) {
		super(currentReading, previousReading, slabs);
		this.currentReading=currentReading;
		this.previousReading=previousReading;
		this.slabs=slabs;	
	}

	public float computeBill()
	{
		int Reading;
		float val;
		Reading=currentReading-previousReading;
		if(Reading<50)
		{
			val=Reading*slabs[0];
		}
		else if(Reading<100)
		{
			int updReading=Reading-50;
			val=115+(updReading*slabs[1]);
		}
		else
		{
			int updReading=Reading-100;
			val=325+(updReading*slabs[2]);
		}
		return val;
	}
}
