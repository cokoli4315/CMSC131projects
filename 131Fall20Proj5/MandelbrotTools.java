import java.awt.Color;

public class MandelbrotTools {

	/* STUDENTS: Put your "isBig" and "divergence" methods here. */
	/*
	 * public static method isBig which returns true if square of a and b are
	 * greater than the divergence boundary located in the controller class
	 * 
	 * @number which is a complexNumber containing both real and imaginary
	 * numbers
	 **/
	public static boolean isBig(ComplexNumber number) {
		// Determining the divergence value which is the addition of the squares
		// of both imaginary and real numbers
		MyDouble imagSquared = number.getImag().multiply(number.getImag());
		MyDouble realSquared = number.getReal().multiply(number.getReal());
		MyDouble isBig = realSquared.add(imagSquared);
		// Comparing the divergence with the divergence boundary using compreTo
		// which gives an integer number
		int x = isBig.compareTo(Controller.DIVERGENCE_BOUNDARY);
		// if the divergence is too big the method returns true
		if (x == 1) {
			return true;
			// else the method will return false which is that divergence isn't
			// too big
		} else {
			return false;
		}
	}

	/*
	 * static divergence method that holds a parameter z0
	 * 
	 * @z0 is a complexNumber that contains both real and imaginary numbers
	 * 
	 */
	public static int divergence(ComplexNumber z0) {
		// ComplexNumber z equals a new ComplexNumber which is z0
		ComplexNumber z = new ComplexNumber(z0);
		// for loop to determine whether the sequence of z is greater than the
		// limit
		for (int i = 1; i <= Controller.LIMIT; i = i + 1) {
			// z is the value of z at each integer less than the limit plus z0
			z = z.multiply(z).add(z0);
			// when the sequence is too big the method returns which sequence it
			// became big at
			// so if it exceeds the limit at 50, the method will return 50
			if (MandelbrotTools.isBig(z) == true) {
				return i;
			}
		}
		// else if the method goes through all the sequences and none of the
		// sequences were big
		// the method will return -1
		return -1;

	}

	/*
	 * This method selects a non-black color for a point which DIVERGED when
	 * tested with the Mandelbrot recurrence, based on how many terms in the
	 * sequence were computed before the terms got "too big".
	 * 
	 * The parameter represents the index of the term in the sequence which was
	 * first to be "too big". This value could be anything from 0 to
	 * Controller.LIMIT. The return value is the Color to be used to color in
	 * the point.
	 * 
	 * STUDENTS: IF you want to have some fun, write code for the else-if clause
	 * below which says "modify this block to create your own color scheme".
	 * When someone runs the program and selects "Student Color Scheme", the
	 * code you have written below will determine the colors.
	 */
	public static Color getColor(int divergence) {
		Color returnValue;

		if (Controller.colorScheme == Controller.RED_AND_WHITE_BANDS) {
			returnValue = (divergence % 2 == 0) ? Color.WHITE : Color.RED;
		}

		else if (Controller.colorScheme == Controller.CRAZY_COLORS) {
			int value = divergence * 2;
			int redAmount = (value % 5) * (255 / 5);
			int greenAmount = (value % 7) * (255 / 7);
			int blueAmount = (value % 9) * (255 / 9);
			returnValue = new Color(redAmount, greenAmount, blueAmount);
		}

		else if (Controller.colorScheme == Controller.STUDENT_DEFINED) {

			/***************************************************************
			 * Modify this block to create your own color scheme! *
			 ***************************************************************/
			returnValue = Color.WHITE; // take this out and return something
										// useful

		} else
			throw new RuntimeException("Unknown color scheme selected!");
		return returnValue;
	}

}
