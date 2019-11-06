import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/search")
public class TranslationServlet extends javax.servlet.http.HttpServlet {
    private static final String[][] dictionary = { {"box", "cai hop"}, {"computer", "may tinh"}, {"lion", "con ho"}};

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String input = request.getParameter("input");
        request.setAttribute("input", input);
        boolean flag = true;
        for (String[] word : dictionary) {
            if (input.equalsIgnoreCase(word[0])) {
                request.setAttribute("result", word[1]);
                flag = false;
                break;
            }
        }
        if (flag) request.setAttribute("result", "That word isn't in this dictionary");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}