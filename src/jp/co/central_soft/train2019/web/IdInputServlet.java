package jp.co.central_soft.train2019.web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.central_soft.train2019.bean.EmployeeDispBean;
import jp.co.central_soft.train2019.bean.IdInputBean;
import jp.co.central_soft.train2019.service.EmployeeService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/IdInputServlet")
public class IdInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//画面から入力したデータを取得する
		String id = request.getParameter("id");
        byte[] bi = id.getBytes("iso-8859-1");
        String strUserId = new String( bi, "UTF-8" );

        //bean のインスタンスを生成する
        IdInputBean bean = new IdInputBean();

		int iid=0;

		try
		{
			iid=Integer.parseInt( strUserId );
		}
		catch( NumberFormatException e )
		{
	        //JSPに遷移する
	        RequestDispatcher disp = request.getRequestDispatcher("/loginError.jsp");
	        disp.forward(request, response);
	        return;
		}


        //サービスを取得
        EmployeeService service = new EmployeeService();

        //IDを指定してログイン者の情報を取得
        EmployeeDispBean emp = service.findByKey( iid );


        bean.setUserId( strUserId );
        bean.setName( emp.getEmployeeName() );
        bean.setLoginDateTime( LocalDateTime.now() );


        //セッションにログイン情報を保存
        HttpSession ss= request.getSession();
        ss.setAttribute("loginInfo", bean.getLoginInfo());


        //beanをリクエストにセット キー名は「bean」とする
        request.setAttribute("bean", bean);

        //JSPに遷移する
        RequestDispatcher disp = request.getRequestDispatcher("/idInput.jsp");
        disp.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}
