package com.donate.orm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FtpManager {

	private static Logger logger = LoggerFactory.getLogger(FtpManager.class);
	public boolean fileUpload(String localFilePath, String remoteFilePath, String fileName, HttpServletRequest req) throws Exception {
		FTPClient ftp = null;
		FileInputStream fis = null;
		File uploadFile = new File(localFilePath);
		
		String url = "coding0596.dothome.co.kr";
		String id = "coding0596";
		String pwd = "cd156e15!";
		int port = 21;
		
		try {
			ftp = new FTPClient();
			ftp.setControlEncoding("UTF-8");
			ftp.connect(url, port);
			ftp.login(id, pwd);
			ftp.enterLocalPassiveMode();
			ftp.changeWorkingDirectory(remoteFilePath);
			ftp.setFileType(ftp.BINARY_FILE_TYPE);
			
			fis = new FileInputStream(uploadFile);
			logger.info("ftp연결 시작");
			return ftp.storeFile(fileName, fis);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			logger.info("ftp연결 종료");
			fis.close();
			ftp.logout();
		}
		return false;
	}
	public boolean fileRemove(String localFilePath, String remoteFilePath, String fileName, HttpServletRequest req) throws Exception {
		FTPClient ftp = null;
		//FileInputStream fis = null;
		//File uploadFile = new File(localFilePath);
		
		String url = "coding0596.dothome.co.kr";
		String id = "coding0596";
		String pwd = "cd156e15!";
		int port = 21;
		
		try {
			ftp = new FTPClient();
			ftp.setControlEncoding("UTF-8");
			ftp.connect(url, port);
			ftp.login(id, pwd);
			ftp.enterLocalPassiveMode();
			ftp.changeWorkingDirectory(remoteFilePath);
			ftp.setFileType(ftp.BINARY_FILE_TYPE);
			return ftp.deleteFile(fileName);
		}catch (Exception e) {
			logger.info("FTP Delete Error");
		}finally {
			logger.info("ftp연결 종료");
			//fis.close();
			ftp.logout();
			//ftp.disconnect();
		}
			
		
		return false;
	}

}
