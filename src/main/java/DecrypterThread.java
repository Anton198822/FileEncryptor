import net.lingala.zip4j.core.ZipFile;

import java.io.File;

public class DecrypterThread extends Thread {
    private GUIForm form;
    private File file;
    private String password;

    public DecrypterThread(GUIForm form) {
        this.form = form;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void run() {
        onStart();
        boolean isErrors = false;
        try {
            String outputPath = getOutputPath();
            ZipFile zipFile = new ZipFile(file);
            zipFile.setPassword(password);
            zipFile.extractAll(outputPath);
        } catch (Exception ex) {
            if (ex.getMessage().indexOf("Wrong password") > 0) {
                form.showWarning("Неправильный пароль");
                isErrors = true;
            } else {
                form.showWarning(ex.getMessage());
            }
        }
        onFinish(isErrors);
    }

    private String getOutputPath() {
        String path = file.getAbsolutePath().replaceAll("\\.enc$", "");
        for (int i = 1; ; i++) {
            String number = i > 1 ? Integer.toString(i) : "";
            String outPutPath = path + number;
            if (!new File(outPutPath).exists()) {
                return outPutPath;
            }
        }
    }

    private void onStart() {
        form.setButtonsEnabled(false);
    }

    private void onFinish(boolean isErrors) {
        form.setButtonsEnabled(true);
        if (!isErrors) {
            form.showFinished();
        }
    }
}
