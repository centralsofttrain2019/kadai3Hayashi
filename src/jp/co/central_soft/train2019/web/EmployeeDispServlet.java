package jp.co.central_soft.train2019.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.central_soft.train2019.bean.EmployeeDispBean;
import jp.co.central_soft.train2019.bean.IdInputBean;
import jp.co.central_soft.train2019.bean.LoginInfo;
import jp.co.central_soft.train2019.service.EmployeeService;

/**
 * Servlet implementation class IndexStartServlet
 */
@WebServlet("/EmployeeDispServlet")
public class EmployeeDispServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDispServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response
			) 	throws ServletException, IOException
	{
		//画面から入力したデータを取得する
		String strId = request.getParameter("id");

        //セッションからログイン情報を取得
        HttpSession ss= request.getSession();
        LoginInfo logIninfo = (LoginInfo)ss.getAttribute( "loginInfo" );

		int id=0;
		try
		{
			id=Integer.parseInt( strId );
		}
		catch( NumberFormatException e )
		{
	        IdInputBean bean = new IdInputBean();

	        //ログイン情報をセット
	        bean.setLoginInfo( logIninfo );

	        //表示するメッセージをセット
	        bean.setMessage("IDは数字で入力してください。");

			//beanをリクエストにセット キー名は「bean」とする
			request.setAttribute("bean", bean);	        //JSPに遷移する

	        RequestDispatcher disp = request.getRequestDispatcher("/idInput.jsp");
	        disp.forward(request, response);
	        return;
		}

		//サービスを取得
		EmployeeService service = new EmployeeService();
		EmployeeDispBean bean = service.findByKey( id );

		//ビーンにログイン情報をセット
		bean.setLogIninfo(logIninfo);

		//beanをリクエストにセット キー名は「bean」とする
		request.setAttribute("bean", bean);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/employeeDisp.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
