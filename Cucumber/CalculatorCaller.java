package Assignment;

public class CalculatorCaller {
	
	private final static String host="http://localhost:1235/"; 
	private HttpServiceCaller service;
	
	private int value1;
	private int value2;
	
	public CalculatorCaller() {
		service=new HttpServiceCaller();
	}
	
	public void assignValues(int value1, int value2) {
		this.value1=value1;
		this.value2=value2;
	}
	public String add()
	{
		String request=host+"add?value1="+Integer.toString(value1)+"&value2="+Integer.toString(value2);
		return service.executeGetRequest(request);
	}
	public String sub()
	{
		String request=host+"sub?value1="+Integer.toString(value1)+"&value2="+Integer.toString(value2);
		return service.executeGetRequest(request);
	}
	public String div()
	{
		String request=host+"div?value1="+Integer.toString(value1)+"&value2="+Integer.toString(value2);
		return service.executeGetRequest(request);
	}
	public String mult()
	{
		String request=host+"mult?value1="+Integer.toString(value1)+"&value2="+Integer.toString(value2);
		return service.executeGetRequest(request);
	}

}
