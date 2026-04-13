import java.util.ArrayList;
import java.util.List;

interface FileSystemItem {
    void show(String prefix);
}

class FileItem implements FileSystemItem {
    private final String name;

    public FileItem(String name) {
        this.name = name;
    }

    @Override
    public void show(String prefix) {
        System.out.println(prefix + "- File: " + name);
    }
}

class FolderItem implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> children = new ArrayList<>();

    public FolderItem(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public void show(String prefix) {
        System.out.println(prefix + "+ Folder: " + name);
        for (FileSystemItem item : children) {
            item.show(prefix + "  ");
        }
    }
}

public class CompositeMain {
    public static void main(String[] args) {
        FolderItem root = new FolderItem("root");
        FileItem file1 = new FileItem("a.txt");
        FileItem file2 = new FileItem("b.txt");

        FolderItem subFolder = new FolderItem("docs");
        subFolder.add(new FileItem("design.pdf"));

        root.add(file1);
        root.add(file2);
        root.add(subFolder);

        root.show("");
    }
}