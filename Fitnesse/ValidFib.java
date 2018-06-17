package ValidFib;


public class ValidFib {
	
	public int value1=1;
	
	
	public void setValue1(int value1) {
		this.value1=value1;
	}
	
	public boolean validFibMethod() {
	long a=0, b=1, c=0;
	while(c<value1) { 
		c= a+b;
		a=b;
		b=c;
		}
	if(c==value1)
	return true;
	else
	return false;	
	}

}
