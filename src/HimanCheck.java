class HimanCheck {
	public static void main(String[] args) {
		double height, weight, weightAve, fat;

		height = 1.70;
		weight = 60.0;

		weightAve = 22 * Math.pow(height,2) ;
		fat = (weight - weightAve) / weightAve * 100;

		System.out.print("あなたの肥満率は");
		System.out.print(fat);
		System.out.println("%です。");
		if (fat > 25) 
		{
			System.out.println("あなたは非常に太りすぎです。");
		} 
		else if (fat >= 20)
		{
			System.out.println("あなたは太りすぎです。");
		} 
		else if (fat < -15)
		{
			System.out.println("あなたは非常に痩せすぎ。");
		}
		else if(fat < -10)
		{
			System.out.println("あなたは痩せすぎ。");
		} 
		else
		{
			System.out.println("あなたは太りすぎではない。");
		}
	}
}
