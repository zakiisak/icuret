package icuret.net;

public class NetFuncs {
	
	@SuppressWarnings("rawtypes")
	public static Class[] getRegisteredClasses() {
		return new Class[] {
			int[].class, int[][].class,
			float[].class, float[][].class,
			double[].class, double[][].class,
			boolean[].class, boolean[][].class
		};
	}
	
}
