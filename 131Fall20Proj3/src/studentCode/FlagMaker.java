package studentCode;
import java.awt.Color;
import GridTools.MyGrid;

public class FlagMaker {
	public static void errorFlag(MyGrid grid, int rowNumber,Color color) {/*Method to print error flag
	everwhere the user enters a wrong concept for each flag and enters an invalid flag number*/
		int width=grid.getWd();
		int height=grid.getHt();
		for(int col=0;col<width;col=col+1) {
			for(int row=0;row<height;row=row+1) {
				grid.setColor(row,col, Color.WHITE);
			}	
		}
		for(int col=0;col<1;col=col+1) {
			for(int row=0;row<1;row=row+1) {
				grid.setColor(row,col, Color.RED);
			}	
		}
		for(int col=0;col<height-1;col=col+1) {
			for(int row=height-1;row<width-1;row=row+1) {
				grid.setColor(height-1,0, Color.BLUE);
			}	
		}
		for(int col=0;col<1;col=col+1) {
			for(int row=0;row<1;row=row+1) {
				grid.setColor(0,width-1, Color.YELLOW);
			}	
		}
		for(int col=0;col<1;col=col+1) {
			for(int row=0;row<1;row=row+1) {
				grid.setColor(height-1,width-1, Color.GREEN);
			}	
		}


	}
	public static void drawMacedonia (MyGrid grid)/*Method created for the diagonals for macedonia painted in orange*/
	{
		int height = grid.getHt();
		int length = 0;
		int row = 2*height;

		for(int i = 0; i < height; i++){
			grid.setColor(i,length,Color.ORANGE);
			length++;
			grid.setColor(i,length,Color.ORANGE);
			length++;
			grid.setColor(i,row-1,Color.ORANGE);
			row--;
			grid.setColor(i,row-1,Color.ORANGE);
			row--;
		}	
	}public static void EritreaTriangle(MyGrid grid) {//Method used to create triangle inside of eritrea
		int width=grid.getWd(); int height=grid.getHt(); int l=4;int i=4;
		for(i=0;i<height;i=i+1) {
			for( l=0;l<4;l=l+1) {
				grid.setColor(i, l, Color.RED);
			}
		}
		for(i=1;i<height-1;i=i+1) {
			for( l=0;l<8;l=l+1) {
				grid.setColor(i, l, Color.RED);
			}
		}
		if(height==5) {
		for(i=2;i<height-2;i=i+1) {
			for( l=8;l<10;l=l+1) {
				grid.setColor(i, l, Color.RED);
			}}
		}else {
			for(i=2;i<height-2;i=i+1) {
				for( l=8;l<12;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}
		}
			}
		if(height==7) {
			for(i=3;i<height-3;i=i+1) {
				for( l=12;l<14;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}
		}
			}else {
				for(i=3;i<height-3;i=i+1) {
					for( l=12;l<16;l=l+1) {
						grid.setColor(i, l, Color.RED);
					}
			}}
		if(height==9) {
			for(i=4;i<height-4;i=i+1) {
				for( l=16;l<18;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}
		}}else {
			for(i=4;i<height-4;i=i+1) {
				for( l=16;l<20;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}
		}}
		if(height==11) {
			for(i=5;i<height-5;i=i+1) {
				for( l=20;l<22;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}
			}}else {
				for(i=5;i<height-5;i=i+1) {
					for( l=20;l<24;l=l+1) {
						grid.setColor(i, l, Color.RED);
					}
			}}
		if(height==13) {
			for(i=6;i<height-6;i=i+1) {
				for( l=24;l<26;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}else {
			for(i=6;i<height-6;i=i+1) {
				for( l=24;l<28;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}
		if(height==15) {
			for(i=7;i<height-7;i=i+1) {
				for( l=28;l<30;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}else {
			for(i=7;i<height-7;i=i+1) {
				for( l=28;l<32;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}
		if(height==17) {
			for(i=8;i<height-8;i=i+1) {
				for( l=32;l<34;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}else {
			for(i=8;i<height-8;i=i+1) {
				for( l=32;l<36;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}
		}}
		if(height==19) {
			for(i=9;i<height-9;i=i+1) {
				for( l=36;l<38;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}
		}}else {
			for(i=9;i<height-9;i=i+1) {
				for( l=36;l<40;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}
		}}
		if(height==21) {
			for(i=10;i<height-10;i=i+1) {
				for( l=40;l<42;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}else {
			for(i=10;i<height-10;i=i+1) {
				for( l=40;l<44;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}
		if(height==23) {
			for(i=11;i<height-11;i=i+1) {
				for( l=44;l<46;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}else {
			for(i=11;i<height-11;i=i+1) {
				for( l=44;l<48;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}
		if(height==25) {
			for(i=12;i<height-12;i=i+1) {
				for( l=48;l<50;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}else {
			for(i=12;i<height-12;i=i+1) {
				for( l=48;l<52;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}
		if(height==27) {
			for(i=13;i<height-13;i=i+1) {
				for( l=52;l<54;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}else {
			for(i=13;i<height-13;i=i+1) {
				for( l=52;l<56;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}
		if(height==29) {
			for(i=14;i<height-14;i=i+1) {
				for( l=56;l<58;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}else {
			for(i=14;i<height-14;i=i+1) {
				for( l=56;l<60;l=l+1) {
					grid.setColor(i, l, Color.RED);
				}}
		}
		
		
		

		
	}
	public static void drawFlag(MyGrid grid, int countryCode) {
		final int INDONISIA=1;final int LITHUNIA=2;final int RWANDA=3; 
		final int MALTA=4;final int AFGHANISTAN=5;final int ERITREA=6;
		final int MACEDONIA=7;final int BAHAMAS=8;final int ZIMBABWE=9;
		int width=grid.getWd(); int height=grid.getHt();
		if(countryCode==INDONISIA) {  /*if the user enters one for the country choice the flag drawn will be  Indonisia*/
			if(height%2==0) {
				for(int col=0;col<width;col=col+1) {
					for(int row=0;row<(height/2);row=row+1) {//Loops to create the top part in red
						grid.setColor(row,col, Color.RED);

					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=(height/2);row<height;row=row+1) {
						grid.setColor(row,col, Color.WHITE);//The bottom part of indonisia in white
					}	
				}}
			else{
				errorFlag(grid,0,Color.GREEN);//If the user doesnt enter a multiple of 2 the program will return the error flag
			}
		}if(countryCode==LITHUNIA) {//If the user enters number 2 it draws the flag of lithunia 
			if(height%3==0) {
				for(int col=0;col<width;col=col+1) {
					for(int row=0;row<(height/3);row=row+1) {//The first portion of Lithunia in yellow
						grid.setColor(row,col, Color.YELLOW);
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=height/3;row<(height*2/3);row=row+1) {//Second part of lithunia in green
						grid.setColor(row,col, Color.GREEN);
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=(height*2/3);row<(height);row=row+1) {
						grid.setColor(row,col, Color.RED);//Final portion of lithunia in red
					}	
				}}
			else{
				errorFlag(grid,0,Color.GREEN);//If the user doesnt enter a multiple of 3 the program will return the error flag
			}
		}if(countryCode==RWANDA) {//If the user enters 3 the code will display the falg for rwanda
			if(height%4==0) {
				for(int col=0;col<width;col=col+1) {
					for(int row=0;row<(height/2);row=row+1) {
						grid.setColor(row,col, Color.BLUE);//for statement for the first portion of rwanda
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=height/2;row<(height*3/4);row=row+1) {
						grid.setColor(row,col, Color.YELLOW);
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=height*3/4;row<(height);row=row+1) {
						grid.setColor(row,col, Color.GREEN);
					}	
				}}else{
					errorFlag(grid,0,Color.GREEN);
				}
		}if(countryCode==MALTA) {
			for(int col=0;col<width/2;col=col+1) {//For the flag of Malta if user inputs country code 4
				for(int row=0;row<(height);row=row+1) {
					grid.setColor(row,col, Color.WHITE);
				}	
			}
			for(int col=width/2;col<width;col=col+1) {
				for(int row=0;row<height;row=row+1) {
					grid.setColor(row,col, Color.RED);
				}	
			}
		}if(countryCode==AFGHANISTAN) {
			if(height%3==0) {//Country code 5 is for Afghanistan
				for(int col=0;col<width/3;col=col+1) {
					for(int row=0;row<(height);row=row+1) {
						grid.setColor(row,col, Color.BLACK);
					}	
				}
				for(int col=width/3;col<width*2/3;col=col+1) {
					for(int row=0;row<height;row=row+1) {
						grid.setColor(row,col, Color.RED);
					}	
				}
				for(int col=width*2/3;col<width;col=col+1) {
					for(int row=0;row<height;row=row+1) {
						grid.setColor(row,col, Color.GREEN);
					}	
				}}else{
					errorFlag(grid,0,Color.GREEN);
				}
		}
		if(countryCode==ERITREA) {//Country code 6 displays eritrea which is three triangles
			for(int col=4;col<width;col=col+1) {
				for(int row=0;row<height/2;row=row+1) {
					grid.setColor(row,col, Color.GREEN);
				}	
			}
			for(int col=4;col<width;col=col+1) {
				for(int row=(height/2);row<height;row=row+1) {
					grid.setColor(row,col, Color.BLUE);
				}	
			}
			
			EritreaTriangle(grid);
		}else if(countryCode==MACEDONIA) {//Displays Macedonia flag which has a diagonal
			if(height>=8&&height%2==0) {
				for(int col=0;col<width;col=col+1) {
					for(int row=0;row<(height);row=row+1) {
						grid.setColor(row,col, Color.RED);

					}	
				}

				for(int col=(width/2)-1;col<(width/2)+1;col=col+1) {
					for(int row=0;row<height;row=row+1) {
						grid.setColor(row, col, Color.ORANGE);
					}

				}
				for(int col=0;col<width;col=col+1) {
					for(int row=(height/2)-1;row<(height/2)+1;row=row+1) {
						grid.setColor(row, col, Color.ORANGE);
					}
				}
				for(int col=(width/2)+1;col<(width/2)+4;col=col+1) {
					for(int row=(height/2)-2;row<(height/2)+2;row=row+1) {
						grid.setColor(row, col, Color.ORANGE);
					}
				}
				for(int col=(width/2)-4;col<(width/2)-1;col=col+1) {
					for(int row=(height/2)-2;row<(height/2)+2;row=row+1) {
						grid.setColor(row, col, Color.ORANGE);
					}


				}
				for(int col=0;col<2;col=col+1) {
					for(int row=0;row<1;row=row+1) {
						grid.setColor(row, col, Color.ORANGE);

					}
				}

				drawMacedonia(grid);//Method called to display the diagonals of macedonia
			}else{
				errorFlag(grid,0,Color.GREEN);//Display error flag
			}
		}if(countryCode==BAHAMAS) {//Displays the bahamas flag when user inputs 8
			if(height%3==0&&height%2!=0) {
				for(int col=0;col<width;col=col+1) {
					for(int row=0;row<(height/3);row=row+1) {
						grid.setColor(row,col, Color.BLUE);
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=height/3;row<(height*2/3);row=row+1) {
						grid.setColor(row,col, Color.YELLOW);
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=(height*2/3);row<(height);row=row+1) {
						grid.setColor(row,col, Color.BLUE);
					}	

				}
				for(int col=0;col<1;col=col+1) {
					for(int row=0;row<height;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}
				for(int col=1;col<2;col=col+1) {
					for(int row=1;row<height-1;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}for(int col=2;col<3;col=col+1) {
					for(int row=2;row<height-2;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}for(int col=3;col<4;col=col+1) {
					for(int row=3;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}
				for(int col=4;col<5;col=col+1) {
					for(int row=4;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}
				for(int col=5;col<6;col=col+1) {
					for(int row=5;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}
				for(int col=6;col<7;col=col+1) {
					for(int row=6;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}
				for(int col=7;col<8;col=col+1) {
					for(int row=7;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}
				for(int col=8;col<9;col=col+1) {
					for(int row=8;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}
				for(int col=9;col<10;col=col+1) {
					for(int row=9;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}
				for(int col=10;col<11;col=col+1) {
					for(int row=10;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}
				for(int col=11;col<12;col=col+1) {
					for(int row=11;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}
				for(int col=12;col<13;col=col+1) {
					for(int row=12;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}
				for(int col=13;col<14;col=col+1) {
					for(int row=13;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.BLACK);

					}	
				}
			}else{
				errorFlag(grid,0,Color.GREEN);//Displays error flag when the user inputs a wrong dimension.Not divisible by 3
			}
		}if(countryCode==ZIMBABWE) {//Displays the flag for zimbabwe
			if(height%7==0) {
				for(int col=0;col<width;col=col+1) {
					for(int row=0;row<(height/7);row=row+1) {
						grid.setColor(row,col, Color.GREEN);
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=height/7;row<(height*2/7);row=row+1) {
						grid.setColor(row,col, Color.YELLOW);
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=(height*2/7);row<(height*3/7);row=row+1) {
						grid.setColor(row,col, Color.RED);
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=(height*3/7);row<(height*4/7);row=row+1) {
						grid.setColor(row,col, Color.BLACK);
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=(height*4/7);row<(height*5/7);row=row+1) {
						grid.setColor(row,col, Color.RED);
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=(height*5/7);row<(height*6/7);row=row+1) {
						grid.setColor(row,col, Color.YELLOW);
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=(height*6/7);row<(height);row=row+1) {
						grid.setColor(row,col, Color.GREEN);
					}	
				}
				for(int col=0;col<width;col=col+1) {
					for(int row=(height*6/7);row<(height);row=row+1) {
						grid.setColor(row,col, Color.GREEN);
					}	
				}
				for(int col=0;col<1;col=col+1) {
					for(int row=0;row<height;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}
				for(int col=1;col<2;col=col+1) {
					for(int row=1;row<height-1;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}for(int col=2;col<3;col=col+1) {
					for(int row=2;row<height-2;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}for(int col=3;col<4;col=col+1) {
					for(int row=3;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}
				for(int col=4;col<5;col=col+1) {
					for(int row=4;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}
				for(int col=5;col<6;col=col+1) {
					for(int row=5;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}
				for(int col=6;col<7;col=col+1) {
					for(int row=6;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}
				for(int col=7;col<8;col=col+1) {
					for(int row=7;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}
				for(int col=8;col<9;col=col+1) {
					for(int row=8;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}
				for(int col=9;col<10;col=col+1) {
					for(int row=9;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}
				for(int col=10;col<11;col=col+1) {
					for(int row=10;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}
				for(int col=11;col<12;col=col+1) {
					for(int row=11;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}
				for(int col=12;col<13;col=col+1) {
					for(int row=12;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}
				for(int col=13;col<14;col=col+1) {
					for(int row=13;row<height-col;row=row+1) {
						grid.setColor(row, col, Color.WHITE);

					}	
				}	
			}
			else{
				errorFlag(grid,0,Color.GREEN);//Displays error flag if the dimension height isn't a multiple of 7
			}
		}
		if(countryCode>9||countryCode<1) {//Displays this error flag if the country code entered by the user isn't between 1-9
			errorFlag(grid,0,Color.GREEN);
		}
	}
}