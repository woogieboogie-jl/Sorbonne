class TestTrianglePascal{
	public static void main(String[] args){
		TrianglePascal tp1 = new TrianglePascal(10);
		TrianglePascal tp2 = new TrianglePascal(5);
		tp1.remplirTriangle();
		tp2.remplirTriangle();
		System.out.print(tp1.toString());
		System.out.print(tp2.toString());
	}
}
