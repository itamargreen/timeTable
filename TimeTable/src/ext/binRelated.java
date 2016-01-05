package ext;

public class binRelated {
	public static int maxNumForLength(int binLength) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< binLength; i++) {
			sb.append("1");
		}
		String res = sb.toString();
		return Integer.parseInt(res,2);
	}

}
