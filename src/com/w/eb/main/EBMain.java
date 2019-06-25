package com.w.eb.main;
import java.util.Scanner;

import com.w.eb.service.ConnectionService;

public class EBMain {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		String c = in.nextLine();
		in.close();
		System.out.println(new ConnectionService().generateBill(a,b,c));
	}
}
