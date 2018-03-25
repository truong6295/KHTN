package phathienluanvan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class gets {
	private static boolean kiemtra=false;
	public static boolean setkiemtra(Boolean khoitao){
		kiemtra=khoitao;
		return kiemtra;
	}
	public static boolean getkiemtra(){
		return kiemtra;
	}
	public static void main(String[] args) throws IOException{
		//vi du lay cac file html 
		//String url="https://123doc.org";
		//gethtmls(url);
		//HashSet<String> hset= new HashSet<>();
		//laylink(url,linkpattern,hset);
		//System.out.println("hoan thanh");
		//String input="../phathienluanvan/tailieu/tailieugoc/html/1+1+2+4+chỉ+tiêu+đánh+giá+hiệu+quả+công+tác+chăm+sóc+khách+hàng+tại+doanh+nghiệp.htm.html";
		//System.out.println(gethtml(input));
	}
	//---lay link
	public static void laylink(String urlboot,String url,HashSet<String> hset) throws IOException{
		
		Document doc = Jsoup.connect(url).timeout(50000).get();
		Elements links = doc.select("a[href]");
		for (Element link : links) {
			Pattern pattern1 = Pattern.compile("^"+urlboot);
			Matcher matcher1=pattern1.matcher(link.attr("abs:href"));
			if(matcher1.find()){
        		hset.add(link.attr("abs:href"));
			}
			if(getkiemtra())
				break;
		}
			
	}
	//------luu file html
	public static void savesfilehtml(String url,String noiluu) throws IOException{
		
		Document doc=Jsoup.connect(url).timeout(50000).get();
		Elements link = doc.select("html");
		String savehtml=link.html();
		//tim ten file trong chuoi url
		String reg="(.+)(?<phandau>/)(?<noidung>.+)((\\.?).*)";
		Pattern pattern=Pattern.compile(reg);
		Matcher matcher=pattern.matcher(url);
		if(matcher.find()){
			//------luu file 
			String tenfile=matcher.group("noidung").replaceAll("\\?","");
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(noiluu+"/"+tenfile+".html"),"UTF-8"));
			try{
				out.write(savehtml);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				out.close();
			}
		}
	}
	//----luu cac trang html 
	public static void gethtmls(String url,String noiluu) throws IOException{
		HashSet<String> hset1=new HashSet<String>();
        HashSet<String> hset2=new HashSet<String>();
        //lay link lan 1
        laylink(url,url, hset1);
        //--lay link lan 2
        for (String movie : hset1) {
        	try{
        		Response response = Jsoup.connect(movie).followRedirects(false).execute();
        		if (200==response.statusCode()) {
        		laylink(url,movie, hset2);
        		}
        	} catch (IOException e) {
                //e.printStackTrace();
            }
        	if(getkiemtra()){
        		break;
        	}
        }
        //in ra vao file 
        for (String movie : hset2) {
        	try{
        		Response response = Jsoup.connect(movie).followRedirects(false).execute();
        		if (200==response.statusCode()) {
        			savesfilehtml(movie,noiluu);
        			//System.err.println("luu duoc 1 file");
        		}
        	}catch (Exception e) {
				// TODO: handle exception
			}
        	if(getkiemtra())
        		break;
        }
    } 

	//---chon file
	public static String selectFiles(String kieuluu){
			
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(kieuluu,kieuluu);
		chooser.setFileFilter(filter);
		chooser.setMultiSelectionEnabled(true);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().getAbsolutePath();
		}
		return "";
	}
	//-------lay toan bo noi dung html
	public static String gethtml(String dauvao) throws IOException {
		File input = new File(dauvao);
		Document doc = Jsoup.parse(input, "UTF-8");
		//Elements link = doc.select("html");
		String text = doc.body().text();
		return text;
	}
}

