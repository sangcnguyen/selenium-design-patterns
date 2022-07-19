package strategy;

public interface UploadStrategy {
    void uploadFile(String fileName);
    String getUploadMessage();
}
