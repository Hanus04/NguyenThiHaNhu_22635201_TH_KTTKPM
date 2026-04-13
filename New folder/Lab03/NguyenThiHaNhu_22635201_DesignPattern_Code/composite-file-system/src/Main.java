public class Main {
    public static void main(String[] args) {

        // ===== File =====
        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.txt", 200);
        File file3 = new File("file3.txt", 300);

        // ===== Folder con =====
        Folder subFolder = new Folder("SubFolder");
        subFolder.add(file2);
        subFolder.add(file3);

        // ===== Folder chính =====
        Folder root = new Folder("Root");
        root.add(file1);
        root.add(subFolder);

        // ===== Hiển thị =====
        root.showDetails();

        // ===== Tổng size =====
        System.out.println("Total size: " + root.getSize());
    }
}