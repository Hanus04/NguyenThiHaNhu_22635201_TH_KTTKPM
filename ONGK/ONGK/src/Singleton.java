class ConfigManager {
    private static ConfigManager instance;

    private ConfigManager() {
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public void showConfig() {
        System.out.println("Đây là cấu hình hệ thống duy nhất.");
    }
}

public class SingletonMain {
    public static void main(String[] args) {
        ConfigManager c1 = ConfigManager.getInstance();
        ConfigManager c2 = ConfigManager.getInstance();

        c1.showConfig();
        System.out.println("c1 và c2 cùng tham chiếu? " + (c1 == c2));
    }
}