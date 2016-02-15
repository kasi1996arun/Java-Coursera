import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class HelloWorld{
	public static String text;
	 protected List<String> getTokens(String pattern)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(text);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		
		return tokens;
	}

	int getSylabel(String text){
		char[] chr = text.toLowerCase().toCharArray();
		int c=0;
		for(int i=0;i<chr.length;i++){
			if(i==chr.length-1 && chr[i]=='e'){
				break;
			}
			if(chr[i]=='a' |chr[i]=='e' | chr[i]=='i' | chr[i]=='o' | chr[i]=='u' | chr[i]=='y' ){
				if(i!=chr.length-1){
					if(chr[i]!=chr[i+1]){
						if(chr[chr.length-1]=='e'){
							if(chr[i+1]=='a' || chr[i+1]=='u' || chr[i+1]=='o'  || chr[i+1]=='i'){
								continue;
							}
							else{
								c++;
							}
						}
						else{
							if(chr[i+1]=='a' || chr[i+1]=='u' || chr[i+1]=='o'  || chr[i+1]=='i' || chr[i+1]=='e'){
								continue;
							}
							else{
								c++;
							}
						}
					}
				}
				else if(chr[i]=='a' |chr[i]=='e' | chr[i]=='i' | chr[i]=='o' | chr[i]=='u' | chr[i]=='y' ){
					c++;
				}
			}
		}
		if(c==0)
			return 1;
	
		return c;
     }
     public static void main(String args[]){
     	Scanner s = new Scanner(System.in);	
     	HelloWorld h = new HelloWorld();	
     	text = s.nextLine();
        List<String> l = h.getTokens("[^!?.]+|[a-zA-Z]+");
        int c = 0,sen = 0;
        Iterator it = l.iterator();
        HelloWorld h1 = new HelloWorld();
        while(it.hasNext()){
        	String txt = (String) it.next();
        	int b = h1.getSylabel(txt);
        	System.out.println(txt+":"+b);
        	c=c+b;
        	sen++;
        }
        System.out.println(c+""+sen);
    }
        

		
}
