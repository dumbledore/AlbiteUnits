Conversion between xxx units in xx unit types.
==============================================

- Temperature: C, K, F, Degree of Frost
- Length: mm, cm, dm, m, km, mil, in, ft, yd, fm, ch, fur, mi, land, cable, nautical mile
- Area: mm2, cm2, dc2, m2, a, daa, ha, km2, sq ft, sq yd, ac, sq mi
- Volume: mL, L, mm3, cm3, dm3, m3, fl oz, gi, pt, qt, gal
- Mass: mg, g, kg, t, gr, oz, lb, st, cwt, ton
- Velocity: m/s, km/h, fps, mph, kn
- Pressure: Pa, hPa, kPa, mbar, bar, mmHg, inHg, Atm, psi
- Power: mW, W, kW, MW, HPS
- Energy: Wh, kWh, J, cal
- Linear density: DPI, DPCM
- Angle: rad, deg

Sample usage
============

Converting units
----------------

Let's convert 3 fathoms into meters
        Unit.convert(Unit.FATHOM, 3, Unit.METER);

Note that converting units from two different group will produce invalid results.

Available unit groups are listed in `UnitGroup.GROUPS`. So to print the available unit groups you can do that:

		for (int i = 0; i < UnitGroup.GROUPS.length; i++) {
			System.out.println(UnitGROUP.GROUPS[i].name);
		}

To print the available units in a group, e.g. temperature:
		Unit[] units = UnitGroup.GROUP_TEMPERATURE.units;
		for (int i = 0; i < units; i++) {
			System.out.println(units[i].name);
		}

Creating new units
------------------

Every unit is defined by a name and three coefficients: `ratio`, `a` and `x`. The model used for conversion is this:
		in_base_units = (ratio * in_current_units + a) * x
		in_current_units = (in_base_units - (a * x)) / (ratio * x)

As most units need only to be scaled by magintude, one can use the simpler model:
		in_base_units = ratio * in_current_units
		in_current_untis = in_base_units / ratio

So every unit is first converted to the base unit in the group and then again converted to the appropriate unit.

Creating a new unit makes sense only if it is defined in a group as each group needs one reference unit, i.e. base unit, to which all units are first converted. For instance the units in the Energy group use the Joule as a base unit. Therefore, they are defined as this:

		Unit WATT_HOUR = new Unit("Watt hour (W h)", 3600); 			// 1W = 3600J
		Unit KILOWATT_HOUR = new Unit("Kilowatt hour (kW h)", 3600000); // 1kW = 1000W = 1000 * 3600J
		Unit JOULE = new Unit("Joule (J)", 1); 							// 1J = 1J
		Unit CALORIE = new Unit("calorie (cal)", 4.1868); 				// 1cal = 4.1868J

Then we can neatly store the units in a group, like so:
	    private static final Unit[] UNITS_ENERGY = {Unit.WATT_HOUR, Unit.KILOWATT_HOUR, Unit.JOULE, Unit.CALORIE
    };
		public static final UnitGroup GROUP_ENERGY = new UnitGroup("Energy", UNITS_ENERGY);
