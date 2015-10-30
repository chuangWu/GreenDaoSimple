package com.example.administrator.greendaosimple;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.greendaosimple.dao.DaoMaster;
import com.example.administrator.greendaosimple.dao.DaoSession;
import com.example.administrator.greendaosimple.dao.Student;
import com.example.administrator.greendaosimple.dao.StudentDao;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private StudentDao dao;
    private TextView content;
    private String result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        content = (TextView) findViewById(R.id.content);
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "student-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        dao = daoSession.getStudentDao();
    }

    public void createTable(View view) {
        Student student = new Student();
        student.setName("chuangWu ");
        student.setAge(22);
        dao.insert(student);

        queryTable(view);
    }

    public void queryTable(View view) {
        List<Student> students = dao.loadAll();
        StringBuffer sb = new StringBuffer();
        for (Student student : students) {
            sb.append(student.toString());
            sb.append("\n");
        }
        result = sb.toString();
        content.setText(result);
    }

    public void updateTable(View view) {
        List<Student> students = dao.loadAll();
        Random random = new Random();
        Student student = students.get(random.nextInt(students.size()));
        student.setName("username");
        dao.update(student);

        queryTable(view);
    }

    public void deleteTable(View view) {
        List<Student> students = dao.loadAll();
        Random random = new Random();
        Student student = students.get(random.nextInt(students.size()));
        dao.delete(student);
        queryTable(view);
    }


//    public static void main(String[] args) throws Exception {
//        createGenerator();
//    }
//
//    public static void createGenerator() {
//        Schema schema = new Schema(1,"com.example.administrator.greendaosimple.dao");
//        Entity student = schema.addEntity("Student");
//        student.addIdProperty();
//        student.addStringProperty("name");
//        student.addIntProperty("age");
//        student.addDateProperty("date");
//        try {
//            new DaoGenerator().generateAll(schema,"./app/src/main/java");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
