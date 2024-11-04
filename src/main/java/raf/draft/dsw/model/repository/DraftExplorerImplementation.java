package raf.draft.dsw.model.repository;

import raf.draft.dsw.model.structures.ProjectExplorer;

public class DraftExplorerImplementation implements DraftRepository{

    private ProjectExplorer projectExplorer;

    public DraftExplorerImplementation() {
        projectExplorer = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }
}
