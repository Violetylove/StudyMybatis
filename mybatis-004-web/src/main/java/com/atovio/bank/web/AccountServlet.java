package com.atovio.bank.web;

import com.atovio.bank.exceptions.MoneyNotEnoughException;
import com.atovio.bank.exceptions.TransferException;
import com.atovio.bank.service.AccountService;
import com.atovio.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 * @since 1.0
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {

    private final AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取表单数据
        String fromActnu = request.getParameter("fromActnu");
        String toActnu = request.getParameter("toActnu");
        double money = Double.parseDouble(request.getParameter("money"));
        try {
            // 调用service的转账方法完成转账
            accountService.transfer(fromActnu, toActnu, money);
            // 调用view完成展示结果
            response.sendRedirect(request.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error1.html");
        } catch (TransferException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error2.html");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error2.html");
        }
    }
}
