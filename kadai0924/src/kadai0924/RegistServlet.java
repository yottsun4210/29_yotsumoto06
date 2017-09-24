package kadai0924;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet{

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	String english = req.getParameter("english");
	String japanese = req.getParameter("japanese");

	List<Word> words=new ArrayList<>();
	WordDAO wdao=new WordDAO();

	Word wd = new Word(english,japanese);
	words.add(wd);

	int count=wdao.registWords(words);
	req.setAttribute("registcount",count);

	List<Word>wList=new ArrayList<>();
	wList = wdao.getWords();
	int wordNum =0;
	for(Word tmp: wList){
		System.out.println(tmp);
		wordNum++;
	}
	req.setAttribute("total",wordNum);
req.getRequestDispatcher("result.jsp").forward(req,res);
}}
