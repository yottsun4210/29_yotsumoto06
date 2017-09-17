package collection4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Colletion4 {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		List<Word> words=new ArrayList<>();
		WordDAO2 wdao=new WordDAO2();

		System.out.println("英単語と日本語をスペースで区切って入力");
		Scanner sc=new Scanner(System.in);
		String input =sc.nextLine();

		while(!input.equals("e")){
			String[] tmp =new String[2];
			tmp=input.split(" ");
			Word wd=new Word(tmp[0],tmp[1]);
			words.add(wd);
			System.out.println("次の英単語と日本語を登録しました");
			input=sc.nextLine();
		}
		int count =wdao.registWords(words);
		System.out.println(count+"件、登録しました。");
		}
}
