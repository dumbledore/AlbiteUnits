/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.albite.util.units;

//import org.albite.util.units.*;
import junit.framework.TestCase;

/**
 *
 * @author albus
 */
public class TestUnits extends TestCase {
    /*
     * Testing temperature
     */
    public void testTemperature() {
        test(Unit.FAHRENHEIT, Unit.CELSIUS, 392, 200, -2);
        test(Unit.DEGREE_OF_FROST, Unit.CELSIUS, 109.5, -60.8, -1);
        test(Unit.DEGREE_OF_FROST, Unit.FAHRENHEIT, 109.5, -77.5);
        test(Unit.DEGREE_OF_FROST, Unit.FAHRENHEIT, 5, 27);
        test(Unit.KELVIN, Unit.CELSIUS, 433.15, 160);
    }

    /*
     * Length
     */
    public void testLength() {
        test(Unit.METRE, Unit.MILLIMETRE, 1, 1000);
        test(Unit.METRE, Unit.CENTIMETRE, 1, 100);
        test(Unit.METRE, Unit.DECIMETRE, 1, 10);
        test(Unit.KILOMETRE, Unit.METRE, 1, 1000);
        test(Unit.INCH, Unit.CENTIMETRE, 1, 2.54, -2);
        test(Unit.FOOT, Unit.INCH, 1, 12);
        test(Unit.YARD, Unit.FOOT, 1, 3);
        test(Unit.FATHOM, Unit.FOOT, 1, 6);
        test(Unit.CHAIN, Unit.FOOT, 1, 66);
        test(Unit.FURLONG, Unit.CHAIN, 1, 10);
        test(Unit.MILE, Unit.CHAIN, 1, 80);
        test(Unit.MILE, Unit.KILOMETRE, 1, 1.609344);
        test(Unit.LEAGUE, Unit.MILE, 1, 3);
        test(Unit.CABLE, Unit.NAUTICAL_MILE, 10, 1);
        test(Unit.NAUTICAL_MILE, Unit.METRE, 1, 1852);
        test(Unit.ROD, Unit.FOOT, 1, 16.5);
    }

    public void testArea() {
        test(Unit.SQUARE_METRE, Unit.SQUARE_MILLIMETRE, 1, 1000000);
        test(Unit.SQUARE_METRE, Unit.SQUARE_CENTIMETRE, 1, 10000);
        test(Unit.SQUARE_METRE, Unit.SQUARE_DECIMETRE, 1, 100);
        test(Unit.SQUARE_KILOMETRE, Unit.SQUARE_METRE, 1, 1000000);
        test(Unit.ARE, Unit.SQUARE_METRE, 1, 100);
        test(Unit.DECARE, Unit.SQUARE_METRE, 1, 1000);
        test(Unit.HECTARE, Unit.SQUARE_METRE, 1, 10000);
        test(Unit.SQUARE_FOOT, Unit.SQUARE_METRE, 1, 0.0929);
        test(Unit.SQUARE_YARD, Unit.SQUARE_METRE, 1, 0.8361);
        test(Unit.ACRE, Unit.SQUARE_YARD, 1, 4840);
        test(Unit.SQUARE_MILE, Unit.SQUARE_KILOMETRE, 1, 2.5899);
    }

    public void testVolume() {
        test(Unit.LITRE, Unit.MILLILITRE, 1, 1000);
        test(Unit.CUBIC_CENTIMETRE, Unit.CUBIC_MILLIMETRE, 1, 1000);
        test(Unit.CUBIC_CENTIMETRE, Unit.MILLILITRE, 1, 1);
        test(Unit.CUBIC_DECIMETRE, Unit.CUBIC_CENTIMETRE, 1, 1000);
        test(Unit.CUBIC_DECIMETRE, Unit.LITRE, 1, 1);
        test(Unit.FLUID_OUNCE, Unit.GALLON, 160, 1);
        test(Unit.PINT, Unit.GALLON, 8, 1);
        test(Unit.QUART, Unit.PINT, 1, 2);
        test(Unit.GALLON, Unit.LITRE, 1, 4.54609);
    }

    public void testMass() {
        test(Unit.GRAM, Unit.MILLIGRAM, 1, 1000);
        test(Unit.KILOGRAM, Unit.GRAM, 1, 1000);
        test(Unit.TONNE, Unit.KILOGRAM, 1, 1000);

        test(Unit.GRAIN, Unit.POUND, 7000, 1);
        test(Unit.OUNCE, Unit.POUND, 16, 1);
        test(Unit.STONE, Unit.POUND, 1, 14);
        test(Unit.HUNDREDWEIGHT, Unit.POUND, 1, 112);
        test(Unit.TON, Unit.POUND, 1, 2240);
    }

    public void testVelocity() {
        test(Unit.METRE_PER_SECOND, Unit.KILOMETRE_PER_HOUR, 1000, 3600);
        test(Unit.KILOMETRE_PER_HOUR, Unit.MILE_PER_HOUR, 100, 62.1371);
        test(Unit.KNOT, Unit.MILE_PER_HOUR, 100, 115, -1);
    }

    public void testPressure() {
        test(Unit.HECTOPASCAL, Unit.PASCAL, 1, 100);
        test(Unit.KILOPASCAL, Unit.PASCAL, 1, 1000);
        test(Unit.MILLIBAR, Unit.PASCAL, 1, 100);
        test(Unit.BAR, Unit.KILOPASCAL, 1, 100);
        test(Unit.MILLIMETRE_OF_MERCURY, Unit.HECTOPASCAL, 1, 1.33322);
        test(Unit.ATMOSPHERE, Unit.KILOPASCAL, 1, 101.325);
        test(Unit.PSI, Unit.KILOPASCAL, 1, 6.894);
        test(Unit.INCH_OF_MERCURY, Unit.KILOPASCAL, 1, 3.386389);
    }

    public void testPower() {
        test(Unit.WATT, Unit.MILLIWATT, 1, 1000);
        test(Unit.KILOWATT, Unit.WATT, 1, 1000);
        test(Unit.MEGAWATT, Unit.KILOWATT, 1, 1000);
        test(Unit.HORSEPOWER, Unit.KILOWATT, 1, 0.74569987);
    }

    public void testEnergy() {
        test(Unit.KILOWATT_HOUR, Unit.WATT_HOUR, 1, 1000);
        test(Unit.WATT_HOUR, Unit.JOULE, 1, 3600);
        test(Unit.CALORIE, Unit.JOULE, 1, 4.1868);
    }

    public void testLinearDensity() {
        test(Unit.DOTS_PER_INCH, Unit.DOTS_PER_CENTIMETRE, 72, 28, 0);
        test(Unit.DOTS_PER_CENTIMETRE, Unit.DOTS_PER_INCH, 1575, 4000, 0);
    }

    public void testAngle() {
        test(Unit.DEGREE, Unit.RADIAN, 180, 3.1415, -1);
        test(Unit.RADIAN, Unit.DEGREE, 2 * 3.1415, 360, -1);
    }
//        test(Unit., Unit., , );
    /**
     * Test helper method
     */
    private void test(Unit convertFromUnit, Unit convertToUnit,
            double convertFromQuantity, double expectedQuantity,
            int errorMagnitude) {

        double error = Math.pow(10, errorMagnitude);
        double result = Unit.convert(convertFromQuantity,
                convertFromUnit, convertToUnit);
        double currentError = Math.abs(result - expectedQuantity);
        System.out.println(convertFromQuantity + " "
                + convertFromUnit.name + " = " + result + " "
                + convertToUnit.name + ", expected: " + expectedQuantity
                +  ", error: " + currentError);

        assertTrue(currentError < error);
    }

    private void test(Unit convertFromUnit, Unit convertToUnit,
            double convertFromQuantity, double expectedQuantity) {
        test(convertFromUnit, convertToUnit,
                convertFromQuantity, expectedQuantity, -3);
    }
}
