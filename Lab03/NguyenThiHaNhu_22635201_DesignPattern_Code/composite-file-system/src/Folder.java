import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {

    private String name;
    private List<FileSystemComponent> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    // add component
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    // remove component
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);

        // gọi đệ quy
        for (FileSystemComponent component : children) {
            component.showDetails();
        }
    }

    @Override
    public long getSize() {
        long totalSize = 0;

        // tính đệ quy
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }

        return totalSize;
    }
}