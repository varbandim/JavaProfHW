package Lesson6.Task3;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
Написать тесты для
проверки того, что при работе с базой корректно добавляются, обновляются и читаются
записи. Следует учесть что в базе есть заранее добавленные записи, и после проведения
тестов эти записи не должны быть удалены/изменены/добавлены.
 */
public class TestDB {
    private DBWork dbWork;
    private String pathFileOriginal = "C:\\Users\\Sim\\YandexDisk\\geekbrains.ru\\Java. Prof\\HomeWorks\\src\\Lesson6\\Task3\\MainDB.db";
    private String pathFileCopy = "C:\\Users\\Sim\\YandexDisk\\geekbrains.ru\\Java. Prof\\HomeWorks\\src\\Lesson6\\Task3\\MainDB1.db";
    InputStream in = null;
    OutputStream out = null;

    private void copyBD() throws IOException {
        try {
            in = new FileInputStream(pathFileOriginal);
            out = new FileOutputStream(pathFileCopy);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } finally {
            in.close();
            out.close();
        }
    }

    @Test
    public void testInsert() throws IOException, SQLException {
        copyBD();
        File file = new File(pathFileCopy);
        dbWork = new DBWork();
        dbWork.connect(pathFileCopy);

        dbWork.disconnect();
        file.delete();
    }

    @Test
    public void testUpdate() throws IOException, SQLException {
        copyBD();
        File file = new File(pathFileCopy);
        dbWork = new DBWork();
        dbWork.connect(pathFileCopy);

        dbWork.disconnect();
        file.delete();
    }

    @Test// - ПОИСПОЛЬЗОВАТЬ @Before!!!
    public void testRead() throws IOException, SQLException {
        copyBD();
        File file = new File(pathFileCopy);
        dbWork = new DBWork();
        dbWork.connect(pathFileCopy);
        ResultSet result = dbWork.stmt.executeQuery("SELECT * FROM Students");
        Assert.assertNotEquals(null, result.next());
        dbWork.disconnect();
        file.delete();
    }
}
