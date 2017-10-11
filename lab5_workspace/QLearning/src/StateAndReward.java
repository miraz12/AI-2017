public class StateAndReward {

private static final int STATES_ANGLE = 10;
private static final double MAX_ANGLE = 2.0;

private static final int STATES_VX = 4;
private static final double MAX_VX = 1.5;

private static final int STATES_VY = 6;
private static final double MAX_VY =  3;

	/* State discretization function for the angle controller */
	public static String getStateAngle(double angle, double vx, double vy) {

		/* TODO: IMPLEMENT THIS FUNCTION */
		
		
		String state;
		
		if(angle < 0)
		{
			state = "TiltingRight";
		}
		else
		{
			state = "TiltingLeft";
		}
//		else
//		{
//			state = "Upright";
//		}
		
		return state;
	}

	/* Reward function for the angle controller */
	public static double getRewardAngle(double angle, double vx, double vy) {

		/* TODO: IMPLEMENT THIS FUNCTION */
		
		//double reward = 0;

		
		return getBalancedReward(angle, MAX_ANGLE);
		
//		else if(angle > 0.02)
//		{
//			reward = - Math.abs(angle);
//		}
//		else
//		{
//			reward = Math.PI * 20;
//		}
		
		//return reward;
	}

	/* State discretization function for the full hover controller */
	public static String getStateHover(double angle, double vx, double vy) {

		/* TODO: IMPLEMENT THIS FUNCTION */

		int descreteX = discretize(vx, STATES_VX, -MAX_VX, MAX_VX);
		int descreteY = discretize(vy, STATES_VY, -MAX_VY, MAX_VY);
		int descreteAngle = discretize(angle, STATES_ANGLE, -MAX_ANGLE, MAX_ANGLE);
		String state = descreteAngle + "." + descreteX + "." + descreteY + ".";
		
		return state;
	}

	/* Reward function for the full hover controller */
	public static double getRewardHover(double angle, double vx, double vy) {

		/* TODO: IMPLEMENT THIS FUNCTION */
		
		//double vxRew = (Math.abs(vx)< 0.1 ? 0 : -Math.pow(Math.abs(vx)/1.5, 2));
		//double vyRew = (Math.abs(vy)< 0.1 ? 0 : -Math.pow(Math.abs(vy)/3, 2)); 
		
		double vxRew = getBalancedReward(vx , MAX_VX);
		//System.out.println("XReward:" + vxRew + "\n");
		double vyRew = getBalancedReward(vy, MAX_VY);
		//System.out.println("YReward:" + vyRew + "\n");
		double angleRew = getBalancedReward(angle, MAX_ANGLE);
		//System.out.println("AReward:" + angleRew + "\n");
		
		double reward = angleRew + vxRew + vyRew;				
		//System.out.println("RealReward:" + reward + "\n");
		
		
		return reward;
	}
	
	public static double getBalancedReward(double value, double max){
		double reward = 0;
		
		if(Math.abs(value) >= max){
			reward = 0;
		}
		else{
			reward = Math.pow(1 - Math.abs(value)/max,2);
			//System.out.print("Reward: " + reward + "\n");
		}
//		if(!(Math.abs(value) >= max)){
//			reward = Math.pow(1 - Math.abs(value)/max,2);
//		}
		
		return reward;
	}
	
	// ///////////////////////////////////////////////////////////
	// discretize() performs a uniform discretization of the
	// value parameter.
	// It returns an integer between 0 and nrValues-1.
	// The min and max parameters are used to specify the interval
	// for the discretization.
	// If the value is lower than min, 0 is returned
	// If the value is higher than min, nrValues-1 is returned
	// otherwise a value between 1 and nrValues-2 is returned.
	//
	// Use discretize2() if you want a discretization method that does
	// not handle values lower than min and higher than max.
	// ///////////////////////////////////////////////////////////
	public static int discretize(double value, int nrValues, double min,
			double max) {
		if (nrValues < 2) {
			return 0;
		}

		double diff = max - min;

		if (value < min) {
			return 0;
		}
		if (value > max) {
			return nrValues - 1;
		}

		double tempValue = value - min;
		double ratio = tempValue / diff;

		return (int) (ratio * (nrValues - 2)) + 1;
	}

	// ///////////////////////////////////////////////////////////
	// discretize2() performs a uniform discretization of the
	// value parameter.
	// It returns an integer between 0 and nrValues-1.
	// The min and max parameters are used to specify the interval
	// for the discretization.
	// If the value is lower than min, 0 is returned
	// If the value is higher than min, nrValues-1 is returned
	// otherwise a value between 0 and nrValues-1 is returned.
	// ///////////////////////////////////////////////////////////
	public static int discretize2(double value, int nrValues, double min,
			double max) {
		double diff = max - min;

		if (value < min) {
			return 0;
		}
		if (value > max) {
			return nrValues - 1;
		}

		double tempValue = value - min;
		double ratio = tempValue / diff;

		return (int) (ratio * nrValues);
	}

}
