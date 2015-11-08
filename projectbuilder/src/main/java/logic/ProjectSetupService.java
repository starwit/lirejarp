package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import frontend.beans.ProjectSetupBean;

public class ProjectSetupService {

	public final static String[] EXT = new String[] { "java", "js", "html", "sql" };
	final static Logger LOG = Logger.getLogger(ProjectSetupService.class);
	
	public void renameAll(ProjectSetupBean properties) {
		System.out.println("Try to rename project " + properties.getNewProjectName() + ".");
		File dir = new File(properties.getProjectPath());
		renameFiles(properties.getCurrentProjectName(), properties.getNewProjectName(), dir);
		renameDirectories(properties.getCurrentProjectName(), dir, properties.getNewProjectName());
	}

	private void renameDirectories(String from, File dir, String projectName) {
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		if (files == null) {
			return;
		}
		for (File file : files) {
			LOG.info("FileName: " + file.getAbsolutePath());
			try {
				if (from.equals(file.getName())) {
					File newFile = new File(file.getParent() + "/" + projectName);
					Files.move(file.toPath(), newFile.toPath());
				}
			} catch (IOException e) {
				LOG.error("Problems moving file with name " + file.getName());
				LOG.error(e.getMessage());
			}
			renameDirectories(from, file, projectName);
		}
	}

	private void renameFiles(String from, String to, File dir) {
		@SuppressWarnings("unchecked")
		Collection<File> files = FileUtils.listFiles(dir, EXT, true);
		for (File file : files) {
			System.out.println("FileName: " + file.getAbsolutePath());
			try {
				renameFileContent(from, to, file);
			} catch (IOException e) {
				LOG.error("Problems rename file with name " + file.getName());
				LOG.error(e.getMessage());
			}
		}
	}

	private void renameFileContent(String from, String to, File fileIn) throws IOException {
		Path filePath = fileIn.toPath();
		Path moved = Files.move(filePath, new File(fileIn.getName() + "_OLD").toPath());
		File fileOut = Files.createFile(filePath).toFile();
		File fileOld = moved.toFile();

		BufferedReader reader = new BufferedReader(new FileReader(fileOld));
		PrintWriter writer = new PrintWriter(new FileWriter(fileOut));

		try {
			String line = null;
			while ((line = reader.readLine()) != null)
				writer.println(line.replaceAll(from, to));
		} catch (IOException e) {
			LOG.error("Error processing file with name " + fileIn.getName());
			LOG.error(e.getMessage());
		} finally {
			reader.close();
			writer.close();
			moved.toFile().delete();
		}

	}
}
