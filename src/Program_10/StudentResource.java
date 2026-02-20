package Program_10;

import model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student")
public class StudentResource extends HttpServlet {

    private static List<Student> students = new ArrayList<>();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        if (students.isEmpty()) {
            res.getWriter().println("No records found");
            return;
        }

        for (Student s : students) {
            res.getWriter().println(
                "id: " + s.id + " name: " + s.name + " age: " + s.age
            );
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        students.add(new Student(id, name, age));
        res.getWriter().println("Student added");
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        for (Student s : students) {
            if (s.id == id) {
                s.name = name;
                s.age = age;
                break;
            }
        }

        res.getWriter().println("Student updated");
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        students.removeIf(s -> s.id == id);

        res.getWriter().println("Student deleted");
    }
}
