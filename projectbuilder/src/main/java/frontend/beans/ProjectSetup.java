package frontend.beans;

import java.nio.file.Paths;

public class ProjectSetup {
	
	private String newProjectName;
	
	private String currentProjectName;
	
	private String projectPath;
	
	public ProjectSetup() {
		this.currentProjectName = "lirejarp";
		this.projectPath = Paths.get("").toAbsolutePath().getParent().toString() + "\\" + currentProjectName;
		this.newProjectName = "myApp";
	}
	
	public String getNewProjectName() {
		return newProjectName;
	}

	public void setNewProjectName(String projectName) {
		this.newProjectName = projectName;
	}

	public String getCurrentProjectName() {
		return currentProjectName;
	}

	public void setCurrentProjectName(String packageName) {
		this.currentProjectName = packageName;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

}
