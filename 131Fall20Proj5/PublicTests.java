import static org.junit.Assert.*;

import org.junit.Test;

public class PublicTests {

	@Test
	public void testBasicConstructorsAndGetters() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble d = new MyDouble(555.729);

		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(
				x.getReal().compareTo(a) == 0 && x.getImag().compareTo(b) == 0);

		ComplexNumber z = new ComplexNumber(d);
		assertTrue(z.getReal().compareTo(d) == 0
				&& z.getImag().compareTo(new MyDouble(0)) == 0);
	}

	@Test
	public void testCopyConstructor() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);

		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y); // Check to be sure they are not aliased!
		assertTrue(
				y.getReal().compareTo(a) == 0 && y.getImag().compareTo(b) == 0);
	}

	@Test
	public void testAdd() {
		MyDouble areal = new MyDouble(6);
		MyDouble bimag = new MyDouble(3.5);
		MyDouble creal = new MyDouble(5);
		MyDouble dimag = new MyDouble(7);
		MyDouble e = new MyDouble(-5);
		ComplexNumber x = new ComplexNumber(areal, bimag);
		ComplexNumber z = new ComplexNumber(creal, dimag);
		ComplexNumber add = new ComplexNumber(areal.add(creal), bimag.add(dimag));
		assertTrue(areal.add(e).equals(new MyDouble(1)));
		assertTrue(areal.add(creal).equals(new MyDouble(11)));
		assertTrue(bimag.add(dimag).equals(new MyDouble(10.5)));
		assertTrue(x.add(z).equals((add)));
	}

	@Test
	public void testSubtract() {
		MyDouble areal = new MyDouble(6);
		MyDouble creal = new MyDouble(7);
		MyDouble bimag = new MyDouble(6.2);
		MyDouble dimag = new MyDouble(4.5);
		MyDouble e = new MyDouble(-4);
		ComplexNumber x = new ComplexNumber(areal, bimag);
		ComplexNumber z = new ComplexNumber(creal, dimag);
		ComplexNumber subtract = new ComplexNumber(areal.subtract(creal),
				bimag.subtract(dimag));
		assertTrue(e.subtract(areal).equals(new MyDouble(-10)));
		assertTrue(areal.subtract(e).equals(new MyDouble(10)));
		assertTrue(areal.subtract(creal).equals(new MyDouble(-1)));
		assertTrue(bimag.subtract(dimag).equals(new MyDouble(1.7)));
		assertTrue(x.subtract(z).equals(subtract));

	}

	@Test
	public void testMult() {
		MyDouble areal = new MyDouble(4);
		MyDouble bimag = new MyDouble(6);
		MyDouble creal = new MyDouble(3);
		MyDouble dimag = new MyDouble(5);
		ComplexNumber x = new ComplexNumber(areal, bimag);
		ComplexNumber y = new ComplexNumber(creal, dimag);
		ComplexNumber multiply = new ComplexNumber(
				areal.multiply(creal).subtract(bimag.multiply(dimag)),
				areal.multiply(dimag).add(bimag.multiply(creal)));
		assertTrue(areal.multiply(creal).equals(new MyDouble(12)));
		assertTrue(bimag.multiply(dimag).equals(new MyDouble(30)));
		assertTrue(x.multiply(y).equals(multiply));
		assertTrue(bimag.multiply(creal).equals(new MyDouble(18)));
	}

	@Test
	public void testDiv() {
		MyDouble areal = new MyDouble(3);
		MyDouble breal = new MyDouble(4);
		MyDouble cimag = new MyDouble(5);
		MyDouble dimag = new MyDouble(6);
		ComplexNumber comp1 = new ComplexNumber(areal, cimag);
		ComplexNumber comp2 = new ComplexNumber(breal, dimag);
		MyDouble num1 = areal.multiply(breal).add(cimag.multiply(dimag));
		MyDouble num2 = cimag.multiply(breal).subtract(areal.multiply(dimag));
		MyDouble den = breal.multiply(breal).add(dimag.multiply(dimag));
		ComplexNumber divide = new ComplexNumber(num1.divide(den),
				num2.divide(den));
		assertTrue(areal.divide(cimag).equals(new MyDouble(0.6)));
		assertTrue(breal.divide(dimag).equals(new MyDouble(0.66666667)));
		assertTrue(areal.divide(dimag).equals(new MyDouble(0.5)));
		assertTrue(comp1.divide(comp2).equals(divide));
	}

	@Test
	public void testEqComp() {
		MyDouble a = new MyDouble(5);
		MyDouble b = new MyDouble(5);
		MyDouble c = new MyDouble(10);
		MyDouble d = new MyDouble(10);
		MyDouble e = new MyDouble(6);
		MyDouble w = new MyDouble(5.5);
		ComplexNumber x = new ComplexNumber(a, c);
		ComplexNumber y = new ComplexNumber(b, d);
		ComplexNumber z = new ComplexNumber(e, w);
		assertTrue(a.equals(b) == true && c.equals(d) == true);
		assertTrue(!a.equals(b) == false && !c.equals(d) == false);
		assertTrue(x.compareTo(y) == 0);
		assertTrue(z.compareTo(y) == -1);
		assertTrue(x.compareTo(z) == 1);

	}

	@Test
	public void testNorm() {
		MyDouble areal = new MyDouble(3);
		MyDouble aimag = new MyDouble(4);
		MyDouble breal = new MyDouble(5);
		MyDouble bimag = new MyDouble(6);
		ComplexNumber complex = new ComplexNumber(areal, aimag);
		ComplexNumber norm = new ComplexNumber(
				areal.multiply(aimag).add(areal.multiply(aimag)).sqrt());
		assertTrue(areal.multiply(areal).add(aimag.multiply(aimag)).sqrt()
				.equals(new MyDouble(5)));
		assertTrue(breal.multiply(breal).add(bimag.multiply(bimag)).sqrt()
				.equals(new MyDouble(7.810249676)));
	}

	@Test
	public void testParse() {
		MyDouble a=new MyDouble(4);
		MyDouble b=new MyDouble(-2);
		MyDouble c=new MyDouble(5);
		MyDouble d=new MyDouble(8);
	}
}
