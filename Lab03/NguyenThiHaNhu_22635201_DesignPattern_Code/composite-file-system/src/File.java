public class File implements FileSystemComponent {

    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name + " | Size: " + size);
    }

    @Override
    public long getSize() {
        return size;
    }
}