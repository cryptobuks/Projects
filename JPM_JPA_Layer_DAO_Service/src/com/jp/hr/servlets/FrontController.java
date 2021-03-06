package com.jp.hr.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jp.hr.entities.Employee;
import com.jp.hr.entities.Product;
import com.jp.hr.entities.User;
import com.jp.hr.exceptions.HRException;
import com.jp.hr.services.EmployeeService;
import com.jp.hr.services.EmployeeServiceImpl;
import com.jp.hr.services.ProductService;
import com.jp.hr.services.ProductServiceImpl;
import com.jp.hr.services.UserService;
import com.jp.hr.services.UserServiceImpl;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService services;
	private ProductService productService;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		try {
			services = new EmployeeServiceImpl();
			productService = new ProductServiceImpl();
			userService = new UserServiceImpl();
		} catch (HRException e) {
			throw new ServletException("Init method failed", e);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		ArrayList<Product> productList = new ArrayList<Product>();
		RequestDispatcher rd = null;
		System.out.println(request.getRequestURI());
		String action = getAction(request.getRequestURI());
		String jspName = "";
		String prefix = "/WEB-INF/jsps/";
		String postfix = ".jsp";
		System.out.println(action);
		try {
			switch (action) {
			case "*":
			case "home": {
				jspName = "Home";
				break;
			}

			case "login": {
				jspName = "Login";
				break;
			}

			case "authenticate": {
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				User user =  userService.findByUsername(username.toLowerCase());
				System.out.println(user);
				if(user!=null && password.equals(user.getPassword())){
					String userFullName = user.getName();
					HttpSession session = request.getSession();
					session.setAttribute("userFullName", userFullName);
					jspName = "MainMenu";
				}
				else{
					String msg = "Invalid Credentials. Please enter again";
					request.setAttribute("errMsg", msg);
					jspName = "Login";
				}
				
				break;
			}

			case "register": {
				jspName = "Registration";
				break;
			}
			
			case "registration": {
				String name = request.getParameter("name");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				
				User user = new User(name,username,password,email,"");
				boolean isSuccessful = userService.addNewUser(user);
				String msg = isSuccessful ? "User Registered" : "Registration failed";
				request.setAttribute("message", msg);
				jspName = "login";
				break;
			}
			
			case "mainMenu": {
				jspName = "MainMenu";
				break;
			}
			case "logout": {
				HttpSession session = request.getSession();
				request.setAttribute("userFullName", session.getAttribute("userFullName"));
				session.invalidate();
				jspName = "ThanksPage";
				break;
			}
			case "empList": {

				empList = services.getEmpList();
				System.out.println(empList);
				request.setAttribute("empList", empList);
				jspName = "EmpList";
				break;
			}
			case "empDetails": {
				String strId = request.getParameter("empId");
				System.out.println(strId);
				int empid = Integer.parseInt(strId);
				Employee emp = services.getEmpDetails(empid);
				request.setAttribute("empDetails", emp);
				jspName = "EmpDetails";
				break;
			}
			case "submitJoinee": {
				//String strEmpId = request.getParameter("empId");
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				//int empId = Integer.parseInt(strEmpId);
				Employee e = new Employee(firstName, lastName);
				boolean isSuccessful = services.joinNewEmployee(e);
				String msg = isSuccessful ? "Employee Inserted" : "Insertion failed";
				request.setAttribute("message", msg);
				jspName = "NewJoining";
				break;
			}
			case "newJoining": {
				jspName = "NewJoining";
				break;
			}
			case "productList": {

				productList = productService.getProductList();
				System.out.println(productList);
				request.setAttribute("productList", productList);
				jspName = "ProductList";
				break;
			}
			case "prodDetails": {
				String strId = request.getParameter("prodId");
				System.out.println(strId);
				int prodid = Integer.parseInt(strId);
				Product prod = productService.getProductDetails(prodid);
				request.setAttribute("prodDetails", prod);
				jspName = "ProductDetails";
				break;
			}
			case "newProduct": {
				jspName = "NewProduct";
				break;
			}
			case "addProduct": {
				String strProdId = request.getParameter("prodID");
				String category = request.getParameter("category");
				String name = request.getParameter("name");
				String strPrice = request.getParameter("price");
				Float price = Float.parseFloat(strPrice);
				int prodId = Integer.parseInt(strProdId);
				Product p = new Product(prodId, category, name, price);
				boolean isSuccessful = productService.addNewProduct(p);
				String msg = isSuccessful ? "Product Inserted" : "Insertion failed";
				request.setAttribute("message", msg);
				jspName = "NewProduct";
				break;
			}
			case "editProduct": {
				String strProdId = request.getParameter("prodID");
				int prodId = Integer.parseInt(strProdId);
				Product prod = productService.getProductDetails(prodId);
				request.setAttribute("productDetails", prod);
				jspName = "EditProduct";
				break;
			}
			case "modifyProduct": {
				String strProdId = request.getParameter("prodID");
				String category = request.getParameter("category");
				String name = request.getParameter("name");
				String strPrice = request.getParameter("price");
				Float price = Float.parseFloat(strPrice);
				int prodId = Integer.parseInt(strProdId);
				System.out.println(price);
				Product p = new Product(prodId, category, name, price);
				boolean isSuccessful = productService.modifyProduct(p);
				String msg = isSuccessful ? "Product Update" : "Updation failed";
				request.setAttribute("message", msg);
				productList = productService.getProductList();
				request.setAttribute("productList", productList);
				jspName = "ProductList";
				break;
			}
			case "deleteProduct": {
				String strProdId = request.getParameter("prodID");
				int productId = Integer.parseInt(strProdId);
				boolean isSuccessful = productService.removeProduct(productId);
				String msg = isSuccessful ? "Product Deleted" : "Deletion failed";
				request.setAttribute("message", msg);
				productList = productService.getProductList();
				request.setAttribute("productList", productList);

				jspName = "ProductList";
				break;
			}
			}

		} catch (HRException e) {
			throw new ServletException(e.getMessage());
		}
		rd = request.getRequestDispatcher(prefix + jspName + postfix);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String getAction(String uri) {
		int leftPosition = uri.lastIndexOf("/");
		int rightPosition = uri.lastIndexOf(".");
		if (rightPosition == -1 || leftPosition == -1) {
			return "home";
		} else {
			return uri.substring(leftPosition + 1, rightPosition);
		}
	}
}
