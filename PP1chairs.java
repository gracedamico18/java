		//CHAIRS
	if (choice == 2)
	{				
		while (choice != 0)
		{	System.out.println("-----------------------------------");
			System.out.println("Current balance: " + fmtCurr.format(currentBalance));
			System.out.println("Current quantity: " + currentQuantityChair);
			System.out.println("Current price: " + fmtCurr.format(currentPriceChair));
			System.out.println("1. Sell Chairs");
			System.out.println("2. Buy Chairs");
			System.out.println("3. Change price");
			System.out.println("0. Return to main menu");
			System.out.print("Please enter choice: ");
				choice = keyboard.nextInt();
				keyboard.nextLine();
				
				if (choice == 1)
				{	//sell chairs
					System.out.print("Amount to sell (current quantity: " + currentQuantityChair
					+ "): ");
					chairsToSell = keyboard.nextInt();
			
					if (chairsToSell < 0)
					{	System.out.print("Please enter a positive number of chairs to sell: ");
						chairsToSell = keyboard.nextInt();
						}
					currentBalance = currentBalance + (chairsToSell * 15.30);
			
					if (currentQuantityChair < chairsToSell)
					{	System.out.print("Warning: Selling more than is in stock!\n");
						System.out.print("Do you wish to proceed (yes or no)? ");
						proceed = keyboard.nextLine();
						String answerProceed = "yes";
						if (!(answerProceed.equalsIgnoreCase(proceed)))
							System.exit(0);
					}
					currentQuantityChair = currentQuantityChair - chairsToSell;
	
				} //end sell chairs
		
				if (choice == 2)
				{	//buy chairs
					System.out.print("\nAmount to buy: ");
					chairsToBuy = keyboard.nextInt();
					System.out.print("Price per item: ");
					pricePerChair = keyboard.nextDouble();
			
					if (chairsToBuy < 0) {
						System.out.print("Please enter a positive number of chairs to buy: ");
						chairsToBuy = keyboard.nextInt();
					}
					if (pricePerChair < 0) {
						System.out.print("Please enter a positive price: ");
						pricePerChair = keyboard.nextDouble();
					}
					currentBalance = currentBalance - (chairsToBuy * pricePerChair);
					currentQuantityChair = currentQuantityChair + chairsToBuy;
					} //end buy chairs
		
				if (choice == 3)
				{	//change price of chairs
					System.out.print("\nNew price: ");
					newChairPrice = keyboard.nextDouble();
					currentPriceChair = newChairPrice;
					} //end price change
			}
	} //END CHAIRS