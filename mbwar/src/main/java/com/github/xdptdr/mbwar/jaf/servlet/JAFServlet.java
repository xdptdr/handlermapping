package com.github.xdptdr.mbwar.jaf.servlet;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.activation.CommandInfo;
import javax.activation.CommandMap;
import javax.activation.DataContentHandler;
import javax.activation.DataContentHandlerFactory;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.FileTypeMap;
import javax.activation.URLDataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JAFServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DataSource dataSource;
	private InputStream inputStream;
	private String contentType;
	private String name;
	private OutputStream outputStream;
	private FileDataSource fileDataSource;
	private File file;
	private FileTypeMap fileTypeMap;
	private URLDataSource urlDataSource;
	private URL url;
	private CommandMap commandMap;
	private String mimeType;
	private DataContentHandler dataContentHandler;
	private CommandInfo[] commandInfos;
	private String commandName;
	private CommandInfo commandInfo;
	private String[] mimeTypes;
	private DataFlavor dataFlavor;
	private DataFlavor[] dataFlavors;
	private Object content;
	private Object transferData;
	private Object object;
	private DataHandler dataHandler;
	private DataContentHandlerFactory dataContentHandlerFactory;
	private Object bean;
	private String commandClass;
	private ClassLoader classLoader;
	private String dataContentHandlerName;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req == null) {
			try {
				doStuff(req, resp);
			} catch (UnsupportedFlavorException | ClassNotFoundException e) {
			}
		}
	}

	private void doStuff(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, UnsupportedFlavorException, ClassNotFoundException {

		inputStream = dataSource.getInputStream();
		contentType = dataSource.getContentType();
		name = dataSource.getName();
		outputStream = dataSource.getOutputStream();

		fileDataSource = new FileDataSource(file);
		fileDataSource = new FileDataSource(name);
		file = fileDataSource.getFile();
		fileDataSource.setFileTypeMap(fileTypeMap);

		urlDataSource = new URLDataSource(url);
		url = urlDataSource.getURL();

		commandMap = CommandMap.getDefaultCommandMap();
		CommandMap.setDefaultCommandMap(commandMap);
		dataContentHandler = commandMap.createDataContentHandler(mimeType);
		dataContentHandler = commandMap.createDataContentHandler(mimeType, dataSource);
		commandInfos = commandMap.getAllCommands(mimeType);
		commandInfos = commandMap.getAllCommands(mimeType, dataSource);
		commandInfo = commandMap.getCommand(mimeType, commandName);
		commandInfo = commandMap.getCommand(mimeType, commandName, dataSource);
		mimeTypes = commandMap.getMimeTypes();
		commandInfos = commandMap.getPreferredCommands(mimeType);
		commandInfos = commandMap.getPreferredCommands(mimeType, dataSource);

		content = dataContentHandler.getContent(dataSource);
		transferData = dataContentHandler.getTransferData(dataFlavor, dataSource);
		dataFlavors = dataContentHandler.getTransferDataFlavors();
		dataContentHandler.writeTo(object, mimeType, outputStream);

		DataHandler.setDataContentHandlerFactory(dataContentHandlerFactory);
		dataHandler = new DataHandler(object, mimeType);
		dataHandler = new DataHandler(url);
		dataHandler = new DataHandler(dataSource);
		commandInfos = dataHandler.getAllCommands();
		bean = dataHandler.getBean(commandInfo);
		dataHandler.getCommand(commandName);
		content = dataHandler.getContent();
		contentType = dataHandler.getContentType();
		dataSource = dataHandler.getDataSource();
		inputStream = dataHandler.getInputStream();
		name = dataHandler.getName();
		outputStream = dataHandler.getOutputStream();
		commandInfos = dataHandler.getPreferredCommands();
		transferData = dataHandler.getTransferData(dataFlavor);
		dataFlavors = dataHandler.getTransferDataFlavors();
		dataHandler.isDataFlavorSupported(dataFlavor);
		dataHandler.setCommandMap(commandMap);
		dataHandler.writeTo(outputStream);

		commandInfo = new CommandInfo(commandName, commandClass);
		commandClass = commandInfo.getCommandClass();
		commandName = commandInfo.getCommandName();
		commandInfo.getCommandObject(dataHandler, classLoader);

		dataContentHandlerFactory.createDataContentHandler(dataContentHandlerName);

	}

}
