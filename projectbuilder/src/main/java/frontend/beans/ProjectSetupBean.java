package frontend.beans;

import java.nio.file.Paths;

public class ProjectSetupBean {
	
	private String newProjectName;
	
	private String currentProjectName;
	
	private String projectPath;
	
	public ProjectSetupBean() {
		this.currentProjectName = "lirejarp";
		this.projectPath = Paths.get("").toAbsolutePath().getParent().toString();
		this.newProjectName = "lirejarp";
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
