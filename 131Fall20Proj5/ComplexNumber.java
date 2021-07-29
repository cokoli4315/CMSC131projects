public class ComplexNumber {

	/* STUDENTS: You may NOT add any further instance or static variables! */
	/*
	 * instance variables that represent the imaginary and real numbers in the
	 * complex number it is initialized as a private variable because it is only
	 * accessible in the complexNumber class
	 */
	private final MyDouble real; // To be initialized in constructors
	private final MyDouble imag; // To be initialized in constructors

	/*
	 * STUDENTS: Put your methods here, as described in the project description.
	 */
	/*
	 * Constructors
	 * 
	 * @realIn, the real numbers in the complex number
	 * 
	 * @ImagIn, determines the imaginary numbers in the complexNumber
	 */
	public ComplexNumber(MyDouble realIn, MyDouble imagIn) {
		this.real = realIn;
		this.imag = imagIn;
	}
	/*
	 * Constructor that takes one parameter and initializes the imaginary
	 * parameter to 0
	 * 
	 * @realIn parameter that determines the real numbers in the complexNumber
	 * 
	 * @Sets the imaginary number parameter to 0
	 */

	public ComplexNumber(MyDouble realIn) {
		this.real = realIn;
		this.imag = new MyDouble(0.0);
	}

	/*
	 * Copy Constructor
	 * 
	 * @sets the parameter other to imaginary and real numbers
	 * 
	 * @parameter other that copies real and imaginary numbers
	 */
	public ComplexNumber(ComplexNumber other) {
		this.imag = other.imag;
		this.real = other.real;
	}

	/*
	 * Getter that returns a real number assigned to the current object
	 */
	public MyDouble getReal() {
		return this.real;
	}

	/*
	 * Getter that returns an imaginary number assigned to the current object
	 */
	public MyDouble getImag() {
		return this.imag;
	}

	/*
	 * instance methods Instance method that returns a complexNumber that
	 * determines the addition of the current object and and the parameter
	 * 
	 * @number, this determines the real and the imaginary numbers of a complex
	 * number added to the current object
	 */
	public ComplexNumber add(ComplexNumber number) {
		// Returns a new complexNumber that equals the sum of the current object
		// this and parameter number
		return new ComplexNumber(this.real.add(number.getReal()),
				this.imag.add(number.getImag()));
	}

	/*
	 * instance method subtract gotten from the subtraction of the parameter
	 * from the current object
	 * 
	 * @ComplexNumber number which is a complexNumber that contains an imaginary
	 * and a real number
	 */
	public ComplexNumber subtract(ComplexNumber number) {
		// returns a new COmplexNumber that is determined by the subtraction of
		// the parameter from current object
		return new ComplexNumber(this.real.subtract(number.getReal()),
				this.imag.subtract(number.getImag()));
	}

	/*
	 * Instance method multiply determines the multiplication between the
	 * current object and parameter
	 * 
	 * @number complexNumer that contains an imaginary number and a real number
	 */
	public ComplexNumber multiply(ComplexNumber number) {
		/*
		 * returns a complexNumber determined by multiplying the current object
		 * and parameter which is either a negative or positive imaginary number
		 */
		return new ComplexNumber(
				this.real.multiply(number.getReal())
						.subtract(this.imag.multiply(number.getImag())),
				this.real.multiply(number.getImag())
						.add(this.imag.multiply(number.getReal())));
	}

	/*
	 * Instance method divide determines the division of the current object by
	 * the parameter
	 * 
	 * @number,complexNumber that contains an imaginary number and a real number
	 */
	public ComplexNumber divide(ComplexNumber number) {
		/*
		 * returns a new complexNumber that is gotten by dividing the current
		 * object with the parameter num1, is the first numerator of the
		 * complexNumber on and num2, the second numerator that indicates the
		 * imaginary number den which is the denominator of both the imaginary
		 * numbers and real numbers
		 */
		MyDouble num1 = this.real.multiply(number.getReal())
				.add(this.imag.multiply(number.getImag()));
		MyDouble num2 = this.imag.multiply(number.getReal())
				.subtract(this.real.multiply(number.getImag()));
		MyDouble den = number.getReal().multiply(number.getReal())
				.add(number.getImag().multiply(number.getImag()));
		return new ComplexNumber((num1.divide(den)), (num2.divide(den)));
	}

	/*
	 * The boolean equals method returns true if the current object is equal to
	 * the parameter, if the real number object is equal to the parameter real
	 * 
	 * @number which is a complexNumber that contains both imaginary and real
	 * numbers
	 */
	public boolean equals(ComplexNumber number) {
		// Returns true if the current object and parameter real numbers and
		// imaginary numbers are equal
		if (this.real.equals(number.getReal())
				&& this.imag.equals(number.getImag())) {
			return true;
			// else it will return false if they are not equal
		} else {
			return false;
		}
	}

	/*
	 * Instance method compareTo, which compares the norm of the current object
	 * and the parameter
	 * 
	 * @number a complexNumber that contains both a real and an imaginary number
	 */
	public int compareTo(ComplexNumber number) {
		int compareToValue = norm(this).compareTo(norm(number));
		// returns 0 if the current object norm and parameter norm are equal
		if (compareToValue == 0) {
			return 0;
			// if the norm of the current object is less than the norm of the
			// parameter the method returns -1
		} else if (compareToValue < 0) {
			return -1;
			// else if the norm of the current object is greater than the norm
			// of the parameter return 1
		} else {
			return 1;
		}

	}

	/*
	 * toString method that returns the string string of the comlplexNumnber
	 */
	public String toString() {
		// returns -1 if there is a negative sign in the imaginary number
		if (this.imag.toString().indexOf('-') == -1) {
			// prints out a complexNumber like 5+4i
			return this.real.toString() + "+" + this.imag.toString() + "i";
		} else {
			return this.real.toString() + "" + this.imag.toString() + "i";
		}

	}

	/*
	 * static method that returns the square root of real number squared plus
	 * imaginary number squared
	 * 
	 * @number which is a complexNumber that contains both imaginary and real
	 * numbers
	 */
	public static MyDouble norm(ComplexNumber z) {
		// This is the square of the real number z
		MyDouble realSquared = z.getReal().multiply(z.getReal());
		MyDouble imagSquared = z.getImag().multiply(z.getImag());
		// Returns the square root of the real number square plus imaginary
		// number squared
		return (realSquared.add(imagSquared)).sqrt();
	}
	/*static method parseComplexNumber that returns the parse of a real number 
	 * and the parse of an imaginary number, method is making sure the code always returns 
	 * a number even if a number wasn't passed, which will equal to 0
	 * 
	 * @number complexNumber that contains both imaginary and real number*/
	
	public static ComplexNumber parseComplexNumber(String number) {
		//removes the number of spaces in the complexNumber to none
		String zeroSpaces = number.replaceAll(" ", "");
		//initialize myDouble parsed real and parsed imaginary
		MyDouble parseReal;
		MyDouble parseImag;
		//if the index of + does not equal to -1
		if (zeroSpaces.indexOf('+') != -1) {
			parseReal = new MyDouble(Double.parseDouble(
					zeroSpaces.substring(0, zeroSpaces.indexOf('+'))));
			parseImag = new MyDouble(Double.parseDouble(zeroSpaces.substring(
					zeroSpaces.indexOf('+'), zeroSpaces.indexOf('i'))));
		} else {
			parseReal = new MyDouble(Double.parseDouble(
					zeroSpaces.substring(0, zeroSpaces.indexOf('-', 1))));

			parseImag = new MyDouble(Double.parseDouble(zeroSpaces.substring(
					zeroSpaces.indexOf('-', 1), zeroSpaces.indexOf('i'))));

		}
		//returns a new complexNumber, which is the parsed real and the parsed imaginary
		return new ComplexNumber(parseReal, parseImag);
	}

}
