package DAO;

import java.io.File;
import java.util.LinkedList;

public class getFileName {
	public static void main(String[] args) {
		// char c=(char)(Math.random()*26+97);
		// System.out.println(c);

		// Object[] StrArr =new
		// Object[]{0,1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','i','j',
		// 'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D',
		// 'E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Z',};
		// int i;
		// String str="";
		// for (int j = 0; j < 4; j++) {
		// i = (int) (Math.random()*52);
		// str +=StrArr[i];
		// }
		// System.out.println(str);

		getFileName t = new getFileName();
		t.getNames();

	}

	public String[] getNames() {
		// �ļ���·��
		String path = "D:\\Tomcat\\apache-tomcat-7.0.100\\webapps\\shiyan6\\download\\";
		int fileNum = 0;
		int folderNum = 0;
		int foldeNum = 0;

		// �ļ��е�·���ľ��
		File file = new File(path);

		// list()�����Ƿ���ĳ��Ŀ¼�µ������ļ���Ŀ¼���ļ��������ص���String����

		String[] FileNames = file.list();

		for (String file3 : FileNames) {
			System.out.println(file3);
		}
		return FileNames;

	}

	
	
	public LinkedList<File> toGetAbsolutePath() {
		// �ļ���·��
		String path = "D:\\Tomcat\\apache-tomcat-7.0.100\\webapps\\shiyan6\\download\\";
		int fileNum = 0;
		int folderNum = 0;
		int foldeNum = 0;

		// �ļ��е�·���ľ��
		File file = new File(path);

		LinkedList<File> list = new LinkedList<File>();
		if (file.exists()) {

			// listFiles()�����Ƿ���ĳ��Ŀ¼�������ļ���Ŀ¼�ľ���·�������ص���File����
			File[] files = file.listFiles();
			for (File file2 : files) {
				if (file2.isDirectory()) {
					System.out.println("�ļ���:" + file2.getAbsolutePath());

					foldeNum++;
				} else {
					list.add(file2);
					System.out.println("�ļ�:" + file2.getAbsolutePath());
					fileNum++;
				}
			}
			System.out.println("�ļ�������" + (folderNum = fileNum + foldeNum));
		}
		return list;
	}
}
