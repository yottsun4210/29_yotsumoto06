package collection4;

public class Word {
	private String English;
	private String Japanese;

	public Word(String english,String japanese){
		super();
		this.English=english;
		this.Japanese=japanese;
	}

	public String toString(){
		return "英単語："+English+"日本語："+Japanese;
	}
	public String getEnglish(){
		return English;
	}
	public void getEnglish(String english){
		this.English=english;
	}
	public String getJapanese(){
		return Japanese;
	}

	public void setJapnaese(String japanese){
		this.Japanese=japanese;
	}
}
