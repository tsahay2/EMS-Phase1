package com.flp.ems.view;

import java.io.IOException;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.Scanner;

public class BootClass {

	static int selection = 0;

	public static void main(String[] args) throws IOException, SQLException {

		menuSelection();

	}

	public static void menuSelection() throws IOException, SQLException {

		UserInteraction uiInteraction = new UserInteraction();

	
		
		
		while (true) {

			System.out.println("Please enter the selection");
			System.out.println("1. Add employee");
			System.out.println("2. Modify employee");
			System.out.println("3. Remove employee");
			System.out.println("4. Search employee");
			System.out.println("5. Get All employee");
			System.out.println("6. Exit");

			Scanner sc = new Scanner(System.in);
			selection = sc.nextInt();
			switch (selection) {

			case 1: {
				uiInteraction.AddEmployee();
				break;
			}

			case 2: {

				uiInteraction.ModifyEmployee();
				break;
			}

			case 3: {

				uiInteraction.RemoveEmployee();
				break;
			}

			case 4: {

				uiInteraction.SearchEmployee();
				break;
			}

			case 5: {

				uiInteraction.getAllEmployee();
				break;
			}

			case 6: {

				return;
			}
			default: {

				System.out.println("Sorry, wrong choice!");
				break;
			}

			}
		}

	}

}
