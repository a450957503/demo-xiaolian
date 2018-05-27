package cn.edu.fjnu.towide.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.PropertySource;

import cn.edu.fjnu.towide.constant.ImgPathNameTemplate;
import cn.edu.fjnu.towide.enums.PictureType;
import cn.edu.fjnu.towide.vo.ImageInfoVo;

@PropertySource("classpath:LossPrevention.property") // 指定本类中将要读取属性文件
public class Base64PictureUtil {
	
	//图片转化成base64字符串  
    public static String GetImageStr(String imgPath)  
    {
    	//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try   
        {  
            in = new FileInputStream(imgPath);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        Encoder encoder = Base64.getEncoder();
//        return Base64Utils.encodeToString(data);	
        return encoder.encodeToString(data);//返回Base64编码过的字节数组字符串  
    }  
      
    //base64字符串转化成图片  
    public static byte[] GenerateImage(String imgStr)  
    {   
    	//对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) //图像数据为空  
            return null;  
        Decoder decoder = Base64.getDecoder();
        
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decode(imgStr);
            for(int i=0; i<b.length; ++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成jpeg图片  
//            String imgFilePath = "D:\\Users\\pic\\new2.jpg";//新生成的图片  
//            OutputStream out = new FileOutputStream(imgFilePath);      
//            out.write(b);  
//            out.flush();  
//            out.close();  
            return b;  
        }   
        catch (Exception e)   
        {  
            return null;  
        }  
    } 
	

	public static String readPictureStringFromFile(String picturePathAndName) {
		BufferedReader bReader = null;
		String picStr = "";
		try {
			File file = new File(picturePathAndName);
			FileReader reader = new FileReader(file);
			bReader = new BufferedReader(reader);
			StringBuilder sb = new StringBuilder();
			String s = "";
			while ((s = bReader.readLine()) != null) {
				sb.append(s);
			}
			picStr = sb.toString();
			return picStr;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return picStr;
	}
	
	
	
	
	
	
	/**
	 * 
	 * v1.3 - 传入图片名列表，获取图片
	 * @param picPathList
	 * @return
	 */
//	public static List<String> readPictureStringListFromFile(List<String> picNameList) {
//		String basePath = "D:\\Users\\pic\\";
//		List<String>base64PictureStringList=new ArrayList<String>();
//		String s = null;
//		String picPath = null;
//		File picFile = null;
//
//		try {
//			File baseDirFile = new File(basePath);
//			if (createDirIfNoExist(baseDirFile)) {
//				for (String picName : picNameList) {
//					picPath = basePath + picName;
//					picFile = new File(picPath);
//					s = FileUtils.readFileToString(picFile);
//					
//					base64PictureStringList.add(s);
//				}
//			}
//			return base64PictureStringList;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//
//		return base64PictureStringList;
//	}
	

	/**
	 * 
	 * v1.4 - 传入图片名列表，获取图片，用map实现
	 * @param picPathList
	 * @return
	 */
	public static Map<String, String> readPictureStringMapFromFile(List<String> picNameList,PictureType pictureType) {
		
		//键-文件名  值-base64图片  LinkedHashMap可以按照添加顺序存键值对
		Map<String, String> base64PictureStringMap = new LinkedHashMap<String, String>();
		String s = null;
		String picPathName = null;
		
		String basePath;//获取路径
		if(pictureType==PictureType.QUESTION_BANK){
			basePath=ImgPathNameTemplate.basePathQuestionBank;
		}else{
			basePath=ImgPathNameTemplate.basePathQuestionAnswer;
		}
		
		
		try {
			File baseDirFile = new File(basePath);
			if (createDirIfNoExist(baseDirFile)) {
				for (String picName : picNameList) {
					picPathName = basePath + picName;
					s = GetImageStr(picPathName);
					s="data:image/jpeg;base64,"+s;
					base64PictureStringMap.put(picName, s);
				}
			}
			return base64PictureStringMap;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return base64PictureStringMap;
	}
	
	
	/**
	 * v1.5 - 传入图片名列表，获取图片，封装到Vo层
	 * @param picNameList
	 * @param pictureType
	 * @return
	 */
	public static List<ImageInfoVo> readPictureStringVoFromFile(List<String> picNameList,PictureType pictureType) {
		
		//键-文件名  值-base64图片  LinkedHashMap可以按照添加顺序存键值对
		List<ImageInfoVo> base64PictureVoList = new ArrayList<>();
		ImageInfoVo imageInfoVo = null;
		String s = null;
		String picPathName = null;
		
		String basePath;//获取路径
		if(pictureType==PictureType.QUESTION_BANK){
			basePath=ImgPathNameTemplate.basePathQuestionBank;
		}else{
			basePath=ImgPathNameTemplate.basePathQuestionAnswer;
		}
		
		
		try {
			File baseDirFile = new File(basePath);
			if (createDirIfNoExist(baseDirFile)) {
				for (String picName : picNameList) {
					picPathName = basePath + picName;
					s = GetImageStr(picPathName);
//					s="data:image/jpeg;base64,"+s;
					imageInfoVo = new ImageInfoVo(picName, s);
					base64PictureVoList.add(imageInfoVo);
				}
			}
			return base64PictureVoList;
		} catch (Exception e) {
			base64PictureVoList = null;
			e.printStackTrace();
		}

		return base64PictureVoList;
	}
	
	
	
	
	/**
	 * v1.0 - 每次写入一张，返回文件名
	 * @param base64PictureString
	 * @param questionId
	 * @param isQuestionerPic
	 * @return
	 */
	public static String writePictureStringToFile(String base64PictureString, String ID, PictureType pictureType) {
		
		String basePath;
		//获取路径
		if(pictureType==PictureType.QUESTION_BANK){
			basePath=ImgPathNameTemplate.basePathQuestionBank;
		}else{
			basePath=ImgPathNameTemplate.basePathQuestionAnswer;
		}
		
		File file = new File(basePath);
		// 创建文件夹失败
		if (!createDirIfNoExist(file)) {
			return null;
		}
		
		String picNameTemplate = null;
		// 获取图片名模版
		if (pictureType==PictureType.QUESTION) {
			picNameTemplate = ImgPathNameTemplate.questionPicNameTemplate;
		} else if(pictureType==PictureType.ANSWER){
			picNameTemplate = ImgPathNameTemplate.answerPicNameTemplate;
		}else{
			picNameTemplate = ImgPathNameTemplate.questionBankPicNameTemplate;
		}
		
		
		// 匹配图片格式，并去除前缀
		// 默认后缀jpeg
		String suffix = "jpeg";
		String reg = "^(data:image/(jpeg|png|gif);base64,)";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(base64PictureString);
		if(matcher.find()){
			suffix = matcher.group(2);
			base64PictureString = base64PictureString.replaceAll(reg, "");
		}
			
		
		// 写入图片
		String picName = String.format(picNameTemplate, ID, new Date().getTime(), suffix);//生成文件名
		String picPathName=basePath+picName;//合成路径+文件名
		file = new File(picPathName);
		try {
			// 将base64转回图片
			byte[] img = GenerateImage(base64PictureString);
			FileUtils.writeByteArrayToFile(file, img);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return picName;//只返回图片名
	}

	/**
	 * v1.1 - 将问题id作为文件夹，时间戳作为文件名，存储图片（按id区分文件夹）
	 * @param base64PictureStringList
	 * @param questionId
	 */
	public static void writePictureStringToFile(List<String> base64PictureStringList, String questionId) {
		PrintStream ps = null;
		File file = null;
		String DirPath = "D:\\Users\\pic\\" + questionId;
		file = new File(DirPath);
		if (createDirIfNoExist(file)) {
			for (String string : base64PictureStringList) {
				String filePath = DirPath + DateTimeUtil.getCurrentDataTimeString();
				file = new File(filePath);
				try {
					ps = new PrintStream(new FileOutputStream(file));
					ps.print(string);// 往文件里写入字符串
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						ps.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
	/**
	 * v1.2 - 将问题id作为文件夹，时间戳作为文件名，存储图片（不按id区分文件夹）
	 * @param base64PictureStringList
	 * @param questionId
	 * @param isQuestionerPic 是否为提问者上传的图片
	 * @return 图片名列表
	 */
	public static List<String> writePictureStringToFile(List<String> base64PictureStringList, String questionId,
			PictureType pictureType) {
		

		String picNameTemplate = null;
		String picName = null;

		File file = null;
		List<String> picPathList = new ArrayList<>();
		String basePath=null;
		if(pictureType==PictureType.QUESTION_BANK){
			basePath=ImgPathNameTemplate.basePathQuestionBank;
		}else{
			basePath=ImgPathNameTemplate.basePathQuestionAnswer;
		}
		
		
		file = new File(basePath);
		// 创建文件夹失败
		if (!createDirIfNoExist(file)) {
			return null;
		}
		
		// 获取图片名模版
		if (pictureType==PictureType.QUESTION) {
			picNameTemplate = ImgPathNameTemplate.questionPicNameTemplate;
		} else if(pictureType==PictureType.ANSWER){
			picNameTemplate = ImgPathNameTemplate.answerPicNameTemplate;
		}else{
			picNameTemplate = ImgPathNameTemplate.questionBankPicNameTemplate;
		}
		
		// 写入图片
		for (String base64PictureString : base64PictureStringList) {
			// 匹配图片格式，并去除前缀
			// 默认后缀jpeg
			String suffix = "jpeg";
			String reg = "^(data:image/(jpeg|png|gif);base64,)";
			Pattern pattern = Pattern.compile(reg);
			Matcher matcher = pattern.matcher(base64PictureString);
			if(matcher.find()){
				suffix = matcher.group(2);
				base64PictureString = base64PictureString.replaceAll(reg, "");
			}
			
			picName = String.format(picNameTemplate, questionId, new Date().getTime(), suffix);  
			file = new File(basePath + picName);
			try {
				// 将base64转回图片
				byte[] img = GenerateImage(base64PictureString);
				FileUtils.writeByteArrayToFile(file, img);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			picPathList.add(picName);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return picPathList;
	}
	
	
	@SuppressWarnings("unused")
	private static void createParentPathIfNotExist(File file) {
		String parentPathString = file.getParent();
		File parentPath = new File(parentPathString);
		if (!parentPath.exists()) {
			parentPath.mkdirs();
		}
	}

	// 判断文件夹是否存在，并创建
	public static boolean createDirIfNoExist(File file) {
		
		if (file.exists()) {
			if (file.isDirectory()) {
				return true;
			} else {
				// 若存在同名文件则删除，同时创建文件夹
				try {
					file.delete();
					file.mkdir();
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		} else {
			// 文件夹不存在，直接创建
			try {
				file.mkdir();
				return true;
			} catch (Exception e) {

				return false;
			}
		}

	}
}