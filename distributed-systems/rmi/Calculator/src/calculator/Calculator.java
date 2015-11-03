package calculator;


public class Calculator implements RmiCalculator{

        @Override
	public double plus(double x, double y)
        {
            return x+y;
        }
        @Override
        public double minus(double x, double y)
        {
            return x-y;
        }  
        @Override
        public double times(double x, double y)
        {
            return x*y;
        }
        @Override
        public double division(double x, double y)
        {
            return x/y;
        }
}
