package com.w.eb.entity;

public abstract class Connection {
	int previousReading;
	int currentReading;
	float[] slabs;
	public Connection(int currentReading,
			int previousReading,float slabs[]) 
	{
		//int p = previousReading;
		//currentReading = 5;
	}
	public abstract float computeBill();
	

}
