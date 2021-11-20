public class TestSegment{
	public static void main(String args[]){
		Segment s1 = new Segment(6,8);
		Segment s2 = new Segment(12,5);
		System.out.println(s1.toString() +" longeur est: " + s1.longeur());
		System.out.println(s2.toString() +" longeur est: " + s2.longeur());

		if (s1.longeur() == s2.longeur()){
			System.out.println(s2.toString() + " a le meme longeur a " + s1.toString());
		} else if(s1.longeur() < s2.longeur()) {
			System.out.println(s2.toString() + " est plus longue!");
		} else {
			System.out.println(s1.toString() + " est plus longue!"); 
		}
	}
}
