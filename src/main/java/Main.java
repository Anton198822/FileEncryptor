import javax.swing.*;


public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("File Encrypter");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        GUIForm form = new GUIForm();
        frame.add(form.getRootPanel());
        frame.setVisible(true);

/*
        String path = "C:/Users/Anton/Desktop/";
        ZipParameters parameters;

        parameters = new ZipParameters();
        parameters
                .setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        parameters
                .setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_ULTRA);
        parameters
                .setEncryptFiles(true);
        parameters
                .setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
        parameters
                .setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        parameters
                .setPassword("123");

        try {
            ZipFile zipFile = new ZipFile(path + "archive.zip");
            zipFile.addFolder(new File(path + "folder"),
                    parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
 */
    }
}
