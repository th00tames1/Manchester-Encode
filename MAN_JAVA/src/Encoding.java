import java.util.Scanner;

public class Encoding {
	private String wonbon;
	private String ManTrans;
	private String DiffManTrans;
	
	public Encoding() {
		System.out.print("Input Code : ");
		Scanner sc=new Scanner(System.in);
		wonbon=sc.nextLine();
		ManTrans=wonbon;
		DiffManTrans=wonbon;
	}
	
	public String ManEncoding() {
		
//		WONBON :		01 00 11 00 011=
//		MAN : 			1001 1010 0101 1010 100101
		
		ManTrans=wonbon.replaceAll("0", "a").replaceAll("1", "b");
		ManTrans=ManTrans.replaceAll("a", "10").replaceAll("b", "01");
		System.out.println("Manchester Encoding = "+ ManTrans);
		return ManTrans;
	}
	
	public String DiffManEncoding() {

//		WONBON :		01 00 11 00 011=
//		DIFFMAN :	(1)	0110	1010	0110	1010	100110
//		OUTPUT :		0110	1010	0110	1010	100110

		int i=0;
		while(i<DiffManTrans.length()-1) {
			if(DiffManTrans.charAt(i)=='0' && i==0)
				DiffManTrans=DiffManTrans.replaceFirst("0", "a1");
			if(DiffManTrans.charAt(i)=='1' && i==0)
				DiffManTrans=DiffManTrans.replaceFirst("1", "b0");
			// 시작지점일 경우 변환 
				
			if(DiffManTrans.charAt(i)=='0' && DiffManTrans.charAt(i+1)=='0')
				DiffManTrans=DiffManTrans.replaceFirst("00", "ab0");
			else if(DiffManTrans.charAt(i)=='0' && DiffManTrans.charAt(i+1)=='1')
				DiffManTrans=DiffManTrans.replaceFirst("01", "aa1");
			else if(DiffManTrans.charAt(i)=='1' && DiffManTrans.charAt(i+1)=='0')
				DiffManTrans=DiffManTrans.replaceFirst("10", "ba1");
			else if(DiffManTrans.charAt(i)=='1' && DiffManTrans.charAt(i+1)=='1')
				DiffManTrans=DiffManTrans.replaceFirst("11", "bb0");
			// 변환과정
			
			i++;
			
		}
		DiffManTrans=DiffManTrans.replaceAll("a", "0").replaceAll("b", "1");
		System.out.println("Differential Manchester Encoding = "+ DiffManTrans);
		return DiffManTrans;
	}
}